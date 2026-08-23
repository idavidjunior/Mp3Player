import json
import os
import re
import shutil
import subprocess
from pathlib import Path


class BackendError(RuntimeError):
    pass


PROJECT_ROOT = Path(__file__).resolve().parents[2]
APP_ID = "com.mp3player"


def _which(name: str, install_hint: str) -> str:
    path = shutil.which(name)
    if not path:
        raise BackendError(f"{name} nao encontrado no PATH. {install_hint}")
    return path


def _run(cmd: list, cwd: Path = None, timeout: int = 600) -> dict:
    try:
        result = subprocess.run(
            cmd,
            cwd=str(cwd) if cwd else None,
            capture_output=True,
            text=True,
            encoding="utf-8",
            errors="replace",
            timeout=timeout,
        )
        return {
            "returncode": result.returncode,
            "stdout": result.stdout or "",
            "stderr": result.stderr or "",
        }
    except subprocess.TimeoutExpired:
        raise BackendError(f"Timeout apos {timeout}s executando: {' '.join(cmd)}")
    except OSError as exc:
        raise BackendError(f"Falha ao executar {cmd[0]}: {exc}")


def project_info() -> dict:
    app_gradle = PROJECT_ROOT / "app" / "build.gradle.kts"
    if not app_gradle.exists():
        raise BackendError(f"build.gradle.kts nao encontrado em {app_gradle}")
    content = app_gradle.read_text(encoding="utf-8", errors="replace")

    def _match(pattern: str, default: str = "") -> str:
        found = re.search(pattern, content)
        return found.group(1).strip() if found else default

    kt_files = list(PROJECT_ROOT.glob("app/src/main/java/**/*.kt"))
    entities = [
        p.stem.replace("Entity", "")
        for p in PROJECT_ROOT.glob("app/src/main/java/**/entity/*.kt")
    ]
    daos = [p.stem.replace("Dao", "") for p in PROJECT_ROOT.glob("app/src/main/java/**/dao/*Dao.kt")]

    return {
        "projeto": PROJECT_ROOT.name,
        "caminho": str(PROJECT_ROOT),
        "application_id": APP_ID,
        "application_id_debug": APP_ID + ".debug",
        "min_sdk": _match(r"minSdk\s*=\s*(\d+)", "?"),
        "target_sdk": _match(r"targetSdk\s*=\s*(\d+)", "?"),
        "arquivos_kotlin": len(kt_files),
        "entidades_room": sorted(entities),
        "daos": sorted(daos),
        "tem_cpp_nativo": (PROJECT_ROOT / "app/src/main/cpp").exists(),
        "gradle_wrapper": (PROJECT_ROOT / "gradlew.bat").exists(),
    }


def devices() -> list:
    adb = _which("adb", "Instale Android Platform-Tools.")
    result = _run([adb, "devices"], timeout=30)
    output = []
    for line in result["stdout"].splitlines()[1:]:
        line = line.strip()
        if not line:
            continue
        parts = line.split()
        state = parts[1] if len(parts) > 1 else "unknown"
        output.append({"serial": parts[0], "estado": state})
    return output


def _require_device() -> str:
    devs = [d for d in devices() if d["estado"] == "device"]
    if not devs:
        raise BackendError("Nenhum dispositivo conectado. Verifique USB debugging.")
    if len(devs) == 1:
        return devs[0]["serial"]
    raise BackendError("Multiplos dispositivos: use --serial <id>. " + ", ".join(d["serial"] for d in devs))


def build(release: bool = False) -> dict:
    gradlew = PROJECT_ROOT / ("gradlew.bat" if os.name == "nt" else "gradlew")
    if not gradlew.exists():
        raise BackendError(f"Gradle wrapper nao encontrado em {gradlew}")
    task = "assembleRelease" if release else "assembleDebug"
    result = _run([str(gradlew), task], cwd=PROJECT_ROOT, timeout=1200)
    apk_type = "release" if release else "debug"
    apk_path = PROJECT_ROOT / "app" / "build" / "outputs" / "apk" / apk_type / f"app-{apk_type}.apk"
    return {
        "task": task,
        "sucesso": result["returncode"] == 0,
        "apk": str(apk_path) if apk_path.exists() else None,
        "apk_existe": apk_path.exists(),
        "stdout_tail": "\n".join(result["stdout"].splitlines()[-25:]),
        "stderr_tail": "\n".join(result["stderr"].splitlines()[-25:]) if result["returncode"] != 0 else "",
    }


def install(release: bool = False, serial: str = None) -> dict:
    build_result = build(release)
    if not build_result["sucesso"] or not build_result["apk"]:
        return {"etapa": "build", "sucesso": False, "build": build_result}
    adb = _which("adb", "Instale Android Platform-Tools.")
    serial = serial or _require_device()
    suffix = ".debug" if not release else ""
    result = _run([adb, "-s", serial, "install", "-r", build_result["apk"]], timeout=300)
    return {
        "etapa": "install",
        "sucesso": result["returncode"] == 0,
        "serial": serial,
        "package": APP_ID + suffix,
        "saida": (result["stdout"] + result["stderr"]).strip()[:500],
        "build": {"task": build_result["task"], "apk": build_result["apk"]},
    }


def launch(release: bool = True, serial: str = None) -> dict:
    adb = _which("adb", "Instale Android Platform-Tools.")
    serial = serial or _require_device()
    package = APP_ID + ("" if release else ".debug")
    result = _run([adb, "-s", serial, "shell", "monkey", "-p", package, "-c",
                   "android.intent.category.LAUNCHER", "1"], timeout=60)
    sucesso = result["returncode"] == 0 and "Events injected: 1" in result["stdout"]
    saida = (result["stdout"] + result["stderr"]).strip()[:300]
    resposta = {"sucesso": sucesso, "serial": serial, "package": package, "saida": saida}
    if not sucesso:
        resposta["erro"] = f"launch falhou para {package} em {serial}: {saida}"
    return resposta


def stop(release: bool = True, serial: str = None) -> dict:
    adb = _which("adb", "Instale Android Platform-Tools.")
    serial = serial or _require_device()
    package = APP_ID + ("" if release else ".debug")
    result = _run([adb, "-s", serial, "shell", "am", "force-stop", package], timeout=60)
    resposta = {"sucesso": result["returncode"] == 0, "serial": serial, "package": package}
    if not resposta["sucesso"]:
        resposta["erro"] = f"stop falhou: {(result['stdout'] + result['stderr']).strip()[:200]}"
    return resposta


def uninstall(release: bool = True, serial: str = None) -> dict:
    adb = _which("adb", "Instale Android Platform-Tools.")
    serial = serial or _require_device()
    package = APP_ID + ("" if release else ".debug")
    result = _run([adb, "-s", serial, "uninstall", package], timeout=120)
    saida = (result["stdout"] + result["stderr"]).strip()
    sucesso = "Success" in saida
    resposta = {"sucesso": sucesso, "serial": serial, "package": package, "saida": saida[:200]}
    if not sucesso:
        resposta["erro"] = f"uninstall falhou: {saida[:200]}"
    return resposta


def logcat(linhas: int = 100, filtro: str = None, serial: str = None) -> dict:
    adb = _which("adb", "Instale Android Platform-Tools.")
    serial = serial or _require_device()
    cmd = [adb, "-s", serial, "logcat", "-d", "-t", str(linhas)]
    if filtro:
        cmd.append(f"*:{filtro}")
    result = _run(cmd, timeout=60)
    return {
        "serial": serial,
        "linhas": result["stdout"].splitlines(),
        "total": len(result["stdout"].splitlines()),
    }


def screenshot(saida: str = None, serial: str = None) -> dict:
    import tempfile

    adb = _which("adb", "Instale Android Platform-Tools.")
    serial = serial or _require_device()
    destino = Path(saida) if saida else Path(tempfile.gettempdir()) / f"mp3player_{serial}_{int(os.times()[0])}.png"
    remote = "/sdcard/_harness_shot.png"
    _run([adb, "-s", serial, "shell", "screencap", "-p", remote], timeout=60)
    pull = _run([adb, "-s", serial, "pull", remote, str(destino)], timeout=120)
    _run([adb, "-s", serial, "shell", "rm", remote], timeout=30)
    ok = pull["returncode"] == 0 and destino.exists()
    return {
        "sucesso": ok,
        "arquivo": str(destino) if ok else None,
        "bytes": destino.stat().st_size if ok else 0,
    }

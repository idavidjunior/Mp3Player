import argparse
import json
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from utils import android_backend as backend

BANNER = """MP3Player Harness CLI - controle do projeto via Gradle + ADB
Metodologia CLI-Anything internalizada no EcoSystemUmGrau"""


def _output(data, as_json: bool) -> int:
    if as_json:
        print(json.dumps(data, ensure_ascii=False, indent=2))
    else:
        print(json.dumps(data, ensure_ascii=False, indent=2))
    return 0 if data.get("sucesso", True) else 1


def _fail(message: str, as_json: bool) -> int:
    payload = {"sucesso": False, "erro": message}
    print(json.dumps(payload, ensure_ascii=False, indent=2))
    return 2


def main() -> int:
    parser = argparse.ArgumentParser(prog="mp3player-cli", description=BANNER)
    parser.add_argument("--json", action="store_true", help="saida em JSON (padrao)")
    sub = parser.add_subparsers(dest="comando", required=True)

    sub.add_parser("info", help="resumo do projeto e arquitetura")
    sub.add_parser("devices", help="dispositivos adb conectados")

    p_build = sub.add_parser("build", help="compila o APK")
    p_build.add_argument("--release", action="store_true")

    p_inst = sub.add_parser("install", help="compila e instala no dispositivo")
    p_inst.add_argument("--release", action="store_true")
    p_inst.add_argument("--serial", default=None)

    p_launch = sub.add_parser("launch", help="abre o app no dispositivo")
    p_launch.add_argument("--debug", action="store_true", help="usa package .debug")
    p_launch.add_argument("--serial", default=None)

    p_stop = sub.add_parser("stop", help="forca parada do app")
    p_stop.add_argument("--debug", action="store_true")
    p_stop.add_argument("--serial", default=None)

    p_uninst = sub.add_parser("uninstall", help="remove o app do dispositivo")
    p_uninst.add_argument("--debug", action="store_true")
    p_uninst.add_argument("--serial", default=None)

    p_log = sub.add_parser("logcat", help="captura logs do dispositivo")
    p_log.add_argument("-n", type=int, default=100)
    p_log.add_argument("--filtro", default=None, help="prioridade ex: E, W, I")
    p_log.add_argument("--serial", default=None)

    p_shot = sub.add_parser("screenshot", help="captura a tela do dispositivo")
    p_shot.add_argument("-o", "--saida", default=None)
    p_shot.add_argument("--serial", default=None)

    args = parser.parse_args()

    try:
        if args.comando == "info":
            return _output(backend.project_info(), args.json)
        if args.comando == "devices":
            devs = backend.devices()
            return _output({"sucesso": bool(devs), "dispositivos": devs}, args.json)

        release_flag = False
        serial = None
        debug_flag = False
        if args.comando == "build":
            return _output(backend.build(release=args.release), args.json)
        if args.comando == "install":
            release_flag = args.release
            serial = args.serial
        elif args.comando in ("launch", "stop", "uninstall"):
            debug_flag = getattr(args, "debug", False)
            serial = args.serial
        elif args.comando == "logcat":
            return _output(backend.logcat(linhas=args.n, filtro=args.filtro, serial=args.serial), args.json)
        elif args.comando == "screenshot":
            return _output(backend.screenshot(saida=args.saida, serial=args.serial), args.json)

        acoes = {
            "install": lambda: backend.install(release=release_flag, serial=serial),
            "launch": lambda: backend.launch(release=not debug_flag, serial=serial),
            "stop": lambda: backend.stop(release=not debug_flag, serial=serial),
            "uninstall": lambda: backend.uninstall(release=not debug_flag, serial=serial),
        }
        return _output(acoes[args.comando](), args.json)

    except backend.BackendError as exc:
        return _fail(str(exc), args.json)
    except Exception as exc:
        return _fail(f"erro inesperado: {type(exc).__name__}: {exc}", args.json)


if __name__ == "__main__":
    sys.exit(main())

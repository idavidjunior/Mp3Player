import json
import subprocess
import sys
import unittest
from pathlib import Path
from unittest.mock import patch

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))
from utils import android_backend as backend


class TestInfo(unittest.TestCase):
    def test_application_id(self):
        info = backend.project_info()
        self.assertEqual(info["application_id"], "com.mp3player")
        self.assertEqual(info["application_id_debug"], "com.mp3player.debug")

    def test_entidades_room(self):
        info = backend.project_info()
        self.assertIn("Playlist", info["entidades_room"])
        self.assertIn("Favorite", info["entidades_room"])
        self.assertGreaterEqual(len(info["daos"]), 2)

    def test_contagem_kotlin(self):
        info = backend.project_info()
        self.assertGreater(info["arquivos_kotlin"], 40)
        self.assertTrue(info["gradle_wrapper"])
        self.assertTrue(info["tem_cpp_nativo"])


class TestDevices(unittest.TestCase):
    def test_estrutura(self):
        devs = backend.devices()
        self.assertIsInstance(devs, list)
        for d in devs:
            self.assertIn("serial", d)
            self.assertIn("estado", d)

    @patch.object(backend, "devices", return_value=[{"serial": "x", "estado": "offline"}])
    def test_require_device_sem_device(self, _mock):
        with self.assertRaises(backend.BackendError) as ctx:
            backend._require_device()
        self.assertIn("Nenhum dispositivo", str(ctx.exception))


class TestCliSubprocess(unittest.TestCase):
    CLI_BASE = [sys.executable, str(ROOT / "mp3_cli.py")]

    def _run(self, args, timeout=120):
        return subprocess.run(
            self.CLI_BASE + args,
            capture_output=True,
            text=True,
            encoding="utf-8",
            errors="replace",
            timeout=timeout,
        )

    def test_help(self):
        result = self._run(["--help"])
        self.assertEqual(result.returncode, 0)
        self.assertIn("mp3player-cli", result.stdout + result.stderr)

    def test_info_ponta_a_ponta(self):
        result = self._run(["info"])
        data = json.loads(result.stdout)
        self.assertEqual(data["projeto"], "Mp3Player")
        self.assertEqual(result.returncode, 0)

    def test_comando_inexistente(self):
        result = self._run(["inexistente"])
        self.assertNotEqual(result.returncode, 0)

    def test_erro_controlado_json(self):
        result = self._run(["launch", "--serial", "serial_que_nao_existe"])
        data = json.loads(result.stdout)
        self.assertFalse(data["sucesso"])
        self.assertIn("erro", data)

    def test_devices_ponta_a_ponta(self):
        result = self._run(["devices"])
        self.assertEqual(result.returncode, 0)
        data = json.loads(result.stdout)
        self.assertIn("dispositivos", data)


if __name__ == "__main__":
    unittest.main()

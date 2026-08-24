# MP3Player Harness CLI

CLI para agentes operarem o projeto Mp3Player Android via Gradle e ADB. Construída com a metodologia CLI-Anything internalizada no EcoSystemUmGrau (mcp/desenvolvimento/habilidades/cli-anything).

## Uso

```
python mp3_cli.py info                    # arquitetura e metadados do projeto
python mp3_cli.py devices                 # dispositivos conectados
python mp3_cli.py build [--release]       # compila APK
python mp3_cli.py install [--release]     # compila e instala no celular
python mp3_cli.py launch [--debug]        # abre o app
python mp3_cli.py stop [--debug]          # força parada
python mp3_cli.py uninstall [--debug]     # remove do celular
python mp3_cli.py logcat -n 100           # captura logs
python mp3_cli.py screenshot -o tela.png  # captura tela
```

Toda saída é JSON com campo sucesso booleano. Respostas com sucesso false sempre incluem campo erro.

## Estrutura

- mp3_cli.py — CLI principal (argparse, stdlib pura)
- utils/android_backend.py — wrapper de gradlew e adb
- tests/test_core.py — 10 testes unittest
- tests/TEST.md — plano e resultados de teste

## Testes

```
python -m unittest discover -s tests -v
```

## Limitações v1

Sem manipulação do banco Room (playlists, favoritos). Sem filtro de logcat por package. Evoluções seguem o ciclo /refine da metodologia.

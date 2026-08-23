# TEST.md — Plano e Resultados de Teste do Harness MP3Player

## Parte 1 — Inventário Planejado

### test_core.py (unitários, sem dispositivo necessário)
- info: retorna dicionário com application_id correto, entidades Room presentes, contagem Kotlin maior que zero. 3 testes
- devices: estrutura serial+estado em cada entrada, nunca lança exceção sem device. 2 testes
- _require_device: falha controlada com BackendError quando não há device ativo. 1 teste
- build: caminho do APK calculado corretamente para debug e release. 2 testes
- CLI subprocess: --help retorna 0; info roda ponta a ponta; comando inexistente retorna 2. 3 testes
- Total planejado: 11 testes

### E2E com dispositivo real (manual ou quando 6d92eed7 conectado)
Fluxo 1 instalar e abrir: install → launch → screenshot → stop. Verifica APK instalado, app em foreground e PNG válido.
Fluxo 2 logs: launch → logcat -n 50. Verifica captura de linhas.

## Parte 2 — Resultados (anexar após execução)

Pendente: rodar python -m pytest tests/ -v após criar ambiente de teste.

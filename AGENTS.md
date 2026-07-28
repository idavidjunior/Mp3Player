# Instruções Globais

## Idioma
Todas as respostas devem ser em **português brasileiro**. O raciocínio interno pode ser em inglês, mas a comunicação com o usuário é sempre em PT-BR.

## Regra de Ouro
Ao final de cada tarefa neste projeto, sempre:

1. **Instalar no celular** (build + deploy)
2. **Atualizar no GitHub** (commit + push)
3. **Sincronizar no PC**

## Bug Fix: TagEditorActivity fecha imediatamente ao editar tags (commit 2e0ae0a)
- **Causa raiz:** InflateException no `TextInputLayout` do Material Components.
  `activity_tag_editor.xml` usa `com.google.android.material.textfield.TextInputLayout`
  que REQUER tema herdando de `Theme.MaterialComponents`. O app usava
  `Theme.AppCompat.DayNight.NoActionBar` → crash no inflate em `onCreate` linha 69.
- **Correção:** Mudar `Theme.Mp3Player` para `Theme.MaterialComponents.DayNight.NoActionBar`
  e `Theme_App_Light` para `Theme.MaterialComponents.Light.NoActionBar`.
- **Teste:** TagEditorActivity abre em ~357ms com todos os metadados carregados.

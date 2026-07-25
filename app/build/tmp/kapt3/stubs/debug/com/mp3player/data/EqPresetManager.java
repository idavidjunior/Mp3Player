package com.mp3player.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fJ\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/mp3player/data/EqPresetManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "addOrUpdatePreset", "", "preset", "Lcom/mp3player/data/EqPreset;", "deletePreset", "name", "", "loadCustomPresets", "", "saveCustomPresets", "presets", "", "app_debug"})
public final class EqPresetManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences prefs = null;
    
    public EqPresetManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mp3player.data.EqPreset> loadCustomPresets() {
        return null;
    }
    
    public final void saveCustomPresets(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.data.EqPreset> presets) {
    }
    
    public final void addOrUpdatePreset(@org.jetbrains.annotations.NotNull
    com.mp3player.data.EqPreset preset) {
    }
    
    public final void deletePreset(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
}
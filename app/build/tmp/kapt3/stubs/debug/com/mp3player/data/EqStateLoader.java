package com.mp3player.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/mp3player/data/EqStateLoader;", "", "()V", "BAND_COUNT", "", "FORMAT_VERSION", "KEY_ENABLED", "", "KEY_GAINS", "KEY_PREAMP", "KEY_VERSION", "PREFS_NAME", "restoreTo", "", "mp", "Lcom/mp3player/MusicPlayer;", "context", "Landroid/content/Context;", "app_debug"})
public final class EqStateLoader {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREFS_NAME = "eq_active_state";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_VERSION = "format_version";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_GAINS = "gains";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_PREAMP = "preamp";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_ENABLED = "eq_enabled";
    private static final int FORMAT_VERSION = 2;
    private static final int BAND_COUNT = 20;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.EqStateLoader INSTANCE = null;
    
    private EqStateLoader() {
        super();
    }
    
    public final void restoreTo(@org.jetbrains.annotations.NotNull
    com.mp3player.MusicPlayer mp, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
}
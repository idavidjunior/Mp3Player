package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0002J\u0014\u0010$\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001e\u0010&\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J\b\u0010*\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/mp3player/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "etFolderPath", "Landroid/widget/EditText;", "etMinDuration", "etMinSize", "folderPickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "onRescan", "Lkotlin/Function0;", "", "prefs", "Landroid/content/SharedPreferences;", "totalAlbums", "", "totalArtists", "totalSongs", "convertSafUriToPath", "", "uri", "getPermissionStatusText", "isPermissionGranted", "", "loadFilterSettings", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "c", "Landroid/view/ViewGroup;", "b", "Landroid/os/Bundle;", "onPause", "saveFilterSettings", "setOnRescan", "callback", "setStats", "songs", "artists", "albums", "updateViews", "app_debug"})
public final class SettingsFragment extends androidx.fragment.app.Fragment {
    private int totalSongs = 0;
    private int totalArtists = 0;
    private int totalAlbums = 0;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function0<kotlin.Unit> onRescan;
    @org.jetbrains.annotations.Nullable
    private android.content.SharedPreferences prefs;
    private android.widget.EditText etMinSize;
    private android.widget.EditText etMinDuration;
    private android.widget.EditText etFolderPath;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> folderPickerLauncher = null;
    
    public SettingsFragment() {
        super();
    }
    
    public final void setStats(int songs, int artists, int albums) {
    }
    
    public final void setOnRescan(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup c, @org.jetbrains.annotations.Nullable
    android.os.Bundle b) {
        return null;
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    private final void loadFilterSettings() {
    }
    
    private final void saveFilterSettings() {
    }
    
    private final java.lang.String convertSafUriToPath(android.net.Uri uri) {
        return null;
    }
    
    private final boolean isPermissionGranted() {
        return false;
    }
    
    private final java.lang.String getPermissionStatusText() {
        return null;
    }
    
    private final void updateViews() {
    }
}
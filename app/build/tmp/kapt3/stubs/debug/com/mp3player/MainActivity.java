package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009b\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\b\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020^H\u0002J\b\u0010`\u001a\u00020^H\u0002J\u0010\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020cH\u0002J\u0006\u0010d\u001a\u00020\u0010J\u0010\u0010e\u001a\u00020^2\u0006\u0010f\u001a\u00020\u0005H\u0002J\u0006\u0010g\u001a\u00020^J\"\u0010h\u001a\u00020^2\u0006\u0010i\u001a\u00020!2\u0006\u0010j\u001a\u00020!2\b\u0010k\u001a\u0004\u0018\u00010SH\u0014J\b\u0010l\u001a\u00020^H\u0016J\u0012\u0010m\u001a\u00020^2\b\u0010n\u001a\u0004\u0018\u00010oH\u0014J\b\u0010p\u001a\u00020^H\u0014J\b\u0010q\u001a\u00020^H\u0014J-\u0010r\u001a\u00020^2\u0006\u0010i\u001a\u00020!2\u000e\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050t2\u0006\u0010u\u001a\u00020vH\u0016\u00a2\u0006\u0002\u0010wJ\b\u0010x\u001a\u00020^H\u0014J\b\u0010y\u001a\u00020^H\u0014J\b\u0010z\u001a\u00020^H\u0014J\u0010\u0010{\u001a\u00020^2\u0006\u0010|\u001a\u00020}H\u0002J\u0010\u0010~\u001a\u00020^2\u0006\u0010|\u001a\u00020\u007fH\u0002J\u0007\u0010\u0080\u0001\u001a\u00020^J\u0010\u0010\u0081\u0001\u001a\u00020^2\u0007\u0010\u0082\u0001\u001a\u00020$J\u0007\u0010\u0083\u0001\u001a\u00020^J\u0007\u0010\u0084\u0001\u001a\u00020^J\u001f\u0010\u0085\u0001\u001a\u00020^2\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020$0#2\u0007\u0010\u0087\u0001\u001a\u00020!J\u000f\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J*\u0010\u0089\u0001\u001a\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008a\u00012\u0006\u0010f\u001a\u00020\u0005H\u0002J\t\u0010\u008b\u0001\u001a\u00020^H\u0002J\t\u0010\u008c\u0001\u001a\u00020^H\u0002J\t\u0010\u008d\u0001\u001a\u00020^H\u0002J\t\u0010\u008e\u0001\u001a\u00020^H\u0002J\t\u0010\u008f\u0001\u001a\u00020^H\u0002J\t\u0010\u0090\u0001\u001a\u00020^H\u0002J\t\u0010\u0091\u0001\u001a\u00020^H\u0002J\t\u0010\u0092\u0001\u001a\u00020^H\u0002J\t\u0010\u0093\u0001\u001a\u00020^H\u0002J\u0013\u0010\u0094\u0001\u001a\u00020^2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\t\u0010\u0097\u0001\u001a\u00020^H\u0002J\t\u0010\u0098\u0001\u001a\u00020^H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020^2\u0007\u0010\u009a\u0001\u001a\u00020!H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u000e\u00109\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010>\u001a\u0004\u0018\u00010=2\b\u0010<\u001a\u0004\u0018\u00010=@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020$0L\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\u0010\u0012\f\u0012\n T*\u0004\u0018\u00010S0S0RX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020VX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020VX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020VX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020CX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/mp3player/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "albumArtCache", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "albumsFragment", "Lcom/mp3player/AlbumsFragment;", "artistsFragment", "Lcom/mp3player/ArtistsFragment;", "audioManager", "Landroid/media/AudioManager;", "bottomNav", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "bound", "", "btnExpandPlayer", "Landroid/widget/ImageButton;", "btnMiniNext", "btnMiniPlayPause", "btnMiniPrev", "btnNext", "btnPlayPause", "btnPrev", "btnRepeat", "btnShuffle", "btnSleepTimer", "connection", "Landroid/content/ServiceConnection;", "contentObserver", "Landroid/database/ContentObserver;", "currentIndex", "", "currentPlaylist", "", "Lcom/mp3player/Song;", "etSearch", "Landroid/widget/EditText;", "expandedControls", "Landroid/view/View;", "foldersFragment", "Lcom/mp3player/FoldersFragment;", "fragmentContainer", "Landroidx/fragment/app/FragmentContainerView;", "isSeeking", "isVolumeChanging", "ivAlbumArt", "Landroid/widget/ImageView;", "ivVolumeIcon", "pendingPermission", "playCountManager", "Lcom/mp3player/data/PlayCountManager;", "getPlayCountManager", "()Lcom/mp3player/data/PlayCountManager;", "playCountManager$delegate", "Lkotlin/Lazy;", "playerExpanded", "playerPanel", "playerPanelDivider", "<set-?>", "Lcom/mp3player/PlayerService;", "playerService", "getPlayerService", "()Lcom/mp3player/PlayerService;", "searchQuery", "seekBar", "Landroid/widget/SeekBar;", "seekBarUpdater", "Ljava/lang/Runnable;", "settingsFragment", "Lcom/mp3player/SettingsFragment;", "sleepTimer", "Landroid/os/CountDownTimer;", "sleepTimerMinutes", "songs", "", "getSongs", "()Ljava/util/List;", "songsFragment", "Lcom/mp3player/SongsFragment;", "tagEditorLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "tvCurrentTime", "Landroid/widget/TextView;", "tvSongArtist", "tvSongTitle", "tvTotalTime", "volumeSeekBar", "applyFilters", "rawSongs", "bindViews", "", "checkAndRequestPermissions", "filterSongs", "formatTime", "millis", "", "hasRequiredPermission", "loadAlbumArt", "path", "loadSongs", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "openAlbumDetail", "item", "Lcom/mp3player/AlbumItem;", "openArtistDetail", "Lcom/mp3player/ArtistItem;", "openNowPlaying", "openTagEditor", "song", "playNext", "playPrevious", "playSongFromList", "songsList", "index", "querySongs", "readMetadataFromFile", "Lkotlin/Triple;", "requestLegacyPermission", "requestMediaPermission", "setupBottomNav", "setupControls", "setupFragments", "setupSearch", "showLegacyRationaleDialog", "showManageStorageDialog", "showSleepTimerDialog", "switchFragment", "f", "Landroidx/fragment/app/Fragment;", "syncViewVisibility", "updateSeekBar", "updateVolumeIcon", "progress", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.android.material.bottomnavigation.BottomNavigationView bottomNav;
    private androidx.fragment.app.FragmentContainerView fragmentContainer;
    private android.widget.ImageButton btnPlayPause;
    private android.widget.ImageButton btnNext;
    private android.widget.ImageButton btnPrev;
    private android.widget.ImageButton btnShuffle;
    private android.widget.ImageButton btnRepeat;
    private android.widget.SeekBar seekBar;
    private android.widget.TextView tvCurrentTime;
    private android.widget.TextView tvTotalTime;
    private android.widget.TextView tvSongTitle;
    private android.widget.TextView tvSongArtist;
    private android.widget.ImageView ivAlbumArt;
    private android.widget.ImageView ivVolumeIcon;
    private android.widget.SeekBar volumeSeekBar;
    private android.widget.ImageButton btnExpandPlayer;
    private android.view.View expandedControls;
    private android.widget.ImageButton btnSleepTimer;
    private android.view.View playerPanel;
    private android.widget.EditText etSearch;
    private android.widget.ImageButton btnMiniPrev;
    private android.widget.ImageButton btnMiniPlayPause;
    private android.widget.ImageButton btnMiniNext;
    private boolean playerExpanded = false;
    @org.jetbrains.annotations.NotNull
    private android.util.LruCache<java.lang.String, android.graphics.Bitmap> albumArtCache;
    @org.jetbrains.annotations.Nullable
    private android.os.CountDownTimer sleepTimer;
    private int sleepTimerMinutes = 0;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mp3player.Song> currentPlaylist;
    @org.jetbrains.annotations.Nullable
    private android.media.AudioManager audioManager;
    private boolean isVolumeChanging = false;
    private android.view.View playerPanelDivider;
    @org.jetbrains.annotations.Nullable
    private com.mp3player.PlayerService playerService;
    private boolean bound = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.mp3player.Song> songs = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy playCountManager$delegate = null;
    private int currentIndex = -1;
    private boolean isSeeking = false;
    private boolean pendingPermission = false;
    @org.jetbrains.annotations.NotNull
    private java.lang.String searchQuery = "";
    @org.jetbrains.annotations.NotNull
    private final java.lang.Runnable seekBarUpdater = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> tagEditorLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final android.database.ContentObserver contentObserver = null;
    private com.mp3player.SongsFragment songsFragment;
    private com.mp3player.AlbumsFragment albumsFragment;
    private com.mp3player.ArtistsFragment artistsFragment;
    private com.mp3player.FoldersFragment foldersFragment;
    private com.mp3player.SettingsFragment settingsFragment;
    @org.jetbrains.annotations.NotNull
    private final android.content.ServiceConnection connection = null;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final int MANAGE_STORAGE_REQUEST_CODE = 101;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "Mp3Player.MainActivity";
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.MainActivity.Companion Companion = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mp3player.PlayerService getPlayerService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mp3player.Song> getSongs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mp3player.data.PlayCountManager getPlayCountManager() {
        return null;
    }
    
    public final void openTagEditor(@org.jetbrains.annotations.NotNull
    com.mp3player.Song song) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @java.lang.Override
    protected void onStop() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    public final boolean hasRequiredPermission() {
        return false;
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void syncViewVisibility() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    private final void bindViews() {
    }
    
    private final void setupFragments() {
    }
    
    private final void setupBottomNav() {
    }
    
    private final void switchFragment(androidx.fragment.app.Fragment f) {
    }
    
    public final void playSongFromList(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.Song> songsList, int index) {
    }
    
    private final void loadAlbumArt(java.lang.String path) {
    }
    
    private final void setupControls() {
    }
    
    private final void updateVolumeIcon(int progress) {
    }
    
    private final void showSleepTimerDialog() {
    }
    
    private final void setupSearch() {
    }
    
    private final void filterSongs() {
    }
    
    public final void playNext() {
    }
    
    public final void playPrevious() {
    }
    
    public final void openNowPlaying() {
    }
    
    private final void updateSeekBar() {
    }
    
    private final void checkAndRequestPermissions() {
    }
    
    private final void showManageStorageDialog() {
    }
    
    private final void requestMediaPermission() {
    }
    
    private final void showLegacyRationaleDialog() {
    }
    
    private final void requestLegacyPermission() {
    }
    
    @java.lang.Override
    @kotlin.Suppress(names = {"DEPRECATION"})
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    public final void loadSongs() {
    }
    
    private final java.util.List<com.mp3player.Song> querySongs() {
        return null;
    }
    
    private final java.util.List<com.mp3player.Song> applyFilters(java.util.List<com.mp3player.Song> rawSongs) {
        return null;
    }
    
    private final void openAlbumDetail(com.mp3player.AlbumItem item) {
    }
    
    private final void openArtistDetail(com.mp3player.ArtistItem item) {
    }
    
    @java.lang.Override
    @kotlin.Suppress(names = {"DEPRECATION"})
    public void onBackPressed() {
    }
    
    private final kotlin.Triple<java.lang.String, java.lang.String, java.lang.String> readMetadataFromFile(java.lang.String path) {
        return null;
    }
    
    private final java.lang.String formatTime(long millis) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/mp3player/MainActivity$Companion;", "", "()V", "MANAGE_STORAGE_REQUEST_CODE", "", "PERMISSION_REQUEST_CODE", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
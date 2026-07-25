package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\u0019H\u0016J\b\u00107\u001a\u00020\u0019H\u0002J\u0010\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010\u0010J(\u0010:\u001a\u00020\u00192\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/mp3player/SongsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/mp3player/SongAdapter;", "allSongs", "", "Lcom/mp3player/Song;", "btnAddSelected", "Landroid/widget/Button;", "btnFilterAll", "btnFilterFav", "btnMultiSelect", "btnSort", "btnViewMode", "currentSongPath", "", "currentSort", "Lcom/mp3player/SortMode;", "currentView", "Lcom/mp3player/ViewMode;", "filterJob", "Lkotlinx/coroutines/Job;", "onSongClick", "Lkotlin/Function1;", "", "prefs", "Landroid/content/SharedPreferences;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "repository", "Lcom/mp3player/data/repository/MusicRepository;", "showFavoritesOnly", "", "sortDialogLabels", "", "[Ljava/lang/String;", "sortLabels", "", "sortOptions", "swipeRefresh", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "tvEmpty", "Landroid/widget/TextView;", "applyFilter", "exitMultiSelect", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "scrollToCurrentSong", "setCurrentSongPath", "path", "setSongs", "songs", "onPlay", "app_debug"})
public final class SongsFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefresh;
    private android.widget.TextView tvEmpty;
    private com.mp3player.SongAdapter adapter;
    private android.widget.Button btnFilterAll;
    private android.widget.Button btnFilterFav;
    private android.widget.Button btnSort;
    private android.widget.Button btnViewMode;
    private android.widget.Button btnMultiSelect;
    private android.widget.Button btnAddSelected;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mp3player.Song> allSongs;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onSongClick;
    private boolean showFavoritesOnly = false;
    @org.jetbrains.annotations.Nullable
    private com.mp3player.data.repository.MusicRepository repository;
    @org.jetbrains.annotations.Nullable
    private android.content.SharedPreferences prefs;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job filterJob;
    @org.jetbrains.annotations.NotNull
    private com.mp3player.SortMode currentSort = com.mp3player.SortMode.TITLE;
    @org.jetbrains.annotations.NotNull
    private com.mp3player.ViewMode currentView = com.mp3player.ViewMode.DETAILED;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currentSongPath;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<com.mp3player.SortMode, java.lang.String> sortLabels = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.mp3player.SortMode> sortOptions = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String[] sortDialogLabels = {"Nome (A-Z)", "Artista", "\u00c1lbum", "Dura\u00e7\u00e3o", "Data de adi\u00e7\u00e3o", "Mais Tocadas"};
    
    public SongsFragment() {
        super();
    }
    
    public final void setSongs(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.Song> songs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onPlay) {
    }
    
    public final void setCurrentSongPath(@org.jetbrains.annotations.Nullable
    java.lang.String path) {
    }
    
    private final void scrollToCurrentSong() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    private final void exitMultiSelect() {
    }
    
    private final void applyFilter() {
    }
}
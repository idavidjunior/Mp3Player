package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\bZ[\\]^_`aB\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ \u00105\u001a\u00020\b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J \u0010;\u001a\u00020\b2\u0006\u00106\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J \u0010<\u001a\u00020\b2\u0006\u00106\u001a\u00020=2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J \u0010>\u001a\u00020\b2\u0006\u00106\u001a\u00020?2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J \u0010@\u001a\u00020\b2\u0006\u00106\u001a\u00020A2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J \u0010B\u001a\u00020\b2\u0006\u00106\u001a\u00020C2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J \u0010D\u001a\u00020\b2\u0006\u00106\u001a\u00020E2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J \u0010F\u001a\u00020\b2\u0006\u00106\u001a\u00020G2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J\u0006\u0010H\u001a\u00020\bJ\b\u0010I\u001a\u00020:H\u0016J\u0010\u0010J\u001a\u00020:2\u0006\u00109\u001a\u00020:H\u0016J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020PH\u0002J\u0018\u0010Q\u001a\u00020\b2\u0006\u00106\u001a\u00020\u00022\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010R\u001a\u00020\u00022\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020:H\u0016J\u0018\u0010V\u001a\u00020\b2\u0006\u00106\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0005H\u0002J\u0006\u0010W\u001a\u00020\bJ\u0014\u0010X\u001a\u00020\b2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b\'\u0010$R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u00100\u001a\u00020/2\u0006\u0010\r\u001a\u00020/@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006b"}, d2 = {"Lcom/mp3player/SongAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "songs", "", "Lcom/mp3player/Song;", "onItemClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "currentList", "getCurrentList", "()Ljava/util/List;", "value", "", "currentSongPath", "getCurrentSongPath", "()Ljava/lang/String;", "setCurrentSongPath", "(Ljava/lang/String;)V", "favoritePaths", "", "getFavoritePaths", "()Ljava/util/Set;", "setFavoritePaths", "(Ljava/util/Set;)V", "multiSelectMode", "", "getMultiSelectMode", "()Z", "setMultiSelectMode", "(Z)V", "onAddToQueue", "getOnAddToQueue", "()Lkotlin/jvm/functions/Function1;", "setOnAddToQueue", "(Lkotlin/jvm/functions/Function1;)V", "onEditTag", "getOnEditTag", "setOnEditTag", "onFavoriteClick", "getOnFavoriteClick", "setOnFavoriteClick", "scope", "Lkotlinx/coroutines/CoroutineScope;", "selectedSongs", "getSelectedSongs", "Lcom/mp3player/ViewMode;", "viewMode", "getViewMode", "()Lcom/mp3player/ViewMode;", "setViewMode", "(Lcom/mp3player/ViewMode;)V", "bindCard", "holder", "Lcom/mp3player/SongAdapter$CardViewHolder;", "song", "position", "", "bindCommon", "bindCompact", "Lcom/mp3player/SongAdapter$CompactViewHolder;", "bindCoverSmall", "Lcom/mp3player/SongAdapter$CoverSmallViewHolder;", "bindDetailed", "Lcom/mp3player/SongAdapter$DetailedViewHolder;", "bindGrid", "Lcom/mp3player/SongAdapter$GridViewHolder;", "bindListLarge", "Lcom/mp3player/SongAdapter$ListLargeViewHolder;", "bindTextOnly", "Lcom/mp3player/SongAdapter$TextOnlyViewHolder;", "cleanup", "getItemCount", "getItemViewType", "loadAlbumArtAsync", "imageView", "Landroid/widget/ImageView;", "path", "context", "Landroid/content/Context;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemBackground", "toggleMultiSelect", "updateSongs", "newSongs", "CardViewHolder", "CompactViewHolder", "Companion", "CoverSmallViewHolder", "DetailedViewHolder", "GridViewHolder", "ListLargeViewHolder", "TextOnlyViewHolder", "app_debug"})
public final class SongAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mp3player.Song> songs;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.mp3player.Song, kotlin.Unit> onItemClick = null;
    private static final int VT_DETAILED = 0;
    private static final int VT_COMPACT = 1;
    private static final int VT_CARD = 2;
    private static final int VT_LIST_LARGE = 3;
    private static final int VT_GRID = 4;
    private static final int VT_TEXT_ONLY = 5;
    private static final int VT_COVER_SMALL = 6;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currentSongPath;
    @org.jetbrains.annotations.NotNull
    private com.mp3player.ViewMode viewMode = com.mp3player.ViewMode.DETAILED;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onAddToQueue;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onFavoriteClick;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onEditTag;
    private boolean multiSelectMode = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.Set<com.mp3player.Song> selectedSongs = null;
    @org.jetbrains.annotations.NotNull
    private java.util.Set<java.lang.String> favoritePaths;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.SongAdapter.Companion Companion = null;
    
    public SongAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.Song> songs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onItemClick) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentSongPath() {
        return null;
    }
    
    public final void setCurrentSongPath(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mp3player.ViewMode getViewMode() {
        return null;
    }
    
    public final void setViewMode(@org.jetbrains.annotations.NotNull
    com.mp3player.ViewMode value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlin.jvm.functions.Function1<com.mp3player.Song, kotlin.Unit> getOnAddToQueue() {
        return null;
    }
    
    public final void setOnAddToQueue(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlin.jvm.functions.Function1<com.mp3player.Song, kotlin.Unit> getOnFavoriteClick() {
        return null;
    }
    
    public final void setOnFavoriteClick(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlin.jvm.functions.Function1<com.mp3player.Song, kotlin.Unit> getOnEditTag() {
        return null;
    }
    
    public final void setOnEditTag(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> p0) {
    }
    
    public final boolean getMultiSelectMode() {
        return false;
    }
    
    public final void setMultiSelectMode(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<com.mp3player.Song> getSelectedSongs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<java.lang.String> getFavoritePaths() {
        return null;
    }
    
    public final void setFavoritePaths(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> p0) {
    }
    
    public final void cleanup() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mp3player.Song> getCurrentList() {
        return null;
    }
    
    public final void updateSongs(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.Song> newSongs) {
    }
    
    public final void toggleMultiSelect() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mp3player.Song> getSelectedSongs() {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    private final void setItemBackground(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mp3player.Song song) {
    }
    
    private final void loadAlbumArtAsync(android.widget.ImageView imageView, java.lang.String path, android.content.Context context) {
    }
    
    private final void bindDetailed(com.mp3player.SongAdapter.DetailedViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    private final void bindCompact(com.mp3player.SongAdapter.CompactViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    private final void bindCard(com.mp3player.SongAdapter.CardViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    private final void bindListLarge(com.mp3player.SongAdapter.ListLargeViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    private final void bindGrid(com.mp3player.SongAdapter.GridViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    private final void bindTextOnly(com.mp3player.SongAdapter.TextOnlyViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    private final void bindCoverSmall(com.mp3player.SongAdapter.CoverSmallViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    private final void bindCommon(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, com.mp3player.Song song, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/mp3player/SongAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "album", "Landroid/widget/TextView;", "getAlbum", "()Landroid/widget/TextView;", "albumArt", "Landroid/widget/ImageView;", "getAlbumArt", "()Landroid/widget/ImageView;", "artist", "getArtist", "cardBorder", "getCardBorder", "()Landroid/view/View;", "duration", "getDuration", "title", "getTitle", "app_debug"})
    public static final class CardViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView albumArt = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView artist = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView album = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView duration = null;
        @org.jetbrains.annotations.NotNull
        private final android.view.View cardBorder = null;
        
        public CardViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getAlbumArt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getArtist() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getAlbum() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDuration() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.view.View getCardBorder() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/mp3player/SongAdapter$CompactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "artist", "Landroid/widget/TextView;", "getArtist", "()Landroid/widget/TextView;", "duration", "getDuration", "title", "getTitle", "app_debug"})
    public static final class CompactViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView artist = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView duration = null;
        
        public CompactViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getArtist() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDuration() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ8\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/mp3player/SongAdapter$Companion;", "", "()V", "VT_CARD", "", "VT_COMPACT", "VT_COVER_SMALL", "VT_DETAILED", "VT_GRID", "VT_LIST_LARGE", "VT_TEXT_ONLY", "formatDuration", "", "millis", "", "sortSongs", "", "Lcom/mp3player/Song;", "songs", "mode", "Lcom/mp3player/SortMode;", "playCounts", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String formatDuration(long millis) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.mp3player.Song> sortSongs(@org.jetbrains.annotations.NotNull
        java.util.List<com.mp3player.Song> songs, @org.jetbrains.annotations.NotNull
        com.mp3player.SortMode mode, @org.jetbrains.annotations.NotNull
        java.util.Map<java.lang.String, java.lang.Integer> playCounts) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/mp3player/SongAdapter$CoverSmallViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "albumArt", "Landroid/widget/ImageView;", "getAlbumArt", "()Landroid/widget/ImageView;", "artist", "Landroid/widget/TextView;", "getArtist", "()Landroid/widget/TextView;", "duration", "getDuration", "title", "getTitle", "app_debug"})
    public static final class CoverSmallViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView albumArt = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView artist = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView duration = null;
        
        public CoverSmallViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getAlbumArt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getArtist() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDuration() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/mp3player/SongAdapter$DetailedViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "albumArt", "Landroid/widget/ImageView;", "getAlbumArt", "()Landroid/widget/ImageView;", "artist", "Landroid/widget/TextView;", "getArtist", "()Landroid/widget/TextView;", "duration", "getDuration", "title", "getTitle", "app_debug"})
    public static final class DetailedViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView albumArt = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView artist = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView duration = null;
        
        public DetailedViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getAlbumArt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getArtist() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDuration() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/mp3player/SongAdapter$GridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "albumArt", "Landroid/widget/ImageView;", "getAlbumArt", "()Landroid/widget/ImageView;", "artist", "Landroid/widget/TextView;", "getArtist", "()Landroid/widget/TextView;", "title", "getTitle", "app_debug"})
    public static final class GridViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView albumArt = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView artist = null;
        
        public GridViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getAlbumArt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getArtist() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/mp3player/SongAdapter$ListLargeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "album", "Landroid/widget/TextView;", "getAlbum", "()Landroid/widget/TextView;", "albumArt", "Landroid/widget/ImageView;", "getAlbumArt", "()Landroid/widget/ImageView;", "artist", "getArtist", "duration", "getDuration", "title", "getTitle", "app_debug"})
    public static final class ListLargeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView albumArt = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView artist = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView album = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView duration = null;
        
        public ListLargeViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getAlbumArt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getArtist() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getAlbum() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDuration() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/mp3player/SongAdapter$TextOnlyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "artist", "Landroid/widget/TextView;", "getArtist", "()Landroid/widget/TextView;", "duration", "getDuration", "title", "getTitle", "app_debug"})
    public static final class TextOnlyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView artist = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView duration = null;
        
        public TextOnlyViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getArtist() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDuration() {
            return null;
        }
    }
}
package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/mp3player/ArtistAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/mp3player/ArtistAdapter$ViewHolder;", "artists", "", "Lcom/mp3player/ArtistItem;", "onItemClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cleanup", "getItemCount", "", "onBindViewHolder", "h", "i", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateArtists", "new", "ViewHolder", "app_debug"})
public final class ArtistAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.mp3player.ArtistAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mp3player.ArtistItem> artists;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.mp3player.ArtistItem, kotlin.Unit> onItemClick = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    public ArtistAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.ArtistItem> artists, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mp3player.ArtistItem, kotlin.Unit> onItemClick) {
        super();
    }
    
    public final void updateArtists(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.ArtistItem> p0_54480) {
    }
    
    public final void cleanup() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.mp3player.ArtistAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.mp3player.ArtistAdapter.ViewHolder h, int i) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/mp3player/ArtistAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "art", "Landroid/widget/ImageView;", "getArt", "()Landroid/widget/ImageView;", "detail", "Landroid/widget/TextView;", "getDetail", "()Landroid/widget/TextView;", "name", "getName", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView name = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView detail = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView art = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View v) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDetail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getArt() {
            return null;
        }
    }
}
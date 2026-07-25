package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J8\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/mp3player/ArtistDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/mp3player/SongAdapter;", "onPlay", "Lkotlin/Function1;", "Lcom/mp3player/Song;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "songs", "", "tvArtistInfo", "Landroid/widget/TextView;", "tvArtistName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "c", "Landroid/view/ViewGroup;", "b", "Landroid/os/Bundle;", "onDestroyView", "setArtist", "name", "", "albumCount", "", "songList", "onPlaySong", "app_debug"})
public final class ArtistDetailFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.mp3player.SongAdapter adapter;
    private android.widget.TextView tvArtistName;
    private android.widget.TextView tvArtistInfo;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mp3player.Song> songs;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onPlay;
    
    public ArtistDetailFragment() {
        super();
    }
    
    public final void setArtist(@org.jetbrains.annotations.NotNull
    java.lang.String name, int albumCount, @org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.Song> songList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onPlaySong) {
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
    public void onDestroyView() {
    }
}
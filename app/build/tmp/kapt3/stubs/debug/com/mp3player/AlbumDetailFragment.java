package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J8\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/mp3player/AlbumDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/mp3player/SongAdapter;", "albumName", "", "artistName", "onPlay", "Lkotlin/Function1;", "Lcom/mp3player/Song;", "", "pendingAlbumName", "pendingArtistName", "pendingSongs", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "songs", "tvAlbumInfo", "Landroid/widget/TextView;", "tvAlbumName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "c", "Landroid/view/ViewGroup;", "b", "Landroid/os/Bundle;", "onDestroyView", "setAlbum", "name", "artist", "songList", "onPlaySong", "app_debug"})
public final class AlbumDetailFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.mp3player.SongAdapter adapter;
    private android.widget.TextView tvAlbumName;
    private android.widget.TextView tvAlbumInfo;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mp3player.Song> songs;
    @org.jetbrains.annotations.NotNull
    private java.lang.String albumName = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String artistName = "";
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> onPlay;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.mp3player.Song> pendingSongs;
    @org.jetbrains.annotations.Nullable
    private java.lang.String pendingAlbumName;
    @org.jetbrains.annotations.Nullable
    private java.lang.String pendingArtistName;
    
    public AlbumDetailFragment() {
        super();
    }
    
    public final void setAlbum(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String artist, @org.jetbrains.annotations.NotNull
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
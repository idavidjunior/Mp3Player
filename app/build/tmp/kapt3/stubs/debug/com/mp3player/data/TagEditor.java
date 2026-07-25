package com.mp3player.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0016\u0010\u0016\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\fJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\fH\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 J.\u0010!\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fJ\u0016\u0010\'\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020(*\u0004\u0018\u00010\fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006+"}, d2 = {"Lcom/mp3player/data/TagEditor;", "", "()V", "tagProcessor", "Lcom/mp3player/data/tagging/FallbackTagProcessor;", "getTagProcessor", "()Lcom/mp3player/data/tagging/FallbackTagProcessor;", "tagProcessor$delegate", "Lkotlin/Lazy;", "findAlbumInfo", "Lcom/mp3player/data/model/MusicMetadata;", "songPath", "", "songAlbum", "songArtist", "context", "Landroid/content/Context;", "getMediaStoreSongsByAlbum", "", "albumName", "getMediaStoreSongsByArtist", "artistName", "mergeMetadata", "others", "readEmbeddedTags", "path", "readEmbeddedWithRetriever", "showEditDialog", "", "song", "Lcom/mp3player/Song;", "onSaved", "Lkotlin/Function0;", "updateMediaStore", "songId", "", "title", "artist", "album", "writeTags", "", "metadata", "isUsable", "app_debug"})
public final class TagEditor {
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy tagProcessor$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.TagEditor INSTANCE = null;
    
    private TagEditor() {
        super();
    }
    
    private final com.mp3player.data.tagging.FallbackTagProcessor getTagProcessor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mp3player.data.model.MusicMetadata readEmbeddedTags(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return null;
    }
    
    public final boolean writeTags(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    com.mp3player.data.model.MusicMetadata metadata) {
        return false;
    }
    
    public final void updateMediaStore(@org.jetbrains.annotations.NotNull
    android.content.Context context, long songId, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String artist, @org.jetbrains.annotations.NotNull
    java.lang.String album) {
    }
    
    private final java.util.List<java.lang.String> getMediaStoreSongsByAlbum(android.content.Context context, java.lang.String albumName) {
        return null;
    }
    
    private final java.util.List<java.lang.String> getMediaStoreSongsByArtist(android.content.Context context, java.lang.String artistName) {
        return null;
    }
    
    private final com.mp3player.data.model.MusicMetadata readEmbeddedWithRetriever(java.lang.String path) {
        return null;
    }
    
    private final boolean isUsable(java.lang.String $this$isUsable) {
        return false;
    }
    
    private final com.mp3player.data.model.MusicMetadata mergeMetadata(java.util.List<com.mp3player.data.model.MusicMetadata> others) {
        return null;
    }
    
    private final com.mp3player.data.model.MusicMetadata findAlbumInfo(java.lang.String songPath, java.lang.String songAlbum, java.lang.String songArtist, android.content.Context context) {
        return null;
    }
    
    public final void showEditDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mp3player.Song song, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSaved) {
    }
}
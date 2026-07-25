package com.mp3player.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fJ\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0 0\u001fJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fJ\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0 0\u001f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u001f2\u0006\u0010)\u001a\u00020\u001aJ\u0016\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010+\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010,\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/mp3player/data/repository/MusicRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Lcom/mp3player/data/AppDatabase;", "favoriteDao", "Lcom/mp3player/data/dao/FavoriteDao;", "playlistDao", "Lcom/mp3player/data/dao/PlaylistDao;", "addFavorite", "", "song", "Lcom/mp3player/Song;", "(Lcom/mp3player/Song;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addSongToPlaylist", "playlistId", "", "position", "", "(JLcom/mp3player/Song;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearPlaylist", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPlaylist", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaylist", "id", "getAllFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mp3player/data/entity/FavoriteEntity;", "getAllPlaylists", "Lcom/mp3player/data/entity/PlaylistEntity;", "getFavoriteCount", "getPlaylistSongs", "Lcom/mp3player/data/entity/PlaylistSongEntity;", "isFavorite", "", "songPath", "isFavoriteSync", "removeFavorite", "removeSongFromPlaylist", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleFavorite", "app_debug"})
public final class MusicRepository {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.mp3player.data.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final com.mp3player.data.dao.FavoriteDao favoriteDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.mp3player.data.dao.PlaylistDao playlistDao = null;
    
    public MusicRepository(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.mp3player.data.entity.FavoriteEntity>> getAllFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String songPath) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object isFavoriteSync(@org.jetbrains.annotations.NotNull
    java.lang.String songPath, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object toggleFavorite(@org.jetbrains.annotations.NotNull
    com.mp3player.Song song, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull
    com.mp3player.Song song, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object removeFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String songPath, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getFavoriteCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.mp3player.data.entity.PlaylistEntity>> getAllPlaylists() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createPlaylist(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deletePlaylist(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.mp3player.data.entity.PlaylistSongEntity>> getPlaylistSongs(long playlistId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addSongToPlaylist(long playlistId, @org.jetbrains.annotations.NotNull
    com.mp3player.Song song, int position, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object removeSongFromPlaylist(long playlistId, @org.jetbrains.annotations.NotNull
    java.lang.String songPath, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearPlaylist(long playlistId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
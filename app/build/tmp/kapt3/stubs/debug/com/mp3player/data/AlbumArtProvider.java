package com.mp3player.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/mp3player/data/AlbumArtProvider;", "", "()V", "cacheDir", "", "getCacheDir", "()Ljava/lang/String;", "cacheDir$delegate", "Lkotlin/Lazy;", "memoryCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "clearCache", "", "findCoverBytes", "", "path", "getAlbumArt", "context", "Landroid/content/Context;", "loadEmbedded", "loadFromFile", "loadFromFolder", "saveToCache", "bmp", "app_debug"})
public final class AlbumArtProvider {
    @org.jetbrains.annotations.NotNull
    private static final android.util.LruCache<java.lang.String, android.graphics.Bitmap> memoryCache = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy cacheDir$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.AlbumArtProvider INSTANCE = null;
    
    private AlbumArtProvider() {
        super();
    }
    
    private final java.lang.String getCacheDir() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.Bitmap getAlbumArt(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.Nullable
    android.content.Context context) {
        return null;
    }
    
    private final android.graphics.Bitmap loadEmbedded(java.lang.String path) {
        return null;
    }
    
    private final android.graphics.Bitmap loadFromFile(java.lang.String path) {
        return null;
    }
    
    private final void saveToCache(java.lang.String path, android.graphics.Bitmap bmp) {
    }
    
    private final android.graphics.Bitmap loadFromFolder(java.lang.String path, android.content.Context context) {
        return null;
    }
    
    public final void clearCache() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final byte[] findCoverBytes(@org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return null;
    }
}
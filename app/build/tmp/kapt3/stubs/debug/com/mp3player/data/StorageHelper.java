package com.mp3player.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001d"}, d2 = {"Lcom/mp3player/data/StorageHelper;", "", "()V", "TAG", "", "tagProcessor", "Lcom/mp3player/data/tagging/FallbackTagProcessor;", "getTagProcessor", "()Lcom/mp3player/data/tagging/FallbackTagProcessor;", "tagProcessor$delegate", "Lkotlin/Lazy;", "copyBackToPfd", "", "tempFile", "Ljava/io/File;", "pfd", "Landroid/os/ParcelFileDescriptor;", "createTempFileFromPfd", "originalPath", "updateMediaStore", "context", "Landroid/content/Context;", "songId", "", "metadata", "Lcom/mp3player/data/model/MusicMetadata;", "writeTagsSafe", "", "filePath", "app_debug"})
public final class StorageHelper {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "StorageHelper";
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy tagProcessor$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.StorageHelper INSTANCE = null;
    
    private StorageHelper() {
        super();
    }
    
    private final com.mp3player.data.tagging.FallbackTagProcessor getTagProcessor() {
        return null;
    }
    
    public final boolean writeTagsSafe(@org.jetbrains.annotations.NotNull
    android.content.Context context, long songId, @org.jetbrains.annotations.NotNull
    java.lang.String filePath, @org.jetbrains.annotations.NotNull
    com.mp3player.data.model.MusicMetadata metadata) {
        return false;
    }
    
    private final java.io.File createTempFileFromPfd(android.os.ParcelFileDescriptor pfd, java.lang.String originalPath) {
        return null;
    }
    
    private final void copyBackToPfd(java.io.File tempFile, android.os.ParcelFileDescriptor pfd) {
    }
    
    private final void updateMediaStore(android.content.Context context, long songId, com.mp3player.data.model.MusicMetadata metadata) {
    }
}
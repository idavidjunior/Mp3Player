package com.mp3player.data.tagging;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0011J\"\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/mp3player/data/tagging/FallbackTagProcessor;", "Lcom/mp3player/data/tagging/TagProcessor;", "processors", "", "(Ljava/util/List;)V", "name", "", "getName", "()Ljava/lang/String;", "createBackup", "Ljava/io/File;", "file", "logSuccess", "", "processor", "operation", "read", "Lcom/mp3player/data/model/MusicMetadata;", "restoreBackup", "backup", "safeWriteWithBackup", "", "metadata", "write", "backupFile", "Companion", "app_debug"})
public final class FallbackTagProcessor implements com.mp3player.data.tagging.TagProcessor {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.mp3player.data.tagging.TagProcessor> processors = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "FallbackTagProcessor";
    private static final int MAX_RETRY_SAME_PROCESSOR = 1;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.mp3player.data.tagging.FallbackTagProcessor instance;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.tagging.FallbackTagProcessor.Companion Companion = null;
    
    public FallbackTagProcessor(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mp3player.data.tagging.TagProcessor> processors) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public com.mp3player.data.model.MusicMetadata read(@org.jetbrains.annotations.NotNull
    java.io.File file) {
        return null;
    }
    
    @java.lang.Override
    public boolean write(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    com.mp3player.data.model.MusicMetadata metadata, @org.jetbrains.annotations.Nullable
    java.io.File backupFile) {
        return false;
    }
    
    public final boolean safeWriteWithBackup(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    com.mp3player.data.model.MusicMetadata metadata) {
        return false;
    }
    
    private final java.io.File createBackup(java.io.File file) {
        return null;
    }
    
    private final void restoreBackup(java.io.File file, java.io.File backup) {
    }
    
    private final void logSuccess(java.lang.String processor, java.lang.String operation, java.io.File file) {
    }
    
    public FallbackTagProcessor() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/mp3player/data/tagging/FallbackTagProcessor$Companion;", "", "()V", "MAX_RETRY_SAME_PROCESSOR", "", "TAG", "", "instance", "Lcom/mp3player/data/tagging/FallbackTagProcessor;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.mp3player.data.tagging.FallbackTagProcessor getInstance() {
            return null;
        }
    }
}
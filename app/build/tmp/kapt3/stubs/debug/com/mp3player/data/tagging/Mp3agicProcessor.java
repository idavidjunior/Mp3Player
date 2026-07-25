package com.mp3player.data.tagging;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/mp3player/data/tagging/Mp3agicProcessor;", "Lcom/mp3player/data/tagging/TagProcessor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "read", "Lcom/mp3player/data/model/MusicMetadata;", "file", "Ljava/io/File;", "write", "", "metadata", "backupFile", "app_debug"})
public final class Mp3agicProcessor implements com.mp3player.data.tagging.TagProcessor {
    
    public Mp3agicProcessor() {
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
}
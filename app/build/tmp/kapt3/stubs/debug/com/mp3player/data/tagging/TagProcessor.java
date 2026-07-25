package com.mp3player.data.tagging;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/mp3player/data/tagging/TagProcessor;", "", "name", "", "getName", "()Ljava/lang/String;", "read", "Lcom/mp3player/data/model/MusicMetadata;", "file", "Ljava/io/File;", "write", "", "metadata", "backupFile", "app_debug"})
public abstract interface TagProcessor {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getName();
    
    @org.jetbrains.annotations.Nullable
    public abstract com.mp3player.data.model.MusicMetadata read(@org.jetbrains.annotations.NotNull
    java.io.File file);
    
    public abstract boolean write(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    com.mp3player.data.model.MusicMetadata metadata, @org.jetbrains.annotations.Nullable
    java.io.File backupFile);
}
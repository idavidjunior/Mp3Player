package com.mp3player.data.online;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J!\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0082 J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J \u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/mp3player/data/online/AcoustIDService;", "", "()V", "ACOUSTID_API_KEY", "", "TAG", "TIMEOUT_MS", "", "nativeLoaded", "", "fetchMusicBrainzDetails", "Lcom/mp3player/data/online/AcoustIDService$MbDetails;", "recordingId", "generateFingerprint", "pcmData", "", "sampleRate", "numChannels", "httpGet", "urlString", "httpPost", "params", "isMusicGenre", "tag", "lookupAcoustId", "Lcom/mp3player/data/model/MusicMetadata;", "fingerprint", "duration", "searchByFile", "filePath", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MbDetails", "app_debug"})
public final class AcoustIDService {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "AcoustID";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ACOUSTID_API_KEY = "4m9Q2k9p";
    private static final int TIMEOUT_MS = 15000;
    private static boolean nativeLoaded = false;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.online.AcoustIDService INSTANCE = null;
    
    private AcoustIDService() {
        super();
    }
    
    private final native java.lang.String generateFingerprint(byte[] pcmData, int sampleRate, int numChannels) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object searchByFile(@org.jetbrains.annotations.NotNull
    java.lang.String filePath, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.mp3player.data.model.MusicMetadata> $completion) {
        return null;
    }
    
    private final com.mp3player.data.model.MusicMetadata lookupAcoustId(java.lang.String fingerprint, int duration) {
        return null;
    }
    
    private final com.mp3player.data.online.AcoustIDService.MbDetails fetchMusicBrainzDetails(java.lang.String recordingId) {
        return null;
    }
    
    private final boolean isMusicGenre(java.lang.String tag) {
        return false;
    }
    
    private final java.lang.String httpGet(java.lang.String urlString) {
        return null;
    }
    
    private final java.lang.String httpPost(java.lang.String urlString, java.lang.String params) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/mp3player/data/online/AcoustIDService$MbDetails;", "", "year", "", "genre", "(Ljava/lang/String;Ljava/lang/String;)V", "getGenre", "()Ljava/lang/String;", "getYear", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class MbDetails {
        @org.jetbrains.annotations.Nullable
        private final java.lang.String year = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String genre = null;
        
        public MbDetails(@org.jetbrains.annotations.Nullable
        java.lang.String year, @org.jetbrains.annotations.Nullable
        java.lang.String genre) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getYear() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getGenre() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.mp3player.data.online.AcoustIDService.MbDetails copy(@org.jetbrains.annotations.Nullable
        java.lang.String year, @org.jetbrains.annotations.Nullable
        java.lang.String genre) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}
package com.mp3player.data.online;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/mp3player/data/online/AudioDecoder;", "", "()V", "MAX_DECODE_SECONDS", "", "TARGET_CHANNELS", "TARGET_SAMPLE_RATE", "decodeToPcm", "Lcom/mp3player/data/online/AudioDecoder$DecodeResult;", "filePath", "", "processOutputBuffer", "", "buf", "Ljava/nio/ByteBuffer;", "info", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "selectAudioTrack", "extractor", "Landroid/media/MediaExtractor;", "(Landroid/media/MediaExtractor;)Ljava/lang/Integer;", "DecodeResult", "app_debug"})
public final class AudioDecoder {
    private static final int TARGET_SAMPLE_RATE = 11025;
    private static final int TARGET_CHANNELS = 1;
    private static final int MAX_DECODE_SECONDS = 60;
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.online.AudioDecoder INSTANCE = null;
    
    private AudioDecoder() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mp3player.data.online.AudioDecoder.DecodeResult decodeToPcm(@org.jetbrains.annotations.NotNull
    java.lang.String filePath) {
        return null;
    }
    
    private final java.lang.Integer selectAudioTrack(android.media.MediaExtractor extractor) {
        return null;
    }
    
    private final byte[] processOutputBuffer(java.nio.ByteBuffer buf, android.media.MediaCodec.BufferInfo info, android.media.MediaFormat format) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/mp3player/data/online/AudioDecoder$DecodeResult;", "", "pcm", "", "sampleRate", "", "channels", "durationSeconds", "", "([BIIF)V", "getChannels", "()I", "getDurationSeconds", "()F", "getPcm", "()[B", "getSampleRate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class DecodeResult {
        @org.jetbrains.annotations.NotNull
        private final byte[] pcm = null;
        private final int sampleRate = 0;
        private final int channels = 0;
        private final float durationSeconds = 0.0F;
        
        public DecodeResult(@org.jetbrains.annotations.NotNull
        byte[] pcm, int sampleRate, int channels, float durationSeconds) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] getPcm() {
            return null;
        }
        
        public final int getSampleRate() {
            return 0;
        }
        
        public final int getChannels() {
            return 0;
        }
        
        public final float getDurationSeconds() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final float component4() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.mp3player.data.online.AudioDecoder.DecodeResult copy(@org.jetbrains.annotations.NotNull
        byte[] pcm, int sampleRate, int channels, float durationSeconds) {
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
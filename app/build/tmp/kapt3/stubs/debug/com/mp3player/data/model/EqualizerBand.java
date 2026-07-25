package com.mp3player.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/mp3player/data/model/EqualizerBand;", "", "id", "", "centerFrequencyHz", "", "gainDb", "(IFF)V", "getCenterFrequencyHz", "()F", "getGainDb", "setGainDb", "(F)V", "getId", "()I", "label", "", "getLabel", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class EqualizerBand {
    private final int id = 0;
    private final float centerFrequencyHz = 0.0F;
    private float gainDb;
    @org.jetbrains.annotations.NotNull
    private static final float[] FREQUENCIES = {31.0F, 44.0F, 63.0F, 88.0F, 125.0F, 175.0F, 250.0F, 350.0F, 500.0F, 700.0F, 1000.0F, 1400.0F, 2000.0F, 2800.0F, 4000.0F, 5600.0F, 8000.0F, 11200.0F, 16000.0F, 20000.0F};
    @org.jetbrains.annotations.NotNull
    public static final com.mp3player.data.model.EqualizerBand.Companion Companion = null;
    
    public EqualizerBand(int id, float centerFrequencyHz, float gainDb) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final float getCenterFrequencyHz() {
        return 0.0F;
    }
    
    public final float getGainDb() {
        return 0.0F;
    }
    
    public final void setGainDb(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLabel() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mp3player.data.model.EqualizerBand copy(int id, float centerFrequencyHz, float gainDb) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/mp3player/data/model/EqualizerBand$Companion;", "", "()V", "FREQUENCIES", "", "getFREQUENCIES", "()[F", "createDefaultBands", "", "Lcom/mp3player/data/model/EqualizerBand;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final float[] getFREQUENCIES() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.mp3player.data.model.EqualizerBand> createDefaultBands() {
            return null;
        }
    }
}
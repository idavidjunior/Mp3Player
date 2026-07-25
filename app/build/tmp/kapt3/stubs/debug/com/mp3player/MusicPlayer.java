package com.mp3player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b%\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010=\u001a\u00020$H\u0002J\u001a\u0010>\u001a\u00020$2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020$0(J\u0014\u0010@\u001a\u00020$2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0#J\u001a\u0010A\u001a\u00020$2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0(J\u000e\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u0010J\u0016\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HJ\b\u0010I\u001a\u00020$H\u0002J\u0006\u0010J\u001a\u00020$J\u0006\u0010K\u001a\u00020\fJ\u0006\u0010L\u001a\u00020\fJ\u0010\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\fH\u0002J\u000e\u0010O\u001a\u00020\f2\u0006\u0010N\u001a\u00020\fJ\u000e\u0010P\u001a\u00020\f2\u0006\u0010N\u001a\u00020\fJ\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00100<J\u0006\u0010R\u001a\u00020\fJ\u0016\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\fJ\u0006\u0010V\u001a\u00020$J\u0006\u0010W\u001a\u00020$J.\u0010X\u001a\u00020$2\u0006\u0010C\u001a\u00020\u00102\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010Z\u001a\b\u0012\u0004\u0012\u00020$0#J\u0006\u0010[\u001a\u00020$J\u000e\u0010\\\u001a\u00020$2\u0006\u0010]\u001a\u00020\fJ\u001a\u0010^\u001a\u00020$2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020$0(J\u0014\u0010_\u001a\u00020$2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0#J\u001a\u0010`\u001a\u00020$2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0(J\b\u0010a\u001a\u00020\bH\u0002J\u0006\u0010b\u001a\u00020$J\u000e\u0010c\u001a\u00020$2\u0006\u0010d\u001a\u00020\fJ\u0016\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020HJ\u000e\u0010h\u001a\u00020$2\u0006\u0010g\u001a\u00020HJ\u0014\u0010i\u001a\u00020$2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00100<J\u0006\u0010k\u001a\u00020-J\u0006\u0010l\u001a\u000204R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020$0(0\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\f0\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0(0\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100<X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006m"}, d2 = {"Lcom/mp3player/MusicPlayer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioFocusHeld", "", "audioManager", "Landroid/media/AudioManager;", "audioSessionId", "", "getAudioSessionId", "()I", "currentSong", "Lcom/mp3player/Song;", "getCurrentSong", "()Lcom/mp3player/Song;", "setCurrentSong", "(Lcom/mp3player/Song;)V", "equalizerProcessor", "Lcom/mp3player/data/audio/EqualizerAudioProcessor;", "getEqualizerProcessor", "()Lcom/mp3player/data/audio/EqualizerAudioProcessor;", "setEqualizerProcessor", "(Lcom/mp3player/data/audio/EqualizerAudioProcessor;)V", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "<set-?>", "isPlaying", "()Z", "isPrepared", "onCompletionCallbacks", "", "Lkotlin/Function0;", "", "onPreparedCallback", "playStateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "queue", "queueChangedListeners", "queueIndex", "repeatMode", "Lcom/mp3player/RepeatMode;", "getRepeatMode", "()Lcom/mp3player/RepeatMode;", "setRepeatMode", "(Lcom/mp3player/RepeatMode;)V", "shuffleIndex", "shuffleMode", "Lcom/mp3player/ShuffleMode;", "getShuffleMode", "()Lcom/mp3player/ShuffleMode;", "setShuffleMode", "(Lcom/mp3player/ShuffleMode;)V", "shuffledIndices", "songChangedListeners", "songList", "", "abandonAudioFocus", "addPlayStateListener", "l", "addQueueChangedListener", "addSongChangedListener", "addToQueue", "song", "applyEqPreset", "gains", "", "preamp", "", "buildShuffleOrder", "clearQueue", "getCurrentPosition", "getDuration", "getNextFromList", "currentIdx", "getNextIndex", "getPrevIndex", "getQueue", "getQueueIndex", "moveQueueItem", "fromIndex", "toIndex", "pause", "play", "playSong", "onPrepared", "onCompletion", "release", "removeFromQueue", "index", "removePlayStateListener", "removeQueueChangedListener", "removeSongChangedListener", "requestAudioFocus", "resetEq", "seekTo", "position", "setEqBandGain", "bandId", "gainDb", "setEqPreampGain", "setPlaylist", "songs", "toggleRepeat", "toggleShuffle", "app_debug"})
@kotlin.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
public final class MusicPlayer {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private com.mp3player.data.audio.EqualizerAudioProcessor equalizerProcessor;
    @org.jetbrains.annotations.Nullable
    private androidx.media3.exoplayer.ExoPlayer exoPlayer;
    @org.jetbrains.annotations.Nullable
    private com.mp3player.Song currentSong;
    private boolean isPlaying = false;
    private boolean isPrepared = false;
    @org.jetbrains.annotations.NotNull
    private com.mp3player.RepeatMode repeatMode = com.mp3player.RepeatMode.ALL;
    @org.jetbrains.annotations.NotNull
    private com.mp3player.ShuffleMode shuffleMode = com.mp3player.ShuffleMode.OFF;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.mp3player.Song> songList;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.Integer> shuffledIndices;
    private int shuffleIndex = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.mp3player.Song> queue = null;
    private int queueIndex = -1;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<com.mp3player.Song, kotlin.Unit>> songChangedListeners = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit>> playStateListeners = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> queueChangedListeners = null;
    @org.jetbrains.annotations.NotNull
    private final android.media.AudioManager audioManager = null;
    private boolean audioFocusHeld = false;
    @org.jetbrains.annotations.NotNull
    private final android.media.AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>> onCompletionCallbacks = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function0<kotlin.Unit> onPreparedCallback;
    
    public MusicPlayer(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mp3player.data.audio.EqualizerAudioProcessor getEqualizerProcessor() {
        return null;
    }
    
    public final void setEqualizerProcessor(@org.jetbrains.annotations.Nullable
    com.mp3player.data.audio.EqualizerAudioProcessor p0) {
    }
    
    public final int getAudioSessionId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mp3player.Song getCurrentSong() {
        return null;
    }
    
    public final void setCurrentSong(@org.jetbrains.annotations.Nullable
    com.mp3player.Song p0) {
    }
    
    public final boolean isPlaying() {
        return false;
    }
    
    public final boolean isPrepared() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mp3player.RepeatMode getRepeatMode() {
        return null;
    }
    
    public final void setRepeatMode(@org.jetbrains.annotations.NotNull
    com.mp3player.RepeatMode p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mp3player.ShuffleMode getShuffleMode() {
        return null;
    }
    
    public final void setShuffleMode(@org.jetbrains.annotations.NotNull
    com.mp3player.ShuffleMode p0) {
    }
    
    private final boolean requestAudioFocus() {
        return false;
    }
    
    private final void abandonAudioFocus() {
    }
    
    public final void addSongChangedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> l) {
    }
    
    public final void removeSongChangedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mp3player.Song, kotlin.Unit> l) {
    }
    
    public final void addPlayStateListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> l) {
    }
    
    public final void removePlayStateListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> l) {
    }
    
    public final void addQueueChangedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> l) {
    }
    
    public final void removeQueueChangedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> l) {
    }
    
    public final void setPlaylist(@org.jetbrains.annotations.NotNull
    java.util.List<com.mp3player.Song> songs) {
    }
    
    private final void buildShuffleOrder() {
    }
    
    public final int getNextIndex(int currentIdx) {
        return 0;
    }
    
    private final int getNextFromList(int currentIdx) {
        return 0;
    }
    
    public final int getPrevIndex(int currentIdx) {
        return 0;
    }
    
    public final int getQueueIndex() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mp3player.ShuffleMode toggleShuffle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mp3player.RepeatMode toggleRepeat() {
        return null;
    }
    
    public final void addToQueue(@org.jetbrains.annotations.NotNull
    com.mp3player.Song song) {
    }
    
    public final void removeFromQueue(int index) {
    }
    
    public final void moveQueueItem(int fromIndex, int toIndex) {
    }
    
    public final void clearQueue() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mp3player.Song> getQueue() {
        return null;
    }
    
    public final void playSong(@org.jetbrains.annotations.NotNull
    com.mp3player.Song song, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPrepared, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCompletion) {
    }
    
    public final void play() {
    }
    
    public final void pause() {
    }
    
    public final void seekTo(int position) {
    }
    
    public final int getCurrentPosition() {
        return 0;
    }
    
    public final int getDuration() {
        return 0;
    }
    
    public final void setEqBandGain(int bandId, float gainDb) {
    }
    
    public final void setEqPreampGain(float gainDb) {
    }
    
    public final void resetEq() {
    }
    
    public final void applyEqPreset(@org.jetbrains.annotations.NotNull
    float[] gains, float preamp) {
    }
    
    public final void release() {
    }
}
package com.mp3player.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/mp3player/ui/EqCurveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barActivePaint", "Landroid/graphics/Paint;", "barPaint", "centerLinePaint", "dotPaint", "fillPaint", "gridPaint", "value", "", "levels", "getLevels", "()[F", "setLevels", "([F)V", "linePaint", "maxLevel", "getMaxLevel", "()I", "setMaxLevel", "(I)V", "minLevel", "getMinLevel", "setMinLevel", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app_debug"})
public final class EqCurveView extends android.view.View {
    @org.jetbrains.annotations.NotNull
    private float[] levels;
    private int minLevel = -12;
    private int maxLevel = 12;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint barPaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint barActivePaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint gridPaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint centerLinePaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint linePaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint fillPaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint dotPaint = null;
    
    @kotlin.jvm.JvmOverloads
    public EqCurveView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final float[] getLevels() {
        return null;
    }
    
    public final void setLevels(@org.jetbrains.annotations.NotNull
    float[] value) {
    }
    
    public final int getMinLevel() {
        return 0;
    }
    
    public final void setMinLevel(int p0) {
    }
    
    public final int getMaxLevel() {
        return 0;
    }
    
    public final void setMaxLevel(int p0) {
    }
    
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    @kotlin.jvm.JvmOverloads
    public EqCurveView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public EqCurveView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
}
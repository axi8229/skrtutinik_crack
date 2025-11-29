package com.github.razir.progressbutton;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawableSpan.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ9\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JW\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/github/razir/progressbutton/DrawableSpan;", "Landroid/text/style/ImageSpan;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "paddingStart", "paddingEnd", "", "useTextAlpha", "<init>", "(Landroid/graphics/drawable/Drawable;IIZ)V", "Landroid/graphics/Paint;", "paint", "", "text", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetricsInt", "getSize", "(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I", "Landroid/graphics/Canvas;", "canvas", "", "x", "top", "y", "bottom", "", "draw", "(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V", "I", "getPaddingStart", "()I", "setPaddingStart", "(I)V", "getPaddingEnd", "setPaddingEnd", "Z", "getUseTextAlpha", "()Z", "progressbutton_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class DrawableSpan extends ImageSpan {
    private int paddingEnd;
    private int paddingStart;
    private final boolean useTextAlpha;

    public /* synthetic */ DrawableSpan(Drawable drawable, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, z);
    }

    public final void setPaddingEnd(int i) {
        this.paddingEnd = i;
    }

    public final void setPaddingStart(int i) {
        this.paddingStart = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableSpan(Drawable drawable, int i, int i2, boolean z) {
        super(drawable);
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        this.paddingStart = i;
        this.paddingEnd = i2;
        this.useTextAlpha = z;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Drawable drawable = getDrawable();
        Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
        Rect bounds = drawable.getBounds();
        Intrinsics.checkExpressionValueIsNotNull(bounds, "drawable.bounds");
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int iMax = Math.max(i, bounds.bottom - bounds.top);
            int i2 = fontMetricsInt2.top + (i / 2);
            int i3 = iMax / 2;
            int i4 = i2 - i3;
            fontMetricsInt.ascent = i4;
            int i5 = i2 + i3;
            fontMetricsInt.descent = i5;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = i5;
        }
        return bounds.width() + this.paddingStart + this.paddingEnd;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i = fontMetricsInt.descent;
        int i2 = (y + i) - ((i - fontMetricsInt.ascent) / 2);
        Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
        int iHeight = i2 - (drawable.getBounds().height() / 2);
        int i3 = this.paddingStart;
        if (i3 != 0) {
            canvas.translate(x + i3, iHeight);
        } else {
            canvas.translate(x, iHeight);
        }
        if (this.useTextAlpha) {
            drawable.setAlpha(Color.alpha(paint.getColor()));
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}

package ru.yoomoney.sdk.gui.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextDrawable.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/gui/drawable/TextDrawable;", "Landroid/graphics/drawable/ShapeDrawable;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "size", "", "valueColor", "Landroid/graphics/Typeface;", "typeFace", "<init>", "(Ljava/lang/CharSequence;FLjava/lang/Integer;Landroid/graphics/Typeface;)V", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "getIntrinsicWidth", "()I", "getIntrinsicHeight", "Ljava/lang/CharSequence;", "getValue", "()Ljava/lang/CharSequence;", "F", "getSize", "()F", "Ljava/lang/Integer;", "getValueColor", "()Ljava/lang/Integer;", "Landroid/graphics/Typeface;", "getTypeFace", "()Landroid/graphics/Typeface;", "Landroid/text/TextPaint;", "textPaint", "Landroid/text/TextPaint;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextDrawable extends ShapeDrawable {
    private final float size;
    private final TextPaint textPaint;
    private final Typeface typeFace;
    private final CharSequence value;
    private final Integer valueColor;

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    public TextDrawable(CharSequence charSequence, float f, Integer num, Typeface typeface) {
        this.value = charSequence;
        this.size = f;
        this.valueColor = num;
        this.typeFace = typeface;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        textPaint.setColor(num != null ? num.intValue() : -16777216);
        textPaint.setTextSize(f);
        textPaint.setTypeface(typeface);
        this.textPaint = textPaint;
        getPaint().setColor(0);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        CharSequence charSequence = this.value;
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getBounds().left, getBounds().top);
        float fWidth = getBounds().width();
        float fHeight = (getBounds().height() / 2.0f) - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f);
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.value, this.textPaint, fWidth, TextUtils.TruncateAt.END);
        canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), fWidth / 2.0f, fHeight, this.textPaint);
        canvas.restoreToCount(iSave);
    }
}

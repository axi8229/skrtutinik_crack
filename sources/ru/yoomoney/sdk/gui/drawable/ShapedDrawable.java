package ru.yoomoney.sdk.gui.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShapedDrawable.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0017J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J(\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/gui/drawable/ShapedDrawable;", "Landroid/graphics/drawable/Drawable;", "source", "prepareShape", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "(Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function1;)V", "buffer", "Landroid/graphics/Bitmap;", "paint", "Landroid/graphics/Paint;", "shape", "shapePaint", "draw", "canvas", "getIntrinsicHeight", "", "getIntrinsicWidth", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "recreateBuffer", "width", "height", "setAlpha", "alpha", "setBounds", "left", "top", "right", "bottom", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShapedDrawable extends Drawable {
    private Bitmap buffer;
    private final Paint paint;
    private final Function1<Canvas, Unit> prepareShape;
    private Bitmap shape;
    private final Paint shapePaint;
    private final Drawable source;

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        return -3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShapedDrawable(Drawable source, Function1<? super Canvas, Unit> prepareShape) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(prepareShape, "prepareShape");
        this.source = source;
        this.prepareShape = prepareShape;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.shapePaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.paint = paint2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.buffer;
        if (bitmap != null) {
            Canvas canvas2 = new Canvas(bitmap);
            canvas2.drawColor(0, PorterDuff.Mode.DST_IN);
            this.source.draw(canvas2);
            Bitmap bitmap2 = this.shape;
            if (bitmap2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            canvas2.drawBitmap(bitmap2, 0.0f, 0.0f, this.shapePaint);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.source.setBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        recreateBuffer(bounds.width(), bounds.height());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.source.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.source.getIntrinsicWidth();
    }

    private final void recreateBuffer(int width, int height) {
        Bitmap bitmap = this.buffer;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.buffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Bitmap bitmap2 = this.shape;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        Bitmap bitmap3 = this.buffer;
        this.shape = bitmap3 != null ? Bitmap.createScaledBitmap(bitmap3, width, height, true) : null;
        Function1<Canvas, Unit> function1 = this.prepareShape;
        Bitmap bitmap4 = this.shape;
        if (bitmap4 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        function1.invoke(new Canvas(bitmap4));
    }
}

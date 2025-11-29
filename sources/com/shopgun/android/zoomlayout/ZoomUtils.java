package com.shopgun.android.zoomlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.shopgun.android.utils.UnitUtils;

/* loaded from: classes3.dex */
public class ZoomUtils {
    private static Paint mDebugPaintBlue;
    private static Paint mDebugPaintRed;
    private static Paint mDebugPaintWhite;
    private static Paint mDebugPaintYellow;
    private static int mDebugRadius;
    private static final float[] v = new float[9];

    private static void ensureDebugOptions(Context context) {
        if (mDebugPaintBlue == null) {
            Paint paint = new Paint();
            mDebugPaintWhite = paint;
            paint.setColor(-1);
            Paint paint2 = new Paint();
            mDebugPaintBlue = paint2;
            paint2.setColor(-16776961);
            Paint paint3 = new Paint();
            mDebugPaintYellow = paint3;
            paint3.setColor(-256);
            Paint paint4 = new Paint();
            mDebugPaintRed = paint4;
            paint4.setColor(-65536);
            mDebugRadius = UnitUtils.dpToPx(4, context);
        }
    }

    public static void debugDraw(Canvas canvas, Context context, float f, float f2, float f3, float f4, float f5) {
        ensureDebugOptions(context);
        int i = (int) (mDebugRadius * f5);
        debugDrawCirc(canvas, f, f2, i, mDebugPaintBlue);
        debugDrawCirc(canvas, 0.0f, 0.0f, i, mDebugPaintRed);
        debugDrawCirc(canvas, f3, f4, i, mDebugPaintYellow);
    }

    private static void debugDrawCirc(Canvas canvas, float f, float f2, int i, Paint paint) {
        canvas.drawCircle(f, f2, i, mDebugPaintWhite);
        canvas.drawCircle(f, f2, i / 2, paint);
    }

    public static void setRect(Rect rect, float[] fArr) {
        setRect(rect, fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    public static void setRect(RectF rectF, float[] fArr) {
        setRect(rectF, fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    public static void setRect(RectF rectF, float f, float f2, float f3, float f4) {
        rectF.set(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4));
    }

    public static void setRect(Rect rect, float f, float f2, float f3, float f4) {
        rect.set(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4));
    }

    public static void setArray(float[] fArr, Rect rect) {
        fArr[0] = rect.left;
        fArr[1] = rect.top;
        fArr[2] = rect.right;
        fArr[3] = rect.bottom;
    }

    public static void setArray(float[] fArr, RectF rectF) {
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.bottom;
    }
}

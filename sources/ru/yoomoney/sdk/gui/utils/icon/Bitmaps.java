package ru.yoomoney.sdk.gui.utils.icon;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* loaded from: classes3.dex */
public class Bitmaps {
    public static Bitmap cropToCircle(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(-((r0 - iMin) / 2), -((r1 - iMin) / 2));
        bitmapShader.setLocalMatrix(matrix);
        Paint paint = new Paint(1);
        paint.setShader(bitmapShader);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, config);
        float f = iMin;
        new Canvas(bitmapCreateBitmap).drawOval(new RectF(0.0f, 0.0f, f, f), paint);
        return bitmapCreateBitmap;
    }
}

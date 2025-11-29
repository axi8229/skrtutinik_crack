package coil.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: DrawableUtils.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcoil/util/DrawableUtils;", "", "<init>", "()V", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Bitmap$Config;", "config", "", "isConfigValid", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$Config;)Z", "allowInexactSize", "Lcoil/size/Size;", "size", "Lcoil/size/Scale;", "scale", "isSizeValid", "(ZLandroid/graphics/Bitmap;Lcoil/size/Size;Lcoil/size/Scale;)Z", "Landroid/graphics/drawable/Drawable;", "drawable", "convertToBitmap", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Bitmap$Config;Lcoil/size/Size;Lcoil/size/Scale;Z)Landroid/graphics/Bitmap;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawableUtils {
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    private DrawableUtils() {
    }

    public final Bitmap convertToBitmap(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean allowInexactSize) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (isConfigValid(bitmap, config) && isSizeValid(allowInexactSize, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int width = Utils.getWidth(drawableMutate);
        if (width <= 0) {
            width = 512;
        }
        int height = Utils.getHeight(drawableMutate);
        int i = height > 0 ? height : 512;
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, i, Sizes.isOriginal(size) ? width : Utils.toPx(size.getWidth(), scale), Sizes.isOriginal(size) ? i : Utils.toPx(size.getHeight(), scale), scale);
        int iRoundToInt = MathKt.roundToInt(width * dComputeSizeMultiplier);
        int iRoundToInt2 = MathKt.roundToInt(dComputeSizeMultiplier * i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRoundToInt, iRoundToInt2, Bitmaps.toSoftware(config));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Rect bounds = drawableMutate.getBounds();
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iRoundToInt, iRoundToInt2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i2, i3, i4, i5);
        return bitmapCreateBitmap;
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == Bitmaps.toSoftware(config);
    }

    private final boolean isSizeValid(boolean allowInexactSize, Bitmap bitmap, Size size, Scale scale) {
        int px;
        int px2;
        if (allowInexactSize) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (Sizes.isOriginal(size)) {
            px = bitmap.getWidth();
        } else {
            px = Utils.toPx(size.getWidth(), scale);
        }
        if (Sizes.isOriginal(size)) {
            px2 = bitmap.getHeight();
        } else {
            px2 = Utils.toPx(size.getHeight(), scale);
        }
        return DecodeUtils.computeSizeMultiplier(width, height, px, px2, scale) == 1.0d;
    }
}

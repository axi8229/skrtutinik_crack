package com.sputnik.common.utils;

import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhotoUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/utils/PhotoUtils;", "", "<init>", "()V", "Landroid/graphics/BitmapFactory$Options;", "options", "", "reqWidth", "reqHeight", "calculateInSampleSize", "(Landroid/graphics/BitmapFactory$Options;II)I", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PhotoUtils {
    public static final PhotoUtils INSTANCE = new PhotoUtils();

    private PhotoUtils() {
    }

    public final int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        Intrinsics.checkNotNullParameter(options, "options");
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i3 = 1;
        if (i > reqHeight || i2 > reqWidth) {
            int i4 = i / 2;
            int i5 = i2 / 2;
            while (i4 / i3 >= reqHeight && i5 / i3 >= reqWidth) {
                i3 *= 2;
            }
        }
        return i3;
    }
}

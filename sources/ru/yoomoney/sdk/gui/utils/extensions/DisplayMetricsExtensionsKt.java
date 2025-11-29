package ru.yoomoney.sdk.gui.utils.extensions;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayMetricsExtensions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"convertDpToPx", "", "Landroid/util/DisplayMetrics;", "dp", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DisplayMetricsExtensionsKt {
    public static final int convertDpToPx(DisplayMetrics displayMetrics, int i) {
        Intrinsics.checkNotNullParameter(displayMetrics, "<this>");
        return Math.round(convertDpToPx(displayMetrics, i));
    }

    public static final float convertDpToPx(DisplayMetrics displayMetrics, float f) {
        Intrinsics.checkNotNullParameter(displayMetrics, "<this>");
        return TypedValue.applyDimension(1, f, displayMetrics);
    }
}

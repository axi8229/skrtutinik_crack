package com.sputnik.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DpUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001¨\u0006\t"}, d2 = {"convertPxToDb", "", "px", "", "resources", "Landroid/content/res/Resources;", "dpToPx", "Landroid/content/Context;", "dp", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DpUtilsKt {
    public static final int convertPxToDb(float f, Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static final int dpToPx(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        return Math.round(i * (displayMetrics.xdpi / 160));
    }
}

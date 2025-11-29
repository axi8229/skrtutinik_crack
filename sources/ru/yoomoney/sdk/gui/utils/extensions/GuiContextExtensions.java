package ru.yoomoney.sdk.gui.utils.extensions;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextExtensions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\u0004\u001a\u0011\u0010\f\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "", "dp", "convertDpToPx", "(Landroid/content/Context;I)I", "", "(Landroid/content/Context;F)F", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "(Landroid/content/Context;)Landroid/util/DisplayMetrics;", "attributeId", "getThemedColor", "getStatusBarHeight", "(Landroid/content/Context;)I", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiContextExtensions {
    public static final int convertDpToPx(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return DisplayMetricsExtensionsKt.convertDpToPx(getDisplayMetrics(context), i);
    }

    public static final float convertDpToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return DisplayMetricsExtensionsKt.convertDpToPx(getDisplayMetrics(context), f);
    }

    public static final DisplayMetrics getDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        return displayMetrics;
    }

    public static final int getThemedColor(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public static final int getStatusBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}

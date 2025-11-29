package ru.yoomoney.sdk.kassa.payments.ui;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;
import ru.yoomoney.sdk.kassa.payments.R$bool;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0007*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0005¨\u0006\t"}, d2 = {"isTablet", "", "Landroid/content/Context;", "(Landroid/content/Context;)Z", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Z", "getScreenHeight", "", "getScreenWidth", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContextExtensionsKt {
    public static final int getScreenHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return GuiContextExtensions.getDisplayMetrics(context).heightPixels - GuiContextExtensions.getStatusBarHeight(context);
    }

    public static final int getScreenWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return GuiContextExtensions.getDisplayMetrics(context).widthPixels;
    }

    public static final boolean isTablet(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getBoolean(R$bool.ym_isTablet);
    }

    public static final boolean isTablet(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        return isTablet(fragmentActivityRequireActivity);
    }
}

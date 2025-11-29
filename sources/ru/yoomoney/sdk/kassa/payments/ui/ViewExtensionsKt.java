package ru.yoomoney.sdk.kassa.payments.ui;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getViewHeight", "", "Landroid/view/View;", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewExtensionsKt {
    public static final int getViewHeight(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        view.measure(View.MeasureSpec.makeMeasureSpec(ContextExtensionsKt.getScreenWidth(context), pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = view.getMeasuredHeight();
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        return RangesKt.coerceAtMost(measuredHeight, ContextExtensionsKt.getScreenHeight(context2));
    }
}

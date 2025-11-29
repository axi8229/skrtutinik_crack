package com.sputnik.common.utils;

import android.view.View;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewBindingUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a.\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u001a\u0016\u0010\f\u001a\u00020\u0001*\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\nH\u0007\u001a\u001b\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0012"}, d2 = {"enableBasedOn", "", "Landroid/view/View;", "condition", "", "showProgressBasedOn", "Landroid/widget/TextView;", "text", "", RemoteMessageConst.Notification.COLOR, "", "enabled", "startImage", "imageRes", "visibilityBasedOn", "(Landroid/view/View;Ljava/lang/Boolean;)V", "visibilityGoneBasedOn", "visibilityHideBasedOn", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewBindingUtilsKt {
    public static final void startImage(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public static final void visibilityBasedOn(View view, Boolean bool) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(bool != null ? bool.booleanValue() : true ? 0 : 8);
    }

    public static final void enableBasedOn(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setEnabled(z);
    }

    public static /* synthetic */ void showProgressBasedOn$default(TextView textView, boolean z, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        showProgressBasedOn(textView, z, str, i, z2);
    }

    public static final void showProgressBasedOn(TextView textView, boolean z, String text, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        if (z) {
            ButtonsExtensionsKt.showProgress(textView, i);
        } else {
            ButtonsExtensionsKt.hideProgress(textView, text);
        }
        if (z2) {
            ViewKt.enable(textView);
        } else {
            ViewKt.disable(textView);
        }
    }

    public static final void visibilityHideBasedOn(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 4);
    }

    public static final void visibilityGoneBasedOn(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }
}

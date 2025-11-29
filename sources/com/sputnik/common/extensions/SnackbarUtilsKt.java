package com.sputnik.common.extensions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R$id;
import com.google.android.material.snackbar.Snackbar;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnackbarUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\b\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"setBackgroundColor", "", "Lcom/google/android/material/snackbar/Snackbar;", RemoteMessageConst.Notification.COLOR, "", "setGravity", "gravity", "setSystemInsetsMargin", "setTextSize", "size", "", "isBold", "", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SnackbarUtilsKt {
    public static final void setBackgroundColor(Snackbar snackbar, int i) {
        Intrinsics.checkNotNullParameter(snackbar, "<this>");
        snackbar.setBackgroundTint(i);
    }

    public static final void setGravity(Snackbar snackbar, int i) {
        Intrinsics.checkNotNullParameter(snackbar, "<this>");
        ViewGroup.LayoutParams layoutParams = snackbar.getView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = i;
        layoutParams2.setMargins(20, 120, 20, 0);
        snackbar.getView().setLayoutParams(layoutParams2);
    }

    public static final void setSystemInsetsMargin(Snackbar snackbar) {
        Intrinsics.checkNotNullParameter(snackbar, "<this>");
        View view = snackbar.getView();
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        ViewKt.addSystemWindowInsetToMargin$default(view, false, true, false, true, 5, null);
    }

    public static final void setTextSize(Snackbar snackbar, float f, boolean z) {
        Intrinsics.checkNotNullParameter(snackbar, "<this>");
        View viewFindViewById = snackbar.getView().findViewById(R$id.snackbar_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        textView.setTextSize(f);
        if (z) {
            textView.setTypeface(textView.getTypeface(), 1);
        }
    }
}

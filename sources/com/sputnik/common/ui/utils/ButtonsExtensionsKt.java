package com.sputnik.common.ui.utils;

import android.widget.TextView;
import com.github.razir.progressbutton.ProgressButtonUtils;
import com.github.razir.progressbutton.ProgressParams;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.extensions.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ButtonsExtensions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"hideProgress", "", "Landroid/widget/TextView;", "text", "", "showProgress", RemoteMessageConst.Notification.COLOR, "", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ButtonsExtensionsKt {
    public static /* synthetic */ void showProgress$default(TextView textView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        showProgress(textView, i);
    }

    public static final void showProgress(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        ViewKt.disable(textView);
        ProgressButtonUtils.Companion companion = ProgressButtonUtils.INSTANCE;
        ProgressParams progressParams = new ProgressParams();
        progressParams.setProgressColor(Integer.valueOf(i));
        progressParams.setGravity(2);
        Unit unit = Unit.INSTANCE;
        companion.showProgress(textView, progressParams);
    }

    public static final void hideProgress(TextView textView, String text) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        ViewKt.enable(textView);
        ProgressButtonUtils.INSTANCE.hideProgress(textView, text);
    }
}

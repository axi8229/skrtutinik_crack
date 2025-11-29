package com.sputnik.common.ui.utils;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.ConnectionResult;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.extensions.snackbar.DefaultSnackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: SnackbarUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", RemoteMessageConst.MessageBody.MSG, "Landroid/view/View;", "view", "", "showSnackbarMessage", "(Ljava/lang/String;Landroid/view/View;)V", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SnackbarUtilsKt {
    private static final int showSnackbarMessage$getDuration(int i) {
        return MathKt.roundToInt((i * 60 * 1.5d) + ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    }

    public static final void showSnackbarMessage(String msg, View view) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(view, "view");
        String str = !StringsKt.isBlank(msg) ? msg : null;
        if (str != null) {
            DefaultSnackbar.Companion.make$default(DefaultSnackbar.INSTANCE, (ViewGroup) view, str, 0, 4, null).setDuration(showSnackbarMessage$getDuration(msg.length())).show();
        }
    }
}

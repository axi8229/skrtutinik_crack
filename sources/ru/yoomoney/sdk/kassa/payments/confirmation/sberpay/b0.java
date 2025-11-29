package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.SPaySdkApp;

/* loaded from: classes5.dex */
public abstract class b0 {
    public static boolean a;

    public static boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a) {
            return SPaySdkApp.INSTANCE.getInstance().isReadyForSPaySdk(context);
        }
        return false;
    }
}

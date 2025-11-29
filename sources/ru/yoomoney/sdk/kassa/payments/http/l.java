package ru.yoomoney.sdk.kassa.payments.http;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class l {
    public static String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "YooKassa.SDK.Client.Android/7.0.0 Android/" + Build.VERSION.RELEASE + " " + (ru.yoomoney.sdk.kassa.payments.extensions.g.c(context) ? "tablet" : "smartphone");
    }
}

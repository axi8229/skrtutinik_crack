package ru.yoomoney.sdk.kassa.payments.utils;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.threeDS.WebViewActivity;

/* loaded from: classes5.dex */
public abstract class c {
    public static final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        int i = WebViewActivity.$r8$clinit;
        if (ru.yoomoney.sdk.kassa.payments.threeDS.a.a(url)) {
            return;
        }
        throw new IllegalArgumentException(("Url " + url + " is not allowed. It should be a valid https url.").toString());
    }
}

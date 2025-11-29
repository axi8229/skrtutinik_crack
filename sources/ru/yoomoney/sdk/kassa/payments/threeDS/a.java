package ru.yoomoney.sdk.kassa.payments.threeDS;

import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivityKt;

/* loaded from: classes5.dex */
public abstract class a {
    public static boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return URLUtil.isHttpsUrl(url);
    }

    public static Intent a(Context context, String url, String str, TestParameters testParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra("ru.yoomoney.sdk.kassa.payments.extra.URL", url);
        intent.putExtra(CheckoutActivityKt.EXTRA_TEST_PARAMETERS, testParameters);
        if (str != null) {
            intent.putExtra("ru.yoomoney.sdk.kassa.payments.extra.LOG_PARAM", str);
        }
        return intent;
    }
}

package ru.yoomoney.sdk.kassa.payments.threeDS;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivityKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/threeDS/WebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "ru/yoomoney/sdk/kassa/payments/threeDS/a", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class WebViewActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.ym_activity_web_view);
        String loadUrl = getIntent().getStringExtra("ru.yoomoney.sdk.kassa.payments.extra.URL");
        if (loadUrl == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(loadUrl, "requireNotNull(...)");
        String stringExtra = getIntent().getStringExtra("ru.yoomoney.sdk.kassa.payments.extra.LOG_PARAM");
        Parcelable parcelableExtra = getIntent().getParcelableExtra(CheckoutActivityKt.EXTRA_TEST_PARAMETERS);
        if (parcelableExtra == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "requireNotNull(...)");
        TestParameters testParameters = (TestParameters) parcelableExtra;
        if (bundle == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            int i = R$id.webview_container;
            WebViewFragment.Companion.getClass();
            Intrinsics.checkNotNullParameter(loadUrl, "loadUrl");
            Intrinsics.checkNotNullParameter("https://checkoutsdk.success", "redirectUrl");
            Intrinsics.checkNotNullParameter(testParameters, "testParameters");
            WebViewFragment webViewFragment = new WebViewFragment();
            Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("loadUrl", loadUrl), TuplesKt.to("returnUrl", "https://checkoutsdk.success"), TuplesKt.to(CheckoutActivityKt.EXTRA_TEST_PARAMETERS, testParameters));
            if (stringExtra != null) {
                bundleBundleOf.putString("ru.yoomoney.sdk.kassa.payments.extra.LOG_PARAM", stringExtra);
            }
            webViewFragment.setArguments(bundleBundleOf);
            fragmentTransactionBeginTransaction.replace(i, webViewFragment).commit();
        }
    }
}

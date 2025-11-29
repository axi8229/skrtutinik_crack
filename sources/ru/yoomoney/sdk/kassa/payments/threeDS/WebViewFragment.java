package ru.yoomoney.sdk.kassa.payments.threeDS;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.view.OnBackPressedDispatcher;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.YandexMetrica;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.i0;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivityKt;
import ru.yoomoney.sdk.kassa.payments.utils.WebTrustManagerImpl;

@Keep
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b7\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J+\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0005J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\rR\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010/\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+R\u001a\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/threeDS/WebViewFragment;", "Landroidx/fragment/app/Fragment;", "Lru/yoomoney/sdk/kassa/payments/threeDS/j;", "", "close3DSProcess", "()V", "", "url", "load", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onCloseActivity", "onShowProgress", "onHideProgress", "", "errorCode", "description", "failingUrl", "onError", "(ILjava/lang/String;Ljava/lang/String;)V", "onSuccess", "onResume", "onPause", "onDestroyView", "onDestroy", "outState", "onSaveInstanceState", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebView;", "loadUrl$delegate", "Lkotlin/Lazy;", "getLoadUrl", "()Ljava/lang/String;", "loadUrl", "redirectUrl$delegate", "getRedirectUrl", "redirectUrl", "Landroidx/lifecycle/MutableLiveData;", "", "progress", "Landroidx/lifecycle/MutableLiveData;", "Lru/yoomoney/sdk/kassa/payments/logging/a;", "reporterLogger", "Lru/yoomoney/sdk/kassa/payments/logging/a;", "<init>", "Companion", "ru/yoomoney/sdk/kassa/payments/threeDS/c", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class WebViewFragment extends Fragment implements j {
    public static final int $stable = 8;
    public static final c Companion = new c();
    private ru.yoomoney.sdk.kassa.payments.logging.a reporterLogger;
    private WebView webView;

    /* renamed from: loadUrl$delegate, reason: from kotlin metadata */
    private final Lazy loadUrl = LazyKt.lazy(new d(this));

    /* renamed from: redirectUrl$delegate, reason: from kotlin metadata */
    private final Lazy redirectUrl = LazyKt.lazy(new i(this));
    private final MutableLiveData<Boolean> progress = new MutableLiveData<>();

    public WebViewFragment() {
        setRetainInstance(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close3DSProcess() {
        ru.yoomoney.sdk.kassa.payments.logging.a aVar = this.reporterLogger;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporterLogger");
            aVar = null;
        }
        aVar.a(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(0);
        fragmentActivityRequireActivity.finish();
    }

    private final String getLoadUrl() {
        return (String) this.loadUrl.getValue();
    }

    private final String getRedirectUrl() {
        return (String) this.redirectUrl.getValue();
    }

    private final void load(String url) {
        WebView webView = this.webView;
        if (webView == null) {
            throw new IllegalStateException("load should be called after fragment initialization");
        }
        webView.loadUrl(url);
    }

    public void onCloseActivity() {
        ru.yoomoney.sdk.kassa.payments.logging.a aVar = this.reporterLogger;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporterLogger");
            aVar = null;
        }
        aVar.a(false);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IReporter reporter = YandexMetrica.getReporter(requireContext().getApplicationContext(), "304c54b9-e8cd-424a-9e4c-a29cf9e9f6b5");
        Intrinsics.checkNotNullExpressionValue(reporter, "getReporter(...)");
        i0 i0Var = new i0(reporter);
        Bundle arguments = getArguments();
        Parcelable parcelable = arguments != null ? arguments.getParcelable(CheckoutActivityKt.EXTRA_TEST_PARAMETERS) : null;
        if (parcelable == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters");
        boolean showLogs = ((TestParameters) parcelable).getShowLogs();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.reporterLogger = new ru.yoomoney.sdk.kassa.payments.logging.a(i0Var, showLogs, contextRequireContext);
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("ru.yoomoney.sdk.kassa.payments.extra.LOG_PARAM") : null;
        if (savedInstanceState == null && string != null) {
            ru.yoomoney.sdk.kassa.payments.logging.a aVar = this.reporterLogger;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reporterLogger");
                aVar = null;
            }
            aVar.a(string, (List) null);
        }
        Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("Context should be present here");
        }
        Intrinsics.checkNotNullExpressionValue(context, "checkNotNull(...)");
        WebView webView = new WebView(context.getApplicationContext(), null, 0);
        webView.setFocusableInTouchMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.setWebViewClient(new b(getRedirectUrl(), this, new WebTrustManagerImpl()));
        webView.setWebChromeClient(new WebChromeClient());
        this.webView = webView;
        int i = WebViewActivity.$r8$clinit;
        String url = getLoadUrl();
        Intrinsics.checkNotNullParameter(url, "url");
        if (!URLUtil.isHttpsUrl(url)) {
            onError(Integer.MIN_VALUE, "Not https:// url", getLoadUrl());
        }
        load(getLoadUrl());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, new e(this));
        LinearLayout linearLayout = new LinearLayout(requireContext());
        linearLayout.setOrientation(1);
        linearLayout.removeAllViews();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-13502801, true, new h(this)));
        linearLayout.addView(composeView);
        linearLayout.addView(this.webView);
        return linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.webView;
        if (webView != null) {
            webView.destroy();
        }
        this.webView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewGroup viewGroup;
        super.onDestroyView();
        WebView webView = this.webView;
        if (webView == null || (viewGroup = (ViewGroup) webView.getParent()) == null) {
            return;
        }
        viewGroup.removeView(webView);
    }

    @Override // ru.yoomoney.sdk.kassa.payments.threeDS.j
    public void onError(int errorCode, String description, String failingUrl) {
        ru.yoomoney.sdk.kassa.payments.logging.a aVar = this.reporterLogger;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporterLogger");
            aVar = null;
        }
        aVar.a(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(1, new Intent().putExtras(fragmentActivityRequireActivity.getIntent()).putExtra(Checkout.EXTRA_ERROR_CODE, errorCode).putExtra(Checkout.EXTRA_ERROR_DESCRIPTION, description).putExtra(Checkout.EXTRA_ERROR_FAILING_URL, failingUrl));
        fragmentActivityRequireActivity.finish();
    }

    @Override // ru.yoomoney.sdk.kassa.payments.threeDS.j
    public void onHideProgress() {
        this.progress.setValue(Boolean.FALSE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onPause();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WebView webView = this.webView;
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("loadUrl", getLoadUrl());
        outState.putString("returnUrl", getRedirectUrl());
    }

    @Override // ru.yoomoney.sdk.kassa.payments.threeDS.j
    public void onShowProgress() {
        this.progress.setValue(Boolean.TRUE);
    }

    @Override // ru.yoomoney.sdk.kassa.payments.threeDS.j
    public void onSuccess() {
        ru.yoomoney.sdk.kassa.payments.logging.a aVar = this.reporterLogger;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporterLogger");
            aVar = null;
        }
        aVar.a(true);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(-1, new Intent().putExtras(fragmentActivityRequireActivity.getIntent()));
        fragmentActivityRequireActivity.finish();
    }
}

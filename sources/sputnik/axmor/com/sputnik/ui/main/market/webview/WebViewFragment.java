package sputnik.axmor.com.sputnik.ui.main.market.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.viewbinding.ViewBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.extensions.ViewKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ServiceWebViewLayoutBinding;

/* compiled from: WebViewFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0013H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u001a\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\f¨\u0006!"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/webview/WebViewFragment;", "Lcom/sputnik/common/base/BaseFragment;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "Lsputnik/axmor/com/databinding/ServiceWebViewLayoutBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/ServiceWebViewLayoutBinding;", "serviceName", "", "getServiceName", "()Ljava/lang/String;", "serviceName$delegate", "Lkotlin/Lazy;", "serviceUrl", "getServiceUrl", "serviceUrl$delegate", "initViews", "", "localize", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "MyWebViewClient", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewFragment extends BaseFragment {
    private ViewBinding _binding;

    /* renamed from: serviceName$delegate, reason: from kotlin metadata */
    private final Lazy serviceName;

    /* renamed from: serviceUrl$delegate, reason: from kotlin metadata */
    private final Lazy serviceUrl;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    public WebViewFragment() {
        super(R.layout.service_web_view_layout);
        this.serviceUrl = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.webview.WebViewFragment$serviceUrl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("url");
                }
                return null;
            }
        });
        this.serviceName = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.webview.WebViewFragment$serviceName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ServiceWebViewLayoutBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ServiceWebViewLayoutBinding");
        return (ServiceWebViewLayoutBinding) viewBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ServiceWebViewLayoutBinding.inflate(getLayoutInflater(), null, false);
        return getBinding().getRoot();
    }

    private final String getServiceUrl() {
        return (String) this.serviceUrl.getValue();
    }

    private final String getServiceName() {
        return (String) this.serviceName.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        getBinding().toolbar.setTitle(getServiceName());
        LinearLayout loader = getBinding().loader;
        Intrinsics.checkNotNullExpressionValue(loader, "loader");
        ViewKt.visible(loader);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    @SuppressLint({"SetJavaScriptEnabled"})
    public void initViews() {
        final ServiceWebViewLayoutBinding binding = getBinding();
        binding.webView.setWebViewClient(new MyWebViewClient());
        binding.webView.getSettings().setJavaScriptEnabled(true);
        final String serviceUrl = getServiceUrl();
        if (serviceUrl != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.market.webview.WebViewFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewFragment.initViews$lambda$2$lambda$1$lambda$0(binding, serviceUrl);
                }
            }, 400L);
        }
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        WebView webView = binding.webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        ViewKt.addSystemWindowInsetToMargin$default(webView, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$1$lambda$0(ServiceWebViewLayoutBinding this_with, String it) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(it, "$it");
        this_with.webView.loadUrl(it);
    }

    /* compiled from: WebViewFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/webview/WebViewFragment$MyWebViewClient;", "Landroid/webkit/WebViewClient;", "(Lsputnik/axmor/com/sputnik/ui/main/market/webview/WebViewFragment;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class MyWebViewClient extends WebViewClient {
        public MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            view.loadUrl(url);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (url != null && StringsKt.contains$default((CharSequence) url, (CharSequence) "#", false, 2, (Object) null)) {
                LinearLayout loader = WebViewFragment.this.getBinding().loader;
                Intrinsics.checkNotNullExpressionValue(loader, "loader");
                if (loader.getVisibility() == 0 && view != null) {
                    view.loadUrl(url);
                }
            }
            LinearLayout loader2 = WebViewFragment.this.getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader2, "loader");
            ViewKt.gone(loader2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        getBinding().webView.destroy();
        super.onDestroy();
        this._binding = null;
    }
}

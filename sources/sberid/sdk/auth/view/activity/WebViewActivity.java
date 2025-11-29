package sberid.sdk.auth.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.view.ComponentActivity;
import androidx.view.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sberid.sdk.auth.R$drawable;
import sberid.sdk.auth.R$id;
import sberid.sdk.auth.R$layout;
import sberid.sdk.auth.network.tsl.X509TrustManagerProviderKt;
import sberid.sdk.auth.network.webview.SberIDWebViewClient;

/* compiled from: WebViewActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0015J\b\u0010\u000f\u001a\u00020\fH\u0014J$\u0010\u0010\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lsberid/sdk/auth/view/activity/WebViewActivity;", "Landroidx/activity/ComponentActivity;", "()V", "progressBar", "Landroid/widget/ProgressBar;", "rootView", "Landroid/view/ViewGroup;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "webView", "Landroid/webkit/WebView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "updateToolbar", "host", "", "backNavigation", "", "webViewBackPressed", "Companion", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class WebViewActivity extends ComponentActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ProgressBar progressBar;
    private ViewGroup rootView;
    private Toolbar toolbar;
    private WebView webView;

    public WebViewActivity() {
        super(R$layout.sber_id_web_view_activity);
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View viewFindViewById = findViewById(R$id.root_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.root_view)");
        this.rootView = (ViewGroup) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.toolbar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) viewFindViewById2;
        this.toolbar = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: sberid.sdk.auth.view.activity.WebViewActivity.onCreate.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewActivity.this.finish();
            }
        });
        View viewFindViewById3 = findViewById(R$id.progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.progress)");
        this.progressBar = (ProgressBar) viewFindViewById3;
        final WebView webView = (WebView) findViewById(R$id.web_view);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "settings");
        final boolean z = true;
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings2, "settings");
        settings2.setAllowContentAccess(false);
        WebSettings settings3 = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings3, "settings");
        settings3.setAllowFileAccess(false);
        WebSettings settings4 = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings4, "settings");
        settings4.setDomStorageEnabled(true);
        WebSettings settings5 = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings5, "settings");
        settings5.setCacheMode(2);
        webView.clearHistory();
        webView.clearCache(true);
        webView.clearFormData();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(z) { // from class: sberid.sdk.auth.view.activity.WebViewActivity$onCreate$$inlined$apply$lambda$1
            @Override // androidx.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                WebViewActivity webViewActivity = this;
                WebView webView2 = webView;
                Intrinsics.checkNotNullExpressionValue(webView2, "this@apply");
                webViewActivity.webViewBackPressed(webView2);
            }
        });
        Resources resources = webView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        webView.setWebViewClient(new SberIDWebViewClient(X509TrustManagerProviderKt.createTrustManagers(resources, false), new Function3<WebView, String, Boolean, Unit>() { // from class: sberid.sdk.auth.view.activity.WebViewActivity$onCreate$$inlined$apply$lambda$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(WebView webView2, String str, Boolean bool) {
                invoke(webView2, str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(WebView webView2, String str, boolean z2) {
                this.this$0.updateToolbar(webView2, str, z2);
            }
        }, new Function1<Uri, Unit>() { // from class: sberid.sdk.auth.view.activity.WebViewActivity$onCreate$$inlined$apply$lambda$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                invoke2(uri);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.this$0.startActivity(new Intent("android.intent.action.VIEW", uri));
            }
        }, new WebViewActivity$onCreate$2$4(webView)));
        String stringExtra = getIntent().getStringExtra("uri");
        if (stringExtra != null) {
            webView.loadUrl(stringExtra);
        }
        Unit unit = Unit.INSTANCE;
        this.webView = webView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.webView;
        if (webView != null) {
            webView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateToolbar(final WebView webView, String host, final boolean backNavigation) {
        int i;
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        TransitionManager.beginDelayedTransition(viewGroup);
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar.setSubtitle(host);
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        if (backNavigation) {
            i = R$drawable.ic_baseline_arrow_24dp;
        } else {
            i = R$drawable.ic_baseline_close_24dp;
        }
        toolbar2.setNavigationIcon(i);
        Toolbar toolbar3 = this.toolbar;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar3.setNavigationOnClickListener(new View.OnClickListener() { // from class: sberid.sdk.auth.view.activity.WebViewActivity.updateToolbar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (backNavigation) {
                    WebView webView2 = webView;
                    if (webView2 != null) {
                        WebViewActivity.this.webViewBackPressed(webView2);
                        return;
                    }
                    return;
                }
                WebViewActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void webViewBackPressed(WebView webView) {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }

    /* compiled from: WebViewActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lsberid/sdk/auth/view/activity/WebViewActivity$Companion;", "", "()V", "GOOGLE_DOCS", "", "PDF_EXTENSION", "URI", "newIntent", "Landroid/content/Intent;", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent newIntent(Uri uri, Context context) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
            intent.putExtra("uri", uri.toString());
            return intent;
        }
    }
}

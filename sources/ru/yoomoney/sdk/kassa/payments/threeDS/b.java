package ru.yoomoney.sdk.kassa.payments.threeDS;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.utils.WebTrustManager;

/* loaded from: classes5.dex */
public final class b extends WebViewClient {
    public final String a;
    public final j b;
    public final WebTrustManager c;

    public b(String str, j jVar, WebTrustManager webViewTrustManager) {
        Intrinsics.checkNotNullParameter(webViewTrustManager, "webViewTrustManager");
        this.a = str;
        this.b = jVar;
        this.c = webViewTrustManager;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.onHideProgress();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.onShowProgress();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.onHideProgress();
            if (i == -2 || i == -6) {
                jVar = null;
            }
            if (jVar != null) {
                jVar.onError(i, str, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView view, SslErrorHandler sslErrorHandler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(error, "error");
        WebTrustManager webTrustManager = this.c;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (!webTrustManager.checkCertificate(context, error)) {
            super.onReceivedSslError(view, sslErrorHandler, error);
        } else if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        String str = this.a;
        if (str == null) {
            throw new IllegalStateException("returnUrl should be present");
        }
        if (!StringsKt.startsWith$default(url, str, false, 2, (Object) null)) {
            view.loadUrl(url);
            return true;
        }
        Log.d("WebViewFragment", "success: " + url);
        j jVar = this.b;
        if (jVar != null) {
            jVar.onSuccess();
        }
        view.stopLoading();
        return true;
    }
}

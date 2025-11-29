package sberid.sdk.auth.network.webview;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sberid.sdk.auth.utils.UriUtilsKt;

/* compiled from: SberIDWebViewClient.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B]\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\"\u0010\t\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR0\u0010\t\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010 R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010 ¨\u0006\""}, d2 = {"Lsberid/sdk/auth/network/webview/SberIDWebViewClient;", "Landroid/webkit/WebViewClient;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lkotlin/Function3;", "Landroid/webkit/WebView;", "", "", "", "updateHost", "Lkotlin/Function1;", "Landroid/net/Uri;", "runDeepLink", "runCustomTabs", "<init>", "(Ljavax/net/ssl/X509TrustManager;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "view", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "url", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/webkit/WebResourceRequest;", "request", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "Ljavax/net/ssl/X509TrustManager;", "Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function1;", "Companion", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class SberIDWebViewClient extends WebViewClient {
    private final Function1<Uri, Unit> runCustomTabs;
    private final Function1<Uri, Unit> runDeepLink;
    private final X509TrustManager trustManager;
    private final Function3<WebView, String, Boolean, Unit> updateHost;

    /* JADX WARN: Multi-variable type inference failed */
    public SberIDWebViewClient(X509TrustManager x509TrustManager, Function3<? super WebView, ? super String, ? super Boolean, Unit> updateHost, Function1<? super Uri, Unit> runDeepLink, Function1<? super Uri, Unit> runCustomTabs) {
        Intrinsics.checkNotNullParameter(updateHost, "updateHost");
        Intrinsics.checkNotNullParameter(runDeepLink, "runDeepLink");
        Intrinsics.checkNotNullParameter(runCustomTabs, "runCustomTabs");
        this.trustManager = x509TrustManager;
        this.updateHost = updateHost;
        this.runDeepLink = runDeepLink;
        this.runCustomTabs = runCustomTabs;
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"WebViewClientOnReceivedSslError"})
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) throws CertificateException {
        SslCertificate certificate;
        X509Certificate x509Certificate;
        if (error != null) {
            try {
                certificate = error.getCertificate();
            } catch (Exception e) {
                if (handler != null) {
                    handler.cancel();
                }
                Uri uri = Uri.parse(error != null ? error.getUrl() : null);
                Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(error?.url)");
                if (UriUtilsKt.isHostWhiteList(uri)) {
                    Function1<Uri, Unit> function1 = this.runCustomTabs;
                    Uri uri2 = Uri.parse(error != null ? error.getUrl() : null);
                    Intrinsics.checkNotNullExpressionValue(uri2, "Uri.parse(error?.url)");
                    function1.invoke(uri2);
                }
                Log.e("WevViewClient", "onReceivedSslError: " + e.getMessage());
                return;
            }
        } else {
            certificate = null;
        }
        byte[] byteArray = SslCertificate.saveState(certificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Intrinsics.checkNotNullExpressionValue(certificateFactory, "CertificateFactory.getInstance(\"X.509\")");
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(new ByteArrayInputStream(byteArray));
            Intrinsics.checkNotNullExpressionValue(certificateGenerateCertificate, "certFactory.generateCert…eArrayInputStream(bytes))");
            if (certificateGenerateCertificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            x509Certificate = (X509Certificate) certificateGenerateCertificate;
        } else {
            x509Certificate = null;
        }
        X509TrustManager x509TrustManager = this.trustManager;
        Intrinsics.checkNotNull(x509TrustManager);
        x509TrustManager.checkServerTrusted(new X509Certificate[]{x509Certificate}, "ECDH_RSA");
        if (handler != null) {
            handler.proceed();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        if (url == null || !URLUtil.isNetworkUrl(url)) {
            return;
        }
        super.onPageFinished(view, url);
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "https://docs.google.com/gview?embedded=true&url=", false, 2, (Object) null)) {
            Function3<WebView, String, Boolean, Unit> function3 = this.updateHost;
            String queryParameter = Uri.parse(url).getQueryParameter("url");
            function3.invoke(view, queryParameter != null ? UriUtilsKt.getHost(queryParameter) : null, Boolean.TRUE);
            return;
        }
        this.updateHost.invoke(view, UriUtilsKt.getHost(url), Boolean.FALSE);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String url = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) ".pdf", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) url, (CharSequence) "https://docs.google.com/gview?embedded=true&url=", false, 2, (Object) null)) {
            Function1<Uri, Unit> function1 = this.runCustomTabs;
            Uri url2 = request.getUrl();
            Intrinsics.checkNotNullExpressionValue(url2, "request.url");
            function1.invoke(url2);
            return true;
        }
        if (!URLUtil.isNetworkUrl(url)) {
            Function1<Uri, Unit> function12 = this.runDeepLink;
            Uri url3 = request.getUrl();
            Intrinsics.checkNotNullExpressionValue(url3, "request.url");
            function12.invoke(url3);
            return true;
        }
        Uri url4 = request.getUrl();
        Intrinsics.checkNotNullExpressionValue(url4, "request.url");
        if (UriUtilsKt.isHostWhiteList(url4)) {
            return false;
        }
        Function1<Uri, Unit> function13 = this.runCustomTabs;
        Uri url5 = request.getUrl();
        Intrinsics.checkNotNullExpressionValue(url5, "request.url");
        function13.invoke(url5);
        return true;
    }
}

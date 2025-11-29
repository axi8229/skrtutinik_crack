package npi.spay;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class M4 extends WebViewClient {
    public final /* synthetic */ I5 a;

    public M4(I5 i5) {
        this.a = i5;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        InterfaceC2010w8 interfaceC2010w8 = this.a.d;
        String string = null;
        if (interfaceC2010w8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("urlProcessor");
            interfaceC2010w8 = null;
        }
        if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null) {
            string = url.toString();
        }
        return interfaceC2010w8.a(string);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterfaceC2010w8 interfaceC2010w8 = this.a.d;
        if (interfaceC2010w8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("urlProcessor");
            interfaceC2010w8 = null;
        }
        return interfaceC2010w8.a(str);
    }
}

package ru.yoomoney.sdk.kassa.payments.threeDS;

import android.webkit.WebView;
import androidx.view.OnBackPressedCallback;

/* loaded from: classes5.dex */
public final class e extends OnBackPressedCallback {
    public final /* synthetic */ WebViewFragment a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(WebViewFragment webViewFragment) {
        super(true);
        this.a = webViewFragment;
    }

    @Override // androidx.view.OnBackPressedCallback
    public final void handleOnBackPressed() {
        WebView webView = this.a.webView;
        if (webView == null || !webView.canGoBack()) {
            this.a.onCloseActivity();
            this.a.requireActivity().finish();
        } else {
            WebView webView2 = this.a.webView;
            if (webView2 != null) {
                webView2.goBack();
            }
        }
    }
}

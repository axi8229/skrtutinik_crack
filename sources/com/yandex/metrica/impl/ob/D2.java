package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import com.yandex.metrica.AppMetricaInitializerJsInterface;
import com.yandex.metrica.AppMetricaJsInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class D2 {
    private final List<InterfaceC1107mm<C0858cm>> a = new ArrayList();
    private C0858cm b;

    class a implements InterfaceC1107mm<C0858cm> {
        final /* synthetic */ String a;

        a(D2 d2, String str) {
            this.a = str;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(C0858cm c0858cm) {
            C0858cm c0858cm2 = c0858cm;
            if (c0858cm2.isEnabled()) {
                c0858cm2.w(this.a);
            }
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(WebView webView, Uf uf) {
        if (!A2.a(17)) {
            a("WebView interface is not available on Android < 17.");
            return;
        }
        try {
            if (!webView.getSettings().getJavaScriptEnabled()) {
                a("WebView interface setup failed because javascript is disabled for the WebView.");
                return;
            }
            webView.addJavascriptInterface(new AppMetricaJsInterface(uf), "AppMetrica");
            webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(uf), "AppMetricaInitializer");
            C2 c2 = new C2(this, "WebView interface setup is successful.");
            synchronized (this) {
                try {
                    C0858cm c0858cm = this.b;
                    if (c0858cm == null) {
                        this.a.add(c2);
                    } else {
                        c2.b(c0858cm);
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            E2 e2 = new E2(this, th, "WebView interface setup failed because of an exception.");
            synchronized (this) {
                try {
                    C0858cm c0858cm2 = this.b;
                    if (c0858cm2 == null) {
                        this.a.add(e2);
                    } else {
                        e2.b(c0858cm2);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void a(C0858cm c0858cm) {
        synchronized (this) {
            this.b = c0858cm;
        }
        Iterator<InterfaceC1107mm<C0858cm>> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(c0858cm);
        }
        this.a.clear();
    }

    private void a(String str) {
        a aVar = new a(this, str);
        synchronized (this) {
            try {
                C0858cm c0858cm = this.b;
                if (c0858cm == null) {
                    this.a.add(aVar);
                } else {
                    aVar.b(c0858cm);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

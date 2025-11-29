package com.yandex.metrica.impl.ob;

import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
class Gl implements Runnable {
    final /* synthetic */ Il a;
    final /* synthetic */ WebView b;
    final /* synthetic */ CountDownLatch c;

    Gl(Hl hl, Il il, WebView webView, CountDownLatch countDownLatch) {
        this.a = il;
        this.b = webView;
        this.c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.h = this.b.getUrl();
            this.a.i = this.b.getOriginalUrl();
            this.c.countDown();
        } catch (Throwable unused) {
        }
    }
}

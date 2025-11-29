package com.yandex.metrica;

import android.webkit.JavascriptInterface;
import com.yandex.metrica.impl.ob.Uf;

/* loaded from: classes3.dex */
public class AppMetricaInitializerJsInterface {
    private final Uf a;

    public AppMetricaInitializerJsInterface(Uf uf) {
        this.a = uf;
    }

    @JavascriptInterface
    public void init(String str) {
        this.a.c(str);
    }
}

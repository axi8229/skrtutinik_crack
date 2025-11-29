package com.yandex.metrica;

import android.webkit.JavascriptInterface;
import com.yandex.metrica.impl.ob.Uf;

/* loaded from: classes3.dex */
public class AppMetricaJsInterface {
    private final Uf a;

    public AppMetricaJsInterface(Uf uf) {
        this.a = uf;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.a.c(str, str2);
    }
}

package com.yandex.metrica;

import android.app.Application;
import android.content.Context;
import android.webkit.WebView;
import com.yandex.metrica.impl.ob.C0786a0;
import com.yandex.metrica.impl.ob.C1137o2;
import com.yandex.metrica.impl.ob.C1183q;
import com.yandex.metrica.impl.ob.D2;
import com.yandex.metrica.impl.ob.P;
import com.yandex.metrica.impl.ob.R2;
import com.yandex.metrica.impl.ob.Sf;
import com.yandex.metrica.impl.ob.Uf;

/* loaded from: classes3.dex */
public class f {
    private final Sf a;
    private final D2 b;
    private final C1183q c;
    private final C1137o2 d;
    private final C0786a0 e;

    public f(Sf sf, D2 d2) {
        this(sf, d2, P.g().b(), P.g().l(), P.g().e());
    }

    public void a(Context context, YandexMetricaConfig yandexMetricaConfig) {
        i iVar = (i) yandexMetricaConfig;
        this.e.a(context);
        Boolean bool = iVar.sessionsAutoTrackingEnabled;
        Boolean bool2 = Boolean.TRUE;
        if (bool == null) {
            bool = bool2;
        }
        if (bool.booleanValue()) {
            this.d.a();
        }
        this.a.getClass();
        R2.a(context).b(iVar);
    }

    public void b(Context context) {
        this.e.a(context);
    }

    public void c(Context context) {
        this.e.a(context);
    }

    public f(Sf sf, D2 d2, C1183q c1183q, C1137o2 c1137o2, C0786a0 c0786a0) {
        this.a = sf;
        this.b = d2;
        this.c = c1183q;
        this.d = c1137o2;
        this.e = c0786a0;
    }

    public C1183q.c a(Application application) {
        this.c.a(application);
        return this.d.a();
    }

    public void a(Context context) {
        this.e.a(context);
    }

    public void a(WebView webView, Uf uf) {
        this.b.a(webView, uf);
    }
}

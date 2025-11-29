package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.impl.ob.C0956gk;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class Xk {
    private final InterfaceC1081ll a;
    private final C1055kk b;
    private final C0820b9 c;
    private volatile C0932fl d;
    private final Bl e;
    private final C0956gk.b f;
    private final C0981hk g;

    class a implements InterfaceC1081ll {
        a(Xk xk) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1081ll
        public void onError(String str) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1081ll
        public void onResult(JSONObject jSONObject) {
        }
    }

    Xk(C0932fl c0932fl, C1055kk c1055kk, C0820b9 c0820b9, Bl bl, C0981hk c0981hk) {
        this(c0932fl, c1055kk, c0820b9, bl, c0981hk, new C0956gk.b());
    }

    void a(C0932fl c0932fl) {
        this.d = c0932fl;
    }

    void b(Activity activity) {
        C0932fl c0932fl = this.d;
        if (this.g.a(activity, c0932fl) == Wk.OK) {
            a(activity, 0L, c0932fl, c0932fl.e);
        }
    }

    Xk(C0932fl c0932fl, C1055kk c1055kk, C0820b9 c0820b9, Bl bl, C0981hk c0981hk, C0956gk.b bVar) {
        this.a = new a(this);
        this.d = c0932fl;
        this.b = c1055kk;
        this.c = c0820b9;
        this.e = bl;
        this.f = bVar;
        this.g = c0981hk;
    }

    void a(Activity activity) {
        C0932fl c0932fl = this.d;
        if (this.g.a(activity, c0932fl) == Wk.OK) {
            C1348wl c1348wl = c0932fl.e;
            a(activity, c1348wl.d, c0932fl, c1348wl);
        }
    }

    private void a(Activity activity, long j, C0932fl c0932fl, C1348wl c1348wl) {
        Bl bl = this.e;
        C0956gk.b bVar = this.f;
        C1055kk c1055kk = this.b;
        C0820b9 c0820b9 = this.c;
        InterfaceC1081ll interfaceC1081ll = this.a;
        bVar.getClass();
        bl.a(activity, j, c0932fl, c1348wl, Collections.singletonList(new C0956gk(c1055kk, c0820b9, false, interfaceC1081ll, new C0956gk.a())));
    }
}

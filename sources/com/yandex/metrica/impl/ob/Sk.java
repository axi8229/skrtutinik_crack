package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.impl.ob.C0956gk;
import java.util.Collections;

/* loaded from: classes3.dex */
class Sk {
    private final C1055kk a;
    private final C0820b9 b;
    private volatile C0932fl c;
    private final Bl d;
    private final C0956gk.b e;
    private final C0981hk f;

    Sk(C0932fl c0932fl, C1055kk c1055kk, C0820b9 c0820b9, Bl bl, C0981hk c0981hk) {
        this(c0932fl, c1055kk, c0820b9, bl, c0981hk, new C0956gk.b());
    }

    void a(C0932fl c0932fl) {
        this.c = c0932fl;
    }

    Sk(C0932fl c0932fl, C1055kk c1055kk, C0820b9 c0820b9, Bl bl, C0981hk c0981hk, C0956gk.b bVar) {
        this.c = c0932fl;
        this.a = c1055kk;
        this.b = c0820b9;
        this.d = bl;
        this.f = c0981hk;
        this.e = bVar;
    }

    void a(Activity activity, InterfaceC1081ll interfaceC1081ll, boolean z) {
        C0932fl c0932fl = this.c;
        if ((!z && !this.a.b().isEmpty()) || activity == null) {
            interfaceC1081ll.onResult(this.a.a());
            return;
        }
        Wk wkA = this.f.a(activity, c0932fl);
        if (wkA != Wk.OK) {
            int iOrdinal = wkA.ordinal();
            interfaceC1081ll.onError(iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? "parsing ui context is forbidden for some reason" : "parsing ui context is forbidden by app for activity" : "parsing ui context is forbidden by app for application" : String.format("feature %s disabled", "ui_parsing") : String.format("no %s_config", "ui_parsing") : String.format("no %s_config", "ui_access"));
            return;
        }
        if (!c0932fl.c) {
            interfaceC1081ll.onError(String.format("feature %s disabled", "ui_collecting_for_bridge"));
            return;
        }
        if (c0932fl.g == null) {
            interfaceC1081ll.onError(String.format("no %s_config", "ui_collecting_for_bridge"));
            return;
        }
        Bl bl = this.d;
        C1348wl c1348wl = c0932fl.e;
        C0956gk.b bVar = this.e;
        C1055kk c1055kk = this.a;
        C0820b9 c0820b9 = this.b;
        bVar.getClass();
        bl.a(activity, 0L, c0932fl, c1348wl, Collections.singletonList(new C0956gk(c1055kk, c0820b9, z, interfaceC1081ll, new C0956gk.a())));
    }
}

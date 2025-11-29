package com.yandex.metrica.impl.ob;

import android.app.Activity;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.gk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0956gk implements InterfaceC1324vl {
    private final C1055kk a;
    private final C0820b9 b;
    private final InterfaceC1081ll c;
    private final a d;
    private final boolean e;

    /* renamed from: com.yandex.metrica.impl.ob.gk$a */
    static class a {
        a() {
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.gk$b */
    static class b {
        b() {
        }
    }

    C0956gk(C1055kk c1055kk, C0820b9 c0820b9, boolean z, InterfaceC1081ll interfaceC1081ll, a aVar) {
        this.a = c1055kk;
        this.b = c0820b9;
        this.e = z;
        this.c = interfaceC1081ll;
        this.d = aVar;
    }

    private boolean b(C0932fl c0932fl) {
        if (!c0932fl.c || c0932fl.g == null) {
            return false;
        }
        return this.e || this.b.a(false);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public void a(long j, Activity activity, C0882dl c0882dl, List<C1228rl> list, C0932fl c0932fl, Bk bk) {
        if (b(c0932fl)) {
            a aVar = this.d;
            C0982hl c0982hl = c0932fl.g;
            aVar.getClass();
            this.a.a((c0982hl.h ? new Fk() : new Ck(list)).a(activity, c0882dl, c0932fl.g, bk.a(), j));
            this.c.onResult(this.a.a());
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public void a(Throwable th, C1348wl c1348wl) {
        this.c.onError("exception: " + th.getMessage());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public boolean a(C0932fl c0932fl) {
        return b(c0932fl) && !c0932fl.g.h;
    }
}

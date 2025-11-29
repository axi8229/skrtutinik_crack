package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.impl.ob.C1396yl;
import java.util.List;

/* loaded from: classes3.dex */
class Lk implements InterfaceC1372xl {
    private final com.yandex.metrica.uiaccessor.b a;
    private final C1396yl.a b;
    private final El c;
    private final Dl d;

    Lk(InterfaceC1107mm<Activity> interfaceC1107mm, El el) {
        this(new C1396yl.a(), interfaceC1107mm, el, new Ek(), new Dl());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1372xl
    public void a(Activity activity, long j) {
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1372xl
    public void a(Activity activity, boolean z) {
        if (z) {
            return;
        }
        try {
            this.a.subscribe(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public boolean a(C0932fl c0932fl) {
        return false;
    }

    Lk(C1396yl.a aVar, InterfaceC1107mm<Activity> interfaceC1107mm, El el, Ek ek, Dl dl) {
        this.b = aVar;
        this.c = el;
        this.a = ek.a(interfaceC1107mm);
        this.d = dl;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public void a(long j, Activity activity, C0882dl c0882dl, List<C1228rl> list, C0932fl c0932fl, Bk bk) {
        C0982hl c0982hl;
        C0982hl c0982hl2;
        if (c0932fl.b && (c0982hl2 = c0932fl.f) != null) {
            this.c.b(this.d.a(activity, c0882dl, c0982hl2, bk.b(), j));
        }
        if (!c0932fl.d || (c0982hl = c0932fl.h) == null) {
            return;
        }
        this.c.a(this.d.a(activity, c0882dl, c0982hl, bk.d(), j));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public void a(Throwable th, C1348wl c1348wl) {
        this.b.getClass();
        new C1396yl(c1348wl, C1152oh.a()).a("ui_parsing", th);
    }

    public void a(Activity activity) {
        try {
            this.a.unsubscribe(activity);
        } catch (Throwable unused) {
        }
    }
}

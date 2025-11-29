package bz;

import android.content.Context;
import android.content.IntentFilter;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class N0 extends AbstractC0538n1 implements S0, A0, P1, U1, InterfaceC0550s {
    public final Context c;
    public final Z0 d;
    public final zone.bi.mobile.fingerprint.api.settings.a e;
    public C0553t f;

    public N0(Context context, Z0 z0, zone.bi.mobile.fingerprint.api.settings.a aVar) {
        super(zone.bi.mobile.fingerprint.api.f.ApprepInstalledApps);
        this.c = context;
        this.d = z0;
        this.e = aVar;
    }

    @Override // bz.S0
    public final R0 b() {
        return new M0(this);
    }

    @Override // bz.U1
    public final void d() {
        C0553t c0553t = this.f;
        if (c0553t != null) {
            this.c.unregisterReceiver(c0553t);
        }
        this.f = null;
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.d;
    }

    @Override // bz.U1
    public final void g() {
        if (this.f != null) {
            d();
        }
        C0553t c0553t = new C0553t(this);
        this.f = c0553t;
        Context context = this.c;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(c0553t, intentFilter);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0563w0 {
        this.e.getClass();
        String str = (String) a(zone.bi.mobile.fingerprint.api.settings.a.a);
        if (str != null) {
            return str;
        }
        S0.o.execute(new M0(this));
        throw new C0563w0("cachedValue == null");
    }

    @Override // bz.P1
    /* renamed from: b */
    public final zone.bi.mobile.fingerprint.api.settings.a mo2257b() {
        return this.e;
    }
}

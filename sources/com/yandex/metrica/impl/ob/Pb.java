package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Looper;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;

/* loaded from: classes3.dex */
public abstract class Pb {
    protected final C0895e9 a;
    protected final Cc b;
    protected final G1 c;
    private final InterfaceC0948gc d;
    private final Mb e;
    private final Nb f;

    public Pb(Cc cc, C0895e9 c0895e9, G1 g1) {
        this.b = cc;
        this.a = c0895e9;
        this.c = g1;
        InterfaceC0948gc interfaceC0948gcA = a();
        this.d = interfaceC0948gcA;
        this.e = new Mb(interfaceC0948gcA, c());
        this.f = new Nb(cc.a.b);
    }

    public Ec<Xb> a(Pc pc, Xb xb) {
        Sb sb = this.b.a;
        Context context = sb.a;
        Looper looper = sb.b.getLooper();
        Cc cc = this.b;
        return new Ec<>(new Tc(context, looper, cc.b, a(cc.a.c), b(), new C1411zc(pc)), this.e, new Ob(this.d, new SystemTimeProvider()), this.f, xb);
    }

    protected abstract InterfaceC0948gc a();

    protected abstract InterfaceC1412zd a(C1388yd c1388yd);

    protected abstract String b();

    protected abstract String c();
}

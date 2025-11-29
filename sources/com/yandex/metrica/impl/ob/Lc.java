package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes3.dex */
public class Lc {
    protected final Cc a;
    private final G1 b;
    private final Ic c;

    public Lc(Cc cc) {
        this(cc, new G1());
    }

    private Ic a() {
        return new Ic();
    }

    Lc(Cc cc, G1 g1) {
        this.a = cc;
        this.b = g1;
        this.c = a();
    }

    public Ec<Xb> a(Pc pc, Xb xb) {
        Sb sb = this.a.a;
        Context context = sb.a;
        Looper looper = sb.b.getLooper();
        Cc cc = this.a;
        return new Ec<>(new Tc(context, looper, cc.b, this.b.c(cc.a.c), "passive", new C1411zc(pc)), this.c, new Kc(), new Jc(), xb);
    }
}

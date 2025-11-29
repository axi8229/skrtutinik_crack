package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* loaded from: classes3.dex */
public class P {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile P j;
    private final Xl a;
    private final C1060l0 b;
    private final Im c;
    private final C1400z1 d;
    private final C1183q e;
    private final C1137o2 f;
    private final C0786a0 g;
    private final C1159p h;
    private final C1415zg i;

    private P() {
        this(new Xl(), new C1183q(), new Im());
    }

    public static P g() {
        if (j == null) {
            synchronized (P.class) {
                try {
                    if (j == null) {
                        j = new P(new Xl(), new C1183q(), new Im());
                    }
                } finally {
                }
            }
        }
        return j;
    }

    public C1159p a() {
        return this.h;
    }

    public C1183q b() {
        return this.e;
    }

    public ICommonExecutor c() {
        return this.c.a();
    }

    public Im d() {
        return this.c;
    }

    public C0786a0 e() {
        return this.g;
    }

    public C1060l0 f() {
        return this.b;
    }

    public Xl h() {
        return this.a;
    }

    public C1400z1 i() {
        return this.d;
    }

    public InterfaceC0833bm j() {
        return this.a;
    }

    public C1415zg k() {
        return this.i;
    }

    public C1137o2 l() {
        return this.f;
    }

    private P(Xl xl, C1183q c1183q, Im im) {
        this(xl, c1183q, im, new C1159p(c1183q, im.a()));
    }

    private P(Xl xl, C1183q c1183q, Im im, C1159p c1159p) {
        this(xl, new C1060l0(), im, c1159p, new C1400z1(xl), c1183q, new C1137o2(c1183q, im.a(), c1159p), new C0786a0(c1183q), new C1415zg());
    }

    P(Xl xl, C1060l0 c1060l0, Im im, C1159p c1159p, C1400z1 c1400z1, C1183q c1183q, C1137o2 c1137o2, C0786a0 c0786a0, C1415zg c1415zg) {
        this.a = xl;
        this.b = c1060l0;
        this.c = im;
        this.h = c1159p;
        this.d = c1400z1;
        this.e = c1183q;
        this.f = c1137o2;
        this.g = c0786a0;
        this.i = c1415zg;
    }
}

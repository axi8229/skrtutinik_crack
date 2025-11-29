package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes3.dex */
public class Q2 {
    private final C0983hm a;
    private Boolean b;
    private S0 c;
    private T0 d;

    public Q2() {
        this(new C0983hm());
    }

    public synchronized S0 a(Context context, Im im) {
        try {
            if (this.c == null) {
                if (a(context)) {
                    this.c = new C1129nj(im.b(), im.b().getHandler(), im.a(), new Q());
                } else {
                    this.c = new P2(context, im);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    Q2(C0983hm c0983hm) {
        this.a = c0983hm;
    }

    public synchronized T0 a(Context context, S0 s0) {
        try {
            if (this.d == null) {
                if (a(context)) {
                    this.d = new C1154oj();
                } else {
                    this.d = new T2(context, s0);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.d;
    }

    private synchronized boolean a(Context context) {
        try {
            if (this.b == null) {
                this.b = Boolean.valueOf(!this.a.a(context));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b.booleanValue();
    }
}

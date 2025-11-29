package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes3.dex */
public class M5 {
    private final int a;
    private final Q5 b;
    private N5 c;

    public M5(Context context, I3 i3, int i) {
        this(new Q5(context, i3), i);
    }

    private void b() {
        this.b.a(this.c);
    }

    public D0 a(String str) {
        if (this.c == null) {
            N5 n5A = this.b.a();
            this.c = n5A;
            int iD = n5A.d();
            int i = this.a;
            if (iD != i) {
                this.c.b(i);
                b();
            }
        }
        int iHashCode = str.hashCode();
        if (this.c.b().contains(Integer.valueOf(iHashCode))) {
            return D0.NON_FIRST_OCCURENCE;
        }
        D0 d0 = this.c.e() ? D0.FIRST_OCCURRENCE : D0.UNKNOWN;
        if (this.c.c() < 1000) {
            this.c.a(iHashCode);
        } else {
            this.c.a(false);
        }
        b();
        return d0;
    }

    M5(Q5 q5, int i) {
        this.a = i;
        this.b = q5;
    }

    public void a() {
        if (this.c == null) {
            N5 n5A = this.b.a();
            this.c = n5A;
            int iD = n5A.d();
            int i = this.a;
            if (iD != i) {
                this.c.b(i);
                b();
            }
        }
        this.c.a();
        this.c.a(true);
        b();
    }
}

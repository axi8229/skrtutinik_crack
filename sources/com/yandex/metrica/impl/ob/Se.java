package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1318vf;

/* loaded from: classes3.dex */
public abstract class Se implements InterfaceC0826bf, Ie {
    private final String a;
    private final int b;
    private final Kn<String> c;
    private final Ke d;
    private C0858cm e = Ul.a();

    Se(int i, String str, Kn<String> kn, Ke ke) {
        this.b = i;
        this.a = str;
        this.c = kn;
        this.d = ke;
    }

    public final C1318vf.a a() {
        C1318vf.a aVar = new C1318vf.a();
        aVar.b = this.b;
        aVar.a = this.a.getBytes();
        aVar.d = new C1318vf.c();
        aVar.c = new C1318vf.b();
        return aVar;
    }

    public Ke b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    protected boolean e() {
        In inA = this.c.a(this.a);
        if (inA.b()) {
            return true;
        }
        if (!this.e.isEnabled()) {
            return false;
        }
        this.e.w("Attribute " + this.a + " of type " + Ze.a(this.b) + " is skipped because " + inA.a());
        return false;
    }

    public void a(C0858cm c0858cm) {
        this.e = c0858cm;
    }
}

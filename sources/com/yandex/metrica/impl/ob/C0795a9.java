package com.yandex.metrica.impl.ob;

@Deprecated
/* renamed from: com.yandex.metrica.impl.ob.a9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0795a9 extends AbstractC0870d9 {
    private final Rd c;
    private final Rd d;

    public C0795a9(S7 s7) {
        super(s7);
        this.c = new Rd("init_event_pref_key");
        this.d = new Rd("first_event_pref_key");
    }

    @Deprecated
    public boolean f() {
        return a(this.d.a(), (String) null) != null;
    }

    @Deprecated
    public String g(String str) {
        return a(this.c.a(), (String) null);
    }

    @Deprecated
    public C0795a9 h() {
        return (C0795a9) f(this.d.a());
    }

    @Deprecated
    public C0795a9 i() {
        return (C0795a9) f(this.c.a());
    }

    @Deprecated
    public void j() {
        b(this.d.a(), "DONE").d();
    }

    @Deprecated
    public void k() {
        b(this.c.a(), "DONE").d();
    }

    @Deprecated
    public boolean g() {
        return a(this.c.a(), (String) null) != null;
    }
}

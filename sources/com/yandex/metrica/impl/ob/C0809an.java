package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.an, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0809an {
    private final C0884dn a;
    private final C0884dn b;
    private final Wm c;
    private final C0858cm d;
    private final String e;

    public C0809an(int i, int i2, int i3, String str, C0858cm c0858cm) {
        this(new Wm(i), new C0884dn(i2, str + "map key", c0858cm), new C0884dn(i3, str + "map value", c0858cm), str, c0858cm);
    }

    public Wm a() {
        return this.c;
    }

    public C0884dn b() {
        return this.a;
    }

    public C0884dn c() {
        return this.b;
    }

    C0809an(Wm wm, C0884dn c0884dn, C0884dn c0884dn2, String str, C0858cm c0858cm) {
        this.c = wm;
        this.a = c0884dn;
        this.b = c0884dn2;
        this.e = str;
        this.d = c0858cm;
    }

    public void a(String str) {
        if (this.d.isEnabled()) {
            this.d.fw("The %s has reached the limit of %d items. Item with key %s will be ignored", this.e, Integer.valueOf(this.c.a()), str);
        }
    }
}

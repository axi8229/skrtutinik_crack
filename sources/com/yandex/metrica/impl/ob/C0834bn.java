package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.bn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0834bn {
    private final C0809an a;
    private final Zm b;

    public C0834bn(C0858cm c0858cm, String str) {
        this(new C0809an(30, 50, 4000, str, c0858cm), new Zm(4500, str, c0858cm));
    }

    synchronized boolean a(C0808am c0808am, String str, String str2) {
        try {
            if (c0808am.size() >= this.a.a().a() && (this.a.a().a() != c0808am.size() || !c0808am.containsKey(str))) {
                this.a.a(str);
            } else {
                if (!this.b.a(c0808am, str, str2)) {
                    c0808am.put(str, str2);
                    return true;
                }
                this.b.a(str);
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean b(C0808am c0808am, String str, String str2) {
        if (c0808am == null) {
            return false;
        }
        String strA = this.a.b().a(str);
        String strA2 = this.a.c().a(str2);
        if (!c0808am.containsKey(strA)) {
            if (strA2 != null) {
                return a(c0808am, strA, strA2);
            }
            return false;
        }
        String str3 = c0808am.get(strA);
        if (strA2 == null || !strA2.equals(str3)) {
            return a(c0808am, strA, strA2);
        }
        return false;
    }

    C0834bn(C0809an c0809an, Zm zm) {
        this.a = c0809an;
        this.b = zm;
    }
}

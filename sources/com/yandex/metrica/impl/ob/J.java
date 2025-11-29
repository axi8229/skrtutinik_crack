package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class J extends C0836c0 {
    private HashMap<a, Integer> r;
    private InterfaceC0934fn<String> s;
    private InterfaceC0934fn<String> t;
    private InterfaceC0934fn<String> u;
    private InterfaceC0934fn<byte[]> v;
    private InterfaceC0934fn<String> w;
    private InterfaceC0934fn<String> x;

    public enum a {
        NAME,
        VALUE,
        USER_INFO
    }

    public J(C0858cm c0858cm) {
        this.r = new HashMap<>();
        a(c0858cm);
    }

    private String g(String str) {
        String strA = this.s.a(str);
        a(str, strA, a.NAME);
        return strA;
    }

    private String h(String str) {
        String strA = this.t.a(str);
        a(str, strA, a.VALUE);
        return strA;
    }

    public static C0836c0 s() {
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_SEND_USER_PROFILE.b();
        return c0836c0;
    }

    private void u() {
        this.h = 0;
        Iterator<Integer> it = this.r.values().iterator();
        while (it.hasNext()) {
            this.h += it.next().intValue();
        }
    }

    public J a(HashMap<a, Integer> map) {
        this.r = map;
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.C0836c0
    public C0836c0 b(String str) {
        String strA = this.s.a(str);
        a(str, strA, a.NAME);
        this.a = strA;
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.C0836c0
    public C0836c0 d(String str) {
        return super.d(this.w.a(str));
    }

    @Override // com.yandex.metrica.impl.ob.C0836c0
    public C0836c0 e(String str) {
        String strA = this.x.a(str);
        a(str, strA, a.USER_INFO);
        return super.e(strA);
    }

    @Override // com.yandex.metrica.impl.ob.C0836c0
    public C0836c0 f(String str) {
        String strA = this.t.a(str);
        a(str, strA, a.VALUE);
        this.b = strA;
        return this;
    }

    public J i(String str) {
        String strA = this.u.a(str);
        a(str, strA, a.VALUE);
        this.b = strA;
        return this;
    }

    public HashMap<a, Integer> t() {
        return this.r;
    }

    private void a(C0858cm c0858cm) {
        this.s = new C0884dn(1000, "event name", c0858cm);
        this.t = new C0859cn(245760, "event value", c0858cm);
        this.u = new C0859cn(1024000, "event extended value", c0858cm);
        this.v = new Tm(245760, "event value bytes", c0858cm);
        this.w = new C0884dn(200, "user profile id", c0858cm);
        this.x = new C0884dn(10000, "UserInfo", c0858cm);
    }

    public J(String str, String str2, int i, C0858cm c0858cm) {
        this(str, str2, i, 0, c0858cm);
    }

    public J(String str, String str2, int i, int i2, C0858cm c0858cm) {
        this.r = new HashMap<>();
        a(c0858cm);
        this.b = h(str);
        this.a = g(str2);
        this.e = i;
        this.f = i2;
    }

    private void a(String str, String str2, a aVar) {
        if (C0810b.b(str, str2)) {
            this.r.put(aVar, Integer.valueOf(C0810b.b(str).length - C0810b.b(str2).length));
        } else {
            this.r.remove(aVar);
        }
        u();
    }

    @Override // com.yandex.metrica.impl.ob.C0836c0
    public final C0836c0 a(byte[] bArr) {
        byte[] bArrA = this.v.a(bArr);
        a aVar = a.VALUE;
        if (bArr.length != bArrA.length) {
            this.r.put(aVar, Integer.valueOf(bArr.length - bArrA.length));
        } else {
            this.r.remove(aVar);
        }
        u();
        return super.a(bArrA);
    }

    static C0836c0 a(String str, C0858cm c0858cm) {
        J j = new J(c0858cm);
        j.e = EnumC0787a1.EVENT_TYPE_SET_USER_PROFILE_ID.b();
        return super.d(j.w.a(str));
    }

    public J(byte[] bArr, String str, int i, C0858cm c0858cm) {
        this.r = new HashMap<>();
        a(c0858cm);
        a(bArr);
        this.a = g(str);
        this.e = i;
    }
}

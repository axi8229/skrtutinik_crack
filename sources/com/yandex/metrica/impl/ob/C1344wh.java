package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.wh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1344wh {
    private final String a;
    private final String b;
    private final C0895e9 c;

    public C1344wh(String str, String str2) {
        this(str, str2, F0.g().s());
    }

    public String a() {
        C0895e9 c0895e9 = this.c;
        String str = this.a;
        String str2 = this.b;
        c0895e9.getClass();
        return c0895e9.a(new Rd("LAST_SOCKET_REPORT_TIMES_" + str + "_" + str2, null).a(), (String) null);
    }

    C1344wh(String str, String str2, C0895e9 c0895e9) {
        this.a = str;
        this.b = str2;
        this.c = c0895e9;
    }

    public void a(String str) {
        this.c.a(this.a, this.b, str);
    }
}

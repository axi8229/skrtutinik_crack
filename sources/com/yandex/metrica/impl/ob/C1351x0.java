package com.yandex.metrica.impl.ob;

import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.x0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1351x0 {
    private C0808am a = new C0808am();
    private C0834bn b;

    C1351x0(C0834bn c0834bn) {
        this.b = c0834bn;
    }

    void a(String str, String str2) {
        this.b.b(this.a, str, str2);
    }

    String a() {
        if (this.a.isEmpty()) {
            return null;
        }
        return new JSONObject(this.a).toString();
    }
}

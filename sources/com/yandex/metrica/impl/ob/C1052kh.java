package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Jf;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.kh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1052kh {
    private final C1077lh a;
    private final com.yandex.metrica.d b;

    public C1052kh() {
        this(new C1077lh(), C1152oh.a());
    }

    public void a(Jf.e.b bVar) {
        this.b.b("provided_request_result", this.a.a(bVar));
    }

    public void b(Jf.e.a aVar) {
        String string;
        com.yandex.metrica.d dVar = this.b;
        this.a.getClass();
        try {
            string = new JSONObject().put("id", aVar.a).toString();
        } catch (Throwable th) {
            string = th.toString();
        }
        dVar.b("provided_request_send", string);
    }

    C1052kh(C1077lh c1077lh, com.yandex.metrica.d dVar) {
        this.a = c1077lh;
        this.b = dVar;
    }

    public void a(Jf.e.a aVar) {
        String string;
        com.yandex.metrica.d dVar = this.b;
        this.a.getClass();
        try {
            string = new JSONObject().put("id", aVar.a).toString();
        } catch (Throwable th) {
            string = th.toString();
        }
        dVar.b("provided_request_schedule", string);
    }
}

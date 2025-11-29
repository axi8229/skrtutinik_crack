package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class R1 implements N0 {
    private Context a;
    private A3 b;
    private T1 c;
    private Handler d;
    private C0979hi e;
    private Map<String, M0> f;
    private final Kn<String> g;
    private final List<String> h;

    public R1(Context context, A3 a3, T1 t1, Handler handler, C0979hi c0979hi) {
        HashMap map = new HashMap();
        this.f = map;
        this.g = new Hn(new Mn(map));
        this.h = Arrays.asList("20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72");
        this.a = context;
        this.b = a3;
        this.c = t1;
        this.d = handler;
        this.e = c0979hi;
    }

    public C1011j1 a(com.yandex.metrica.i iVar, boolean z, C0820b9 c0820b9) {
        this.g.a(iVar.apiKey);
        Context context = this.a;
        A3 a3 = this.b;
        C1011j1 c1011j1 = new C1011j1(context, a3, iVar, this.c, new C1017j7(context, a3), this.e, new C1377y2(this, "20799a27-fa80-4b36-b2db-0f8141f24180"), new C1377y2(this, "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"), c0820b9, P.g(), new A0(context));
        a(c1011j1);
        if (z) {
            c1011j1.i.c(c1011j1.b);
        }
        Map<String, String> map = iVar.h;
        if (!A2.b(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key)) {
                    c1011j1.i.a(key, value, c1011j1.b);
                } else if (c1011j1.c.isEnabled()) {
                    c1011j1.c.fw("Invalid App Environment (key,value) pair: (%s,%s).", key, value);
                }
            }
        }
        c1011j1.a(iVar.errorEnvironment);
        c1011j1.f();
        this.c.a(c1011j1);
        this.f.put(iVar.apiKey, c1011j1);
        return c1011j1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.yandex.metrica.impl.ob.M0] */
    @Override // com.yandex.metrica.impl.ob.N0
    public synchronized M0 b(com.yandex.metrica.e eVar) {
        C1061l1 c1061l1;
        try {
            M0 m0 = this.f.get(eVar.apiKey);
            c1061l1 = m0;
            if (m0 == 0) {
                if (!this.h.contains(eVar.apiKey)) {
                    this.e.g();
                }
                C1061l1 c1061l12 = new C1061l1(this.a, this.b, eVar, this.c);
                a(c1061l12);
                c1061l12.f();
                this.f.put(eVar.apiKey, c1061l12);
                c1061l1 = c1061l12;
            }
        } catch (Throwable th) {
            throw th;
        }
        return c1061l1;
    }

    @Override // com.yandex.metrica.impl.ob.O0
    public N0 b() {
        return this;
    }

    public synchronized void c(com.yandex.metrica.e eVar) {
        try {
            if (this.f.containsKey(eVar.apiKey)) {
                C0858cm c0858cmB = Ul.b(eVar.apiKey);
                if (c0858cmB.isEnabled()) {
                    c0858cmB.fw("Reporter with apiKey=%s already exists.", eVar.apiKey);
                }
            } else {
                b(eVar);
                Log.i("AppMetrica", "Activate reporter with APIKey " + A2.a(eVar.apiKey));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.yandex.metrica.impl.ob.N0
    public synchronized R0 a(com.yandex.metrica.i iVar) {
        R0 r0;
        R0 r02 = (M0) this.f.get(iVar.apiKey);
        r0 = r02;
        if (r02 == null) {
            C0861d0 c0861d0 = new C0861d0(this.a, this.b, iVar, this.c);
            a(c0861d0);
            c0861d0.a(iVar.errorEnvironment);
            c0861d0.f();
            r0 = c0861d0;
        }
        return r0;
    }

    private void a(B b) {
        b.a(new C0812b1(this.d, b));
        b.b.a(this.e);
    }
}

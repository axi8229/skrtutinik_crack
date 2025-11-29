package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.IHandlerExecutor;

/* renamed from: com.yandex.metrica.impl.ob.wc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1339wc {
    private final IHandlerExecutor a = F0.g().q().b();
    private final U7 b;
    private final T7 c;
    private final Ed d;
    private final C1388yd e;

    public C1339wc(Context context) {
        this.b = C1020ja.a(context).f();
        this.c = C1020ja.a(context).e();
        Ed ed = new Ed();
        this.d = ed;
        this.e = new C1388yd(ed.a());
    }

    public IHandlerExecutor a() {
        return this.a;
    }

    public T7 b() {
        return this.c;
    }

    public U7 c() {
        return this.b;
    }

    public C1388yd d() {
        return this.e;
    }

    public Ed e() {
        return this.d;
    }
}

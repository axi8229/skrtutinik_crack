package com.yandex.metrica.impl.ob;

import android.os.Handler;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.nj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1129nj implements S0 {
    private final Handler a;
    private final ICommonExecutor b;
    private final ICommonExecutor c;

    public C1129nj(ICommonExecutor iCommonExecutor, Handler handler, ICommonExecutor iCommonExecutor2, Q q) {
        this.b = iCommonExecutor;
        this.a = handler;
        this.c = iCommonExecutor2;
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public C1278u a() {
        return new C1278u(this.c);
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public void a(com.yandex.metrica.i iVar, O0 o0) {
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public void a(Map<String, Object> map) {
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public ICommonExecutor b() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public Handler c() {
        return this.a;
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public Eb d() {
        return new C1386yb();
    }
}

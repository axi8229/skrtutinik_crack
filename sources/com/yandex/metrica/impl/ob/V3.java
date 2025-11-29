package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.D3;
import com.yandex.metrica.impl.ob.Lg;
import com.yandex.metrica.impl.ob.U3.b;

/* loaded from: classes3.dex */
public class V3 extends M3 {
    private final Pm m;

    public V3(Context context, I3 i3, D3.a aVar, AbstractC1321vi abstractC1321vi, C1178pi c1178pi, Lg.e eVar, ICommonExecutor iCommonExecutor, int i, Pm pm, C0912f1 c0912f1) {
        super(context, i3, aVar, abstractC1321vi, c1178pi, eVar, iCommonExecutor, i, c0912f1);
        this.m = pm;
    }

    public C1117n7 a(C0993i7 c0993i7, InterfaceC0918f7<String> interfaceC0918f7, C0845c9 c0845c9) {
        return new C1117n7(this.c, new B0(), c0993i7, interfaceC0918f7, F0.g().q().e(), c0845c9);
    }

    public InterfaceC0918f7<String> b(U3 u3) {
        return new C1067l7(u3);
    }

    public C1271tg c(U3 u3) {
        return new C1271tg(new C1076lg(u3), u3.new b(), u3);
    }

    public C0993i7 f() {
        return new C0993i7(new C0843c7(EnumC0943g7.BREAKPAD, null), new C0968h7(new P6()));
    }

    public C0889e3 a(U3 u3) {
        return new C0889e3(this.c, this.m.a(), this.m.i(), C0914f3.a(), new C0839c3(this.c), new C0814b3(u3, F0.g().q().e()), F0.g().b(), new C0864d3());
    }
}

package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* loaded from: classes3.dex */
public class Nb extends Ub<Xb> {
    public Nb(ICommonExecutor iCommonExecutor) {
        super(iCommonExecutor);
    }

    @Override // com.yandex.metrica.impl.ob.Qb
    public void a(Runnable runnable, Object obj) {
        Wb wb = ((Xb) obj).b;
        if (wb != null) {
            a(runnable, wb.a);
        }
    }
}

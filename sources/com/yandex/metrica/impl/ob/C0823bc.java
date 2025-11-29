package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* renamed from: com.yandex.metrica.impl.ob.bc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0823bc extends Ub<C0848cc> {
    public C0823bc(ICommonExecutor iCommonExecutor) {
        super(iCommonExecutor);
    }

    @Override // com.yandex.metrica.impl.ob.Qb
    public void a(Runnable runnable, Object obj) {
        C0798ac c0798ac = ((C0848cc) obj).b;
        if (c0798ac != null) {
            a(runnable, c0798ac.b);
        }
    }
}

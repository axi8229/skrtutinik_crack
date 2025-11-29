package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C0947gb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* renamed from: com.yandex.metrica.impl.ob.hb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0972hb {
    private final C0947gb.b a = new C0947gb.b(false, 1);

    public final C0947gb a(Uh uh) {
        C0947gb.b bVar = this.a;
        Random.Companion companion = Random.INSTANCE;
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        Pm pmQ = f0G.q();
        Intrinsics.checkNotNullExpressionValue(pmQ, "GlobalServiceLocator.get…).serviceExecutorProvider");
        ICommonExecutor iCommonExecutorG = pmQ.g();
        Intrinsics.checkNotNullExpressionValue(iCommonExecutorG, "GlobalServiceLocator.get…rovider.supportIOExecutor");
        M0 m0A = C1152oh.a();
        Intrinsics.checkNotNullExpressionValue(m0A, "YandexMetricaSelfReportFacade.getReporter()");
        return new C0947gb(uh, bVar, companion, iCommonExecutorG, new C1046kb(new C1021jb(uh, m0A), uh));
    }
}

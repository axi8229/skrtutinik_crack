package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.plugins.YandexMetricaPlugins;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class W2 {
    private static final YandexMetricaPlugins a;

    static {
        P pG = P.g();
        Intrinsics.checkNotNullExpressionValue(pG, "ClientServiceLocator.getInstance()");
        ICommonExecutor iCommonExecutorC = pG.c();
        Intrinsics.checkNotNullExpressionValue(iCommonExecutorC, "ClientServiceLocator.get…stance().apiProxyExecutor");
        a = new V2(new Tf(iCommonExecutorC));
    }

    public static final YandexMetricaPlugins a() {
        return a;
    }
}

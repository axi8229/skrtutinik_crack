package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Yd implements X<C0900ee> {
    @Override // com.yandex.metrica.impl.ob.X, kotlin.jvm.functions.Function1
    public Boolean invoke(Object obj) {
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        return Boolean.valueOf(f0G.k().b((C0900ee) obj));
    }
}

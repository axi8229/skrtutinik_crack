package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1306v3;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.u3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1282u3 implements X<Map<String, ? extends String>> {
    @Override // com.yandex.metrica.impl.ob.X, kotlin.jvm.functions.Function1
    public Boolean invoke(Object obj) {
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        return Boolean.valueOf(f0G.d().b(new C1306v3.a((Map) obj, EnumC1279u0.RETAIL)));
    }
}

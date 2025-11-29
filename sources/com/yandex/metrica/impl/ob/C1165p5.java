package com.yandex.metrica.impl.ob;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.p5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1165p5 extends X4 {
    public C1165p5(L3 l3) {
        super(l3);
        I3 i3E = l3.e();
        Intrinsics.checkNotNullExpressionValue(i3E, "component.componentId");
        String strA = i3E.a();
        if (strA != null) {
            A2.a(strA);
        }
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        Map<String, byte[]> mapI = c0836c0.i();
        Intrinsics.checkNotNullExpressionValue(mapI, "reportData.extras");
        for (Map.Entry<String, byte[]> entry : mapI.entrySet()) {
            L3 component = a();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            C0967h6 c0967h6U = component.u();
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            c0967h6U.a(key, entry.getValue());
        }
        return true;
    }
}

package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1306v3;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.w3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1330w3 extends AbstractC1255t0<C1306v3.a> {
    @Override // com.yandex.metrica.impl.ob.AbstractC1255t0
    public boolean a(C1306v3.a aVar, C1306v3.a aVar2) {
        if (!A2.b(aVar2.b())) {
            if (A2.b(aVar.b())) {
                return false;
            }
            if (aVar.a() == EnumC1279u0.APP) {
                int iIntValue = a().a(aVar.a()).intValue();
                Integer numA = a().a(aVar2.a());
                Intrinsics.checkNotNullExpressionValue(numA, "priorities[oldData.source]");
                if (Intrinsics.compare(iIntValue, numA.intValue()) < 0) {
                    return false;
                }
            } else {
                int iIntValue2 = a().a(aVar.a()).intValue();
                Integer numA2 = a().a(aVar2.a());
                Intrinsics.checkNotNullExpressionValue(numA2, "priorities[oldData.source]");
                if (Intrinsics.compare(iIntValue2, numA2.intValue()) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

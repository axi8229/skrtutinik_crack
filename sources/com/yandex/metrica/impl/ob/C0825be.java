package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.be, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0825be extends AbstractC1255t0<C0900ee> {
    @Override // com.yandex.metrica.impl.ob.AbstractC1255t0
    public boolean a(C0900ee c0900ee, C0900ee c0900ee2) {
        C0900ee c0900ee3 = c0900ee;
        C0900ee c0900ee4 = c0900ee2;
        if (c0900ee3.c) {
            if (c0900ee4.c) {
                int iIntValue = a().a(c0900ee3.e).intValue();
                Integer numA = a().a(c0900ee4.e);
                Intrinsics.checkNotNullExpressionValue(numA, "priorities[oldData.source]");
                if (Intrinsics.compare(iIntValue, numA.intValue()) > 0) {
                }
            }
            return true;
        }
        return false;
    }
}

package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;

/* renamed from: com.yandex.metrica.impl.ob.de, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0875de implements Converter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer fromModel(EnumC1279u0 enumC1279u0) {
        int iOrdinal = enumC1279u0.ordinal();
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? 0 : 2;
        }
        return 3;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC1279u0 toModel(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == 1) {
            return EnumC1279u0.APP;
        }
        if (iIntValue == 2) {
            return EnumC1279u0.RETAIL;
        }
        if (iIntValue != 3) {
            return EnumC1279u0.UNDEFINED;
        }
        return EnumC1279u0.SATELLITE;
    }
}

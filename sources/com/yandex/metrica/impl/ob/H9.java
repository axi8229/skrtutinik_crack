package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.gpllibrary.a;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class H9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.k.a.b.C0287a fromModel(C0798ac c0798ac) {
        If.k.a.b.C0287a c0287a = new If.k.a.b.C0287a();
        c0287a.a = c0798ac.b;
        c0287a.b = c0798ac.c;
        int iOrdinal = c0798ac.a.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    i = 0;
                }
            }
        }
        c0287a.c = i;
        return c0287a;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0798ac toModel(If.k.a.b.C0287a c0287a) {
        a.b bVar;
        int i = c0287a.c;
        if (i == 1) {
            bVar = a.b.PRIORITY_LOW_POWER;
        } else if (i == 2) {
            bVar = a.b.PRIORITY_BALANCED_POWER_ACCURACY;
        } else if (i != 3) {
            bVar = a.b.PRIORITY_NO_POWER;
        } else {
            bVar = a.b.PRIORITY_HIGH_ACCURACY;
        }
        return new C0798ac(bVar, c0287a.a, c0287a.b);
    }
}

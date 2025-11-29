package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1366xf;

/* renamed from: com.yandex.metrica.impl.ob.a3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0789a3 implements ProtobufConverter {
    C0789a3() {
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1366xf.a fromModel(com.yandex.metrica.billing_interface.a aVar) {
        int i;
        C1366xf.a aVar2 = new C1366xf.a();
        int iOrdinal = aVar.a.ordinal();
        if (iOrdinal != 0) {
            i = 1;
            if (iOrdinal == 1) {
                i = 3;
            }
        } else {
            i = 2;
        }
        aVar2.a = i;
        aVar2.b = aVar.b;
        aVar2.c = aVar.c;
        aVar2.d = aVar.d;
        aVar2.e = aVar.e;
        return aVar2;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.yandex.metrica.billing_interface.a toModel(C1366xf.a aVar) {
        com.yandex.metrica.billing_interface.e eVar;
        int i = aVar.a;
        if (i == 2) {
            eVar = com.yandex.metrica.billing_interface.e.INAPP;
        } else if (i != 3) {
            eVar = com.yandex.metrica.billing_interface.e.UNKNOWN;
        } else {
            eVar = com.yandex.metrica.billing_interface.e.SUBS;
        }
        return new com.yandex.metrica.billing_interface.a(eVar, aVar.b, aVar.c, aVar.d, aVar.e);
    }
}

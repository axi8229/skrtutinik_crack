package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1342wf;
import com.yandex.metrica.impl.ob.C1398z;

/* renamed from: com.yandex.metrica.impl.ob.u9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1288u9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1342wf.a fromModel(C1398z c1398z) {
        C1342wf.a aVar = new C1342wf.a();
        C1398z.a aVar2 = c1398z.a;
        if (aVar2 != null) {
            int iOrdinal = aVar2.ordinal();
            if (iOrdinal == 0) {
                aVar.a = 1;
            } else if (iOrdinal == 1) {
                aVar.a = 2;
            } else if (iOrdinal == 2) {
                aVar.a = 3;
            } else if (iOrdinal == 3) {
                aVar.a = 4;
            } else if (iOrdinal == 4) {
                aVar.a = 5;
            }
        }
        Boolean bool = c1398z.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                aVar.b = 1;
            } else {
                aVar.b = 0;
            }
        }
        return aVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1398z toModel(C1342wf.a aVar) {
        C1398z.a aVar2;
        int i = aVar.a;
        Boolean bool = null;
        if (i == 1) {
            aVar2 = C1398z.a.ACTIVE;
        } else if (i == 2) {
            aVar2 = C1398z.a.WORKING_SET;
        } else if (i == 3) {
            aVar2 = C1398z.a.FREQUENT;
        } else if (i != 4) {
            aVar2 = i != 5 ? null : C1398z.a.RESTRICTED;
        } else {
            aVar2 = C1398z.a.RARE;
        }
        int i2 = aVar.b;
        if (i2 == 0) {
            bool = Boolean.FALSE;
        } else if (i2 == 1) {
            bool = Boolean.TRUE;
        }
        return new C1398z(aVar2, bool);
    }
}

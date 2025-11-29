package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.yandex.metrica.impl.ob.C1100mf;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Ga implements Fa {
    private final Ha a;
    private final Ca b;
    private final C1058kn c;
    private final La d;

    public Ga() {
        this(new Ha(), new Ca(), new C1058kn(100), new La());
    }

    private C1100mf a(C1100mf c1100mf) {
        C1100mf c1100mf2 = new C1100mf();
        c1100mf2.a = c1100mf.a;
        C1100mf.h hVar = new C1100mf.h();
        c1100mf2.f = hVar;
        hVar.a = new C1100mf.f();
        C1100mf.f fVar = c1100mf2.f.a;
        C1100mf.f fVar2 = c1100mf.f.a;
        fVar.b = fVar2.b;
        fVar.a = fVar2.a;
        fVar.e = fVar2.e;
        fVar.c = fVar2.c;
        return c1100mf2;
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        Na<C1100mf.i, Vm> naFromModel;
        Va va = (Va) obj;
        C1100mf c1100mf = new C1100mf();
        c1100mf.a = va.b;
        c1100mf.f = new C1100mf.h();
        Wa wa = va.c;
        C1100mf.f fVar = new C1100mf.f();
        fVar.a = C0810b.b(wa.a);
        C0959gn<String, Vm> c0959gnA = this.c.a(wa.b);
        fVar.b = C0810b.b(c0959gnA.a);
        fVar.e = wa.c.size();
        Map<String, String> map = wa.d;
        if (map != null) {
            naFromModel = this.a.fromModel(map);
            fVar.c = naFromModel.a;
        } else {
            naFromModel = null;
        }
        c1100mf.f.a = fVar;
        Vm vmA = Um.a(c0959gnA, naFromModel);
        List<Ua> list = wa.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int iComputeInt32Size = c1100mf.a != new C1100mf().a ? CodedOutputByteBufferNano.computeInt32Size(1, c1100mf.a) : 0;
        C1100mf.q qVar = c1100mf.b;
        if (qVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, qVar);
        }
        C1100mf.o oVar = c1100mf.c;
        if (oVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, oVar);
        }
        C1100mf.p pVar = c1100mf.d;
        int i = 4;
        if (pVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, pVar);
        }
        C1100mf.b bVar = c1100mf.e;
        if (bVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, bVar);
        }
        C1100mf.h hVar = c1100mf.f;
        if (hVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, hVar);
        }
        ArrayList arrayList2 = new ArrayList();
        C1100mf c1100mfA = a(c1100mf);
        int i2 = 0;
        Vm vmA2 = vmA;
        int i3 = iComputeInt32Size;
        while (i2 < list.size()) {
            Ua ua = list.get(i2);
            C1100mf.g gVar = new C1100mf.g();
            gVar.a = i2;
            Na<C1100mf.c, Vm> naFromModel2 = this.b.fromModel(ua);
            gVar.b = naFromModel2.a;
            this.d.getClass();
            int iComputeTagSize = CodedOutputByteBufferNano.computeTagSize(i);
            int iComputeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag(gVar);
            int iComputeRawVarint32Size = iComputeTagSize + iComputeMessageSizeNoTag + ((iComputeMessageSizeNoTag & (-128)) == 0 ? 0 : CodedOutputByteBufferNano.computeRawVarint32Size(iComputeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i3 + iComputeRawVarint32Size > 204800) {
                c1100mfA.f.a.d = (C1100mf.g[]) arrayList2.toArray(new C1100mf.g[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Na(c1100mfA, vmA2));
                vmA2 = vmA;
                i3 = iComputeInt32Size;
                c1100mfA = a(c1100mf);
                arrayList2 = arrayList3;
            }
            arrayList2.add(gVar);
            vmA2 = Um.a(vmA2, naFromModel2);
            i3 += iComputeRawVarint32Size;
            i2++;
            i = 4;
        }
        c1100mfA.f.a.d = (C1100mf.g[]) arrayList2.toArray(new C1100mf.g[arrayList2.size()]);
        arrayList.add(new Na(c1100mfA, vmA2));
        return arrayList;
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Ga(Ha ha, Ca ca, C1058kn c1058kn, La la) {
        this.a = ha;
        this.b = ca;
        this.c = c1058kn;
        this.d = la;
    }
}

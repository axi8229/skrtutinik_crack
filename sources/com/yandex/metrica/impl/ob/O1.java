package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.yandex.metrica.impl.ob.C1199qf;
import java.util.List;

/* loaded from: classes3.dex */
class O1 implements InterfaceC0806ak {
    final /* synthetic */ C1199qf a;
    final /* synthetic */ P1 b;

    O1(P1 p1, C1199qf c1199qf) {
        this.b = p1;
        this.a = c1199qf;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0806ak
    public void a(Zj zj) {
        C1199qf c1199qf = this.a;
        List<Tj> listC = zj.c();
        if (A2.b(listC)) {
            return;
        }
        c1199qf.d = new C1199qf.e[listC.size()];
        for (int i = 0; i < listC.size(); i++) {
            Tj tj = listC.get(i);
            C1199qf.e[] eVarArr = c1199qf.d;
            int i2 = J1.e;
            C1199qf.e eVar = new C1199qf.e();
            if (tj.b() != null) {
                eVar.a = tj.b().intValue();
            }
            if (tj.c() != null) {
                eVar.b = tj.c().intValue();
            }
            if (!TextUtils.isEmpty(tj.a())) {
                eVar.c = tj.a();
            }
            eVar.d = tj.d();
            eVarArr[i] = eVar;
            P1.a(this.b, CodedOutputByteBufferNano.computeMessageSizeNoTag(c1199qf.d[i]));
            P1.a(this.b, CodedOutputByteBufferNano.computeTagSize(10));
        }
    }
}

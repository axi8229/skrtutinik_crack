package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import com.yandex.metrica.impl.ob.C1298uj;

@TargetApi(17)
/* renamed from: com.yandex.metrica.impl.ob.yj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1394yj implements S {
    private final Jj a;
    private final AbstractC1179pj b;
    private final AbstractC1179pj c;
    private final AbstractC1179pj d;
    private final AbstractC1179pj e;
    private final S[] f;

    public C1394yj() {
        this(new Aj());
    }

    public void a(CellInfo cellInfo, C1298uj.a aVar) {
        this.a.a(cellInfo, aVar);
        if (cellInfo instanceof CellInfoGsm) {
            this.b.a((CellInfoGsm) cellInfo, aVar);
            return;
        }
        if (cellInfo instanceof CellInfoCdma) {
            this.c.a((CellInfoCdma) cellInfo, aVar);
            return;
        }
        if (cellInfo instanceof CellInfoLte) {
            this.d.a((CellInfoLte) cellInfo, aVar);
        } else if (A2.a(18) && (cellInfo instanceof CellInfoWcdma)) {
            this.e.a((CellInfoWcdma) cellInfo, aVar);
        }
    }

    private C1394yj(AbstractC1179pj abstractC1179pj) {
        this(new Jj(), new Bj(), new C1418zj(), new Gj(), A2.a(18) ? new Hj() : abstractC1179pj);
    }

    C1394yj(Jj jj, AbstractC1179pj abstractC1179pj, AbstractC1179pj abstractC1179pj2, AbstractC1179pj abstractC1179pj3, AbstractC1179pj abstractC1179pj4) {
        this.a = jj;
        this.b = abstractC1179pj;
        this.c = abstractC1179pj2;
        this.d = abstractC1179pj3;
        this.e = abstractC1179pj4;
        this.f = new S[]{abstractC1179pj, abstractC1179pj2, abstractC1179pj4, abstractC1179pj3};
    }

    @Override // com.yandex.metrica.impl.ob.S
    public void a(Sh sh) {
        for (S s : this.f) {
            s.a(sh);
        }
    }
}

package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellIdentityGsm;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import com.yandex.metrica.impl.ob.C1298uj;

@TargetApi(17)
/* loaded from: classes3.dex */
public class Bj extends AbstractC1179pj {
    private final Mj<CellIdentityGsm> c;

    public Bj() {
        this(A2.a(28) ? new Oj() : new Nj());
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1179pj
    protected void b(CellInfo cellInfo, C1298uj.a aVar) {
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        aVar.a(1).b(Integer.valueOf(cellIdentity.getCid())).c(Integer.valueOf(cellIdentity.getLac())).l(Integer.valueOf(cellInfoGsm.getCellSignalStrength().getDbm())).i(this.c.b(cellIdentity)).j(this.c.a(cellIdentity));
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1179pj
    protected void c(CellInfo cellInfo, C1298uj.a aVar) {
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        if (A2.a(24)) {
            aVar.a(Integer.valueOf(cellInfoGsm.getCellIdentity().getArfcn()));
        }
    }

    Bj(Mj<CellIdentityGsm> mj) {
        this.c = mj;
    }
}

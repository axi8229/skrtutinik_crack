package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoWcdma;
import com.yandex.metrica.DoNotInline;
import com.yandex.metrica.impl.ob.C1298uj;

@TargetApi(18)
@DoNotInline
/* loaded from: classes3.dex */
public class Hj extends AbstractC1179pj {
    private final Mj<CellIdentityWcdma> c;

    public Hj() {
        this(A2.a(28) ? new Sj() : new Rj());
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1179pj
    protected void b(CellInfo cellInfo, C1298uj.a aVar) {
        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        aVar.a(3).b(Integer.valueOf(cellIdentity.getCid())).c(Integer.valueOf(cellIdentity.getLac())).k(Integer.valueOf(cellIdentity.getPsc())).l(Integer.valueOf(cellInfoWcdma.getCellSignalStrength().getDbm())).i(this.c.b(cellIdentity)).j(this.c.a(cellIdentity));
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1179pj
    protected void c(CellInfo cellInfo, C1298uj.a aVar) {
        if (A2.a(24)) {
            aVar.a(Integer.valueOf(Cj.a(((CellInfoWcdma) cellInfo).getCellIdentity())));
        }
    }

    Hj(Mj<CellIdentityWcdma> mj) {
        this.c = mj;
    }
}

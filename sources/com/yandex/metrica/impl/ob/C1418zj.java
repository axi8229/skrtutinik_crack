package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import com.yandex.metrica.impl.ob.C1298uj;

@TargetApi(17)
/* renamed from: com.yandex.metrica.impl.ob.zj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1418zj extends AbstractC1179pj {
    @Override // com.yandex.metrica.impl.ob.AbstractC1179pj
    protected void b(CellInfo cellInfo, C1298uj.a aVar) {
        aVar.l(Integer.valueOf(((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm()));
        aVar.a(2);
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1179pj
    protected void c(CellInfo cellInfo, C1298uj.a aVar) {
    }
}

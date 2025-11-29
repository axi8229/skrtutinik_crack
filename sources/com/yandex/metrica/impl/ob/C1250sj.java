package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellInfo;
import com.yandex.metrica.impl.ob.C1298uj;

@TargetApi(17)
/* renamed from: com.yandex.metrica.impl.ob.sj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1250sj implements Lj {
    private final C1394yj a;
    private final C1370xj b;

    public C1250sj() {
        this(new C1394yj(), new C1370xj());
    }

    @Override // com.yandex.metrica.impl.ob.S
    public void a(Sh sh) {
        this.a.a(sh);
    }

    C1250sj(C1394yj c1394yj, C1370xj c1370xj) {
        this.a = c1394yj;
        this.b = c1370xj;
    }

    @Override // com.yandex.metrica.impl.ob.Lj
    public C1298uj a(CellInfo cellInfo) {
        C1298uj.a aVar = new C1298uj.a();
        this.a.a(cellInfo, aVar);
        return this.b.a(new C1298uj(aVar));
    }
}

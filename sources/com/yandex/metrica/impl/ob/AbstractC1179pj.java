package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellInfo;
import com.yandex.metrica.impl.ob.C1298uj;

@TargetApi(17)
/* renamed from: com.yandex.metrica.impl.ob.pj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1179pj implements S {
    private final String a = "[" + getClass().getName() + "]";
    private volatile Sh b;

    private boolean b(CellInfo cellInfo) {
        Sh sh = this.b;
        if (sh == null || !sh.t) {
            return false;
        }
        return !sh.u || cellInfo.isRegistered();
    }

    public void a(CellInfo cellInfo, C1298uj.a aVar) {
        b(cellInfo, aVar);
        if (b(cellInfo)) {
            c(cellInfo, aVar);
        }
    }

    protected abstract void b(CellInfo cellInfo, C1298uj.a aVar);

    protected abstract void c(CellInfo cellInfo, C1298uj.a aVar);

    @Override // com.yandex.metrica.impl.ob.S
    public void a(Sh sh) {
        this.b = sh;
    }
}

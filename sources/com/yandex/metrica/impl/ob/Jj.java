package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellInfo;
import com.yandex.metrica.impl.ob.C1298uj;
import java.util.concurrent.TimeUnit;

@TargetApi(17)
/* loaded from: classes3.dex */
public class Jj {
    private C0958gm a;

    public Jj() {
        this(new C0958gm());
    }

    public void a(CellInfo cellInfo, C1298uj.a aVar) {
        long timeStamp = cellInfo.getTimeStamp();
        Long lValueOf = null;
        if (timeStamp > 0) {
            C0958gm c0958gm = this.a;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long jC = c0958gm.c(timeStamp, timeUnit);
            if (jC > 0 && jC < TimeUnit.HOURS.toSeconds(1L)) {
                lValueOf = Long.valueOf(jC);
            }
            if (lValueOf == null) {
                long jA = this.a.a(timeStamp, timeUnit);
                if (jA > 0 && jA < TimeUnit.HOURS.toSeconds(1L)) {
                    lValueOf = Long.valueOf(jA);
                }
            }
        }
        aVar.a(lValueOf).a(cellInfo.isRegistered());
    }

    Jj(C0958gm c0958gm) {
        this.a = c0958gm;
    }
}

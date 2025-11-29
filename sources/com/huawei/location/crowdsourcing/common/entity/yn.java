package com.huawei.location.crowdsourcing.common.entity;

import android.os.SystemClock;
import android.telephony.CellInfo;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class yn {
    private static boolean yn;
    private final CellInfo FB;
    private final long Vw;

    static {
        LogLocation.i("CellWrapper", "nano time delay:" + (SystemClock.elapsedRealtimeNanos() - System.nanoTime()));
        yn = true;
    }

    yn(CellInfo cellInfo, long j) {
        this.FB = cellInfo;
        this.Vw = j;
    }

    public static List<yn> yn(List<CellInfo> list) {
        long j;
        if (!yn || list.isEmpty()) {
            j = 0;
        } else {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long jNanoTime = System.nanoTime();
            j = jElapsedRealtimeNanos - jNanoTime;
            if (j > 100000000000L) {
                LogLocation.d("CellWrapper", "detect nano");
                Iterator<CellInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().getTimeStamp() > jNanoTime) {
                        LogLocation.i("CellWrapper", "close nano detect");
                        yn = false;
                        break;
                    }
                }
                if (yn) {
                    LogLocation.d("CellWrapper", "use nano. diff:" + j);
                }
            } else {
                LogLocation.d("CellWrapper", "not detect nano. diff:" + j);
            }
            j = 0;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<CellInfo> it2 = list.iterator();
        while (it2.hasNext()) {
            linkedList.add(new yn(it2.next(), j));
        }
        return linkedList;
    }

    public CellInfo Vw() {
        return this.FB;
    }

    public long yn() {
        return this.FB.getTimeStamp() + this.Vw;
    }
}

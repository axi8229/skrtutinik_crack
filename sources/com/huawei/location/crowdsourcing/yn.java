package com.huawei.location.crowdsourcing;

import android.os.SystemClock;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
final class yn implements com.huawei.location.crowdsourcing.common.yn {
    private List<com.huawei.location.crowdsourcing.common.entity.yn> Vw = new LinkedList();
    private long yn;

    yn() {
    }

    private static void yn(List<com.huawei.location.crowdsourcing.common.entity.yn> list) {
        final long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        final long jD2 = Config.FB.yn.d2();
        com.huawei.location.crowdsourcing.common.util.Vw vw = new com.huawei.location.crowdsourcing.common.util.Vw() { // from class: com.huawei.location.crowdsourcing.yn$$ExternalSyntheticLambda0
            @Override // com.huawei.location.crowdsourcing.common.util.Vw
            public final boolean yn(Object obj) {
                return yn.yn(jElapsedRealtimeNanos, jD2, (com.huawei.location.crowdsourcing.common.entity.yn) obj);
            }
        };
        Iterator<com.huawei.location.crowdsourcing.common.entity.yn> it = list.iterator();
        while (it.hasNext()) {
            if (vw.yn(it.next())) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean yn(long j, long j2, com.huawei.location.crowdsourcing.common.entity.yn ynVar) {
        long jAbs = Math.abs(ynVar.yn() - j);
        if (jAbs <= j2) {
            return false;
        }
        LogLocation.d("CellCollector", "remove expired(ns). timeDiff:" + jAbs);
        return true;
    }

    List<com.huawei.location.crowdsourcing.common.entity.yn> Vw() {
        List<com.huawei.location.crowdsourcing.common.entity.yn> listYn;
        Config config = Config.FB.yn;
        if (!config.t6()) {
            LogLocation.d("CellCollector", "no need get cell");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.yn) < config.E5()) {
            LogLocation.d("CellCollector", "collect interval check failed");
            return null;
        }
        if (PermissionUtil.checkSelfPermission(Vw.Vw(), "android.permission.ACCESS_FINE_LOCATION")) {
            listYn = com.huawei.location.crowdsourcing.common.entity.yn.yn(com.huawei.location.crowdsourcing.common.util.dC.yn(Vw.Vw()));
        } else {
            LogLocation.e("CellCollector", "check permission failed");
            listYn = new LinkedList<>();
        }
        yn(listYn);
        if (listYn.isEmpty()) {
            LogLocation.d("CellCollector", "no available cell info");
            return null;
        }
        this.Vw = listYn;
        LogLocation.d("CellCollector", "cell list size." + listYn.size());
        this.yn = jCurrentTimeMillis;
        config.Vw();
        return this.Vw;
    }

    @Override // com.huawei.location.crowdsourcing.common.yn
    public void yn() {
        LogLocation.w("CellCollector", "Stop");
    }
}

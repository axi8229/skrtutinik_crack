package com.huawei.location.nlp.logic;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes3.dex */
public class yn {
    private static volatile yn Vw;
    private static final byte[] yn = new byte[0];
    private long FB;
    private long LW;
    private List<CellSourceInfo> dC = new ArrayList();
    private List<WifiInfo> E5 = new ArrayList();
    private long d2 = 0;
    private long zp = 0;

    private yn() {
        this.FB = UtilsKt.UPDATE_INTERVAL;
        this.LW = UtilsKt.UPDATE_INTERVAL;
        String config = ConfigManager.getInstance().getConfig("location", "valid_wifi_position_time");
        if (!TextUtils.isEmpty(config)) {
            LogLocation.d("NLPCacheManger", "get valid wifi time " + config);
            this.FB = TimeUnit.SECONDS.toMillis((long) Integer.parseInt(config));
        }
        String config2 = ConfigManager.getInstance().getConfig("location", "valid_cell_position_time");
        if (TextUtils.isEmpty(config2)) {
            return;
        }
        LogLocation.d("NLPCacheManger", "get valid cell time " + config2);
        this.LW = TimeUnit.SECONDS.toMillis((long) Integer.parseInt(config2));
    }

    public static yn dC() {
        if (Vw == null) {
            synchronized (yn) {
                try {
                    if (Vw == null) {
                        Vw = new yn();
                    }
                } finally {
                }
            }
        }
        return Vw;
    }

    public List<WifiInfo> E5() {
        return this.E5;
    }

    public synchronized List<CellSourceInfo> FB() {
        return this.dC;
    }

    public synchronized long LW() {
        return this.zp;
    }

    public void Vw(Pair<Long, List<WifiInfo>> pair) {
        this.d2 = ((Long) pair.first).longValue();
        this.E5 = (List) pair.second;
    }

    public boolean Vw() {
        List<WifiInfo> list = this.E5;
        if (list != null && !list.isEmpty()) {
            return SystemClock.elapsedRealtime() - this.d2 < this.FB;
        }
        LogLocation.e("NLPCacheManger", "wifiInfoList is empty");
        return false;
    }

    public long d2() {
        return TimeUnit.MILLISECONDS.toNanos(this.d2);
    }

    public synchronized void yn(Pair<Long, List<CellSourceInfo>> pair) {
        this.zp = ((Long) pair.first).longValue();
        this.dC = (List) pair.second;
    }

    public synchronized boolean yn() {
        List<CellSourceInfo> list = this.dC;
        if (list != null && !list.isEmpty()) {
            return SystemClock.elapsedRealtime() - (this.zp / 1000000) < this.LW;
        }
        LogLocation.e("NLPCacheManger", "cellInfoList is empty");
        return false;
    }
}

package com.huawei.location.crowdsourcing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
final class dC implements com.huawei.location.crowdsourcing.common.yn {
    private List<ScanResult> FB = new LinkedList();
    private LW LW;
    private final Vw Vw;
    private long yn;

    private static class FB implements Comparator<ScanResult> {
        private FB() {
        }

        @Override // java.util.Comparator
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            ScanResult scanResult3 = scanResult;
            ScanResult scanResult4 = scanResult2;
            long j = scanResult3.timestamp - scanResult4.timestamp;
            if (j != 0) {
                return j > 0 ? 1 : -1;
            }
            int iCompareTo = scanResult3.level - scanResult4.level;
            return (iCompareTo == 0 && (iCompareTo = scanResult3.BSSID.compareTo(scanResult4.BSSID)) == 0) ? scanResult3.SSID.compareTo(scanResult4.SSID) : iCompareTo;
        }
    }

    private class LW extends BroadcastReceiver {
        private LW() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (action == null) {
                str = "get null action";
            } else {
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    boolean booleanExtra = safeIntent.getBooleanExtra("resultsUpdated", false);
                    LogLocation.d("WifiCollector", "onReceive action=" + action + " isUpdated=" + booleanExtra);
                    if (booleanExtra) {
                        Vw vw = dC.this.Vw;
                        vw.getClass();
                        vw.obtainMessage(0, Long.valueOf(System.currentTimeMillis())).sendToTarget();
                        return;
                    }
                    return;
                }
                str = "receive unknown action,action:" + action;
            }
            LogLocation.e("WifiCollector", str);
        }
    }

    private class Vw extends Handler {
        Vw(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                LogLocation.e("WifiCollector", "unknown msg:" + message.what);
                return;
            }
            Object obj = message.obj;
            if (obj instanceof Long) {
                dC.yn(dC.this, ((Long) obj).longValue());
            } else {
                LogLocation.e("WifiCollector", "handleMessage not location obj");
            }
        }
    }

    dC(Looper looper) {
        this.Vw = new Vw(looper);
    }

    static void yn(dC dCVar, long j) {
        dCVar.yn = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean yn(long j, long j2, ScanResult scanResult) {
        long jAbs = Math.abs(scanResult.timestamp - j);
        if (jAbs <= j2) {
            return false;
        }
        LogLocation.d("WifiCollector", "remove expired(μs). timeDiff:" + jAbs);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean yn(ScanResult scanResult, ScanResult scanResult2) {
        return TextUtils.equals(scanResult.BSSID, scanResult2.BSSID) && scanResult.timestamp == scanResult2.timestamp;
    }

    boolean FB() {
        LW lw = new LW();
        this.LW = lw;
        com.huawei.location.crowdsourcing.Vw.Vw().registerReceiver(lw, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        LogLocation.i("WifiCollector", "wifi scan finish register success");
        return true;
    }

    List<ScanResult> Vw() {
        List<ScanResult> scanResults;
        Config config = Config.FB.yn;
        if (!config.a6()) {
            LogLocation.d("WifiCollector", "no need get wifi");
            return null;
        }
        if (Math.abs(System.currentTimeMillis() - this.yn) > Config.FB.yn.EF()) {
            LogLocation.d("WifiCollector", "not fresh");
            return null;
        }
        Object systemService = com.huawei.location.crowdsourcing.Vw.Vw().getApplicationContext().getSystemService("wifi");
        if (systemService instanceof WifiManager) {
            scanResults = ((WifiManager) systemService).getScanResults();
        } else {
            LogLocation.d("WifiCollector", "no wifi service");
            scanResults = new ArrayList<>();
        }
        yn(scanResults);
        int iWf = Config.FB.yn.Wf();
        int size = scanResults.size();
        if (size > iWf) {
            LogLocation.d("WifiCollector", "limit ap num from " + size + " to " + iWf);
            Collections.sort(scanResults, new FB());
            scanResults.subList(0, size - iWf).clear();
        }
        if (scanResults.isEmpty()) {
            LogLocation.d("WifiCollector", "no available ap info");
            return null;
        }
        if (!Vw(scanResults)) {
            LogLocation.d("WifiCollector", "no update");
            return null;
        }
        LogLocation.d("WifiCollector", "ap list size." + scanResults.size());
        config.FB();
        return this.FB;
    }

    private void yn(List<ScanResult> list) {
        final long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        final long jOB = Config.FB.yn.OB();
        com.huawei.location.crowdsourcing.common.util.Vw vw = new com.huawei.location.crowdsourcing.common.util.Vw() { // from class: com.huawei.location.crowdsourcing.dC$$ExternalSyntheticLambda0
            @Override // com.huawei.location.crowdsourcing.common.util.Vw
            public final boolean yn(Object obj) {
                return dC.yn(jElapsedRealtimeNanos, jOB, (ScanResult) obj);
            }
        };
        Iterator<ScanResult> it = list.iterator();
        while (it.hasNext()) {
            if (vw.yn(it.next())) {
                it.remove();
            }
        }
    }

    @Override // com.huawei.location.crowdsourcing.common.yn
    public void yn() {
        LogLocation.w("WifiCollector", "Stop");
        LW lw = this.LW;
        if (lw != null) {
            com.huawei.location.crowdsourcing.Vw.Vw().unregisterReceiver(lw);
        }
    }

    private boolean Vw(List<ScanResult> list) {
        List<ScanResult> list2 = this.FB;
        com.huawei.location.crowdsourcing.common.util.yn ynVar = new com.huawei.location.crowdsourcing.common.util.yn() { // from class: com.huawei.location.crowdsourcing.dC$$ExternalSyntheticLambda1
            @Override // com.huawei.location.crowdsourcing.common.util.yn
            public final boolean compare(Object obj, Object obj2) {
                return dC.yn((ScanResult) obj, (ScanResult) obj2);
            }
        };
        if (list2.size() == list.size()) {
            for (ScanResult scanResult : list2) {
                Iterator<ScanResult> it = list.iterator();
                while (it.hasNext()) {
                    if (!ynVar.compare(scanResult, it.next())) {
                    }
                }
            }
            return false;
        }
        this.FB = list;
        return true;
    }
}

package com.huawei.location.nlp.scan;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.util.Pair;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import com.huawei.location.nlp.scan.cell.yn;
import com.huawei.location.nlp.scan.wifi.FB;
import java.util.List;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes3.dex */
public class E5 extends LW implements com.huawei.location.nlp.scan.yn {
    private com.huawei.location.nlp.scan.cell.yn E5;
    private Handler LW;
    private yn.Vw Ot;
    private boolean d2;
    private com.huawei.location.nlp.scan.wifi.FB dC;
    private FB.yn oc;
    private boolean ut;
    private boolean zp;

    class FB extends Handler {
        FB(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LogLocation.i("WifiAndCell", "msg.what=" + message.what);
            int i = message.what;
            if (i == -1) {
                E5.dC(E5.this);
                return;
            }
            if (i == 0) {
                if (E5.Vw(E5.this)) {
                    E5.FB(E5.this);
                }
            } else if (i == 1 && E5.Vw(E5.this)) {
                E5.LW(E5.this);
            }
        }
    }

    class Vw implements yn.Vw {
        Vw() {
        }

        @Override // com.huawei.location.nlp.scan.cell.yn.Vw
        public void yn(List<CellInfo> list) {
            if (list == null || list.isEmpty()) {
                LogLocation.e("WifiAndCell", "cellInfoList is empty");
                return;
            }
            LogLocation.i("WifiAndCell", "cell scan success, result size is " + list.size());
            com.huawei.location.nlp.logic.yn.dC().yn(E5.this.Vw(list));
            E5.this.ut = false;
        }
    }

    class yn implements FB.yn {
        yn() {
        }

        @Override // com.huawei.location.nlp.scan.wifi.FB.yn
        public void onFail(int i, String str) {
            LogLocation.i("WifiAndCell", "wifi scan fail, code is " + i);
            if (E5.this.LW.hasMessages(-1)) {
                E5.this.LW.removeMessages(-1);
                E5.this.LW.sendEmptyMessage(-1);
            }
        }

        @Override // com.huawei.location.nlp.scan.wifi.FB.yn
        public void yn(List<ScanResult> list) throws NumberFormatException {
            if (list.isEmpty()) {
                LogLocation.e("WifiAndCell", "wifi scan success, scanResultList is empty");
                return;
            }
            LogLocation.i("WifiAndCell", "wifi scan success, scanResultList size is " + list.size());
            E5.yn(E5.this, list);
        }
    }

    public E5(com.huawei.location.nlp.api.Vw vw) {
        super(vw);
        this.d2 = true;
        this.zp = true;
        this.ut = true;
        this.oc = new yn();
        this.Ot = new Vw();
        this.dC = new com.huawei.location.nlp.scan.wifi.FB();
        this.E5 = new com.huawei.location.nlp.scan.cell.yn();
        FB();
    }

    private void FB() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.LW = new FB(handlerThread.getLooper());
    }

    static void FB(E5 e5) {
        e5.LW.removeMessages(0);
        e5.LW.sendEmptyMessageDelayed(0, UtilsKt.UPDATE_INTERVAL);
        boolean zVw = com.huawei.location.nlp.logic.yn.dC().Vw();
        LogLocation.i("WifiAndCell", "isFirstScanWifi = " + e5.zp + ",isWifiCacheValid = " + zVw);
        if (e5.zp && zVw) {
            e5.zp = false;
        } else {
            e5.dC.yn(e5.oc);
        }
    }

    static void LW(E5 e5) {
        e5.LW.removeMessages(1);
        e5.LW.sendEmptyMessageDelayed(1, e5.Vw);
        boolean zYn = com.huawei.location.nlp.logic.yn.dC().yn();
        LogLocation.i("WifiAndCell", "isFirstScanCell = " + e5.ut + ", isCellCacheValid = " + zYn);
        if (e5.ut && zYn) {
            e5.ut = false;
        } else {
            e5.E5.yn(e5.Ot);
        }
    }

    static boolean Vw(E5 e5) {
        e5.getClass();
        if (!NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) || !LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            LogLocation.i("WifiAndCell", "checkLocationAvailability false");
            return false;
        }
        LogLocation.i("WifiAndCell", "isNeed:" + e5.d2);
        return e5.d2;
    }

    static void dC(E5 e5) {
        e5.zp = false;
        if (com.huawei.location.nlp.logic.yn.dC().yn() || com.huawei.location.nlp.logic.yn.dC().Vw()) {
            LogLocation.i("WifiAndCell", "handlerTimeout onScanResult");
            e5.yn.yn();
        }
    }

    static void yn(E5 e5, List list) throws NumberFormatException {
        String str;
        Pair<Long, List<WifiInfo>> pairYn = e5.yn((List<ScanResult>) list);
        List list2 = (List) pairYn.second;
        if (list2.size() < 1) {
            str = "handlerWifiScanResult, filterResult is empty";
        } else {
            if (!LW.yn(list2, com.huawei.location.nlp.logic.yn.dC().E5())) {
                com.huawei.location.nlp.logic.yn.dC().Vw(pairYn);
                if (e5.LW.hasMessages(-1)) {
                    e5.LW.removeMessages(-1);
                    e5.zp = false;
                    e5.yn.yn();
                    return;
                }
                return;
            }
            str = "The Wi-Fi scanning result is the same as that in the cache.";
        }
        LogLocation.e("WifiAndCell", str);
    }

    @Override // com.huawei.location.nlp.scan.yn
    public void Vw() {
        LogLocation.i("WifiAndCell", "stopScan");
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        if (this.LW.hasMessages(1)) {
            this.LW.removeMessages(1);
        }
        if (this.LW.hasMessages(-1)) {
            this.LW.removeMessages(-1);
        }
        this.dC.yn();
        this.d2 = false;
        this.ut = true;
        this.zp = true;
    }

    @Override // com.huawei.location.nlp.scan.yn
    public void yn() {
        this.d2 = true;
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        if (this.LW.hasMessages(1)) {
            this.LW.removeMessages(1);
        }
        if (this.LW.hasMessages(-1)) {
            this.LW.removeMessages(-1);
        }
        this.LW.sendEmptyMessage(0);
        this.LW.sendEmptyMessage(1);
        this.LW.sendEmptyMessageDelayed(-1, 3000L);
    }

    @Override // com.huawei.location.nlp.scan.yn
    public void yn(long j) {
        LogLocation.i("WifiAndCell", "setScanInterval:" + j);
        this.Vw = j;
    }
}

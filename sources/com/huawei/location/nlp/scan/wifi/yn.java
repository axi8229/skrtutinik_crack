package com.huawei.location.nlp.scan.wifi;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import com.huawei.location.nlp.scan.LW;
import com.huawei.location.nlp.scan.wifi.FB;
import java.util.List;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes3.dex */
public class yn extends LW implements com.huawei.location.nlp.scan.yn {
    private boolean E5;
    private Handler LW;
    private boolean d2;
    private FB dC;
    private FB.yn zp;

    class Vw extends Handler {
        Vw(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LogLocation.i("OnlyWifi", "msg.what=" + message.what);
            if (message.what == 0 && yn.yn(yn.this)) {
                yn.Vw(yn.this);
            }
        }
    }

    /* renamed from: com.huawei.location.nlp.scan.wifi.yn$yn, reason: collision with other inner class name */
    class C0094yn implements FB.yn {
        C0094yn() {
        }

        @Override // com.huawei.location.nlp.scan.wifi.FB.yn
        public void onFail(int i, String str) {
            LogLocation.i("OnlyWifi", "wifi scan fail, code is " + i);
        }

        @Override // com.huawei.location.nlp.scan.wifi.FB.yn
        public void yn(List<ScanResult> list) throws NumberFormatException {
            if (list.isEmpty()) {
                LogLocation.e("OnlyWifi", "scan wifi success, scanResultList is empty");
            } else {
                yn.yn(yn.this, list);
            }
        }
    }

    public yn(com.huawei.location.nlp.api.Vw vw) {
        super(vw);
        this.E5 = false;
        this.d2 = true;
        this.zp = new C0094yn();
        this.dC = new FB();
        FB();
    }

    private void FB() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.LW = new Vw(handlerThread.getLooper());
    }

    static void Vw(yn ynVar) {
        String str;
        ynVar.LW.removeMessages(0);
        ynVar.LW.sendEmptyMessageDelayed(0, UtilsKt.UPDATE_INTERVAL);
        if (ynVar.d2 && com.huawei.location.nlp.logic.yn.dC().Vw()) {
            str = "first scan, cached wifi is valid";
        } else {
            ynVar.dC.yn(ynVar.zp);
            str = "requestScan wifi";
        }
        LogLocation.i("OnlyWifi", str);
    }

    static void yn(yn ynVar, List list) throws NumberFormatException {
        String str;
        Pair<Long, List<WifiInfo>> pairYn = ynVar.yn((List<ScanResult>) list);
        List list2 = (List) pairYn.second;
        if (list2.size() < 1) {
            str = "handlerWifiScanFail, filterResult is empty";
        } else {
            if (!LW.yn(list2, com.huawei.location.nlp.logic.yn.dC().E5())) {
                com.huawei.location.nlp.logic.yn.dC().Vw(pairYn);
                ynVar.d2 = false;
                ynVar.yn.yn();
                return;
            }
            str = "The Wi-Fi scanning result is the same as that in the cache.";
        }
        LogLocation.e("OnlyWifi", str);
    }

    @Override // com.huawei.location.nlp.scan.yn
    public void Vw() {
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        this.E5 = false;
        this.d2 = true;
        this.dC.yn();
    }

    @Override // com.huawei.location.nlp.scan.yn
    public void yn() {
        this.E5 = true;
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        this.LW.sendEmptyMessage(0);
    }

    @Override // com.huawei.location.nlp.scan.yn
    public void yn(long j) {
        this.Vw = j;
    }

    static boolean yn(yn ynVar) {
        ynVar.getClass();
        if (!NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) || !LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            LogLocation.i("OnlyWifi", "gnssAndNet is false");
            return false;
        }
        LogLocation.e("OnlyWifi", "isNeedScan is " + ynVar.E5);
        return ynVar.E5;
    }
}

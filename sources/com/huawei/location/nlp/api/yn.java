package com.huawei.location.nlp.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationProviderCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.huawei.location.nlp.network.request.OnlineLocationRequest;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import com.huawei.location.nlp.scan.dC;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes3.dex */
public class yn {
    private static volatile yn Vw;
    private static final byte[] yn = new byte[0];
    public long FB;
    public long LW;
    private LocationProviderCallback d2;
    private Handler dC;
    private PriorityBlockingQueue<RequestLocationUpdatesRequest> zp;
    private boolean Ot = true;
    private boolean G3 = false;
    private long Yx = -1;
    private OnlineLocationService E5 = new OnlineLocationService();
    private dC ut = new dC(new C0091yn());
    private int oc = dC.yn();

    class FB extends Handler {
        FB(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LogLocation.i("NLPClient", "msg.what=" + message.what);
            if (message.what != 0) {
                return;
            }
            yn.yn(yn.this, true);
        }
    }

    class Vw implements Comparator<RequestLocationUpdatesRequest> {
        Vw(yn ynVar) {
        }

        @Override // java.util.Comparator
        public int compare(RequestLocationUpdatesRequest requestLocationUpdatesRequest, RequestLocationUpdatesRequest requestLocationUpdatesRequest2) {
            return requestLocationUpdatesRequest.getLocationRequest().getInterval() > requestLocationUpdatesRequest2.getLocationRequest().getInterval() ? 1 : 0;
        }
    }

    /* renamed from: com.huawei.location.nlp.api.yn$yn, reason: collision with other inner class name */
    class C0091yn implements com.huawei.location.nlp.api.Vw {
        C0091yn() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Vw() {
            yn.yn(yn.this, false);
        }

        @Override // com.huawei.location.nlp.api.Vw
        public void yn() {
            if (yn.this.G3) {
                return;
            }
            LogLocation.i("NLPClient", "isCacheAvailable is false, do request");
            ExecutorUtil.getInstance().execute(new Runnable() { // from class: com.huawei.location.nlp.api.yn$yn$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Vw();
                }
            });
        }
    }

    private yn() {
        this.FB = 2L;
        this.LW = 86400L;
        Vw();
        this.zp = new PriorityBlockingQueue<>(11, new Vw(this));
        String config = ConfigManager.getInstance().getConfig("location", "position_min_interval");
        String config2 = ConfigManager.getInstance().getConfig("location", "position_max_interval");
        LogLocation.i("NLPClient", "minInterval is " + config + ", maxInterval is " + config2);
        try {
            if (!TextUtils.isEmpty(config)) {
                this.FB = Long.parseLong(config);
            }
            if (TextUtils.isEmpty(config2)) {
                return;
            }
            this.LW = Long.parseLong(config2);
        } catch (NumberFormatException unused) {
            LogLocation.e("NLPClient", "parse interval fail ");
        }
    }

    private void Vw() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-request");
        handlerThread.start();
        this.dC = new FB(handlerThread.getLooper());
    }

    private void dC() {
        LocationRequest locationRequest;
        RequestLocationUpdatesRequest requestLocationUpdatesRequestPeek = this.zp.peek();
        if (requestLocationUpdatesRequestPeek == null || (locationRequest = requestLocationUpdatesRequestPeek.getLocationRequest()) == null) {
            return;
        }
        long interval = locationRequest.getInterval();
        if (interval == this.Yx) {
            return;
        }
        this.Yx = Math.min(Math.max(interval, this.FB * 1000), this.LW * 1000);
        LogLocation.i("NLPClient", "currentInterval is " + this.Yx);
        this.ut.yn(this.Yx);
    }

    public static yn yn() {
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

    static void yn(yn ynVar, boolean z) {
        boolean zYn;
        ynVar.getClass();
        if (!NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) || !LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            LogLocation.e("NLPClient", "doRequest fail, Network or LocationEnabled is not available");
            return;
        }
        if (z) {
            ynVar.dC.removeMessages(0);
            ynVar.dC.sendEmptyMessageDelayed(0, ynVar.Yx);
        }
        OnlineLocationRequest onlineLocationRequest = new OnlineLocationRequest();
        int i = ynVar.oc;
        if (i == 1) {
            onlineLocationRequest.setWifiScanResult(com.huawei.location.nlp.logic.yn.dC().E5());
            zYn = com.huawei.location.nlp.logic.yn.dC().Vw();
        } else if (i == 2) {
            onlineLocationRequest.setCellInfos(com.huawei.location.nlp.logic.yn.dC().FB());
            zYn = com.huawei.location.nlp.logic.yn.dC().yn();
        } else {
            zYn = ynVar.yn(onlineLocationRequest);
        }
        if (zYn) {
            ynVar.G3 = true;
            ynVar.d2.onLocationChanged(ynVar.E5.getLocationFromCloud(onlineLocationRequest));
        } else {
            ynVar.G3 = false;
            LogLocation.e("NLPClient", "doRequest, cache is invalid");
            ynVar.d2.onLocationChanged(new HwLocationResult(LocationStatusCode.ARGUMENTS_EMPTY, com.huawei.location.nlp.constant.yn.yn(LocationStatusCode.ARGUMENTS_EMPTY)));
        }
    }

    private boolean yn(OnlineLocationRequest onlineLocationRequest) {
        List<WifiInfo> listE5 = com.huawei.location.nlp.logic.yn.dC().E5();
        boolean zVw = com.huawei.location.nlp.logic.yn.dC().Vw();
        if (zVw) {
            onlineLocationRequest.setWifiScanResult(listE5);
        }
        List<CellSourceInfo> listFB = com.huawei.location.nlp.logic.yn.dC().FB();
        boolean zYn = com.huawei.location.nlp.logic.yn.dC().yn();
        if (zYn) {
            onlineLocationRequest.setCellInfos(listFB);
        }
        if (!this.Ot) {
            return zVw || zYn;
        }
        LogLocation.i("NLPClient", "The first online location request verifies only Wi-Fi availability.");
        this.Ot = false;
        return zVw;
    }

    public void FB() {
        if (this.zp.isEmpty()) {
            return;
        }
        LogLocation.i("NLPClient", "startRequest");
        if (this.dC.hasMessages(0)) {
            this.dC.removeMessages(0);
        }
        this.dC.sendEmptyMessage(0);
        this.ut.Vw();
    }

    public void LW() {
        LogLocation.i("NLPClient", "stopRequest");
        if (this.dC.hasMessages(0)) {
            this.dC.removeMessages(0);
        }
        this.ut.FB();
    }

    public void Vw(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        if (requestLocationUpdatesRequest.getLocationRequest() == null) {
            return;
        }
        this.zp.add(requestLocationUpdatesRequest);
        LogLocation.i("NLPClient", "requestLocationUpdates, nlpCache size is " + this.zp.size());
        long j = this.Yx;
        dC();
        if (j > 0) {
            return;
        }
        FB();
    }

    public void yn(LocationProviderCallback locationProviderCallback) {
        this.d2 = locationProviderCallback;
    }

    public void yn(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        this.zp.remove(requestLocationUpdatesRequest);
        LogLocation.i("NLPClient", "removeLocationUpdates, nlpCache size is " + this.zp.size());
        if (!this.zp.isEmpty()) {
            dC();
            return;
        }
        LW();
        this.Yx = -1L;
        this.Ot = true;
    }
}

package com.huawei.location.vdr.data;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;

/* loaded from: classes3.dex */
public class LW implements com.huawei.location.vdr.listener.yn {
    private Location E5;
    private final Vw FB;
    private com.huawei.location.vdr.listener.Vw LW;
    private final yn Vw;
    GnssRawObservation[] d2;
    private Handler dC;
    private long yn = -1;
    long zp;

    public LW() {
        yn ynVar = new yn();
        this.Vw = ynVar;
        ynVar.yn(this);
        ynVar.yn();
        this.FB = new Vw();
        HandlerThread handlerThread = new HandlerThread("Loc-vdr-data");
        handlerThread.start();
        this.dC = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.huawei.location.vdr.data.LW$$ExternalSyntheticLambda0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f$0.yn(message);
            }
        });
    }

    private synchronized void yn(GnssRawObservation[] gnssRawObservationArr, long j) {
        com.huawei.location.vdr.listener.Vw vw;
        Handler handler = this.dC;
        if (handler == null) {
            LogLocation.e("VdrDataManager", "handler is null,can not handler data");
            return;
        }
        handler.removeCallbacksAndMessages(null);
        if (gnssRawObservationArr == null) {
            Handler handler2 = this.dC;
            handler2.sendMessageDelayed(handler2.obtainMessage(10), 1000L);
        } else {
            Handler handler3 = this.dC;
            handler3.sendMessageDelayed(handler3.obtainMessage(10), 1300L);
        }
        MotionSensors motionSensorsYn = this.FB.yn(this.yn, j);
        this.yn = j;
        if (motionSensorsYn != null && (vw = this.LW) != null) {
            vw.onVdrDataReceived(new FB(gnssRawObservationArr, motionSensorsYn, this.E5));
            this.E5 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean yn(Message message) {
        int i = message.what;
        if (i == 10) {
            yn(null, SystemClock.elapsedRealtimeNanos());
            return false;
        }
        if (i != 11) {
            return false;
        }
        yn(this.d2, this.zp);
        return false;
    }

    public synchronized void Vw() {
        yn ynVar = this.Vw;
        if (ynVar != null && this.FB != null) {
            ynVar.Vw();
            this.FB.Vw();
            this.dC.removeCallbacksAndMessages(null);
            this.dC.getLooper().quitSafely();
            this.dC = null;
            LogLocation.i("VdrDataManager", "stop vdr data");
            return;
        }
        LogLocation.e("VdrDataManager", "init fail, try to call start method");
    }

    public void Vw(GnssRawObservation[] gnssRawObservationArr, long j) {
        Handler handler = this.dC;
        if (handler == null) {
            LogLocation.e("VdrDataManager", "handler is null, drop gnss data here.");
            return;
        }
        handler.removeCallbacksAndMessages(null);
        if (this.E5 != null) {
            yn(gnssRawObservationArr, j);
            return;
        }
        this.d2 = gnssRawObservationArr;
        this.zp = j;
        Handler handler2 = this.dC;
        handler2.sendMessageDelayed(handler2.obtainMessage(11), 40L);
    }

    public Location yn() {
        return this.E5;
    }

    public void yn(Location location) {
        this.E5 = location;
    }

    public synchronized void yn(com.huawei.location.vdr.listener.Vw vw) {
        Handler handler = this.dC;
        if (handler == null) {
            LogLocation.e("VdrDataManager", "handler is null, setVdrDataListener failed.");
            return;
        }
        this.LW = vw;
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.dC;
        handler2.sendMessage(handler2.obtainMessage(10));
    }
}

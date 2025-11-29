package com.huawei.location.nlp.scan.cell;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.scan.LW;
import com.huawei.location.nlp.scan.cell.yn;
import java.util.List;

/* loaded from: classes3.dex */
public class Vw extends LW implements com.huawei.location.nlp.scan.yn {
    private boolean E5;
    private Handler LW;
    private boolean d2;
    private com.huawei.location.nlp.scan.cell.yn dC;
    private yn.Vw zp;

    /* renamed from: com.huawei.location.nlp.scan.cell.Vw$Vw, reason: collision with other inner class name */
    class HandlerC0092Vw extends Handler {
        HandlerC0092Vw(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LogLocation.i("OnlyCell", "msg.what=" + message.what);
            if (message.what == 0 && Vw.Vw(Vw.this)) {
                Vw.FB(Vw.this);
            }
        }
    }

    class yn implements yn.Vw {
        yn() {
        }

        @Override // com.huawei.location.nlp.scan.cell.yn.Vw
        public void yn(List<CellInfo> list) {
            if (list == null || list.isEmpty()) {
                LogLocation.e("OnlyCell", "scan cell success, cellInfoList is empty");
                return;
            }
            LogLocation.i("OnlyCell", "cell scan success, result size is " + list.size());
            com.huawei.location.nlp.logic.yn.dC().yn(Vw.this.Vw(list));
            Vw.this.d2 = false;
            ((LW) Vw.this).yn.yn();
        }
    }

    public Vw(com.huawei.location.nlp.api.Vw vw) {
        super(vw);
        this.E5 = false;
        this.d2 = true;
        this.zp = new yn();
        this.dC = new com.huawei.location.nlp.scan.cell.yn();
        FB();
    }

    private void FB() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.LW = new HandlerC0092Vw(handlerThread.getLooper());
    }

    static void FB(Vw vw) {
        String str;
        vw.LW.removeMessages(0);
        vw.LW.sendEmptyMessageDelayed(0, vw.Vw);
        if (vw.d2 && com.huawei.location.nlp.logic.yn.dC().yn()) {
            str = "first scan, cached cell is valid";
        } else {
            vw.dC.yn(vw.zp);
            str = "requestScan cell";
        }
        LogLocation.i("OnlyCell", str);
    }

    static boolean Vw(Vw vw) {
        vw.getClass();
        if (NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) && LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            return vw.E5;
        }
        LogLocation.i("OnlyCell", "network and location enable is false");
        return false;
    }

    @Override // com.huawei.location.nlp.scan.yn
    public void Vw() {
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        this.E5 = false;
        this.d2 = true;
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
}

package com.huawei.location.lite.common.android.receiver;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ScreenStatusBroadcastReceiver extends SafeBroadcastReceiver {
    private static List<ScreenStatusCallback> callbackList = new CopyOnWriteArrayList();
    private static long currentReportLatencyNs;
    private HandlerThread handlerThread;
    private Handler screenOffHandler = null;

    public interface ScreenStatusCallback {
        void onScreenOff();

        void onScreenOn();
    }

    public static boolean isScreenOn() {
        Object systemService = ContextUtil.getContext().getSystemService("power");
        boolean zIsScreenOn = systemService instanceof PowerManager ? ((PowerManager) systemService).isScreenOn() : false;
        LogLocation.d("ScreenStatusBroadcastReceiver", "isCurScreenOn:" + zIsScreenOn);
        return zIsScreenOn;
    }

    private void onScreenOff() {
        setCurrentReportLatencyNs(200000000000L);
        LogLocation.d("ScreenStatusBroadcastReceiver", "onScreenOff,report latency is:" + (currentReportLatencyNs / 1000000000) + "s");
        try {
            for (ScreenStatusCallback screenStatusCallback : callbackList) {
                if (screenStatusCallback != null) {
                    screenStatusCallback.onScreenOff();
                }
            }
        } catch (Exception unused) {
            LogLocation.e("ScreenStatusBroadcastReceiver", "exec callback onScreenOff exception", true);
        }
    }

    private void onScreenOn() {
        setCurrentReportLatencyNs(5000000000L);
        LogLocation.d("ScreenStatusBroadcastReceiver", "onScreenOn,report latency is:" + (currentReportLatencyNs / 1000000000) + "s");
        try {
            for (ScreenStatusCallback screenStatusCallback : callbackList) {
                if (screenStatusCallback != null) {
                    screenStatusCallback.onScreenOn();
                }
            }
        } catch (Exception unused) {
            LogLocation.e("ScreenStatusBroadcastReceiver", "exec callback onScreenOn exception", true);
        }
    }

    private void postDelayMsg() {
        if (this.handlerThread == null || this.screenOffHandler == null) {
            LogLocation.d("ScreenStatusBroadcastReceiver", "postDelayMsg new handlerThread");
            HandlerThread handlerThread = new HandlerThread("Location_Lite_Broadcast");
            this.handlerThread = handlerThread;
            handlerThread.start();
            this.screenOffHandler = new Handler(this.handlerThread.getLooper()) { // from class: com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message == null || message.what != 1005) {
                        LogLocation.e("ScreenStatusBroadcastReceiver", "message error");
                        return;
                    }
                    LogLocation.d("ScreenStatusBroadcastReceiver", "isScreenOn : " + ScreenStatusBroadcastReceiver.isScreenOn());
                }
            };
        } else {
            LogLocation.d("ScreenStatusBroadcastReceiver", "screen off remove Messages");
            this.screenOffHandler.removeMessages(1005);
        }
        LogLocation.d("ScreenStatusBroadcastReceiver", "sendEmptyMessageDelayed 5 seconds for screenOff. the result is : " + this.screenOffHandler.sendEmptyMessageDelayed(1005, DeviceOrientationRequest.OUTPUT_PERIOD_FAST));
    }

    private void setCurrentReportLatencyNs(long j) {
        currentReportLatencyNs = j;
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    public void onSafeReceive(Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        LogLocation.d("ScreenStatusBroadcastReceiver", "onReceive action : " + safeIntent.getAction());
        if ("android.intent.action.SCREEN_OFF".equals(safeIntent.getAction())) {
            onScreenOff();
            postDelayMsg();
        }
        if ("android.intent.action.SCREEN_ON".equals(safeIntent.getAction())) {
            onScreenOn();
            Handler handler = this.screenOffHandler;
            if (handler == null || !handler.hasMessages(1005)) {
                return;
            }
            LogLocation.d("ScreenStatusBroadcastReceiver", "screen on remove Messages");
            this.screenOffHandler.removeMessages(1005);
        }
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    public String receiveThreadName() {
        return "Loc-Screen-Receive";
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    public int threadExitDelayTime() {
        return 120000;
    }
}

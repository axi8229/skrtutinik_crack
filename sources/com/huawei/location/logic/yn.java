package com.huawei.location.logic;

import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.activity.RiemannSoftArService;
import com.huawei.location.base.activity.AbstractARServiceManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.android.receiver.PackageOperateCallback;
import com.huawei.location.lite.common.android.receiver.PackageReceiver;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ROMUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class yn {
    private static volatile yn Vw;
    private static final byte[] yn = new byte[0];
    private Handler LW;
    private HandlerThread dC;
    private Map<String, Runnable> E5 = new ConcurrentHashMap();
    private PackageOperateCallback d2 = new C0089yn();
    private AbstractARServiceManager FB = RiemannSoftArService.getInstance();

    /* renamed from: com.huawei.location.logic.yn$yn, reason: collision with other inner class name */
    class C0089yn implements PackageOperateCallback {

        /* renamed from: com.huawei.location.logic.yn$yn$yn, reason: collision with other inner class name */
        class RunnableC0090yn implements Runnable {
            final /* synthetic */ String yn;

            RunnableC0090yn(String str) {
                this.yn = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    LogLocation.i("ActivityRecognitionClientImpl", "uninstall:" + this.yn + " remove AR and AT request start", true);
                    yn.this.FB.getRecognitionRequestMapping().removeActivityUpdatesMappingInfoByPackageName(this.yn);
                    yn.this.FB.getTransitionMappingManager().removeActivityTransitionMappingInfoByPackageName(this.yn);
                    yn.this.FB.scheduleTimer();
                    yn.this.E5.remove(this.yn);
                    yn.this.LW.getLooper().quitSafely();
                    LogLocation.i("ActivityRecognitionClientImpl", "uninstall:" + this.yn + " remove AR and AT request success!");
                } catch (Exception unused) {
                    LogLocation.e("ActivityRecognitionClientImpl", "uninstall:" + this.yn + " remove AR and AT exception", true);
                }
            }
        }

        C0089yn() {
        }

        @Override // com.huawei.location.lite.common.android.receiver.PackageOperateCallback
        public void onAdded(String str) {
            LogLocation.i("ActivityRecognitionClientImpl", "call onAdded enter:" + str);
        }

        @Override // com.huawei.location.lite.common.android.receiver.PackageOperateCallback
        public void onRemoved(String str) {
            LogLocation.i("ActivityRecognitionClientImpl", "call onRemoved:" + str, true);
            RunnableC0090yn runnableC0090yn = new RunnableC0090yn(str);
            yn.this.E5.put(str, runnableC0090yn);
            if (yn.this.LW == null || yn.this.dC == null || !yn.this.dC.isAlive()) {
                yn.dC(yn.this);
            }
            yn.this.LW.postDelayed(runnableC0090yn, 60000L);
            LogLocation.i("ActivityRecognitionClientImpl", "call onRemoved end:" + str);
        }

        @Override // com.huawei.location.lite.common.android.receiver.PackageOperateCallback
        public void onReplaced(String str) {
            LogLocation.i("ActivityRecognitionClientImpl", "call onReplaced enter:" + str, true);
            Runnable runnable = (Runnable) yn.this.E5.get(str);
            if (runnable == null) {
                LogLocation.i("ActivityRecognitionClientImpl", "removeThread had deleted or executed", true);
                return;
            }
            yn.this.LW.removeCallbacks(runnable);
            LogLocation.i("ActivityRecognitionClientImpl", "call onReplaced end:" + str + ":cancle removeThread success");
        }
    }

    private yn() {
        PackageReceiver.getInstance().registerCallback(this.d2);
    }

    static void dC(yn ynVar) {
        ynVar.getClass();
        HandlerThread handlerThread = new HandlerThread("Location-ARCImp");
        ynVar.dC = handlerThread;
        handlerThread.start();
        ynVar.LW = new Handler(ynVar.dC.getLooper());
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

    private List<String> yn(ClientInfo clientInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(clientInfo.getPackageName());
        arrayList.add(clientInfo.getTransactionID());
        arrayList.add("ARService is not support");
        return arrayList;
    }

    public void yn(long j, ARCallback aRCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.requestActivityUpdates(j, aRCallback, clientInfo);
            return;
        }
        List<String> listYn = yn(clientInfo);
        com.huawei.location.lite.common.log.d2 d2Var = new com.huawei.location.lite.common.log.d2();
        d2Var.yn(listYn);
        LogLocation.e("ActivityRecognitionClientImpl", (com.huawei.location.lite.common.log.Vw) d2Var, true);
        throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    public void yn(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.requestActivityTransitionUpdates(activityTransitionRequest, aTCallback, clientInfo);
            return;
        }
        List<String> listYn = yn(clientInfo);
        com.huawei.location.lite.common.log.d2 d2Var = new com.huawei.location.lite.common.log.d2();
        d2Var.yn(listYn);
        LogLocation.e("ActivityRecognitionClientImpl", (com.huawei.location.lite.common.log.Vw) d2Var, true);
        throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    public void yn(ARCallback aRCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.removeActivityUpdates(aRCallback, clientInfo);
            return;
        }
        List<String> listYn = yn(clientInfo);
        com.huawei.location.lite.common.log.d2 d2Var = new com.huawei.location.lite.common.log.d2();
        d2Var.yn(listYn);
        LogLocation.e("ActivityRecognitionClientImpl", (com.huawei.location.lite.common.log.Vw) d2Var, true);
        throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    public void yn(ATCallback aTCallback, ClientInfo clientInfo) {
        if (!ROMUtil.isHuaweiPlatformDevice() || ROMUtil.getEmuiVersionCode() >= 17) {
            this.FB.removeActivityTransitionUpdates(aTCallback, clientInfo);
            return;
        }
        List<String> listYn = yn(clientInfo);
        com.huawei.location.lite.common.log.d2 d2Var = new com.huawei.location.lite.common.log.d2();
        d2Var.yn(listYn);
        LogLocation.e("ActivityRecognitionClientImpl", (com.huawei.location.lite.common.log.Vw) d2Var, true);
        throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }
}

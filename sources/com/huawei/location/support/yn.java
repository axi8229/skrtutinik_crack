package com.huawei.location.support;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.ISoftARManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.router.LocationNaming;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import com.huawei.location.sdm.Config;
import com.huawei.location.tiles.store.dC;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class yn {
    private Vw[] E5;
    private boolean FB;
    private Config G3;
    private Vw[] LW;
    private dC Ot;
    private Vw[] d2;
    private Vw[] dC;
    private FB oc;
    private com.huawei.location.ephemeris.yn ut;
    private ISoftARManager zp;
    private int yn = -1;
    private long Vw = 0;
    private ARCallback Yx = new C0097yn();

    class FB extends Handler {
        FB(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                yn.this.yn();
            }
        }
    }

    static class Vw {
        int FB;
        boolean Vw = true;
        boolean yn;

        Vw() {
        }
    }

    /* renamed from: com.huawei.location.support.yn$yn, reason: collision with other inner class name */
    class C0097yn implements ARCallback {
        C0097yn() {
        }

        @Override // com.huawei.location.base.activity.callback.ARCallback
        public void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) {
            LogLocation.i("SDMSupportManager", "onActivityRecognition");
            if (activityRecognitionResult == null || activityRecognitionResult.getProbableActivities() == null || activityRecognitionResult.getProbableActivities().size() <= 0) {
                return;
            }
            DetectedActivity detectedActivity = activityRecognitionResult.getProbableActivities().get(0);
            if (detectedActivity != null) {
                yn.this.yn = detectedActivity.getType();
            }
            if (yn.this.yn != 2 || activityRecognitionResult.getProbableActivities().size() <= 1) {
                return;
            }
            DetectedActivity detectedActivity2 = activityRecognitionResult.getProbableActivities().get(1);
            if (detectedActivity != null) {
                yn.this.yn = detectedActivity2.getType();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn() {
        IRouterResponse iRouterResponseExecute = RouterTaskHandler.getInstance().execute(new RouterRequest(LocationNaming.REQUEST_ADAPTER_SDM, "", UUID.randomUUID().toString(), null));
        if (iRouterResponseExecute instanceof ISoftARManager) {
            this.zp = (ISoftARManager) iRouterResponseExecute;
        }
        ISoftARManager iSoftARManager = this.zp;
        if (iSoftARManager != null) {
            iSoftARManager.requestActivityUpdates(1000L, this.Yx);
        }
        this.LW = new Vw[2];
        this.dC = new Vw[2];
        this.E5 = new Vw[2];
        this.d2 = new Vw[2];
        this.Ot = new dC(25, 30);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean yn(com.huawei.location.support.yn.Vw[] r8, boolean r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L8a
            int r1 = r8.length
            r2 = 2
            if (r1 >= r2) goto L9
            goto L8a
        L9:
            r1 = r8[r0]
            java.lang.String r2 = "SDMSupportManager"
            r3 = 1
            if (r1 != 0) goto L24
            java.lang.String r1 = "sdm record status[0] first time"
            com.huawei.location.lite.common.log.LogLocation.i(r2, r1)
            com.huawei.location.support.yn$Vw r1 = new com.huawei.location.support.yn$Vw
            r1.<init>()
            r8[r0] = r1
            r1.yn = r9
            int r8 = r1.FB
            int r8 = r8 + r3
            r1.FB = r8
            return r9
        L24:
            boolean r4 = r1.yn
            r5 = 0
            if (r4 == r9) goto L75
            r4 = r8[r3]
            if (r4 != 0) goto L41
            java.lang.String r1 = "sdm record status[1] first time"
            com.huawei.location.lite.common.log.LogLocation.i(r2, r1)
            com.huawei.location.support.yn$Vw r1 = new com.huawei.location.support.yn$Vw
            r1.<init>()
            r8[r3] = r1
            r1.yn = r9
            int r9 = r1.FB
            int r9 = r9 + r3
            r1.FB = r9
            goto L85
        L41:
            int r6 = r4.FB
            int r6 = r6 + r3
            r4.FB = r6
            com.huawei.location.sdm.Config r4 = r7.G3
            boolean r1 = r1.Vw
            r9 = r9 | r1
            if (r4 == 0) goto L5a
            int r1 = r4.yn()
            com.huawei.location.sdm.Config r4 = r7.G3
            int r4 = r4.Vw()
            if (r9 == 0) goto L61
            goto L5d
        L5a:
            if (r9 == 0) goto L5f
            r1 = 3
        L5d:
            r4 = r1
            goto L61
        L5f:
            r4 = 10
        L61:
            r9 = r8[r3]
            int r9 = r9.FB
            if (r9 < r4) goto L85
            java.lang.String r9 = "sdm status changed"
            com.huawei.location.lite.common.log.LogLocation.i(r2, r9)
            r9 = r8[r3]
            r8[r0] = r9
            r9.Vw = r0
            r8[r3] = r5
            goto L85
        L75:
            int r9 = r1.FB
            int r9 = r9 + r3
            r1.FB = r9
            r9 = r8[r3]
            if (r9 == 0) goto L85
            java.lang.String r9 = "sdm destroy status[1]"
            com.huawei.location.lite.common.log.LogLocation.i(r2, r9)
            r8[r3] = r5
        L85:
            r8 = r8[r0]
            boolean r8 = r8.yn
            return r8
        L8a:
            r7.yn()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.support.yn.yn(com.huawei.location.support.yn$Vw[], boolean):boolean");
    }

    public void Vw() {
        ISoftARManager iSoftARManager = this.zp;
        if (iSoftARManager != null) {
            iSoftARManager.removeActivityUpdates(this.Yx);
            this.yn = -1;
        }
        this.oc = null;
    }

    public void yn(Looper looper, com.huawei.location.ephemeris.yn ynVar, Config config) {
        this.G3 = config;
        this.ut = ynVar;
        if (this.oc == null) {
            this.oc = new FB(looper);
        }
        if (this.oc.hasMessages(11)) {
            LogLocation.i("SDMSupportManager", "init failed,caz has msg");
        } else {
            this.oc.sendEmptyMessage(11);
        }
    }

    public boolean yn(double d, double d2, float f) throws JSONException, IOException {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.Vw > 1000) {
            this.Vw = jCurrentTimeMillis;
            boolean zYn = yn(this.LW, ScreenStatusBroadcastReceiver.isScreenOn());
            boolean zYn2 = yn(this.dC, !PermissionUtil.isAppIsInBackground(ContextUtil.getContext().getPackageName()));
            Vw[] vwArr = this.E5;
            LogLocation.i("SDMSupportManager", "currentARType: " + this.yn);
            int i = this.yn;
            if (i == 3 || i == 7) {
                Config config = this.G3;
                z = config == null || f < ((float) config.dC());
            } else {
                if (this.G3 != null && f < r5.dC()) {
                    LogLocation.i("SDMSupportManager", "speed: " + f);
                }
            }
            boolean zYn3 = yn(vwArr, z);
            Vw[] vwArr2 = this.d2;
            dC dCVar = this.Ot;
            boolean zYn4 = yn(vwArr2, dCVar != null ? dCVar.yn(d, d2) : false);
            boolean z2 = zYn && zYn2 && zYn3 && zYn4;
            this.FB = z2;
            if (z2) {
                com.huawei.location.ephemeris.yn ynVar = this.ut;
                if (ynVar == null) {
                    return false;
                }
                boolean zYn5 = ynVar.yn();
                this.FB = zYn5;
                LogLocation.i("SDMSupportManager", zYn5 ? "sdm is ok" : "sdm is bad caz EphModule not available");
                return this.FB;
            }
            LogLocation.i("SDMSupportManager", "sdm is bad caz after smooth:   screen[" + zYn + "]; isForeground[" + zYn2 + "]; ar[" + zYn3 + "]; tile[" + zYn4 + "]");
            return this.FB;
        }
        LogLocation.i("SDMSupportManager", "sdm check time support: " + this.FB);
        return this.FB;
    }
}

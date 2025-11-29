package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {
    private WeakReference<Activity> a;
    private String b = "";
    private long c = 0;

    private void a(long j) {
        if (!RegionUtils.isChinaROM(c())) {
            HMSLog.i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity activityC = c();
        if (activityC == null || activityC.isFinishing()) {
            return;
        }
        HashMap map = new HashMap();
        map.put("package", activityC.getPackageName());
        map.put(CommonCode.MapKey.RESOLUTION_FLAG, this.c + "-" + j);
        HiAnalyticsUtils.getInstance().onEvent(activityC, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, map);
        HMSLog.e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.b + ", carriedTimeStamp: " + this.c + ", savedTimeStamp: " + j);
    }

    private void b() {
        Activity activityC = c();
        if (activityC == null || activityC.isFinishing()) {
            return;
        }
        activityC.finish();
    }

    private Activity c() {
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.b);
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBridgeActivityCreate(android.app.Activity r10) throws android.content.IntentSender.SendIntentException {
        /*
            r9 = this;
            java.lang.String r0 = "BaseResolutionAdapter"
            if (r10 != 0) goto Ld
            java.lang.String r10 = "activity is null"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
            r9.d()
            return
        Ld:
            boolean r1 = r10.isFinishing()
            if (r1 == 0) goto L19
            java.lang.String r10 = "activity is finishing"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
            return
        L19:
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r10)
            r9.a = r1
            android.content.Intent r1 = r10.getIntent()
            if (r1 != 0) goto L2a
            r9.d()
            return
        L2a:
            android.os.Bundle r2 = r1.getExtras()     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "transaction_id"
            java.lang.String r3 = r1.getStringExtra(r3)     // Catch: java.lang.Throwable -> L41
            r9.b = r3     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "resolution_flag"
            r4 = 0
            long r3 = r1.getLongExtra(r3, r4)     // Catch: java.lang.Throwable -> L41
            r9.c = r3     // Catch: java.lang.Throwable -> L41
            goto L61
        L41:
            r1 = move-exception
            goto L45
        L43:
            r1 = move-exception
            r2 = 0
        L45:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "get transaction_id or resolution_flag exception:"
            r3.append(r4)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
        L61:
            boolean r1 = r9.a()
            if (r1 != 0) goto L6b
            r9.d()
            return
        L6b:
            java.lang.String r1 = r9.b
            if (r1 == 0) goto L83
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r1 < r3) goto L83
            java.lang.String r1 = "remove apk resolution failed task."
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager r1 = com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager.getInstance()
            java.lang.String r3 = r9.b
            r1.removeTask(r3)
        L83:
            if (r2 != 0) goto L89
            r9.d()
            return
        L89:
            java.lang.String r1 = "resolution"
            android.os.Parcelable r1 = r2.getParcelable(r1)
            if (r1 != 0) goto L95
            r9.d()
            return
        L95:
            boolean r2 = r1 instanceof android.content.Intent
            if (r2 == 0) goto Lae
            android.content.Intent r1 = (android.content.Intent) r1     // Catch: java.lang.Throwable -> La5
            android.content.Intent r1 = com.huawei.hms.utils.IntentUtil.modifyIntentBehaviorsSafe(r1)     // Catch: java.lang.Throwable -> La5
            r2 = 1001(0x3e9, float:1.403E-42)
            r10.startActivityForResult(r1, r2)     // Catch: java.lang.Throwable -> La5
            goto Lcb
        La5:
            r9.d()
            java.lang.String r10 = "ActivityNotFoundException:exception"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
            goto Lcb
        Lae:
            boolean r2 = r1 instanceof android.app.PendingIntent
            if (r2 == 0) goto Lcb
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1     // Catch: android.content.IntentSender.SendIntentException -> Lc3
            android.content.IntentSender r3 = r1.getIntentSender()     // Catch: android.content.IntentSender.SendIntentException -> Lc3
            r7 = 0
            r8 = 0
            r4 = 1001(0x3e9, float:1.403E-42)
            r5 = 0
            r6 = 0
            r2 = r10
            r2.startIntentSenderForResult(r3, r4, r5, r6, r7, r8)     // Catch: android.content.IntentSender.SendIntentException -> Lc3
            goto Lcb
        Lc3:
            r9.d()
            java.lang.String r10 = "SendIntentException:exception"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.ui.BaseResolutionAdapter.onBridgeActivityCreate(android.app.Activity):void");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i2);
        if (i2 == 1001 || i2 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i2);
        }
        if (i2 == -1 || intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) || intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(intent, this.b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(null, this.b);
        }
        b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    private boolean a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.b);
        if (resolutionFlag != 0 && resolutionFlag == this.c) {
            return true;
        }
        a(resolutionFlag);
        return false;
    }
}

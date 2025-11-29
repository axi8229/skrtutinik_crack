package com.huawei.hms.jos;

import android.content.Context;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.apptouch.AppInfo;
import com.huawei.hms.apptouch.AppTouch;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;

/* loaded from: classes3.dex */
public final class AppUpdateClientImpl implements AppUpdateClient {

    static class a implements OnFailureListener {
        Context a;
        CheckUpdateCallBack b;

        a(Context context, CheckUpdateCallBack checkUpdateCallBack) {
            this.a = context;
            this.b = checkUpdateCallBack;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            HMSLog.w("AppUpdateClientImpl", "GetAppInfos onFailure:\n" + exc.getMessage());
            UpdateSdkAPI.checkAppUpdate(this.a, new UpdateParams.Builder().setTargetPkgName(this.a.getPackageName()).build(), this.b);
        }
    }

    static class b implements OnSuccessListener<AppInfo> {
        Context a;
        CheckUpdateCallBack b;

        b(Context context, CheckUpdateCallBack checkUpdateCallBack) {
            this.a = context;
            this.b = checkUpdateCallBack;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AppInfo appInfo) {
            if (appInfo != null) {
                AppInfoAdapter appInfoAdapter = new AppInfoAdapter();
                appInfoAdapter.setAppId(appInfo.getAppId());
                appInfoAdapter.setTargetPkgName(appInfo.getAppPackageName());
                appInfoAdapter.setAppStorePkgName(appInfo.getAppTouchPackageName());
                appInfoAdapter.setBusiness(appInfo.getBusiness());
                appInfoAdapter.setCarrierId(appInfo.getCarrierId());
                appInfoAdapter.setServiceZone(appInfo.getHomeCountry());
                UpdateSdkAPI.checkAppUpdateByAppInfo(this.a, this.b, appInfoAdapter);
            }
        }
    }

    static class c implements OnFailureListener {
        Context a;
        ApkUpgradeInfo b;
        private boolean c;

        c(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z) {
            this.a = context;
            this.b = apkUpgradeInfo;
            this.c = z;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            HMSLog.w("AppUpdateClientImpl", "GetAppInfos onFailure:\n" + exc.getMessage());
            UpdateSdkAPI.showUpdateDialog(this.a, this.b, this.c);
        }
    }

    static class d implements OnSuccessListener<AppInfo> {
        Context a;
        ApkUpgradeInfo b;
        private boolean c;

        d(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z) {
            this.a = context;
            this.b = apkUpgradeInfo;
            this.c = z;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AppInfo appInfo) {
            if (appInfo != null) {
                AppInfoAdapter appInfoAdapter = new AppInfoAdapter();
                appInfoAdapter.setAppId(appInfo.getAppId());
                appInfoAdapter.setTargetPkgName(appInfo.getAppPackageName());
                appInfoAdapter.setAppStorePkgName(appInfo.getAppTouchPackageName());
                appInfoAdapter.setBusiness(appInfo.getBusiness());
                appInfoAdapter.setCarrierId(appInfo.getCarrierId());
                appInfoAdapter.setServiceZone(appInfo.getHomeCountry());
                appInfoAdapter.setMustBtnOne(this.c);
                UpdateSdkAPI.showUpdateDialogByAppInfo(this.a, this.b, appInfoAdapter);
            }
        }
    }

    @Override // com.huawei.hms.jos.AppUpdateClient
    public void checkAppUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack) {
        if (context != null) {
            AppTouch.getAppClientImpl(context).getAppInfo().addOnFailureListener(new a(context, checkUpdateCallBack)).addOnSuccessListener(new b(context, checkUpdateCallBack));
        }
    }

    @Override // com.huawei.hms.jos.AppUpdateClient
    public void releaseCallBack() {
        UpdateSdkAPI.releaseCallBack();
    }

    @Override // com.huawei.hms.jos.AppUpdateClient
    public void showUpdateDialog(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z) {
        AppTouch.getAppClientImpl(context).getAppInfo().addOnFailureListener(new c(context, apkUpgradeInfo, z)).addOnSuccessListener(new d(context, apkUpgradeInfo, z));
    }
}

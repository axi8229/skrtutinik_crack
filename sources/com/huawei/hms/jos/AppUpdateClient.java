package com.huawei.hms.jos;

import android.content.Context;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

/* loaded from: classes3.dex */
public interface AppUpdateClient {
    void checkAppUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack);

    void releaseCallBack();

    void showUpdateDialog(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z);
}

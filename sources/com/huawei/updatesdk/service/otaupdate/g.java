package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import java.util.List;

/* loaded from: classes3.dex */
public final class g {
    public static void a() {
        Log.i("UpdateSdk", "UpdateSDK releaseCallBack");
        d.a().a((CheckUpdateCallBack) null);
        List<AsyncTask> listA = com.huawei.updatesdk.b.g.b.a();
        if (listA == null || listA.isEmpty()) {
            return;
        }
        for (AsyncTask asyncTask : listA) {
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            Log.d("UpdateSdk", "cancel task");
        }
        listA.clear();
    }

    private static void a(Context context) {
        com.huawei.updatesdk.a.b.a.a.a(context);
        Log.i("updatesdk", "UpdateSDK version is: 3.0.2.300 ,flavor: envrelease ,pkgName: " + context.getPackageName());
        if (com.huawei.updatesdk.b.c.b.a().b() == 3) {
            com.huawei.updatesdk.a.a.d.h.a.b(context);
        }
    }

    public static void a(Context context, ApkUpgradeInfo apkUpgradeInfo, AppInfoAdapter appInfoAdapter) {
        if (appInfoAdapter != null && !TextUtils.isEmpty(appInfoAdapter.getAppStorePkgName()) && !TextUtils.equals(f.e().c(), appInfoAdapter.getAppStorePkgName())) {
            f.e().c(appInfoAdapter.getAppStorePkgName());
        }
        a(context, apkUpgradeInfo, appInfoAdapter != null && appInfoAdapter.isMustBtnOne(), a(appInfoAdapter));
    }

    public static void a(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z) {
        a(context, apkUpgradeInfo, z, false);
    }

    private static void a(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z, boolean z2) {
        StringBuilder sb;
        String str;
        if (context == null || apkUpgradeInfo == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AppUpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("app_update_parm", apkUpgradeInfo);
        bundle.putBoolean("app_must_btn", z);
        bundle.putBoolean("is_apptouch", z2);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            str = "go AppUpdateActivity error: ";
            sb.append(str);
            sb.append(e.toString());
            Log.e("UpdateSdk", sb.toString());
        } catch (SecurityException e2) {
            e = e2;
            sb = new StringBuilder();
            str = "go AppUpdateActivity security error: ";
            sb.append(str);
            sb.append(e.toString());
            Log.e("UpdateSdk", sb.toString());
        }
    }

    public static void a(Context context, CheckUpdateCallBack checkUpdateCallBack, AppInfoAdapter appInfoAdapter) {
        if (context == null) {
            return;
        }
        UpdateParams.Builder builder = new UpdateParams.Builder();
        if (appInfoAdapter != null) {
            if (!TextUtils.isEmpty(appInfoAdapter.getServiceZone())) {
                builder.setServiceZone(appInfoAdapter.getServiceZone());
            }
            a(appInfoAdapter.getAppStorePkgName());
            builder.setTargetPkgName(appInfoAdapter.getTargetPkgName()).setPackageList(appInfoAdapter.getPackageList()).setMustBtnOne(appInfoAdapter.isMustBtnOne()).setIsShowImmediate(appInfoAdapter.isShowImmediate()).setMinIntervalDay(appInfoAdapter.getMinIntervalDay());
        }
        UpdateParams updateParamsBuild = builder.build();
        updateParamsBuild.resetParamList();
        a(context, updateParamsBuild, checkUpdateCallBack, a(appInfoAdapter));
    }

    public static void a(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, int i, boolean z2) {
        if (context == null || !com.huawei.updatesdk.a.a.d.i.a.d(context)) {
            return;
        }
        a(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = com.huawei.updatesdk.b.b.a.d().b();
        if (i == 0 || Math.abs(jCurrentTimeMillis - jB) >= i * 86400000) {
            com.huawei.updatesdk.b.b.a.d().a(jCurrentTimeMillis);
            e eVar = new e(context, new UpdateParams.Builder().setIsShowImmediate(z).setMustBtnOne(z2).setMinIntervalDay(i).build(), checkUpdateCallBack);
            eVar.b(true);
            eVar.executeOnExecutor(com.huawei.updatesdk.b.g.c.b, new Void[0]);
        }
    }

    public static void a(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, boolean z2) {
        if (context == null) {
            return;
        }
        if (com.huawei.updatesdk.a.a.d.i.a.d(context)) {
            a(context);
            new e(context, new UpdateParams.Builder().setIsShowImmediate(z).setMustBtnOne(z2).build(), checkUpdateCallBack).executeOnExecutor(com.huawei.updatesdk.b.g.c.b, new Void[0]);
            return;
        }
        if (checkUpdateCallBack != null) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.STATUS, 2);
            checkUpdateCallBack.onUpdateInfo(intent);
        }
        Toast.makeText(context, com.huawei.updatesdk.b.h.c.c(context, "upsdk_no_available_network_prompt_toast"), 0).show();
    }

    public static void a(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        if (context == null || updateParams == null || checkUpdateCallBack == null) {
            return;
        }
        a(context);
        updateParams.resetParamList();
        b(context, updateParams, checkUpdateCallBack);
    }

    private static void a(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack, boolean z) {
        if (context == null || updateParams == null || checkUpdateCallBack == null) {
            return;
        }
        a(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = com.huawei.updatesdk.b.b.a.d().b();
        if (updateParams.getMinIntervalDay() == 0 || Math.abs(jCurrentTimeMillis - jB) >= updateParams.getMinIntervalDay() * 86400000) {
            if (!com.huawei.updatesdk.a.a.d.i.a.d(context)) {
                Intent intent = new Intent();
                intent.putExtra(UpdateKey.STATUS, 2);
                checkUpdateCallBack.onUpdateInfo(intent);
            } else {
                com.huawei.updatesdk.b.b.a.d().a(jCurrentTimeMillis);
                e eVar = new e(context, updateParams, checkUpdateCallBack);
                eVar.a(z);
                eVar.executeOnExecutor(com.huawei.updatesdk.b.g.c.b, new Void[0]);
            }
        }
    }

    public static void a(Context context, String str, CheckUpdateCallBack checkUpdateCallBack) {
        if (context == null || TextUtils.isEmpty(str) || checkUpdateCallBack == null) {
            if (checkUpdateCallBack != null) {
                Intent intent = new Intent();
                intent.putExtra(UpdateKey.STATUS, 1);
                checkUpdateCallBack.onUpdateInfo(intent);
                return;
            }
            return;
        }
        if (com.huawei.updatesdk.a.a.d.i.a.d(context)) {
            a(context);
            new e(context, new UpdateParams.Builder().setMustBtnOne(false).setTargetPkgName(str).build(), checkUpdateCallBack).executeOnExecutor(com.huawei.updatesdk.b.g.c.b, new Void[0]);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra(UpdateKey.STATUS, 2);
            checkUpdateCallBack.onUpdateInfo(intent2);
        }
    }

    public static void a(String str) {
        f.e().c(str);
    }

    private static boolean a(AppInfoAdapter appInfoAdapter) {
        return (appInfoAdapter == null || TextUtils.isEmpty(appInfoAdapter.getAppStorePkgName()) || !TextUtils.equals(appInfoAdapter.getBusiness(), "AppTouch")) ? false : true;
    }

    public static void b(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        a(context, updateParams, checkUpdateCallBack, false);
    }

    public static void b(String str) {
        f.e().b(str);
    }
}

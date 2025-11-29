package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class e extends AsyncTask<Void, Void, com.huawei.updatesdk.a.b.c.c.d> {
    private Context a;
    private CheckUpdateCallBack b;
    private UpdateParams c;
    private Toast d;
    private com.huawei.updatesdk.a.b.c.b g;
    private boolean e = false;
    private List<String> f = new ArrayList();
    private boolean h = false;

    public e(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        this.c = updateParams;
        this.a = context;
        this.b = checkUpdateCallBack;
        f.e().b(updateParams.getServiceZone());
    }

    private PackageInfo a(Context context, String str) {
        PackageInfo packageInfoA = com.huawei.updatesdk.b.h.b.a(str, context);
        if (packageInfoA != null) {
            return packageInfoA;
        }
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = str;
        packageInfo.versionName = "1.0";
        packageInfo.versionCode = 1;
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.targetSdkVersion = 19;
        packageInfo.applicationInfo = applicationInfo;
        return packageInfo;
    }

    private com.huawei.updatesdk.a.b.c.c.d a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(context, it.next()));
        }
        com.huawei.updatesdk.service.appmgr.bean.d dVar = !com.huawei.updatesdk.b.h.d.a(this.c.getParamList()) ? new com.huawei.updatesdk.service.appmgr.bean.d(this.c.getParamList()) : com.huawei.updatesdk.service.appmgr.bean.d.a(arrayList);
        dVar.d(this.h ? 34 : 0);
        dVar.b(0);
        dVar.d(com.huawei.updatesdk.a.a.d.h.c.b(context, com.huawei.updatesdk.b.e.e.a(this.h ? "apptouch" : "default").b()));
        if (isCancelled()) {
            com.huawei.updatesdk.a.a.a.c("UpdateSDKCheckTask", "UpdateSDK task is canceled and return empty upgradeInfo");
            return null;
        }
        com.huawei.updatesdk.a.b.c.b bVar = new com.huawei.updatesdk.a.b.c.b(dVar, null);
        this.g = bVar;
        return bVar.c();
    }

    private void a() {
        Toast toast = this.d;
        if (toast != null) {
            toast.cancel();
        }
    }

    private void a(Context context, ApkUpgradeInfo apkUpgradeInfo) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AppUpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("app_update_parm", apkUpgradeInfo);
        bundle.putBoolean("app_must_btn", this.c.isMustBtnOne());
        bundle.putBoolean("is_apptouch", this.h);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            com.huawei.updatesdk.a.a.c.a.a.a.b("UpdateSDKCheckTask", "go AppUpdateActivity error: " + e.toString());
        }
    }

    private void a(List<ApkUpgradeInfo> list) {
        if (com.huawei.updatesdk.b.h.d.a(list)) {
            return;
        }
        for (ApkUpgradeInfo apkUpgradeInfo : list) {
            if (apkUpgradeInfo != null && !TextUtils.isEmpty(apkUpgradeInfo.getFullDownUrl_())) {
                if (apkUpgradeInfo.getDiffSize_() > 0) {
                    apkUpgradeInfo.setDiffDownUrl_(apkUpgradeInfo.getDownurl_());
                }
                apkUpgradeInfo.setDownurl_(apkUpgradeInfo.getFullDownUrl_());
            }
        }
    }

    private void b() {
        String targetPkgName = this.c.getTargetPkgName();
        if (TextUtils.isEmpty(targetPkgName)) {
            targetPkgName = this.a.getPackageName();
        }
        if (!com.huawei.updatesdk.b.h.d.a(this.c.getPackageList())) {
            this.f.addAll(this.c.getPackageList());
        } else {
            if (TextUtils.isEmpty(targetPkgName)) {
                return;
            }
            this.f.add(targetPkgName);
        }
    }

    private void b(com.huawei.updatesdk.a.b.c.c.d dVar) {
        if (this.b != null) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.STATUS, 6);
            if (dVar.a() != null) {
                intent.putExtra(UpdateKey.FAIL_CODE, dVar.a().ordinal());
            }
            intent.putExtra(UpdateKey.FAIL_REASON, dVar.c());
            intent.putExtra(UpdateKey.RESPONSE_CODE, dVar.b());
            this.b.onUpdateInfo(intent);
            this.b.onUpdateStoreError(dVar.d());
        }
    }

    private boolean c() {
        return !this.e && TextUtils.isEmpty(this.c.getTargetPkgName()) && com.huawei.updatesdk.b.h.d.a(this.c.getPackageList()) && com.huawei.updatesdk.b.h.d.a(this.c.getParamList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.huawei.updatesdk.a.b.c.c.d doInBackground(Void... voidArr) throws ExecutionException, InterruptedException, TimeoutException {
        com.huawei.updatesdk.a.a.c.a.a.a.a("UpdateSDKCheckTask", "CheckOtaAndUpdataTask doInBackground");
        com.huawei.updatesdk.b.b.a.d().c();
        com.huawei.updatesdk.b.g.b.a(this);
        b();
        com.huawei.updatesdk.b.e.a aVarA = com.huawei.updatesdk.b.e.e.a(this.h ? "apptouch" : "default");
        aVarA.a(this.f);
        aVarA.c();
        com.huawei.updatesdk.a.b.c.c.c.c(aVarA.b(this.a));
        com.huawei.updatesdk.b.b.a.d().e(f.e().a());
        return a(this.a, this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(com.huawei.updatesdk.a.b.c.c.d dVar) {
        ArrayList<ApkUpgradeInfo> arrayList;
        com.huawei.updatesdk.b.g.b.a().remove(this);
        a();
        if (this.b == null) {
            com.huawei.updatesdk.a.a.a.c("UpdateSDKCheckTask", "UpdateSDK callback is null");
        }
        if (dVar == null) {
            if (this.b != null) {
                Intent intent = new Intent();
                intent.putExtra(UpdateKey.STATUS, 3);
                this.b.onUpdateInfo(intent);
                return;
            }
            return;
        }
        int iB = dVar.b();
        if (dVar.f()) {
            com.huawei.updatesdk.service.appmgr.bean.e eVar = (com.huawei.updatesdk.service.appmgr.bean.e) dVar;
            arrayList = eVar.list;
            if (!com.huawei.updatesdk.b.h.d.a(eVar.notRcmList)) {
                ApkUpgradeInfo apkUpgradeInfo = eVar.notRcmList.get(0);
                com.huawei.updatesdk.a.a.a.c("UpdateSDKCheckTask", "UpdateSDK get update info is not recommend,reason: " + apkUpgradeInfo.getNotRcmReason_() + ",is same signature: " + apkUpgradeInfo.getSameS_());
            }
            a(arrayList);
            if (com.huawei.updatesdk.b.h.d.a(arrayList) && this.b != null) {
                com.huawei.updatesdk.a.a.a.b("UpdateSDKCheckTask", "no upgrade info");
                Intent intent2 = new Intent();
                intent2.putExtra(UpdateKey.STATUS, 3);
                intent2.putExtra(UpdateKey.RESPONSE_CODE, iB);
                this.b.onUpdateInfo(intent2);
            }
        } else {
            b(dVar);
            com.huawei.updatesdk.a.a.a.a("UpdateSDKCheckTask", "get app update msg failed,responseCode is " + dVar.d() + ",failreason: " + dVar.c());
            arrayList = null;
        }
        if (com.huawei.updatesdk.b.h.d.a(arrayList)) {
            if (c()) {
                com.huawei.updatesdk.a.a.a.b("UpdateSDKCheckTask", "show no upgrade info toast.");
                Context context = this.a;
                Toast.makeText(context, com.huawei.updatesdk.b.h.c.c(context, "upsdk_update_check_no_new_version"), 0).show();
                return;
            }
            return;
        }
        ApkUpgradeInfo apkUpgradeInfo2 = arrayList.get(0);
        if (this.b != null) {
            Intent intent3 = new Intent();
            intent3.putExtra(UpdateKey.INFO, (Serializable) apkUpgradeInfo2);
            intent3.putParcelableArrayListExtra(UpdateKey.INFO_LIST, arrayList);
            intent3.putExtra(UpdateKey.STATUS, 7);
            intent3.putExtra(UpdateKey.RESPONSE_CODE, iB);
            this.b.onUpdateInfo(intent3);
        }
        if (apkUpgradeInfo2 != null) {
            com.huawei.updatesdk.a.a.a.b("UpdateSDKCheckTask", "ApkUpgradeInfo,version = " + apkUpgradeInfo2.getVersion_() + ",versionCode = " + apkUpgradeInfo2.getVersionCode_() + ",detailId = " + apkUpgradeInfo2.getDetailId_() + ",devType = " + apkUpgradeInfo2.getDevType_() + ",packageName = " + apkUpgradeInfo2.getPackage_() + ",oldVersionCode = " + apkUpgradeInfo2.getOldVersionCode_());
        } else {
            com.huawei.updatesdk.a.a.a.a("UpdateSDKCheckTask", "info == null");
        }
        if (this.c.isShowImmediate()) {
            a(this.a, apkUpgradeInfo2);
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(boolean z) {
        this.e = z;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        com.huawei.updatesdk.a.b.c.b bVar = this.g;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() throws Resources.NotFoundException {
        super.onPreExecute();
        d.a().a(this.b);
        if (c()) {
            Context context = this.a;
            Toast toastMakeText = Toast.makeText(context, com.huawei.updatesdk.b.h.c.c(context, "upsdk_checking_update_prompt"), 1);
            this.d = toastMakeText;
            toastMakeText.show();
        }
    }
}

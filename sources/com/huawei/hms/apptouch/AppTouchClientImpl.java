package com.huawei.hms.apptouch;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppTouchClientImpl extends HuaweiApi<c> implements AppTouchClient {
    private static a a = new a();
    private static final Api<c> b = new Api<>("AppTouch.API");
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private Context g;

    public AppTouchClientImpl(Activity activity, c cVar) {
        super(activity, b, cVar, (AbstractClientBuilder) a);
        this.c = 1;
        this.d = 3;
        this.e = ExceptionCode.CRASH_EXCEPTION;
        this.f = 20000000;
        this.g = activity;
    }

    public AppTouchClientImpl(Context context, c cVar) {
        super(context, b, cVar, a);
        this.c = 1;
        this.d = 3;
        this.e = ExceptionCode.CRASH_EXCEPTION;
        this.f = 20000000;
        this.g = context;
    }

    private int a(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.huawei.hms.kit.api_level:hmscore");
                HMSLog.i("AppTouchClientImpl", "getRealApiLevel:" + i);
                return i;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return 1;
    }

    @Override // com.huawei.hms.apptouch.AppTouchClient
    public Task<AppInfo> getAppInfo() {
        HMSLog.i("AppTouchClientImpl", "getAppInfo");
        return doWrite(new e("apptouch.getAppInfo", ""));
    }

    @Override // com.huawei.hms.apptouch.AppTouchClient
    public Task<AppInfo> getAppInfoByName(String str) {
        Checker.checkNonNull(str);
        HMSLog.i("AppTouchClientImpl", "getAppInfoByName");
        return doWrite(new e("apptouch.getAppInfoByName", str));
    }

    @Override // com.huawei.hms.apptouch.AppTouchClient
    public List<String> getHMSPackageName(Context context) {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(context);
        HMSLog.i("AppTouchClientImpl", "getHMSPackageName");
        ArrayList arrayList = new ArrayList();
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        String hMSPackageName = hMSPackageManager.getHMSPackageName();
        HMSLog.i("AppTouchClientImpl", "packageName is " + hMSPackageName);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(hMSPackageName))) {
            HMSLog.i("AppTouchClientImpl", "packageName is not installed");
            arrayList.add(PackageConstants.SERVICES_PACKAGE_ALL_SCENE);
            hMSPackageName = "com.huawei.hwid";
        } else {
            HMSLog.i("AppTouchClientImpl", "packageName is installed with the name " + hMSPackageName);
        }
        arrayList.add(hMSPackageName);
        return arrayList;
    }

    @Override // com.huawei.hms.apptouch.AppTouchClient
    public Intent getResolveErrorIntent(Context context) {
        String hMSPackageName = HMSPackageManager.getInstance(context).getHMSPackageName();
        HMSLog.i("AppTouchClientImpl", "packageName is " + hMSPackageName);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(hMSPackageName, "com.huawei.hms.StatementActivity"));
        intent.putExtra("isFromNotice", true);
        intent.putExtra("isHidePrivacy", true);
        return intent;
    }

    @Override // com.huawei.hms.apptouch.AppTouchClient
    public boolean hasPrivacy() throws PackageManager.NameNotFoundException {
        int iIsHMSCoreAvailable = isHMSCoreAvailable(this.g);
        if (iIsHMSCoreAvailable == 1) {
            HMSLog.i("AppTouchClientImpl", "Service is missing with errorCode " + iIsHMSCoreAvailable);
            return false;
        }
        int packageVersionCode = new PackageManagerHelper(this.g).getPackageVersionCode(HMSPackageManager.getInstance(this.g).getHMSPackageName());
        HMSLog.i("AppTouchClientImpl", "version " + packageVersionCode);
        return packageVersionCode >= 20000000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        if ("3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(r0) == false) goto L12;
     */
    @Override // com.huawei.hms.apptouch.AppTouchClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int isHMSCoreAvailable(android.content.Context r7) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r6 = this;
            com.huawei.hms.utils.PackageManagerHelper r0 = new com.huawei.hms.utils.PackageManagerHelper
            r0.<init>(r7)
            com.huawei.hms.utils.HMSPackageManager r1 = com.huawei.hms.utils.HMSPackageManager.getInstance(r7)
            java.lang.String r1 = r1.getHMSPackageName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "hmsPackageName is "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "AppTouchClientImpl"
            com.huawei.hms.support.log.HMSLog.i(r3, r2)
            com.huawei.hms.adapter.AvailableAdapter r2 = new com.huawei.hms.adapter.AvailableAdapter
            r4 = 10000000(0x989680, float:1.4012985E-38)
            r2.<init>(r4)
            int r2 = r2.isHuaweiMobileServicesAvailable(r7)
            if (r2 == 0) goto L4f
            r4 = 1
            if (r2 != r4) goto L4e
            java.lang.String r0 = r0.getPackageSignature(r1)
            java.lang.String r4 = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 != 0) goto L4f
            java.lang.String r4 = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C"
            boolean r5 = r4.equalsIgnoreCase(r0)
            if (r5 != 0) goto L4f
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 != 0) goto L4f
        L4e:
            return r2
        L4f:
            int r7 = r6.a(r7, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "connect apiLevel:"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.huawei.hms.support.log.HMSLog.i(r3, r0)
            r0 = 3
            if (r7 >= r0) goto L6c
            r7 = 2
            return r7
        L6c:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.apptouch.AppTouchClientImpl.isHMSCoreAvailable(android.content.Context):int");
    }

    @Override // com.huawei.hms.apptouch.AppTouchClient
    public Task<AppInfoSetResponse> setAppInfos(List<AppInfo> list) throws JSONException {
        Checker.checkNonNull(list);
        JSONArray jSONArray = new JSONArray();
        HMSLog.i("AppTouchClientImpl", "setAppInfos");
        for (AppInfo appInfo : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", appInfo.getAppId());
                jSONObject.put("business", appInfo.getBusiness());
                jSONObject.put("appTouchPackageName", appInfo.getAppTouchPackageName());
                jSONObject.put("appPackageName", appInfo.getAppPackageName());
                jSONObject.put("carrierId", appInfo.getCarrierId());
                jSONObject.put("homeCountry", appInfo.getHomeCountry());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                HMSLog.e("AppTouchClientImpl", "catch JSONException");
            }
        }
        return doWrite(new d("apptouch.setAppInfo", jSONArray.toString()));
    }
}

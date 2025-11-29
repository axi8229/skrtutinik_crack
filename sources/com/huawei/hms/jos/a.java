package com.huawei.hms.jos;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.jos.apps.AppsBaseClientImpl;
import com.huawei.hms.jos.util.Utils;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class a extends AppsBaseClientImpl implements JosAppsClient {
    private Context e;

    /* renamed from: com.huawei.hms.jos.a$a, reason: collision with other inner class name */
    class CallableC0079a implements Callable<String> {
        CallableC0079a() {
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            return Util.getAppId(a.this.e);
        }
    }

    public a(Activity activity) {
        super(activity);
        this.e = activity.getApplicationContext();
    }

    private boolean a() throws PackageManager.NameNotFoundException {
        int packageVersionCode = Utils.getPackageVersionCode(Utils.getHMSPackageName(this.e));
        if (packageVersionCode >= 30000000) {
            return true;
        }
        HMSLog.w("JosAppsClientImpl", "hmsApkVersion is " + packageVersionCode + " call init failed");
        return false;
    }

    private void b() throws JSONException {
        HMSLog.i("JosAppsClientImpl", "request Jos Notice.");
        String strReportEntry = HiAnalyticsClient.reportEntry(getContext(), "core.getNoticeIntent", Utils.getSDKVersionCode(getContext()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("noticeType", 0);
            jSONObject.put("hmsSdkVersionName", "5.2.0.300");
            jSONObject.put("cpId", Util.getCpId(this.e));
            doWrite(new NoticeTaskApiCall("core.getNoticeIntent", jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            HMSLog.w("JosAppsClientImpl", "build Notice request meet JSONException.");
        }
    }

    @Override // com.huawei.hms.jos.JosAppsClient
    public Task<String> getAppId() {
        return Tasks.callInBackground(new CallableC0079a());
    }

    @Override // com.huawei.hms.jos.JosAppsClient
    public void init() throws JSONException {
        if (isInit()) {
            return;
        }
        setInit();
        if (a()) {
            b();
        }
    }
}

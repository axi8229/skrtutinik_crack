package com.huawei.hms.apptouch;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e extends TaskApiCall<b, AppInfo> {
    public e(String str, String str2) {
        super(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(b bVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<AppInfo> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.e("AppTouchTaskApiCall", "Apptouch get the errorcode is " + responseErrorCode.getErrorCode());
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        AppInfo appInfo = new AppInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            appInfo.setBusiness(JsonUtil.getStringValue(jSONObject, "business"));
            appInfo.setAppTouchPackageName(JsonUtil.getStringValue(jSONObject, "appTouchPackageName"));
            appInfo.setAppId(JsonUtil.getStringValue(jSONObject, "appId"));
            appInfo.setAppPackageName(JsonUtil.getStringValue(jSONObject, "appPackageName"));
            appInfo.setCarrierId(JsonUtil.getStringValue(jSONObject, "carrierId"));
            appInfo.setHomeCountry(JsonUtil.getStringValue(jSONObject, "homeCountry"));
        } catch (JSONException unused) {
            HMSLog.e("AppTouchTaskApiCall", "fromJson failed");
        }
        taskCompletionSource.setResult(appInfo);
    }
}

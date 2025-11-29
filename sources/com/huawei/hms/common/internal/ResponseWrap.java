package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ResponseWrap {
    private String a;
    private ResponseHeader b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.b.setAppID(JsonUtil.getStringValue(jSONObject, HiAnalyticsConstant.BI_KEY_APP_ID));
            this.b.setPkgName(JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.b.setResolution(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.HAS_RESOLUTION));
            this.a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = new JSONObject().toString();
        }
        return this.a;
    }

    public ResponseHeader getResponseHeader() {
        return this.b;
    }

    public void setBody(String str) {
        this.a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.b = responseHeader;
    }

    public String toJson() throws JSONException {
        if (this.b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.b.getStatusCode());
            jSONObject.put("error_code", this.b.getErrorCode());
            jSONObject.put("error_reason", this.b.getErrorReason());
            jSONObject.put("srv_name", this.b.getSrvName());
            jSONObject.put("api_name", this.b.getApiName());
            jSONObject.put(HiAnalyticsConstant.BI_KEY_APP_ID, this.b.getAppID());
            jSONObject.put("pkg_name", this.b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.b.getTransactionId());
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.b.getResolution());
            String sessionId = this.b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("body", this.a);
            }
        } catch (JSONException e) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.a + "', responseHeader=" + this.b + '}';
    }
}

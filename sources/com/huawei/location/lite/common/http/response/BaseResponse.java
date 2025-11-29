package com.huawei.location.lite.common.http.response;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* loaded from: classes3.dex */
public abstract class BaseResponse {

    @SerializedName(alternate = {"code", "returnCode"}, value = "errorCode")
    protected String code;

    @SerializedName(alternate = {CrashHianalyticsData.MESSAGE, "returnDesc"}, value = "errorMsg")
    protected String msg;

    public abstract String getApiCode();

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return "0".equals(this.code);
    }
}

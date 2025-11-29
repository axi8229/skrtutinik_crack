package com.huawei.location.lite.common.config;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.location.lite.common.http.response.BaseResponse;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ConfigResponseData extends BaseResponse {

    @SerializedName(RemoteMessageConst.DATA)
    private ArrayList<ConfigResponseItem> data;

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public String getApiCode() {
        return String.valueOf(this.code);
    }

    public ArrayList<ConfigResponseItem> getData() {
        return this.data;
    }

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0") || TextUtils.isEmpty(this.code);
    }
}

package com.huawei.location.nlp.network.response;

import android.text.TextUtils;
import com.huawei.location.lite.common.http.response.BaseResponse;
import com.huawei.location.nlp.network.request.ResponseExtraInfo;

/* loaded from: classes3.dex */
public class OnlineLocationResponse extends BaseResponse {
    private static final String SUCCESS = "0";
    private ResponseExtraInfo extraInfo;
    private int indoor;
    private String locateType;
    private Location position;
    private String sessionId;
    private int status;

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public String getApiCode() {
        return this.code.isEmpty() ? SUCCESS : this.code;
    }

    public ResponseExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public int getIndoor() {
        return this.indoor;
    }

    public String getLocateType() {
        return this.locateType;
    }

    public Location getPosition() {
        return this.position;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getStatus() {
        return this.status;
    }

    @Override // com.huawei.location.lite.common.http.response.BaseResponse
    public boolean isSuccess() {
        return TextUtils.equals(this.code, SUCCESS) || TextUtils.isEmpty(this.code);
    }

    public void setExtraInfo(ResponseExtraInfo responseExtraInfo) {
        this.extraInfo = responseExtraInfo;
    }

    public void setIndoor(int i) {
        this.indoor = i;
    }

    public void setLocateType(String str) {
        this.locateType = str;
    }

    public void setPosition(Location location) {
        this.position = location;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "OnlineLocationResponse{code='" + this.code + "', msg='" + this.msg + "',locateType='" + this.locateType + "', indoor=" + this.indoor + ", position=" + this.position + ", extraInfo=" + this.extraInfo + ", status=" + this.status + '}';
    }
}

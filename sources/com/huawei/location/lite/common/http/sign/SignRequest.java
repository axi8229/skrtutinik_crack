package com.huawei.location.lite.common.http.sign;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes3.dex */
public class SignRequest {
    private String[] headSigned;
    private String method;
    private String path;
    private String payload;
    private String query;
    private String tid;
    private String url;

    public static class Builder {
        private final SignRequest signRequest;

        public Builder(String str, String str2, String str3, String str4) {
            SignRequest signRequest = new SignRequest();
            this.signRequest = signRequest;
            str4 = TextUtils.isEmpty(str4) ? UUID.randomUUID().toString() : str4;
            signRequest.setUrl(str2);
            signRequest.setTid(str4);
            signRequest.setPath(str3);
            signRequest.setMethod(str);
        }

        public SignRequest build() {
            return this.signRequest;
        }

        public Builder headSigned(String[] strArr) {
            this.signRequest.setHeadSigned(strArr);
            return this;
        }

        public Builder payLoad(String str) {
            this.signRequest.setPayload(str);
            return this;
        }

        public Builder query(String str) {
            this.signRequest.setQuery(str);
            return this;
        }
    }

    private SignRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadSigned(String[] strArr) {
        this.headSigned = strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethod(String str) {
        this.method = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPayload(String str) {
        this.payload = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(String str) {
        this.query = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        this.url = str;
    }

    public String[] getHeadSigned() {
        String[] strArr = this.headSigned;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public String getPayload() {
        return this.payload;
    }

    public String getQuery() {
        return this.query;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String toString() {
        return "SignMessageReq{method='" + this.method + "', query='" + this.query + "', payload='" + this.payload + "', url='" + this.url + "', tid='" + this.tid + "'}";
    }
}

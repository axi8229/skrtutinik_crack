package com.yandex.metrica.networktasks.api;

import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DefaultResponseParser {

    public class Response {
        public final String mStatus;

        public Response(String str) {
            this.mStatus = str;
        }

        public String toString() {
            return "Response{mStatus='" + this.mStatus + "'}";
        }
    }

    public Response parse(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    return new Response(new JSONObject(new String(bArr, "UTF-8")).optString(UpdateKey.STATUS));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}

package com.huawei.location.lite.common.http.request;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.location.lite.common.http.adapter.RequestBodyAdapter;
import com.huawei.location.lite.common.log.LogLocation;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RequestJsonBody extends RequestBodyAdapter {
    private String body;

    public static final class Builder {
        private int dataFormatType;
        private JSONObject jsonBody = new JSONObject();
        private StringBuilder rawBody;

        public Builder add(String str, String str2) throws JSONException {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    if (this.dataFormatType == 1) {
                        StringBuilder sb = this.rawBody;
                        sb.append(str);
                        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(str2);
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    } else {
                        this.jsonBody.put(str, str2);
                    }
                } catch (JSONException unused) {
                    LogLocation.e("RequestJsonBody", "add: failed");
                }
            }
            return this;
        }

        public RequestJsonBody build() {
            return new RequestJsonBody(this);
        }

        public RequestJsonBody build(JSONObject jSONObject) {
            this.jsonBody = jSONObject;
            return new RequestJsonBody(this);
        }
    }

    public RequestJsonBody(Builder builder) {
        String string;
        if (builder.dataFormatType != 1) {
            string = builder.jsonBody.toString();
        } else if (TextUtils.isEmpty(builder.rawBody)) {
            return;
        } else {
            string = builder.rawBody.substring(0, builder.rawBody.length() - 1);
        }
        this.body = string;
    }

    public String contentType() {
        return "application/json; charset=utf-8";
    }

    public String getBody() {
        return this.body;
    }
}

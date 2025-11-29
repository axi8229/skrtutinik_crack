package com.huawei.location.lite.common.http.sign;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SignHeadInfo {
    private Builder builder;

    public static final class Builder {
        Map<String, String> signHeadInfo = new HashMap(4);

        public SignHeadInfo build() {
            return new SignHeadInfo(this);
        }

        public Builder buildWithHeadSigned(String str, String str2) {
            this.signHeadInfo.put(str, str2);
            return this;
        }
    }

    public SignHeadInfo(Builder builder) {
        this.builder = builder;
    }

    public String[] toStringArray() {
        StringBuffer stringBuffer = new StringBuffer("");
        StringBuffer stringBuffer2 = new StringBuffer("");
        for (Map.Entry<String, String> entry : this.builder.signHeadInfo.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(entry.getValue());
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            stringBuffer2.append(entry.getKey());
            stringBuffer2.append(";");
        }
        return new String[]{TextUtils.isEmpty(stringBuffer) ? "" : stringBuffer.substring(0, stringBuffer.length() - 1), TextUtils.isEmpty(stringBuffer2) ? "" : stringBuffer2.substring(0, stringBuffer2.length() - 1)};
    }
}

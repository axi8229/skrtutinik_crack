package com.huawei.location.lite.common.http.interceptor;

import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class BaseCommonInterceptor implements InterceptorAdapter {
    private void addCommonHeads(BaseRequest.Builder builder) {
        addHead(builder, "X-Device-Type", Integer.toString(DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext())));
        addHead(builder, "X-PhoneModel", DeviceInfoUtil.getDeviceModel());
    }

    protected static String getUserAgent() {
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = property.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public abstract void addCustomHeads(BaseRequest.Builder builder);

    public abstract void addCustomQuery(BaseRequest.Builder builder);

    void addHead(BaseRequest.Builder builder, String str, String str2) {
        try {
            builder.addHeader(str, str2);
        } catch (IllegalArgumentException | NullPointerException unused) {
            LogLocation.d("CommonHeadsInterceptor", "add head failed : key or value is null or illegal");
        }
    }

    @Override // com.huawei.location.lite.common.http.adapter.InterceptorAdapter
    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws OnErrorException, OnFailureException, IOException {
        BaseRequest.Builder builderNewBuilder = chain.request().newBuilder();
        addCommonHeads(builderNewBuilder);
        addCustomHeads(builderNewBuilder);
        addCustomQuery(builderNewBuilder);
        return chain.proceed(builderNewBuilder.build());
    }
}

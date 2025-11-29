package com.huawei.location.lite.common.http.interceptor;

import android.text.TextUtils;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.sign.SignHeadInfo;
import com.huawei.location.lite.common.http.sign.SignRequest;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public abstract class BaseAuthInterceptor implements InterceptorAdapter {
    protected BaseRequest auth(BaseRequest baseRequest) throws IOException {
        LogLocation.d("authorization", "auth request start...");
        String str = new String(baseRequest.getBody(), StandardCharsets.UTF_8);
        String str2 = baseRequest.getHeads().get("X-Request-ID");
        String str3 = baseRequest.getHeads().get("X-CP-Info");
        SignRequest.Builder builderQuery = new SignRequest.Builder(baseRequest.getMethod(), baseRequest.getBaseUrl(), baseRequest.getPath(), str2).payLoad(str).query(baseRequest.getQueryString());
        SignHeadInfo.Builder builder = new SignHeadInfo.Builder();
        if (!TextUtils.isEmpty(str3)) {
            builder.buildWithHeadSigned("X-CP-Info", str3);
        }
        builderQuery.headSigned(builder.build().toStringArray());
        return sign(baseRequest, builderQuery.build());
    }

    public abstract BaseRequest sign(BaseRequest baseRequest, SignRequest signRequest) throws IOException;
}

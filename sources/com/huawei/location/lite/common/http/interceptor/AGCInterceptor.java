package com.huawei.location.lite.common.http.interceptor;

import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.agc.yn;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;

/* loaded from: classes3.dex */
public class AGCInterceptor implements InterceptorAdapter {
    private BaseRequest addHeader(BaseRequest baseRequest) {
        yn agcInfo = AGCManager.getInstance().getAgcInfo();
        return agcInfo == null ? baseRequest : baseRequest.newBuilder().addHeader("expireTime", String.valueOf(agcInfo.yn())).addHeader("token", agcInfo.Vw()).build();
    }

    @Override // com.huawei.location.lite.common.http.adapter.InterceptorAdapter
    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws OnErrorException, OnFailureException, IOException {
        return chain.proceed(addHeader(chain.request()));
    }
}

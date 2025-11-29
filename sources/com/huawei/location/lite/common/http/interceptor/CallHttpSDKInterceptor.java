package com.huawei.location.lite.common.http.interceptor;

import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.RealInterceptorChain;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.IOException;

/* loaded from: classes3.dex */
public class CallHttpSDKInterceptor implements InterceptorAdapter {
    @Override // com.huawei.location.lite.common.http.adapter.InterceptorAdapter
    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws OnErrorException, OnFailureException, IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LogLocation.d("CallHttpSDKInterceptor", "RequestTask execute start");
        ResponseAdapter responseAdapterExecute = ((RealInterceptorChain) chain).getRequestTask().execute(chain.request());
        if (responseAdapterExecute == null) {
            return null;
        }
        return responseAdapterExecute.newBuilder().sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
    }
}

package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class RealInterceptorChain implements InterceptorAdapter.Chain {
    private IHttpClient httpClient;
    private int index;
    private List<InterceptorAdapter> interceptors;
    private BaseRequest request;
    private IHttpSDKRequestTask requestTask;

    public RealInterceptorChain(IHttpClient iHttpClient, BaseRequest baseRequest, List<InterceptorAdapter> list, int i, IHttpSDKRequestTask iHttpSDKRequestTask) {
        this.httpClient = iHttpClient;
        this.request = baseRequest;
        this.interceptors = list;
        this.index = i;
        this.requestTask = iHttpSDKRequestTask;
    }

    public IHttpSDKRequestTask getRequestTask() {
        return this.requestTask;
    }

    @Override // com.huawei.location.lite.common.http.adapter.InterceptorAdapter.Chain
    public ResponseAdapter proceed(BaseRequest baseRequest) throws OnErrorException, OnFailureException, IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        ResponseAdapter responseAdapterIntercept = this.interceptors.get(this.index).intercept(new RealInterceptorChain(this.httpClient, baseRequest, this.interceptors, this.index + 1, this.requestTask));
        if (responseAdapterIntercept != null) {
            return responseAdapterIntercept;
        }
        throw new OnFailureException(ErrorCode.valueOf(10307));
    }

    @Override // com.huawei.location.lite.common.http.adapter.InterceptorAdapter.Chain
    public BaseRequest request() {
        return this.request;
    }
}

package com.huawei.location.lite.common.http;

import android.content.Context;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.http.adapter.HttpClientBuilder;
import com.huawei.location.lite.common.http.adapter.IHttpClient;
import com.huawei.location.lite.common.http.adapter.ISubmitAdapter;
import com.huawei.location.lite.common.http.request.BaseRequest;

/* loaded from: classes3.dex */
public class HttpClientEx {
    private final IHttpClient httpClient;

    public HttpClientEx() {
        this(ContextUtil.getContext(), new HttpClientBuilder());
    }

    public HttpClientEx(Context context) {
        this(context, new HttpClientBuilder());
    }

    public HttpClientEx(Context context, HttpClientBuilder httpClientBuilder) {
        HttpClientReal httpClientReal = new HttpClientReal(httpClientBuilder, context);
        this.httpClient = httpClientReal;
        httpClientReal.init();
    }

    public ISubmitAdapter newSubmit(BaseRequest baseRequest) {
        return new SubmitEx(baseRequest, this.httpClient);
    }
}

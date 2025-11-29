package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.exception.OnErrorException;
import java.util.List;

/* loaded from: classes3.dex */
public interface IHttpClient {
    List<InterceptorAdapter> getInterceptors();

    void init();

    IHttpSDKRequestTask newRequestTask() throws OnErrorException;
}

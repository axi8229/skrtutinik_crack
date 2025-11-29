package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface InterceptorAdapter {

    public interface Chain {
        ResponseAdapter proceed(BaseRequest baseRequest) throws OnErrorException, OnFailureException, IOException;

        BaseRequest request();
    }

    ResponseAdapter intercept(Chain chain) throws OnErrorException, OnFailureException, IOException;
}

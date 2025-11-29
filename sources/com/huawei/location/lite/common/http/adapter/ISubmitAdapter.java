package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.response.BaseResponse;

/* loaded from: classes3.dex */
public interface ISubmitAdapter {
    <T extends BaseResponse> T execute(Class<T> cls) throws OnErrorException, OnFailureException;

    byte[] executeOriginal() throws OnErrorException, OnFailureException;
}

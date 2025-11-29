package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;

/* loaded from: classes3.dex */
public interface r1 {
    @t1
    <TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> Task<TResult> a(HuaweiApi<TOption> huaweiApi, TaskApiCall<TClient, TResult> taskApiCall, AbstractClientBuilder<TClient, TOption> abstractClientBuilder);
}

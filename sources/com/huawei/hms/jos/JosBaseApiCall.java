package com.huawei.hms.jos;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.jos.JosHmsClient;
import com.huawei.hms.jos.util.Utils;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes3.dex */
public abstract class JosBaseApiCall<K extends JosHmsClient, T> extends TaskApiCall<K, T> {
    public JosBaseApiCall(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    protected void doCommonFailed(TaskCompletionSource<T> taskCompletionSource) {
        taskCompletionSource.setException(new ApiException(new Status(7001)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(K k, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<T> taskCompletionSource) {
        HMSLog.i("JosBaseApiCall", JosBaseApiCall.class.getName() + " onResult: " + responseErrorCode.getErrorCode());
        if (responseErrorCode.getStatusCode() == 0 && responseErrorCode.getErrorCode() == 0) {
            doExecuteSuccess(responseErrorCode, str, taskCompletionSource);
        } else {
            doExecuteFailed(responseErrorCode, taskCompletionSource);
        }
        reportExit(k, responseErrorCode);
    }

    protected void doExecuteFailed(ResponseErrorCode responseErrorCode, TaskCompletionSource<T> taskCompletionSource) {
        taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    protected abstract void doExecuteSuccess(ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<T> taskCompletionSource);

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return super.getApiLevel();
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 30000000;
    }

    protected void reportExit(K k, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(k.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), Utils.getSDKVersionCode(k.getContext()));
    }
}

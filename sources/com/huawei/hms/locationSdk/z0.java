package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.GsonUtil;

/* loaded from: classes3.dex */
public class z0 extends n0<s, OfflineLocationResponse> {
    public z0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<OfflineLocationResponse> taskCompletionSource) throws ApiException {
        try {
            HMSLocationLog.i("GetOfflineLocationTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, responseErrorCode.getErrorCode() == 0 ? (OfflineLocationResponse) GsonUtil.getInstance().fromJson(str, OfflineLocationResponse.class) : null);
        } catch (ApiException e) {
            HMSLocationLog.e("GetOfflineLocationTaskApiCall", ((n0) this).a, "get last location doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            HMSLocationLog.e("GetOfflineLocationTaskApiCall", ((n0) this).a, "get last location doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 7;
    }
}

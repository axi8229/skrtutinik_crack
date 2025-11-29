package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.LocationSceneResponse;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.enhance.LocationSceneApiResponse;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.GsonUtil;

/* loaded from: classes3.dex */
public class x0 extends n0<t, LocationSceneResponse> {
    public x0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(t tVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<LocationSceneResponse> taskCompletionSource) throws ApiException {
        try {
            HMSLocationLog.i("GetLocationSceneResponseTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            LocationSceneApiResponse locationSceneApiResponse = responseErrorCode.getErrorCode() == 0 ? (LocationSceneApiResponse) GsonUtil.getInstance().fromJson(str, LocationSceneApiResponse.class) : null;
            if (locationSceneApiResponse != null) {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, locationSceneApiResponse.getLocationSceneResponse());
            } else {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
            }
        } catch (ApiException e) {
            HMSLocationLog.e("GetLocationSceneResponseTaskApiCall", ((n0) this).a, "get last location doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            HMSLocationLog.e("GetLocationSceneResponseTaskApiCall", ((n0) this).a, "get last location doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 9;
    }
}

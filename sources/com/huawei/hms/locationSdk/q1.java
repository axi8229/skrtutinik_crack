package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.RoadDataResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.GsonUtil;

/* loaded from: classes3.dex */
public class q1 extends n0<t, RoadDataResult> {
    public q1(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(t tVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<RoadDataResult> taskCompletionSource) throws ApiException {
        try {
            HMSLocationLog.i("SetRoadDataTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            int errorCode = responseErrorCode.getErrorCode();
            HMSLocationLog.i("SetRoadDataTaskApiCall", ((n0) this).a, "SetRoadDataTaskApiCall message start");
            RoadDataResult roadDataResult = new RoadDataResult();
            if (errorCode == 0) {
                roadDataResult = (RoadDataResult) GsonUtil.getInstance().fromJson(str, RoadDataResult.class);
            }
            roadDataResult.setStatus(new Status(errorCode));
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, roadDataResult);
            HMSLocationLog.d("SetRoadDataTaskApiCall", ((n0) this).a, "SetRoadData message success");
        } catch (ApiException e) {
            HMSLocationLog.e("SetRoadDataTaskApiCall", ((n0) this).a, "SetRoadData doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            HMSLocationLog.e("SetRoadDataTaskApiCall", ((n0) this).a, "SetRoadData doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}

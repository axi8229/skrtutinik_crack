package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.locationavailability.GetLocationAvailabilityResponse;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes3.dex */
public class w0 extends n0<s, LocationAvailability> {
    public w0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<LocationAvailability> taskCompletionSource) throws ApiException {
        LocationAvailability locationAvailability;
        try {
            HMSLocationLog.i("GetLocationAvailabilityTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                GetLocationAvailabilityResponse getLocationAvailabilityResponse = new GetLocationAvailabilityResponse();
                JsonUtil.jsonToEntity(str, getLocationAvailabilityResponse);
                locationAvailability = getLocationAvailabilityResponse.getLocationAvailability();
            } else {
                locationAvailability = null;
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, locationAvailability);
        } catch (Exception unused) {
            HMSLocationLog.e("GetLocationAvailabilityTaskApiCall", ((n0) this).a, "doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}

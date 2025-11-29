package com.huawei.location;

import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.locationavailability.GetLocationAvailabilityResponse;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;

/* loaded from: classes3.dex */
public class GetAvailabilityTaskCall extends BaseApiRequest {
    private static final String TAG = "GetLocationAvailabilityApi";

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        LogLocation.i(TAG, "onRequest GetAvailabilityTaskCall");
        com.huawei.location.logic.LW lwYn = com.huawei.location.logic.LW.yn();
        lwYn.getClass();
        LocationAvailability locationAvailability = new LocationAvailability();
        if (lwYn.Vw() != null) {
            LogLocation.i("HwLocationManager", "get last location successful");
            locationAvailability.setLocationStatus(0);
        } else {
            LogLocation.e("HwLocationManager", "get last location failed");
            locationAvailability.setLocationStatus(1001);
        }
        StatusInfo statusInfo = new StatusInfo(0, 0, "");
        GetLocationAvailabilityResponse getLocationAvailabilityResponse = new GetLocationAvailabilityResponse();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest();
        com.huawei.location.utils.yn.yn(str, locationBaseRequest);
        getLocationAvailabilityResponse.setLocationAvailability(locationAvailability);
        doExecute(new RouterResponse(com.huawei.location.utils.yn.Vw(getLocationAvailabilityResponse), statusInfo));
        this.errorCode = String.valueOf(0);
        this.reportBuilder.yn("Location_getLocationAvailability");
        this.reportBuilder.yn(locationBaseRequest);
        this.reportBuilder.yn().yn(this.errorCode);
    }
}

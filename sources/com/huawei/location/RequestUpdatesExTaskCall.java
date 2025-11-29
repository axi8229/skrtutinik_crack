package com.huawei.location;

import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.callback.oc;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;

/* loaded from: classes3.dex */
public class RequestUpdatesExTaskCall extends BaseApiRequest {
    private static final String TAG = "RequestLocationUpdatesExAPI";
    private oc hwLocationCallback = new yn();

    class yn implements oc {
        yn() {
        }

        @Override // com.huawei.location.callback.oc
        public void yn() {
            RequestUpdatesExTaskCall.this.onComplete(new RouterResponse(GsonUtil.getInstance().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, 0, "success")));
        }

        @Override // com.huawei.location.callback.oc
        public void yn(RouterResponse routerResponse) {
            RequestUpdatesExTaskCall.this.doExecute(routerResponse);
        }
    }

    private boolean checkNeedOffLineLocation(LocationRequest locationRequest) {
        LogLocation.i(TAG, "checkNeedOffLineLocation Ex");
        if (!agcFail()) {
            return true;
        }
        if (locationRequest.getPriority() == 100 || locationRequest.getPriority() == 200) {
            LogLocation.i(TAG, "agc fail ,but use offLine Ex");
            return true;
        }
        RouterResponse routerResponse = new RouterResponse("", new StatusInfo(0, LocationStatusCode.AGC_CHECK_FAIL, LocationStatusCode.getStatusCodeString(LocationStatusCode.AGC_CHECK_FAIL)));
        if (getRouterCallback() != null) {
            getRouterCallback().onComplete(routerResponse);
        }
        return false;
    }

    private void checkRequest(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        if (requestLocationUpdatesRequest.getLocationRequest() == null) {
            LogLocation.e(TAG, "locationRequest is invalid");
            throw new LocationServiceException(10000, LocationStatusCode.getStatusCodeString(10000));
        }
        if (!com.huawei.location.activity.model.Vw.FB(requestLocationUpdatesRequest.getLocationRequest().getPriority())) {
            LogLocation.i(TAG, "request is invalid");
            throw new LocationServiceException(10101, LocationStatusCode.getStatusCodeString(10101));
        }
        LogLocation.i(TAG, "onRequest，tid is " + requestLocationUpdatesRequest.getTid() + ", packageName is " + requestLocationUpdatesRequest.getPackageName() + ", uuid is " + requestLocationUpdatesRequest.getUuid() + ", locationRequest is " + requestLocationUpdatesRequest.getLocationRequest().getPriority());
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        LogLocation.i(TAG, "RequestLocationUpdatesExAPI begin");
        RequestLocationUpdatesRequest requestLocationUpdatesRequest = new RequestLocationUpdatesRequest();
        this.apiName = "Location_requestLocationUpdatesEx";
        try {
            com.huawei.location.utils.yn.yn(str, requestLocationUpdatesRequest);
            checkRequest(requestLocationUpdatesRequest);
            checkApproximatelyPermission();
        } catch (LocationServiceException e) {
            this.errorCode = String.valueOf(e.getExceptionCode());
            onRequestFail(e.getExceptionCode(), e.getMessage());
        } catch (Exception unused) {
            this.errorCode = String.valueOf(10000);
            onRequestFail(10000, LocationStatusCode.getStatusCodeString(10000));
        }
        if (checkNeedOffLineLocation(requestLocationUpdatesRequest.getLocationRequest())) {
            boolean zYn = com.huawei.location.cache.yn.Vw().yn(requestLocationUpdatesRequest.getUuid());
            com.huawei.location.logic.LW.yn().FB(new com.huawei.location.cache.Vw(requestLocationUpdatesRequest), this.hwLocationCallback);
            this.reportBuilder.Vw();
            this.reportBuilder.yn(requestLocationUpdatesRequest.getLocationRequest(), zYn);
            report(requestLocationUpdatesRequest);
        }
    }
}

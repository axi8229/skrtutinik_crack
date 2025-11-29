package com.huawei.location;

import android.location.Location;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationRequest;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GetLastLocationTaskCall extends BaseApiRequest {
    private static final String TAG = "GetLastLocationApi";

    private String buildRpt(GetLastLocationRequest getLastLocationRequest) throws JSONException {
        LogLocation.i(TAG, "buildRpt:" + GsonUtil.getInstance().toJson(getLastLocationRequest));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("needAddress", getLastLocationRequest.getNeedAddress());
            return jSONObject.toString();
        } catch (JSONException unused) {
            LogLocation.e(TAG, "buildRpt failed by exception");
            return "";
        }
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        LogLocation.i(TAG, "onRequest GetLastLocationTaskCall");
        GetLastLocationRequest getLastLocationRequest = new GetLastLocationRequest(ContextUtil.getContext());
        this.apiName = "Location_getLocation";
        try {
            checkApproximatelyPermission();
            Location locationVw = com.huawei.location.logic.LW.yn().Vw();
            StatusInfo statusInfo = new StatusInfo(0, 0, "");
            GetLastLocationResponse getLastLocationResponse = new GetLastLocationResponse();
            com.huawei.location.utils.yn.yn(str, getLastLocationRequest);
            getLastLocationResponse.setLocation(locationVw);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = com.huawei.location.activity.model.Vw.yn(getLastLocationResponse.getLocation());
            } catch (JSONException unused) {
                LogLocation.e("LocationInnerUtil", "buildEntityFromResponse get jsonException .");
            }
            doExecute(new RouterResponse(jSONObject.toString(), statusInfo));
            this.reportBuilder.Vw(buildRpt(getLastLocationRequest));
        } catch (LocationServiceException e) {
            this.errorCode = String.valueOf(e.getExceptionCode());
            onRequestFail(e.getExceptionCode(), e.getMessage());
        } catch (Exception unused2) {
            this.errorCode = String.valueOf(10000);
            onRequestFail(10000, LocationStatusCode.getStatusCodeString(10000));
        }
        report(getLastLocationRequest);
    }
}

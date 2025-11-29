package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LocationSettingsResult;
import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class o0 extends n0<s, LocationSettingsResponse> {
    public o0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<LocationSettingsResponse> taskCompletionSource) throws ApiException, JSONException {
        LocationSettingsResponse locationSettingsResponse;
        Status status;
        try {
            HMSLocationLog.i("CheckLocationSettingsTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            Status status2 = null;
            LocationSettingsStates locationSettingsStates = null;
            if (responseErrorCode.getErrorCode() == 0) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("statusCheck")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("statusCheck");
                    Parcelable parcelable = responseErrorCode.getParcelable();
                    status = new Status(jSONObject2.has(HiAnalyticsConstant.HaKey.BI_KEY_RESULT) ? jSONObject2.getInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT) : -100, jSONObject2.has("statusMessage") ? jSONObject2.getString("statusMessage") : "", (parcelable == null || !(parcelable instanceof PendingIntent)) ? null : (PendingIntent) parcelable);
                } else {
                    status = null;
                }
                if (jSONObject.has("locationSettingsStates")) {
                    locationSettingsStates = new LocationSettingsStates();
                    JsonUtil.jsonToEntity(jSONObject.getJSONObject("locationSettingsStates").toString(), locationSettingsStates);
                    locationSettingsStates.setGnssPresent(locationSettingsStates.isGpsPresent());
                    locationSettingsStates.setGnssUsable(locationSettingsStates.isGpsUsable());
                }
                LocationSettingsResult locationSettingsResult = new LocationSettingsResult();
                locationSettingsResult.setLocationSettingsStates(locationSettingsStates);
                locationSettingsResult.setStatus(status);
                locationSettingsResponse = new LocationSettingsResponse(locationSettingsResult);
                status2 = status;
            } else {
                locationSettingsResponse = null;
            }
            if (status2 == null || status2.getStatusCode() != 6) {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, locationSettingsResponse);
            } else {
                taskCompletionSource.setException(new ResolvableApiException(status2));
            }
        } catch (Exception unused) {
            HMSLocationLog.e("CheckLocationSettingsTaskApiCall", ((n0) this).a, "doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}

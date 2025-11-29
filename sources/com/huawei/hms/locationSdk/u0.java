package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.coordinateconverter.CoordinateUtil;
import com.huawei.location.lite.common.util.coordinateconverter.LatLon;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class u0 extends n0<s, HWLocation> {
    private int b;

    public u0(String str, String str2, String str3, String str4, int i) {
        super(str, str2, str3, str4);
        this.b = i;
    }

    private void a(HWLocation hWLocation) {
        int i = this.b;
        if (1 != i) {
            if (i == 0) {
                LogLocation.d("GetLastLocationTaskApiCall", "ConvertCoord-- current coordinateType is 0 --no conversion");
                return;
            } else {
                HMSLocationLog.i("GetLastLocationTaskApiCall", ((n0) this).a, "ConvertCoord-- current coordinateType is unKnown --return 84");
                return;
            }
        }
        Map<String, Object> extraInfo = hWLocation.getExtraInfo();
        if (extraInfo.containsKey("SourceType") && a(((Integer) extraInfo.get("SourceType")).intValue())) {
            HMSLocationLog.i("GetLastLocationTaskApiCall", ((n0) this).a, "RTK position, no conversion required");
            return;
        }
        LatLon latLonConvertCoord = CoordinateUtil.convertCoord(hWLocation.getLatitude(), hWLocation.getLongitude(), 1);
        if (latLonConvertCoord == null) {
            hWLocation.setCoordinateType(0);
            HMSLocationLog.e("GetLastLocationTaskApiCall", ((n0) this).a, "ConvertCoord-- result is null,reset the coordinateType to 0");
        } else {
            hWLocation.setCoordinateType(1);
            hWLocation.setLatitude(latLonConvertCoord.getLatitude());
            hWLocation.setLongitude(latLonConvertCoord.getLongitude());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<HWLocation> taskCompletionSource) throws ApiException {
        HWLocation locationFromJsonObject;
        try {
            HMSLocationLog.i("GetLastLocationTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                locationFromJsonObject = LocationJsonUtil.parseLocationFromJsonObject(new JSONObject(str));
                if (locationFromJsonObject != null) {
                    a(locationFromJsonObject);
                }
            } else {
                locationFromJsonObject = null;
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, locationFromJsonObject);
        } catch (ApiException e) {
            HMSLocationLog.e("GetLastLocationTaskApiCall", ((n0) this).a, "get last locationEn doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            HMSLocationLog.e("GetLastLocationTaskApiCall", ((n0) this).a, "get last locationEn doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40000000;
    }
}

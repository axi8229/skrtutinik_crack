package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.GetFromLocationNameRequest;
import com.huawei.hms.location.GetFromLocationRequest;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.geocoder.GeocoderRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class n extends HuaweiApi<w> implements l {
    private static final m c = new m();
    private static final Api<w> d = new Api<>("HmsLocation.API");
    private r1 a;
    private Locale b;

    public n(Activity activity, Locale locale, w wVar) {
        super(activity, d, wVar, (AbstractClientBuilder) c);
        this.b = locale;
    }

    public n(Context context, Locale locale, w wVar) {
        super(context, d, wVar, c);
        this.b = locale;
    }

    private boolean b(GetFromLocationNameRequest getFromLocationNameRequest) {
        boolean z = getFromLocationNameRequest.getLowerLeftLatitude() < -90.0d || getFromLocationNameRequest.getLowerLeftLatitude() > 90.0d;
        boolean z2 = getFromLocationNameRequest.getLowerLeftLongitude() < -180.0d || getFromLocationNameRequest.getLowerLeftLongitude() > 180.0d;
        boolean z3 = getFromLocationNameRequest.getUpperRightLatitude() < -90.0d || getFromLocationNameRequest.getUpperRightLatitude() > 90.0d;
        if (!z && !z2 && !z3) {
            boolean z4 = getFromLocationNameRequest.getUpperRightLongitude() < -180.0d || getFromLocationNameRequest.getUpperRightLongitude() > 180.0d;
            boolean z5 = getFromLocationNameRequest.getMaxResults() < 0;
            if (!z4 && !z5) {
                return false;
            }
        }
        return true;
    }

    private boolean b(GetFromLocationRequest getFromLocationRequest) {
        boolean z = getFromLocationRequest.getLatitude() < -90.0d || getFromLocationRequest.getLatitude() > 90.0d;
        boolean z2 = getFromLocationRequest.getLongitude() < -180.0d || getFromLocationRequest.getLongitude() > 180.0d;
        boolean z3 = getFromLocationRequest.getMaxResults() < 0;
        LogLocation.i("LocationGeocoderClientImpl", "isValidReversesRequest latitudeState = " + z + ",longitudeState = " + z2 + ",maxState = " + z3);
        return z || z2 || z3;
    }

    @Override // com.huawei.hms.locationSdk.l
    public Task<List<HWLocation>> a(GetFromLocationNameRequest getFromLocationNameRequest) {
        ApiException apiException;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (getFromLocationNameRequest == null || getFromLocationNameRequest.getLocationName() == null || getFromLocationNameRequest.getLocationName().isEmpty()) {
            apiException = new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        } else if (b(getFromLocationNameRequest)) {
            apiException = new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        } else {
            LogLocation.i("LocationGeocoderClientImpl", "getFromLocationName checkParams success");
            GeocoderRequest geocoderRequest = new GeocoderRequest(getContext(), getFromLocationNameRequest.getLocationName(), getFromLocationNameRequest.getMaxResults());
            geocoderRequest.setLowerLeftLatitude(getFromLocationNameRequest.getLowerLeftLatitude());
            geocoderRequest.setLowerLeftLongitude(getFromLocationNameRequest.getLowerLeftLongitude());
            geocoderRequest.setUpperRightLatitude(getFromLocationNameRequest.getUpperRightLatitude());
            geocoderRequest.setUpperRightLongitude(getFromLocationNameRequest.getUpperRightLongitude());
            Locale locale = this.b;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            geocoderRequest.setLanguage(locale.getLanguage());
            Locale locale2 = this.b;
            if (locale2 == null) {
                locale2 = Locale.getDefault();
            }
            geocoderRequest.setCountry(locale2.getCountry());
            String tid = geocoderRequest.getTid();
            try {
                HMSLocationLog.i("LocationGeocoderClientImpl", tid, "getFromLocationName begin. Version Code = 61200300");
                String strCreateJsonString = JsonUtil.createJsonString(geocoderRequest);
                return doWrite(new r0(getContext(), LocationNaming.GET_FROM_LOCATION_NAME, strCreateJsonString, geocoderRequest.getTid(), ""));
            } catch (Exception unused) {
                HMSLocationLog.e("LocationGeocoderClientImpl", tid, "getFromLocationName exception");
                apiException = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
        }
        taskCompletionSource.setException(apiException);
        return taskCompletionSource.getTask();
    }

    @Override // com.huawei.hms.locationSdk.l
    public Task<List<HWLocation>> a(GetFromLocationRequest getFromLocationRequest) {
        ApiException apiException;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (getFromLocationRequest == null) {
            apiException = new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        } else if (b(getFromLocationRequest)) {
            apiException = new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        } else {
            LogLocation.i("LocationGeocoderClientImpl", "getFromLocation checkParams success");
            GeocoderRequest geocoderRequest = new GeocoderRequest(getContext(), getFromLocationRequest.getLatitude(), getFromLocationRequest.getLongitude(), getFromLocationRequest.getMaxResults());
            Locale locale = this.b;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            geocoderRequest.setLanguage(locale.getLanguage());
            Locale locale2 = this.b;
            if (locale2 == null) {
                locale2 = Locale.getDefault();
            }
            geocoderRequest.setCountry(locale2.getCountry());
            String tid = geocoderRequest.getTid();
            try {
                HMSLocationLog.i("LocationGeocoderClientImpl", tid, "getFromLocation begin. Version Code = 61200300");
                String strCreateJsonString = JsonUtil.createJsonString(geocoderRequest);
                return doWrite(new s0(getContext(), LocationNaming.GET_FROM_LOCATION, strCreateJsonString, geocoderRequest.getTid(), ""));
            } catch (Exception unused) {
                HMSLocationLog.e("LocationGeocoderClientImpl", tid, "getFromLocation exception");
                apiException = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
        }
        taskCompletionSource.setException(apiException);
        return taskCompletionSource.getTask();
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        r1 r1Var;
        if (this.a == null) {
            Object objA = u1.a(getContext(), new v1());
            if (objA instanceof r1) {
                this.a = (r1) objA;
            }
        }
        return (v1.a(getContext()) || (r1Var = this.a) == null) ? super.doWrite(taskApiCall) : r1Var.a(this, taskApiCall, c);
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 5;
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getKitSdkVersion() {
        return 61200300;
    }
}

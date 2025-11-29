package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.checksettings.CheckLocationSettingsRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationRequest;
import com.huawei.hms.support.api.entity.location.mock.SetMockLocationRequest;
import com.huawei.hms.support.api.entity.location.mock.SetMockModeRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.entity.location.updates.RemoveLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.logwrite.LogWriteApi;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.req.BackgroundReq;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h extends HuaweiApi<w> implements f {
    private static final g b = new g();
    private static final Api<w> c = new Api<>("HmsLocation.API");
    private r1 a;

    public h(Activity activity, w wVar) {
        super(activity, c, wVar, (AbstractClientBuilder) b);
        c(activity);
    }

    public h(Context context, w wVar) {
        super(context, c, wVar, b);
        c(context);
    }

    private Task<Void> a(LocationCallback locationCallback, PendingIntent pendingIntent, String str) {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RemoveLocationUpdatesRequest removeLocationUpdatesRequest = new RemoveLocationUpdatesRequest(getContext());
        String tid = removeLocationUpdatesRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, str + " removeLocationUpdates  begin");
            return doWrite(LocationRequestHelper.createRemoveTaskApiCall(locationCallback, pendingIntent, str, tid, removeLocationUpdatesRequest));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationClientImpl", tid, str + " remove location updates api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, str + " remove location updates exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    private Task<Void> a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper, PendingIntent pendingIntent, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestLocationUpdatesRequest requestLocationUpdatesRequest = new RequestLocationUpdatesRequest(getContext());
        String tid = requestLocationUpdatesRequest.getTid();
        n0 n0VarCreateRequestApiCall = null;
        try {
            HMSLocationLog.i("LocationClientImpl", tid, str + " requestLocationUpdates begin");
            n0VarCreateRequestApiCall = LocationRequestHelper.createRequestApiCall(str, locationRequest, locationCallback, looper, pendingIntent, requestLocationUpdatesRequest);
            try {
                return doWrite(n0VarCreateRequestApiCall);
            } catch (ApiException e) {
                e = e;
                if (n0VarCreateRequestApiCall != null) {
                    n0VarCreateRequestApiCall.a(true);
                }
                HMSLocationLog.e("LocationClientImpl", tid, str + " requestLocationUpdates api exception" + e.getMessage());
                LocationRequestHelper.reportRequest(tid, e.getStatusCode(), e.getStatusMessage(), LocationRequestHelper.getCpTid(locationRequest));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("LocationClientImpl", tid, str + " requestLocationUpdates exception");
                if (n0VarCreateRequestApiCall != null) {
                    n0VarCreateRequestApiCall.a(true);
                }
                LocationRequestHelper.reportRequest(tid, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(locationRequest));
                taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
                return taskCompletionSource.getTask();
            }
        } catch (ApiException e2) {
            e = e2;
        } catch (Exception unused2) {
        }
    }

    private void b(LocationRequest locationRequest) throws ApiException {
        if (locationRequest.getCoordinateType() != 0 && locationRequest.getCoordinateType() != 1) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
    }

    private void c(Context context) {
        ContextUtil.setContext(context);
        Tracker.getInstance().init();
    }

    private void e() throws ApiException {
        if (!PermissionUtil.isLocationPermissionAvailable(getContext())) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED))));
        return taskCompletionSource.getTask();
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(int i, Notification notification) throws ApiException {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (v1.a(getContext())) {
            e = new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED)));
        } else {
            BackgroundReq backgroundReq = new BackgroundReq(getContext());
            String tid = backgroundReq.getTid();
            try {
                HMSLocationLog.i("LocationClientImpl", tid, "enableBackgroundLocation");
                if (i == 0) {
                    throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                }
                if (notification == null) {
                    throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
                }
                if (Build.VERSION.SDK_INT >= 28 && !PermissionUtil.isPermissionAvailable(getContext(), "android.permission.FOREGROUND_SERVICE")) {
                    throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
                }
                backgroundReq.setNotificationId(i);
                q0 q0Var = new q0("location.enableBackgroundLocation", JsonUtil.createJsonString(backgroundReq), tid);
                q0Var.setParcelable(notification);
                return doWrite(q0Var);
            } catch (ApiException e) {
                e = e;
                HMSLocationLog.e("LocationClientImpl", tid, "enable background location api exception:" + e.getMessage());
            }
        }
        taskCompletionSource.setException(e);
        return taskCompletionSource.getTask();
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(PendingIntent pendingIntent) {
        return a((LocationCallback) null, pendingIntent, "Intent");
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(Location location) throws ApiException, JSONException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        SetMockLocationRequest setMockLocationRequest = new SetMockLocationRequest(getContext());
        String tid = setMockLocationRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "set mock location begin");
            if (location == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            if (!PermissionUtil.isLocationPermissionAvailable(getContext()) || !PermissionUtil.canAccessMockLocation(getContext().getPackageName(), getContext())) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            setMockLocationRequest.setPackageName(getContext().getPackageName());
            setMockLocationRequest.setMockLocation(location);
            JSONObject jSONObjectCreateLocationJsonObject = LocationJsonUtil.createLocationJsonObject(setMockLocationRequest.getMockLocation());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mockLocation", jSONObjectCreateLocationJsonObject);
            jSONObject.put("packageName", setMockLocationRequest.getPackageName());
            jSONObject.put("locTransactionId", setMockLocationRequest.getTid());
            return doWrite(new o1("location.setMockLocation", jSONObject.toString(), tid));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationClientImpl", tid, "set mock location api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "set mock location exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(LocationCallback locationCallback) {
        return a(locationCallback, (PendingIntent) null, "NORMAL Callback");
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<HWLocation> a(LocationRequest locationRequest) {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetLastLocationRequest getLastLocationRequest = new GetLastLocationRequest(getContext(), locationRequest.getNeedAddress(), locationRequest.getLanguage(), locationRequest.getCountryCode());
        String tid = getLastLocationRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "get last location begin. Version Code = 61200300");
            e();
            b(locationRequest);
            return doWrite(new u0("location.getLastLocation", JsonUtil.createJsonString(getLastLocationRequest), getLastLocationRequest.getTid(), "", locationRequest.getCoordinateType()));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationClientImpl", tid, "get last location with address api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "get last location with address exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return a(locationRequest, null, null, pendingIntent, "Intent");
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return a(locationRequest, locationCallback, looper, null, "ExCallback");
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<LocationSettingsResponse> a(LocationSettingsRequest locationSettingsRequest) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        CheckLocationSettingsRequest checkLocationSettingsRequest = new CheckLocationSettingsRequest(getContext());
        String tid = checkLocationSettingsRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "checkLocationSettings");
            if (locationSettingsRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            checkLocationSettingsRequest.setLocationSettingsRequest(locationSettingsRequest);
            return doWrite(new o0("location.checkLocationSettings", JsonUtil.createJsonString(checkLocationSettingsRequest), tid));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationClientImpl", tid, "check location settings api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "check location settings exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(LogConfig logConfig) throws ApiException {
        ApiException e;
        String string = UUID.randomUUID().toString();
        HMSLocationLog.i("LocationClientImpl", string, "setLogConfig start");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            if (logConfig == null) {
                throw new ApiException(new Status(LocationStatusCode.ARGUMENTS_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY)));
            }
            HMSLocationLog.i("LocationClientImpl", string, "setLogConfig logConfig check");
            String logPath = logConfig.getLogPath();
            l0.a(getContext(), logPath, string);
            l0.a(logPath, string);
            LogWriteApi.init(l0.a(logConfig));
            if (l0.b()) {
                LogWriteApi.i("LocationClientImpl", l0.a(getContext()), null);
            }
            return taskCompletionSource.getTask();
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationClientImpl", string, "setLogConfig apiException");
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", string, "setLogConfig exception");
            e = new ApiException(new Status(LocationStatusCode.METHOD_INVOKE_ERROR, LocationStatusCode.getStatusCodeString(LocationStatusCode.METHOD_INVOKE_ERROR)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<OfflineLocationResponse> a(OfflineLocationRequest offlineLocationRequest) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (offlineLocationRequest != null) {
            try {
                if (offlineLocationRequest.getRequestDataList() != null && !offlineLocationRequest.getRequestDataList().isEmpty()) {
                    String tid = offlineLocationRequest.getTid();
                    HMSLocationLog.i("LocationClientImpl", tid, "getOfflineLocation begin. Version Code = 61200300");
                    e();
                    return doWrite(new z0(LocationNaming.GET_OFFLINE_LOCATION_NAME, GsonUtil.getInstance().toJson(offlineLocationRequest), tid));
                }
            } catch (ApiException e2) {
                e = e2;
                HMSLocationLog.e("LocationClientImpl", null, "getOfflineLocation api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("LocationClientImpl", null, "getOfflineLocation exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> a(boolean z) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        String tid = new LocationBaseRequest(getContext()).getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "set mock mode begin");
            if (!PermissionUtil.isLocationPermissionAvailable(getContext()) || !PermissionUtil.canAccessMockLocation(getContext().getPackageName(), getContext())) {
                HMSLocationLog.e("LocationClientImpl", tid, "setMockEnabled,Permission is false ");
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            SetMockModeRequest setMockModeRequest = new SetMockModeRequest(getContext());
            setMockModeRequest.setMockMode(z);
            return doWrite(new p1("location.setMockMode", JsonUtil.createJsonString(setMockModeRequest), tid));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationClientImpl", tid, "set mock mode api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "set mock mode exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<LocationAvailability> b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "get location availability begin");
            e();
            return doWrite(new w0("location.getLocationAvailability", JsonUtil.createJsonString(locationBaseRequest), tid));
        } catch (ApiException e) {
            HMSLocationLog.e("LocationClientImpl", tid, "getLocationAvailability ApiException:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "getLocationAvailability exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> b(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return a(locationRequest, locationCallback, looper, null, "NORMAL Callback");
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Void> c() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (v1.a(getContext())) {
            taskCompletionSource.setException(new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED))));
            return taskCompletionSource.getTask();
        }
        String tid = new BackgroundReq(getContext()).getTid();
        HMSLocationLog.i("LocationClientImpl", tid, "disableBackgroundLocation");
        return doWrite(new p0("location.disableBackgroundLocation", "", tid));
    }

    @Override // com.huawei.hms.locationSdk.f
    public Task<Location> d() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            HMSLocationLog.i("LocationClientImpl", tid, "get last location begin. Version Code = 61200300");
            e();
            return doWrite(new v0("location.getLastLocation", JsonUtil.createJsonString(locationBaseRequest), locationBaseRequest.getTid(), ""));
        } catch (ApiException e) {
            HMSLocationLog.e("LocationClientImpl", tid, "get last location api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationClientImpl", tid, "get last location exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
            return taskCompletionSource.getTask();
        }
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
        return (v1.a(getContext()) || (r1Var = this.a) == null) ? super.doWrite(taskApiCall) : r1Var.a(this, taskApiCall, b);
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getKitSdkVersion() {
        return 61200300;
    }
}

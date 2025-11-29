package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.LocationSceneRequest;
import com.huawei.hms.location.LocationSceneResponse;
import com.huawei.hms.location.NavigationRequest;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.location.RoadData;
import com.huawei.hms.location.RoadDataResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.enhance.LocationSceneApiRequest;
import com.huawei.hms.support.api.entity.location.enhance.RequestNavigationStateRequest;
import com.huawei.hms.support.api.entity.location.enhance.RequestReportLocationRequest;
import com.huawei.hms.support.api.entity.location.enhance.RoadDataRequest;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineRequest;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoRequest;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.StationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.StringUtil;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class k extends HuaweiApi<w> implements i {
    private static final j b = new j();
    private static final Api<w> c = new Api<>("HmsLocation.API");
    private r1 a;

    public k(Activity activity, w wVar) {
        super(activity, c, wVar, (AbstractClientBuilder) b);
    }

    public k(Context context, w wVar) {
        super(context, c, wVar, b);
    }

    private void a() throws ApiException {
        if (!PermissionUtil.isPermissionAvailable(getContext(), "android.permission.ACCESS_COARSE_LOCATION") && !PermissionUtil.isPermissionAvailable(getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    private void a(StationRequest stationRequest) throws ApiException {
        if (stationRequest == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(stationRequest.getAppId());
        arrayList.add(stationRequest.getProjectId());
        arrayList.add(stationRequest.getPkgName());
        arrayList.add(stationRequest.getType());
        arrayList.add(stationRequest.getOperation());
        if (StringUtil.isAnyBlank(arrayList)) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<Void> a(Location location, String str) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestReportLocationRequest requestReportLocationRequest = new RequestReportLocationRequest(getContext());
        String tid = requestReportLocationRequest.getTid();
        if (location != null && str != null) {
            try {
                if (!str.equals("")) {
                    requestReportLocationRequest.setReportType(str);
                    l1 l1Var = new l1("location.requestReportLocation", JsonUtil.createJsonString(requestReportLocationRequest), tid);
                    l1Var.setParcelable(location);
                    return doWrite(l1Var);
                }
            } catch (ApiException e2) {
                e = e2;
                HMSLocationLog.e("EnhanceClientImpl", tid, "requestReportLocation api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                HMSLocationLog.e("EnhanceClientImpl", tid, "requestReportLocation exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<LocationSceneResponse> a(LocationSceneRequest locationSceneRequest) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationSceneApiRequest locationSceneApiRequest = new LocationSceneApiRequest(getContext());
        String tid = locationSceneApiRequest.getTid();
        try {
            if (locationSceneRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            locationSceneApiRequest.setLocationSceneRequest(locationSceneRequest);
            return doWrite(new x0(LocationNaming.GET_LOCATION_SCENE_RESPONSE, GsonUtil.getInstance().toJson(locationSceneApiRequest), locationSceneApiRequest.getTid()));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("EnhanceClientImpl", tid, "setLocationSceneMode api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("EnhanceClientImpl", tid, "setLocationSceneMode exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<NavigationResult> a(NavigationRequest navigationRequest) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestNavigationStateRequest requestNavigationStateRequest = new RequestNavigationStateRequest(getContext());
        String tid = requestNavigationStateRequest.getTid();
        try {
            if (navigationRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            if (!PermissionUtil.isLocationPermissionAvailable(getContext())) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            requestNavigationStateRequest.setNavigationRequest(navigationRequest);
            return doWrite(new y0("location.getNavigationContextState", JsonUtil.createJsonString(requestNavigationStateRequest), requestNavigationStateRequest.getTid(), navigationRequest.getType()));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("EnhanceClientImpl", tid, "getNavigationState api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("EnhanceClientImpl", tid, "getNavigationState exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<RoadDataResult> a(RoadData roadData) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RoadDataRequest roadDataRequest = new RoadDataRequest(getContext());
        String tid = roadDataRequest.getTid();
        try {
            if (roadData == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            roadDataRequest.setRoadData(roadData);
            return doWrite(new q1(LocationNaming.SET_ROAD_DATA, GsonUtil.getInstance().toJson(roadDataRequest), roadDataRequest.getTid()));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("EnhanceClientImpl", tid, "setRoadData api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("EnhanceClientImpl", tid, "setRoadData exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<HistoryStationInfoResponse> a(String str) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        HistoryStationInfoRequest historyStationInfoRequest = new HistoryStationInfoRequest(getContext());
        String tid = historyStationInfoRequest.getTid();
        try {
            if (TextUtils.isEmpty(str)) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            a();
            historyStationInfoRequest.setTripId(str);
            return doWrite(new t0(LocationNaming.GET_HISTORY_STATION_INFO, GsonUtil.getInstance().toJson(historyStationInfoRequest), historyStationInfoRequest.getTid()));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("EnhanceClientImpl", tid, "getHistoryStationInfo api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("EnhanceClientImpl", tid, "getHistoryStationInfo exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<CityStationLineResponse> a(String str, String str2) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        CityStationLineRequest cityStationLineRequest = new CityStationLineRequest(getContext());
        String tid = cityStationLineRequest.getTid();
        try {
            if (TextUtils.isEmpty(str)) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            a();
            cityStationLineRequest.setCityCode(str);
            if (!TextUtils.isEmpty(str2)) {
                cityStationLineRequest.setStationType(str2);
            }
            return doWrite(new a1(LocationNaming.GET_STATION_LINE, GsonUtil.getInstance().toJson(cityStationLineRequest), cityStationLineRequest.getTid()));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("EnhanceClientImpl", tid, "getStationLines api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("EnhanceClientImpl", tid, "getStationLines exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<LocationSceneResponse> b(LocationSceneRequest locationSceneRequest) throws ApiException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationSceneApiRequest locationSceneApiRequest = new LocationSceneApiRequest(getContext());
        String tid = locationSceneApiRequest.getTid();
        try {
            if (locationSceneRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            locationSceneApiRequest.setLocationSceneRequest(locationSceneRequest);
            return doWrite(new n1(LocationNaming.SET_LOCATION_SCENE_MODE, GsonUtil.getInstance().toJson(locationSceneApiRequest), locationSceneApiRequest.getTid()));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("EnhanceClientImpl", tid, "setLocationSceneMode api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("EnhanceClientImpl", tid, "setLocationSceneMode exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.i
    public Task<Void> b(String str) throws ApiException, JSONException {
        ApiException e;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        String string = UUID.randomUUID().toString();
        try {
            if (StringUtil.isEmpty(str)) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            a((StationRequest) GsonUtil.getInstance().fromJson(str, StationRequest.class));
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("pkgName")) {
                String string2 = jSONObject.getString("pkgName");
                jSONObject.remove("pkgName");
                jSONObject.put("packageName", string2);
            }
            a();
            return doWrite(new m1(LocationNaming.REQUEST_STATION_NAME, jSONObject.toString(), string));
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("EnhanceClientImpl", string, "requestStationRecognition api exception" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (JSONException unused) {
            HMSLocationLog.e("EnhanceClientImpl", string, "requestStationRecognition JSONException");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused2) {
            HMSLocationLog.e("EnhanceClientImpl", string, "requestStationRecognition exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
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
    public int getApiLevel() {
        return 2;
    }
}

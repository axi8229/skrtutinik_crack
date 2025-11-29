package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.CommonStatusCodes;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.GeofenceRequest;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.fence.AddGeofencesRequest;
import com.huawei.hms.support.api.entity.location.fence.RemoveGeofencesRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import java.util.List;

/* loaded from: classes3.dex */
public class q extends HuaweiApi<w> implements o {
    private static final p b = new p();
    private static final Api<w> c = new Api<>("HmsLocation.API");
    private r1 a;

    public q(Activity activity, w wVar) {
        super(activity, c, wVar, (AbstractClientBuilder) b);
    }

    public q(Context context, w wVar) {
        super(context, c, wVar, b);
    }

    @Override // com.huawei.hms.locationSdk.o
    public Task<Void> a(PendingIntent pendingIntent) throws ApiException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            d1 d1Var = new d1("location.removeGeofences", JsonUtil.createJsonString(locationBaseRequest), tid);
            d1Var.setParcelable(pendingIntent);
            Task<Void> taskDoWrite = doWrite(d1Var);
            HMSLocationLog.i("LocationGeofenceClientImpl", tid, "removeGeofences sdk useTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return taskDoWrite;
        } catch (ApiException e) {
            HMSLocationLog.e("LocationGeofenceClientImpl", tid, "removeGeofences api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            HMSLocationLog.i("LocationGeofenceClientImpl", tid, "removeGeofences sdk useTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.o
    public Task<Void> a(GeofenceRequest geofenceRequest, PendingIntent pendingIntent) throws ApiException {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        AddGeofencesRequest addGeofencesRequest = new AddGeofencesRequest(getContext());
        String tid = addGeofencesRequest.getTid();
        try {
            if (geofenceRequest == null || pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            if (!PermissionUtil.isGeofencePermissionAvailable(getContext())) {
                throw new ApiException(new Status(10204, CommonStatusCodes.getStatusCodeString(10204)));
            }
            addGeofencesRequest.setGeofencingRequest(geofenceRequest);
            m0 m0Var = new m0("location.addGeofences", JsonUtil.createJsonString(addGeofencesRequest), tid);
            m0Var.setParcelable(pendingIntent);
            return doWrite(m0Var);
        } catch (ApiException e) {
            HMSLocationLog.e("LocationGeofenceClientImpl", tid, "addGeofences api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.o
    public Task<Void> a(List<String> list) throws ApiException {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RemoveGeofencesRequest removeGeofencesRequest = new RemoveGeofencesRequest(getContext());
        String tid = removeGeofencesRequest.getTid();
        if (list != null) {
            try {
                if (list.size() != 0) {
                    removeGeofencesRequest.setGeofenceRequestIds(list);
                    return doWrite(new d1("location.removeGeofences", JsonUtil.createJsonString(removeGeofencesRequest), tid));
                }
            } catch (ApiException e) {
                HMSLocationLog.e("LocationGeofenceClientImpl", tid, "removeGeofences api exception:" + e.getMessage());
                taskCompletionSource.setException(e);
                return taskCompletionSource.getTask();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
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

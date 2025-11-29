package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.ActivityConversionInfo;
import com.huawei.hms.location.ActivityConversionRequest;
import com.huawei.hms.location.ActivityIdentificationData;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.activityrecognition.RequestActivityConversionRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e extends HuaweiApi<w> implements c {
    private static final d b = new d();
    private static final Api<w> c = new Api<>("HmsLocation.API");
    private r1 a;

    public e(Activity activity, w wVar) {
        super(activity, c, wVar, (AbstractClientBuilder) b);
    }

    public e(Context context, w wVar) {
        super(context, c, wVar, b);
    }

    private void a(String str) throws ApiException {
        if (Build.VERSION.SDK_INT > 28) {
            if (PermissionUtil.isPermissionAvailable(getContext(), "android.permission.ACTIVITY_RECOGNITION")) {
                return;
            }
            HMSLocationLog.e("LocationArClientImpl", str, "android Q requestActivityUpdates isPermissionAvailable is false ");
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
        if (!v1.a(getContext()) || PermissionUtil.isPermissionAvailable(getContext(), "com.huawei.hms.permission.ACTIVITY_RECOGNITION")) {
            return;
        }
        HMSLocationLog.e("LocationArClientImpl", str, "requestActivityUpdates isPermissionAvailable is false ");
        throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
    }

    @Override // com.huawei.hms.locationSdk.c
    public Task<Void> a(long j, PendingIntent pendingIntent) throws ApiException, JSONException {
        ApiException e;
        String string = UUID.randomUUID().toString();
        HMSLocationLog.i("LocationArClientImpl", string, "createActivityIdentificationUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            a(string);
            if (j < 0) {
                throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
            }
            f0 f0Var = new f0();
            f0Var.a(pendingIntent);
            f0Var.a(string);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("detectionIntervalMillis", j);
            jSONObject.put("locTransactionId", string);
            jSONObject.put("packageName", getContext().getPackageName());
            g1 g1Var = new g1("location.requestActivityIdentificationUpdates", jSONObject.toString(), f0Var);
            g1Var.setParcelable(pendingIntent);
            return doWrite(g1Var);
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationArClientImpl", string, "createActivityIdentificationUpdates api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationArClientImpl", string, "createActivityIdentificationUpdates exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.c
    public Task<Void> a(PendingIntent pendingIntent) throws ApiException {
        ApiException e;
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        HMSLocationLog.i("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            f0 f0Var = new f0();
            f0Var.a(pendingIntent);
            f0 f0Var2 = (f0) g0.b().b(f0Var);
            if (f0Var2 != null) {
                HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates cannot find cache");
                tid = f0Var2.a();
            }
            locationBaseRequest.setTid(tid);
            f0Var.a(tid);
            c1 c1Var = new c1("location.removeActivityIdentificationUpdates", JsonUtil.createJsonString(locationBaseRequest), f0Var);
            c1Var.setParcelable(pendingIntent);
            return doWrite(c1Var);
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.c
    public Task<Void> a(ActivityConversionRequest activityConversionRequest, PendingIntent pendingIntent) throws ApiException {
        ApiException e;
        RequestActivityConversionRequest requestActivityConversionRequest = new RequestActivityConversionRequest(getContext());
        String tid = requestActivityConversionRequest.getTid();
        HMSLocationLog.i("LocationArClientImpl", tid, "createActivityConversionUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            if (activityConversionRequest == null || pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            a(tid);
            List<ActivityConversionInfo> activityConversions = activityConversionRequest.getActivityConversions();
            if (!CollectionsUtil.isEmpty(activityConversions)) {
                for (ActivityConversionInfo activityConversionInfo : activityConversions) {
                    int conversionType = activityConversionInfo.getConversionType();
                    int activityType = activityConversionInfo.getActivityType();
                    if (conversionType != 0 && conversionType != 1) {
                        throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                    }
                    if (!ActivityIdentificationData.isValidType(activityType)) {
                        throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                    }
                }
            }
            d0 d0Var = new d0();
            d0Var.a(pendingIntent);
            d0Var.a(tid);
            requestActivityConversionRequest.setActivityConversions(activityConversionRequest.getActivityConversions());
            f1 f1Var = new f1("location.requestActivityConversionUpdates", v1.a(getContext()) ? JsonUtil.createJsonString(requestActivityConversionRequest) : GsonUtil.getInstance().toJson(requestActivityConversionRequest), d0Var);
            f1Var.setParcelable(pendingIntent);
            return doWrite(f1Var);
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationArClientImpl", tid, "createActivityConversionUpdates api exception");
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationArClientImpl", tid, "createActivityConversionUpdates exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        }
    }

    @Override // com.huawei.hms.locationSdk.c
    public Task<Void> b(PendingIntent pendingIntent) throws ApiException {
        ApiException e;
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        HMSLocationLog.i("LocationArClientImpl", tid, "deleteActivityConversionUpdates begin");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            d0 d0Var = new d0();
            d0Var.a(pendingIntent);
            d0 d0Var2 = (d0) e0.b().b(d0Var);
            if (d0Var2 != null) {
                HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityConversionUpdates cannot find cache");
                tid = d0Var2.a();
            }
            locationBaseRequest.setTid(tid);
            d0Var.a(tid);
            b1 b1Var = new b1("location.removeActivityConversionUpdates", JsonUtil.createJsonString(locationBaseRequest), d0Var);
            b1Var.setParcelable(pendingIntent);
            return doWrite(b1Var);
        } catch (ApiException e2) {
            e = e2;
            HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityConversionUpdates api exception:" + e.getMessage());
            taskCompletionSource.setException(e);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            HMSLocationLog.e("LocationArClientImpl", tid, "deleteActivityConversionUpdates exception");
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
    public int getKitSdkVersion() {
        return 61200300;
    }
}

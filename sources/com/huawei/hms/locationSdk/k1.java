package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class k1 extends n0<s, Void> {
    private k0 b;

    public k1(String str, String str2, String str3, k0 k0Var, String str4) {
        super(str, str2, str3, str4);
        this.b = k0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) throws ApiException {
        ApiException e;
        HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "doExecute");
        try {
            if (responseErrorCode == null) {
                j0.b().c(this.b);
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                JSONObject jSONObject = new JSONObject(str);
                k0 k0Var = this.b;
                if (k0Var != null && k0Var.d() != null) {
                    if (jSONObject.has("locationResult")) {
                        int size = LocationJsonUtil.parseLocationResultFromJsonObject(jSONObject).getLocations().size();
                        int iG = this.b.g();
                        HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "modify numUpdates with callback, numUpdates:" + iG + " , locationSize:" + size);
                        if (iG > 0 && iG >= size) {
                            if (iG == size) {
                                HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "modify numUpdates last need remove request");
                                b.b(sVar.getContext(), (w) null).a(this.b.b());
                            } else {
                                HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "numUpdates greater than locationSize");
                            }
                            j0.b().a(this.b, iG - size);
                            return;
                        }
                        HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "modify numUpdates exception need remove request");
                        b.b(sVar.getContext(), (w) null).a(this.b.b());
                        return;
                    }
                    if (jSONObject.has("locationAvailability")) {
                        return;
                    } else {
                        j0.b().d(this.b);
                    }
                }
                HMSLocationLog.e("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "INTERNAL_ERROR : doExecute requestLocationUpdatesCache is null");
                return;
            }
            j0.b().c(this.b);
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
        } catch (ApiException e2) {
            e = e2;
            j0.b().c(this.b);
            HMSLocationLog.e("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            j0.b().c(this.b);
            HMSLocationLog.e("RequestLocationUpdatesWithIntentTaskApiCall", ((n0) this).a, "doExecute exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 4;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40000000;
    }
}

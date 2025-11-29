package com.huawei.hms.locationSdk;

import android.location.Location;
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
public class v0 extends n0<s, Location> {
    public v0(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Location> taskCompletionSource) throws ApiException {
        try {
            HMSLocationLog.i("GetLastLocationTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, LocationJsonUtil.convertLocation(responseErrorCode.getErrorCode() == 0 ? LocationJsonUtil.parseLocationFromJsonObject(new JSONObject(str)) : null));
        } catch (ApiException e) {
            HMSLocationLog.e("GetLastLocationTaskApiCall", ((n0) this).a, "get last location doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            HMSLocationLog.e("GetLastLocationTaskApiCall", ((n0) this).a, "get last location doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}

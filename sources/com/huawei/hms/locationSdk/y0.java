package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class y0 extends n0<t, NavigationResult> {
    public y0(String str, String str2, String str3, int i) {
        super(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(t tVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<NavigationResult> taskCompletionSource) throws ApiException {
        try {
            HMSLocationLog.i("GetNavigationContextStateTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            int errorCode = responseErrorCode.getErrorCode();
            HMSLocationLog.d("GetNavigationContextStateTaskApiCall", ((n0) this).a, "getNavigationContextState message start");
            NavigationResult navigationResult = new NavigationResult();
            if (errorCode == 0) {
                JSONObject jSONObject = new JSONObject(str);
                navigationResult.setState(jSONObject.getInt("environment"));
                navigationResult.setPossibility(jSONObject.getInt("confidence"));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, navigationResult);
            HMSLocationLog.d("GetNavigationContextStateTaskApiCall", ((n0) this).a, "getNavigationContextState message success");
        } catch (ApiException e) {
            HMSLocationLog.e("GetNavigationContextStateTaskApiCall", ((n0) this).a, "get navi doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            HMSLocationLog.e("GetNavigationContextStateTaskApiCall", ((n0) this).a, "get navi doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}

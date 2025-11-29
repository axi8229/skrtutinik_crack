package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class s0 extends n0<u, List<HWLocation>> {
    private Context b;

    public s0(Context context, String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(u uVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<List<HWLocation>> taskCompletionSource) throws ApiException {
        try {
            HMSLocationLog.i("GetFromLocationTaskApiCall", ((n0) this).a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, responseErrorCode.getErrorCode() == 0 ? LocationJsonUtil.parseHwLocationsFromJsonObject(new JSONObject(str)) : null);
        } catch (ApiException e) {
            HMSLocationLog.e("GetFromLocationTaskApiCall", ((n0) this).a, "getFromLocation doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            HMSLocationLog.e("GetFromLocationTaskApiCall", ((n0) this).a, "getFromLocation doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        int deviceFeature = DeviceInfoUtil.getDeviceFeature(this.b);
        return (deviceFeature == 0 || deviceFeature == 1) ? 6 : 5;
    }
}

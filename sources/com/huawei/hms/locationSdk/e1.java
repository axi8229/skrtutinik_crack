package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.huawei.location.vdr.VdrManager;

/* loaded from: classes3.dex */
public class e1 extends n0<s, Void> {
    private k0 b;

    public e1(String str, String str2, String str3, k0 k0Var, String str4) {
        super(str, str2, str3, str4);
        this.b = k0Var;
        if (ReflectionUtils.isSupportClass("com.huawei.location.vdr.VdrManager")) {
            VdrManager.getInstance().unRegisterVdrLocationLis(this.b.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) throws ApiException {
        try {
            HMSLocationLog.i("RemoveLocationUpdatesTaskApiCall", ((n0) this).a, "doExecute");
            j0.b().a(this.b.c());
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0 || responseErrorCode.getErrorCode() == 10104) {
                j0.b().c(this.b);
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
        } catch (Exception unused) {
            HMSLocationLog.e("RemoveLocationUpdatesTaskApiCall", ((n0) this).a, "doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}

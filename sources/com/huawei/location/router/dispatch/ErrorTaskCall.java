package com.huawei.location.router.dispatch;

import com.huawei.location.lite.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;

/* loaded from: classes3.dex */
class ErrorTaskCall extends BaseRouterTaskCallImpl {
    ErrorTaskCall() {
    }

    public void onComplete(int i) {
        onComplete(i, LocationStatusCode.getStatusCodeString(i));
    }

    public void onComplete(int i, String str) {
        LogLocation.e("ErrorRequestApi", "handlerNoApiTask");
        onComplete(new RouterResponse("", new StatusInfo(0, i, str)));
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
    }
}

package com.huawei.location.activity;

import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.logic.zp;
import com.huawei.location.router.entity.IRouterResponse;

/* loaded from: classes3.dex */
public class RequestAdapterSDMTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RequestAdapterSDMAPI";

    @Override // com.huawei.location.router.BaseRouterTaskCallImpl, com.huawei.location.router.interfaces.IRouterRequest
    public IRouterResponse onExecute(String str) {
        BaseLocationReq baseLocationReq;
        LogLocation.i(TAG, "onExecute start");
        try {
            baseLocationReq = (BaseLocationReq) GsonUtil.getInstance().fromJson(str, BaseLocationReq.class);
        } catch (JsonSyntaxException unused) {
            LogLocation.i(TAG, "removeActivityIdentificationUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest RequestAdapterSDMTaskCall exception";
            baseLocationReq = null;
        }
        this.reportBuilder.yn("AR_requestAdapterSDM");
        zp zpVarYn = zp.yn();
        this.reportBuilder.yn(baseLocationReq);
        this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
        return zpVarYn;
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        LogLocation.i(TAG, "onRequest start");
    }
}

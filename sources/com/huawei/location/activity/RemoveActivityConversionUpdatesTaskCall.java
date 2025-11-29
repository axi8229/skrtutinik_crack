package com.huawei.location.activity;

import android.app.PendingIntent;
import android.os.Parcelable;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.api.request.RemoveActivityConversionReq;
import com.huawei.hms.location.api.response.RequestActivityConversionResp;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.callback.LW;
import com.huawei.location.callback.Vw;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.ObjectCheckUtils;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;

/* loaded from: classes3.dex */
public class RemoveActivityConversionUpdatesTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RemoveActivityConversionUpdatesAPI";

    private boolean checkRequest(RemoveActivityConversionReq removeActivityConversionReq) {
        if (removeActivityConversionReq == null || removeActivityConversionReq.getPackageName() == null || removeActivityConversionReq.getLocTransactionId() == null) {
            dealRequest();
            return false;
        }
        if (!removeActivityConversionReq.getPackageName().isEmpty() && !removeActivityConversionReq.getLocTransactionId().isEmpty()) {
            return true;
        }
        dealRequest();
        return false;
    }

    private void dealRequest() {
        onComplete(new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101))));
        this.errorCode = 10101;
    }

    private LW getBaseCallbackMapping(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            return com.huawei.location.callback.Vw.Vw().yn(getRouterCallback());
        }
        LW lwYn = com.huawei.location.callback.Vw.Vw().yn(pendingIntent);
        ObjectCheckUtils.checkNullObject(TAG, lwYn, ActivityErrorCode.NO_MATCHED_INTENT, "NO_MATCHED_INTENT");
        return lwYn;
    }

    private PendingIntent getPendingIntent() {
        Parcelable parcelable = getParcelable();
        if (parcelable instanceof PendingIntent) {
            return (PendingIntent) parcelable;
        }
        return null;
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        RemoveActivityConversionReq removeActivityConversionReq;
        LogLocation.i(TAG, "onRequest start");
        this.reportBuilder.yn("AR_removeActivityTransition");
        RemoveActivityConversionReq removeActivityConversionReq2 = null;
        try {
            ObjectCheckUtils.checkEmptyString(TAG, str);
            removeActivityConversionReq = (RemoveActivityConversionReq) GsonUtil.getInstance().fromJson(str, RemoveActivityConversionReq.class);
        } catch (JsonSyntaxException unused) {
        } catch (LocationServiceException e) {
            e = e;
        } catch (Exception unused2) {
        }
        try {
        } catch (JsonSyntaxException unused3) {
            removeActivityConversionReq2 = removeActivityConversionReq;
            LogLocation.i(TAG, "removeActivityConversionUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest removeActivityConversionUpdates exception";
            removeActivityConversionReq = removeActivityConversionReq2;
            this.reportBuilder.yn(removeActivityConversionReq);
            this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
            doExecute(new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        } catch (LocationServiceException e2) {
            e = e2;
            removeActivityConversionReq2 = removeActivityConversionReq;
            this.errorCode = e.getExceptionCode();
            this.errorReason = "onRequest removeActivityConversionUpdates LocationServiceException:" + e.getMessage();
            removeActivityConversionReq = removeActivityConversionReq2;
            this.reportBuilder.yn(removeActivityConversionReq);
            this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
            doExecute(new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        } catch (Exception unused4) {
            removeActivityConversionReq2 = removeActivityConversionReq;
            this.errorCode = 10000;
            this.errorReason = "onRequest removeActivityConversionUpdates exception";
            removeActivityConversionReq = removeActivityConversionReq2;
            this.reportBuilder.yn(removeActivityConversionReq);
            this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
            doExecute(new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        }
        if (!checkRequest(removeActivityConversionReq)) {
            this.reportBuilder.yn(removeActivityConversionReq);
            this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
            return;
        }
        removeActivityConversionReq.setModuleName("Location");
        String locTransactionId = removeActivityConversionReq.getLocTransactionId();
        String packageName = removeActivityConversionReq.getPackageName();
        ClientInfo clientInfo = new ClientInfo(packageName, APKUtil.getUidByPackageName(packageName), 0, locTransactionId);
        LW baseCallbackMapping = getBaseCallbackMapping(getPendingIntent());
        Vw.yn ynVar = new Vw.yn();
        if (baseCallbackMapping instanceof Vw.yn) {
            ynVar = (Vw.yn) baseCallbackMapping;
        }
        ObjectCheckUtils.checkNullObject(TAG, ynVar, Vw.yn.class);
        ObjectCheckUtils.checkNullObject(TAG, ynVar.FB(), Vw.yn.class);
        ((com.huawei.location.logic.Vw) com.huawei.location.logic.Vw.yn()).yn(removeActivityConversionReq.getModuleName(), ynVar.FB(), clientInfo);
        com.huawei.location.callback.Vw.Vw().yn((com.huawei.location.callback.Vw) ynVar);
        this.errorReason = "removeActivityConversionUpdates success";
        this.reportBuilder.yn(removeActivityConversionReq);
        this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
        doExecute(new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
    }
}

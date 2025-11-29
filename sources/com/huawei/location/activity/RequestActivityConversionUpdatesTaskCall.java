package com.huawei.location.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.ActivityConversionData;
import com.huawei.hms.location.ActivityConversionInfo;
import com.huawei.hms.location.ActivityConversionResponse;
import com.huawei.hms.location.api.request.RequestActivityConversionReq;
import com.huawei.hms.location.api.response.RequestActivityConversionResp;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionEvent;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.hms.location.entity.activity.ActivityTransitionResult;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.callback.LW;
import com.huawei.location.callback.Vw;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.ObjectCheckUtils;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RequestActivityConversionUpdatesTaskCall extends BaseApiTaskCall {
    private static final String KEY_RESPONSE = "KEY_RESPONSE";
    private static final String KEY_RESPONSE_RESULT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_RESULT";
    private static final String TAG = "RequestActivityConversionUpdatesAPI";
    private Vw.yn callBackInfo;
    private ClientInfo clientInfo;
    private String moduleName;
    private PendingIntent pendingIntent;
    private RequestActivityConversionReq requestActivityConversionReq = null;

    private class Vw implements ATCallback {
        private Vw() {
        }

        @Override // com.huawei.location.base.activity.callback.ATCallback
        public void onActivityTransition(ActivityTransitionResult activityTransitionResult) throws PendingIntent.CanceledException {
            String str;
            RequestActivityConversionUpdatesTaskCall.this.reportBuilder.yn("AR_activityTransitionCallback");
            if (RequestActivityConversionUpdatesTaskCall.this.pendingIntent == null) {
                RequestActivityConversionResp requestActivityConversionResp = new RequestActivityConversionResp();
                requestActivityConversionResp.setActivityTransitionResult(activityTransitionResult);
                String json = GsonUtil.getInstance().toJson(requestActivityConversionResp);
                RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall = RequestActivityConversionUpdatesTaskCall.this;
                requestActivityConversionUpdatesTaskCall.doExecute(new RouterResponse(json, new StatusInfo(0, requestActivityConversionUpdatesTaskCall.errorCode, requestActivityConversionUpdatesTaskCall.errorReason)));
            } else {
                if (!ARLocationPermissionManager.checkCPActivityRecognitionPermissionByException(RequestActivityConversionUpdatesTaskCall.this.getTAG(), "checkActivityRecognitionPermission", RequestActivityConversionUpdatesTaskCall.this.clientInfo.getClientPid(), RequestActivityConversionUpdatesTaskCall.this.clientInfo.getClientUid())) {
                    RequestActivityConversionUpdatesTaskCall.this.removeActivityConversionUpdates();
                    return;
                }
                try {
                    List<ActivityTransitionEvent> transitionEvents = activityTransitionResult.getTransitionEvents();
                    ArrayList arrayList = new ArrayList();
                    for (ActivityTransitionEvent activityTransitionEvent : transitionEvents) {
                        arrayList.add(new ActivityConversionData(activityTransitionEvent.getActivityType() + 100, activityTransitionEvent.getTransitionType(), activityTransitionEvent.getElapsedRealTimeNanos()));
                    }
                    ActivityConversionResponse activityConversionResponse = new ActivityConversionResponse(arrayList);
                    LogLocation.i(RequestActivityConversionUpdatesTaskCall.TAG, "sending transition result:" + activityTransitionResult);
                    Intent intent = new Intent();
                    SafeBundle safeBundle = new SafeBundle();
                    safeBundle.putParcelable(RequestActivityConversionUpdatesTaskCall.KEY_RESPONSE, activityConversionResponse);
                    intent.putExtra(RequestActivityConversionUpdatesTaskCall.KEY_RESPONSE_RESULT, safeBundle.getBundle());
                    RequestActivityConversionUpdatesTaskCall.this.pendingIntent.send(ContextUtil.getContext(), 0, intent);
                } catch (PendingIntent.CanceledException unused) {
                    str = "CanceledException";
                    LogLocation.e(RequestActivityConversionUpdatesTaskCall.TAG, str, true);
                    RequestActivityConversionUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall2 = RequestActivityConversionUpdatesTaskCall.this;
                    requestActivityConversionUpdatesTaskCall2.reportBuilder.yn(requestActivityConversionUpdatesTaskCall2.requestActivityConversionReq);
                    RequestActivityConversionUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
                } catch (NullPointerException unused2) {
                    str = "NullPointerException";
                    LogLocation.e(RequestActivityConversionUpdatesTaskCall.TAG, str, true);
                    RequestActivityConversionUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall22 = RequestActivityConversionUpdatesTaskCall.this;
                    requestActivityConversionUpdatesTaskCall22.reportBuilder.yn(requestActivityConversionUpdatesTaskCall22.requestActivityConversionReq);
                    RequestActivityConversionUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
                }
            }
            RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall222 = RequestActivityConversionUpdatesTaskCall.this;
            requestActivityConversionUpdatesTaskCall222.reportBuilder.yn(requestActivityConversionUpdatesTaskCall222.requestActivityConversionReq);
            RequestActivityConversionUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
        }
    }

    private boolean checkRequest(RequestActivityConversionReq requestActivityConversionReq) {
        RouterResponse routerResponse;
        if (requestActivityConversionReq.getPackageName().isEmpty()) {
            LogLocation.e(TAG, "packageName is invalid");
            routerResponse = new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else if (requestActivityConversionReq.getLocTransactionId().isEmpty()) {
            LogLocation.e(TAG, "tid is invalid");
            routerResponse = new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else {
            if (!requestActivityConversionReq.getModuleName().isEmpty()) {
                return true;
            }
            LogLocation.e(TAG, "ModuleName is invalid");
            routerResponse = new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        }
        onComplete(routerResponse);
        return false;
    }

    private void getCallback() {
        LW lwYn = this.pendingIntent != null ? com.huawei.location.callback.Vw.Vw().yn(this.pendingIntent) : com.huawei.location.callback.yn.Vw().yn(getRouterCallback());
        if (lwYn instanceof Vw.yn) {
            this.callBackInfo = (Vw.yn) lwYn;
        }
    }

    private PendingIntent getPendingIntent() {
        Parcelable parcelable = getParcelable();
        if (parcelable instanceof PendingIntent) {
            this.pendingIntent = (PendingIntent) parcelable;
        }
        return this.pendingIntent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTAG() {
        return TAG;
    }

    private List<ActivityTransition> getTransitionLists() {
        List<ActivityConversionInfo> activityConversions = this.requestActivityConversionReq.getActivityConversions();
        ArrayList arrayList = new ArrayList();
        for (ActivityConversionInfo activityConversionInfo : activityConversions) {
            ActivityTransition activityTransition = new ActivityTransition();
            activityTransition.setActivityType(activityConversionInfo.getActivityType() - 100);
            activityTransition.setTransitionType(activityConversionInfo.getConversionType());
            arrayList.add(activityTransition);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeActivityConversionUpdates() {
        int i;
        LogLocation.i(TAG, "removeActivityConversionUpdates start");
        if (this.callBackInfo != null) {
            try {
                ((com.huawei.location.logic.Vw) com.huawei.location.logic.Vw.yn()).yn(this.moduleName, this.callBackInfo.FB(), this.clientInfo);
                com.huawei.location.callback.Vw.Vw().yn((com.huawei.location.callback.Vw) this.callBackInfo);
                i = 0;
            } catch (LocationServiceException e) {
                int exceptionCode = e.getExceptionCode();
                this.errorReason = "removeActivityConversionUpdates in request api LocationServiceException:" + e.getMessage();
                i = exceptionCode;
            } catch (Exception unused) {
                this.errorReason = "removeActivityConversionUpdates in request api exception";
                i = 10000;
            }
        } else {
            i = 0;
        }
        this.reportBuilder.yn(this.requestActivityConversionReq);
        this.reportBuilder.yn("AR_removeActivityTransition");
        this.reportBuilder.yn().Vw(String.valueOf(i));
    }

    private void saveCallbackInfo() {
        if (this.callBackInfo == null) {
            Vw.yn ynVar = new Vw.yn();
            this.callBackInfo = ynVar;
            ynVar.yn(new Vw());
            this.callBackInfo.yn(this.pendingIntent);
            this.callBackInfo.yn(getRouterCallback());
            com.huawei.location.callback.Vw.Vw().Vw(this.callBackInfo);
        }
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        LogLocation.i(TAG, "onRequest start");
        this.reportBuilder.yn("AR_requestActivityTransition");
        try {
            ObjectCheckUtils.checkEmptyString(TAG, str);
            RequestActivityConversionReq requestActivityConversionReq = (RequestActivityConversionReq) GsonUtil.getInstance().fromJson(str, RequestActivityConversionReq.class);
            this.requestActivityConversionReq = requestActivityConversionReq;
            if (requestActivityConversionReq.getModuleName() == null || this.requestActivityConversionReq.getModuleName().isEmpty()) {
                this.requestActivityConversionReq.setModuleName("Location");
            }
        } catch (JsonSyntaxException unused) {
            LogLocation.i(TAG, "requestActivityConversionUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest requestActivityConversionUpdates exception";
        } catch (LocationServiceException e) {
            this.errorCode = e.getExceptionCode();
            this.errorReason = "onRequest requestActivityConversionUpdates LocationServiceException:" + e.getMessage();
        } catch (Exception unused2) {
            this.errorCode = 10000;
            this.errorReason = "onRequest requestActivityConversionUpdates exception";
        }
        if (!checkRequest(this.requestActivityConversionReq)) {
            this.reportBuilder.yn(this.requestActivityConversionReq);
            this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
            return;
        }
        String locTransactionId = this.requestActivityConversionReq.getLocTransactionId();
        String packageName = this.requestActivityConversionReq.getPackageName();
        this.clientInfo = new ClientInfo(packageName, APKUtil.getUidByPackageName(packageName), 0, locTransactionId);
        this.pendingIntent = getPendingIntent();
        getCallback();
        saveCallbackInfo();
        List<ActivityTransition> transitionLists = getTransitionLists();
        ActivityTransitionRequest activityTransitionRequest = new ActivityTransitionRequest();
        activityTransitionRequest.setTransitions(transitionLists);
        this.moduleName = this.requestActivityConversionReq.getModuleName();
        ((com.huawei.location.logic.Vw) com.huawei.location.logic.Vw.yn()).yn(this.moduleName, activityTransitionRequest, this.callBackInfo.FB(), this.clientInfo);
        this.errorReason = "requestActivityConversionUpdates success";
        if (this.errorCode != 0 || this.callBackInfo.yn() != null) {
            doExecute(new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        }
        this.reportBuilder.yn(this.requestActivityConversionReq);
        this.reportBuilder.yn().yn(String.valueOf(this.errorCode));
    }
}

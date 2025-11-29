package com.huawei.location.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.ActivityIdentificationData;
import com.huawei.hms.location.ActivityIdentificationResponse;
import com.huawei.hms.location.api.request.RequestActivityIdentificationReq;
import com.huawei.hms.location.api.response.RequestActivityIdentificationResp;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.callback.LW;
import com.huawei.location.callback.yn;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RequestActivityIdentificationUpdatesTaskCall extends BaseApiTaskCall {
    private static final String KEY_RESPONSE = "KEY_RESPONSE";
    private static final String KEY_RESPONSE_RESULT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_RESULT";
    private static final String TAG = "RequestActivityIdentificationUpdatesAPI";
    private yn.C0083yn callBackInfo;
    private ClientInfo clientInfo;
    private PendingIntent pendingIntent;
    private RequestActivityIdentificationReq requestActivityIdentificationReq = null;

    private class Vw implements ARCallback {
        private Vw() {
        }

        @Override // com.huawei.location.base.activity.callback.ARCallback
        public void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) throws PendingIntent.CanceledException {
            String str;
            RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn("AR_activityStateCallback");
            if (RequestActivityIdentificationUpdatesTaskCall.this.pendingIntent == null) {
                RequestActivityIdentificationResp requestActivityIdentificationResp = new RequestActivityIdentificationResp();
                requestActivityIdentificationResp.setActivityRecognitionResult(activityRecognitionResult);
                String json = GsonUtil.getInstance().toJson(requestActivityIdentificationResp);
                RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall = RequestActivityIdentificationUpdatesTaskCall.this;
                requestActivityIdentificationUpdatesTaskCall.doExecute(new RouterResponse(json, new StatusInfo(0, requestActivityIdentificationUpdatesTaskCall.errorCode, requestActivityIdentificationUpdatesTaskCall.errorReason)));
            } else {
                if (!ARLocationPermissionManager.checkCPActivityRecognitionPermissionByException(RequestActivityIdentificationUpdatesTaskCall.this.getTAG(), "checkActivityRecognitionPermission", RequestActivityIdentificationUpdatesTaskCall.this.clientInfo.getClientPid(), RequestActivityIdentificationUpdatesTaskCall.this.clientInfo.getClientUid())) {
                    RequestActivityIdentificationUpdatesTaskCall.this.removeActivityIdentificationUpdates();
                    return;
                }
                try {
                    List<DetectedActivity> probableActivities = activityRecognitionResult.getProbableActivities();
                    ArrayList arrayList = new ArrayList();
                    for (DetectedActivity detectedActivity : probableActivities) {
                        arrayList.add(new ActivityIdentificationData(detectedActivity.getType() + 100, detectedActivity.getConfidence()));
                    }
                    ActivityIdentificationResponse activityIdentificationResponse = new ActivityIdentificationResponse(arrayList, activityRecognitionResult.getTime(), activityRecognitionResult.getElapsedRealtimeMillis());
                    LogLocation.i(RequestActivityIdentificationUpdatesTaskCall.TAG, "sending recognition result:" + activityRecognitionResult);
                    Intent intent = new Intent();
                    SafeBundle safeBundle = new SafeBundle();
                    safeBundle.putParcelable(RequestActivityIdentificationUpdatesTaskCall.KEY_RESPONSE, activityIdentificationResponse);
                    intent.putExtra(RequestActivityIdentificationUpdatesTaskCall.KEY_RESPONSE_RESULT, safeBundle.getBundle());
                    RequestActivityIdentificationUpdatesTaskCall.this.pendingIntent.send(ContextUtil.getContext(), 0, intent);
                } catch (PendingIntent.CanceledException unused) {
                    str = "CanceledException";
                    LogLocation.e(RequestActivityIdentificationUpdatesTaskCall.TAG, str, true);
                    RequestActivityIdentificationUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall2 = RequestActivityIdentificationUpdatesTaskCall.this;
                    requestActivityIdentificationUpdatesTaskCall2.reportBuilder.yn(requestActivityIdentificationUpdatesTaskCall2.requestActivityIdentificationReq);
                    RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
                } catch (ApiException unused2) {
                    str = "ApiException";
                    LogLocation.e(RequestActivityIdentificationUpdatesTaskCall.TAG, str, true);
                    RequestActivityIdentificationUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall22 = RequestActivityIdentificationUpdatesTaskCall.this;
                    requestActivityIdentificationUpdatesTaskCall22.reportBuilder.yn(requestActivityIdentificationUpdatesTaskCall22.requestActivityIdentificationReq);
                    RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
                } catch (NullPointerException unused3) {
                    str = "NullPointerException";
                    LogLocation.e(RequestActivityIdentificationUpdatesTaskCall.TAG, str, true);
                    RequestActivityIdentificationUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall222 = RequestActivityIdentificationUpdatesTaskCall.this;
                    requestActivityIdentificationUpdatesTaskCall222.reportBuilder.yn(requestActivityIdentificationUpdatesTaskCall222.requestActivityIdentificationReq);
                    RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
                }
            }
            RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall2222 = RequestActivityIdentificationUpdatesTaskCall.this;
            requestActivityIdentificationUpdatesTaskCall2222.reportBuilder.yn(requestActivityIdentificationUpdatesTaskCall2222.requestActivityIdentificationReq);
            RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.yn().Vw(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
        }
    }

    private boolean checkRequest(RequestActivityIdentificationReq requestActivityIdentificationReq) {
        RouterResponse routerResponse;
        if (requestActivityIdentificationReq.getPackageName().isEmpty()) {
            LogLocation.e(TAG, "packageName is invalid");
            routerResponse = new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else {
            if (!requestActivityIdentificationReq.getLocTransactionId().isEmpty()) {
                return true;
            }
            LogLocation.e(TAG, "tid is invalid");
            routerResponse = new RouterResponse(GsonUtil.getInstance().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        }
        onComplete(routerResponse);
        return false;
    }

    private void getCallback() {
        LW lwYn = this.pendingIntent != null ? com.huawei.location.callback.yn.Vw().yn(this.pendingIntent) : com.huawei.location.callback.yn.Vw().yn(getRouterCallback());
        if (lwYn instanceof yn.C0083yn) {
            this.callBackInfo = (yn.C0083yn) lwYn;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void removeActivityIdentificationUpdates() {
        int i;
        LogLocation.i(TAG, "removeActivityIdentificationUpdates start");
        if (this.callBackInfo != null) {
            try {
                ((com.huawei.location.logic.Vw) com.huawei.location.logic.Vw.yn()).yn(this.callBackInfo.FB(), this.clientInfo);
                com.huawei.location.callback.yn.Vw().yn((com.huawei.location.callback.yn) this.callBackInfo);
                i = 0;
            } catch (LocationServiceException e) {
                int exceptionCode = e.getExceptionCode();
                this.errorReason = "removeActivityUpdates in request api LocationServiceException:" + e.getMessage();
                i = exceptionCode;
            } catch (Exception unused) {
                this.errorReason = "removeActivityUpdates in request api exception";
                i = 10000;
            }
        } else {
            i = 0;
        }
        this.reportBuilder.yn(this.requestActivityIdentificationReq);
        this.reportBuilder.yn("AR_removeActivityState");
        this.reportBuilder.yn().Vw(String.valueOf(i));
    }

    private void saveCallbackInfo() {
        if (this.callBackInfo == null) {
            yn.C0083yn c0083yn = new yn.C0083yn();
            this.callBackInfo = c0083yn;
            c0083yn.yn(new Vw());
            this.callBackInfo.yn(this.pendingIntent);
            this.callBackInfo.yn(getRouterCallback());
            com.huawei.location.callback.yn.Vw().Vw(this.callBackInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1  */
    @Override // com.huawei.location.router.interfaces.IRouterRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRequest(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "onRequest start"
            java.lang.String r1 = "RequestActivityIdentificationUpdatesAPI"
            com.huawei.location.lite.common.log.LogLocation.i(r1, r0)
            com.huawei.location.util.yn$yn r0 = r7.reportBuilder
            java.lang.String r2 = "AR_requestActivityState"
            r0.yn(r2)
            r0 = 10000(0x2710, float:1.4013E-41)
            r2 = 0
            com.huawei.location.lite.common.util.ObjectCheckUtils.checkEmptyString(r1, r8)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.google.gson.Gson r3 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            java.lang.Class<com.huawei.hms.location.api.request.RequestActivityIdentificationReq> r4 = com.huawei.hms.location.api.request.RequestActivityIdentificationReq.class
            java.lang.Object r8 = r3.fromJson(r8, r4)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = (com.huawei.hms.location.api.request.RequestActivityIdentificationReq) r8     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r7.requestActivityIdentificationReq = r8     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            boolean r8 = r7.checkRequest(r8)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            if (r8 != 0) goto L41
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r3 = r7.requestActivityIdentificationReq     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r8.yn(r3)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.util.yn r8 = r8.yn()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            int r3 = r7.errorCode     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r8.yn(r3)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            return
        L3f:
            r8 = move-exception
            goto L8f
        L41:
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = r7.requestActivityIdentificationReq     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            java.lang.String r8 = r8.getLocTransactionId()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r3 = r7.requestActivityIdentificationReq     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            java.lang.String r3 = r3.getPackageName()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            int r4 = com.huawei.location.lite.common.util.APKUtil.getUidByPackageName(r3)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.base.activity.entity.ClientInfo r5 = new com.huawei.location.base.activity.entity.ClientInfo     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r5.<init>(r3, r4, r2, r8)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r7.clientInfo = r5     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = r7.requestActivityIdentificationReq     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            long r3 = r8.getDetectionIntervalMillis()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L66
            r3 = 30000(0x7530, double:1.4822E-319)
        L66:
            android.app.PendingIntent r8 = r7.getPendingIntent()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r7.pendingIntent = r8     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r7.getCallback()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r7.saveCallbackInfo()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.logic.FB r8 = com.huawei.location.logic.Vw.yn()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.callback.yn$yn r5 = r7.callBackInfo     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.base.activity.callback.ARCallback r5 = r5.FB()     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.base.activity.entity.ClientInfo r6 = r7.clientInfo     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            com.huawei.location.logic.Vw r8 = (com.huawei.location.logic.Vw) r8     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            r8.yn(r3, r5, r6)     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            java.lang.String r8 = "requestActivityIdentificationUpdates success"
            r7.errorReason = r8     // Catch: com.huawei.location.lite.common.exception.LocationServiceException -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> Lab
            goto Lb5
        L88:
            r7.errorCode = r0
            java.lang.String r8 = "onRequest requestActivityIdentificationUpdates exception"
        L8c:
            r7.errorReason = r8
            goto Lb5
        L8f:
            int r0 = r8.getExceptionCode()
            r7.errorCode = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onRequest requestActivityIdentificationUpdates LocationServiceException:"
            r0.append(r1)
            java.lang.String r8 = r8.getMessage()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            goto L8c
        Lab:
            java.lang.String r8 = "requestActivityIdentificationUpdatesTaskCall json parse failed"
            com.huawei.location.lite.common.log.LogLocation.i(r1, r8)
            r7.errorCode = r0
            java.lang.String r8 = "onRequest requestActivityIdentificationUpdates json parse exception"
            goto L8c
        Lb5:
            int r8 = r7.errorCode
            if (r8 != 0) goto Lc1
            com.huawei.location.callback.yn$yn r8 = r7.callBackInfo
            android.app.PendingIntent r8 = r8.yn()
            if (r8 == 0) goto Ldf
        Lc1:
            com.huawei.location.router.RouterResponse r8 = new com.huawei.location.router.RouterResponse
            com.google.gson.Gson r0 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            com.huawei.hms.location.api.response.RequestActivityIdentificationResp r1 = new com.huawei.hms.location.api.response.RequestActivityIdentificationResp
            r1.<init>()
            java.lang.String r0 = r0.toJson(r1)
            com.huawei.location.router.entity.StatusInfo r1 = new com.huawei.location.router.entity.StatusInfo
            int r3 = r7.errorCode
            java.lang.String r4 = r7.errorReason
            r1.<init>(r2, r3, r4)
            r8.<init>(r0, r1)
            r7.doExecute(r8)
        Ldf:
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r0 = r7.requestActivityIdentificationReq
            r8.yn(r0)
            com.huawei.location.util.yn$yn r8 = r7.reportBuilder
            com.huawei.location.util.yn r8 = r8.yn()
            int r0 = r7.errorCode
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r8.yn(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.RequestActivityIdentificationUpdatesTaskCall.onRequest(java.lang.String):void");
    }
}

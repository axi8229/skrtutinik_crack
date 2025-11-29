package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallReplaceRequestParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallReplaceRequestParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallReplaceRequestParam onCallReplaceRequestParam) {
        if (onCallReplaceRequestParam == null) {
            return 0L;
        }
        return onCallReplaceRequestParam.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_OnCallReplaceRequestParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnCallReplaceRequestParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnCallReplaceRequestParam_rdata_get = pjsua2JNI.OnCallReplaceRequestParam_rdata_get(this.swigCPtr, this);
        if (jOnCallReplaceRequestParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnCallReplaceRequestParam_rdata_get, false);
    }

    public void setStatusCode(int i) {
        pjsua2JNI.OnCallReplaceRequestParam_statusCode_set(this.swigCPtr, this, i);
    }

    public int getStatusCode() {
        return pjsua2JNI.OnCallReplaceRequestParam_statusCode_get(this.swigCPtr, this);
    }

    public void setReason(String str) {
        pjsua2JNI.OnCallReplaceRequestParam_reason_set(this.swigCPtr, this, str);
    }

    public String getReason() {
        return pjsua2JNI.OnCallReplaceRequestParam_reason_get(this.swigCPtr, this);
    }

    public void setOpt(CallSetting callSetting) {
        pjsua2JNI.OnCallReplaceRequestParam_opt_set(this.swigCPtr, this, CallSetting.getCPtr(callSetting), callSetting);
    }

    public CallSetting getOpt() {
        long jOnCallReplaceRequestParam_opt_get = pjsua2JNI.OnCallReplaceRequestParam_opt_get(this.swigCPtr, this);
        if (jOnCallReplaceRequestParam_opt_get == 0) {
            return null;
        }
        return new CallSetting(jOnCallReplaceRequestParam_opt_get, false);
    }

    public void setNewCall(Call call) {
        pjsua2JNI.OnCallReplaceRequestParam_newCall_set(this.swigCPtr, this, Call.getCPtr(call), call);
    }

    public Call getNewCall() {
        long jOnCallReplaceRequestParam_newCall_get = pjsua2JNI.OnCallReplaceRequestParam_newCall_get(this.swigCPtr, this);
        if (jOnCallReplaceRequestParam_newCall_get == 0) {
            return null;
        }
        return new Call(jOnCallReplaceRequestParam_newCall_get, false);
    }

    public OnCallReplaceRequestParam() {
        this(pjsua2JNI.new_OnCallReplaceRequestParam(), true);
    }
}

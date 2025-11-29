package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallTxOfferParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallTxOfferParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallTxOfferParam onCallTxOfferParam) {
        if (onCallTxOfferParam == null) {
            return 0L;
        }
        return onCallTxOfferParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallTxOfferParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setOpt(CallSetting callSetting) {
        pjsua2JNI.OnCallTxOfferParam_opt_set(this.swigCPtr, this, CallSetting.getCPtr(callSetting), callSetting);
    }

    public CallSetting getOpt() {
        long jOnCallTxOfferParam_opt_get = pjsua2JNI.OnCallTxOfferParam_opt_get(this.swigCPtr, this);
        if (jOnCallTxOfferParam_opt_get == 0) {
            return null;
        }
        return new CallSetting(jOnCallTxOfferParam_opt_get, false);
    }

    public OnCallTxOfferParam() {
        this(pjsua2JNI.new_OnCallTxOfferParam(), true);
    }
}

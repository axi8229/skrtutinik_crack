package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallRxOfferParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallRxOfferParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallRxOfferParam onCallRxOfferParam) {
        if (onCallRxOfferParam == null) {
            return 0L;
        }
        return onCallRxOfferParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallRxOfferParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setOffer(SdpSession sdpSession) {
        pjsua2JNI.OnCallRxOfferParam_offer_set(this.swigCPtr, this, SdpSession.getCPtr(sdpSession), sdpSession);
    }

    public SdpSession getOffer() {
        long jOnCallRxOfferParam_offer_get = pjsua2JNI.OnCallRxOfferParam_offer_get(this.swigCPtr, this);
        if (jOnCallRxOfferParam_offer_get == 0) {
            return null;
        }
        return new SdpSession(jOnCallRxOfferParam_offer_get, false);
    }

    public void setStatusCode(int i) {
        pjsua2JNI.OnCallRxOfferParam_statusCode_set(this.swigCPtr, this, i);
    }

    public int getStatusCode() {
        return pjsua2JNI.OnCallRxOfferParam_statusCode_get(this.swigCPtr, this);
    }

    public void setOpt(CallSetting callSetting) {
        pjsua2JNI.OnCallRxOfferParam_opt_set(this.swigCPtr, this, CallSetting.getCPtr(callSetting), callSetting);
    }

    public CallSetting getOpt() {
        long jOnCallRxOfferParam_opt_get = pjsua2JNI.OnCallRxOfferParam_opt_get(this.swigCPtr, this);
        if (jOnCallRxOfferParam_opt_get == 0) {
            return null;
        }
        return new CallSetting(jOnCallRxOfferParam_opt_get, false);
    }

    public OnCallRxOfferParam() {
        this(pjsua2JNI.new_OnCallRxOfferParam(), true);
    }
}

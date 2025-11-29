package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallRxReinviteParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallRxReinviteParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallRxReinviteParam onCallRxReinviteParam) {
        if (onCallRxReinviteParam == null) {
            return 0L;
        }
        return onCallRxReinviteParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallRxReinviteParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setOffer(SdpSession sdpSession) {
        pjsua2JNI.OnCallRxReinviteParam_offer_set(this.swigCPtr, this, SdpSession.getCPtr(sdpSession), sdpSession);
    }

    public SdpSession getOffer() {
        long jOnCallRxReinviteParam_offer_get = pjsua2JNI.OnCallRxReinviteParam_offer_get(this.swigCPtr, this);
        if (jOnCallRxReinviteParam_offer_get == 0) {
            return null;
        }
        return new SdpSession(jOnCallRxReinviteParam_offer_get, false);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnCallRxReinviteParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnCallRxReinviteParam_rdata_get = pjsua2JNI.OnCallRxReinviteParam_rdata_get(this.swigCPtr, this);
        if (jOnCallRxReinviteParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnCallRxReinviteParam_rdata_get, false);
    }

    public void setIsAsync(boolean z) {
        pjsua2JNI.OnCallRxReinviteParam_isAsync_set(this.swigCPtr, this, z);
    }

    public boolean getIsAsync() {
        return pjsua2JNI.OnCallRxReinviteParam_isAsync_get(this.swigCPtr, this);
    }

    public void setStatusCode(int i) {
        pjsua2JNI.OnCallRxReinviteParam_statusCode_set(this.swigCPtr, this, i);
    }

    public int getStatusCode() {
        return pjsua2JNI.OnCallRxReinviteParam_statusCode_get(this.swigCPtr, this);
    }

    public void setOpt(CallSetting callSetting) {
        pjsua2JNI.OnCallRxReinviteParam_opt_set(this.swigCPtr, this, CallSetting.getCPtr(callSetting), callSetting);
    }

    public CallSetting getOpt() {
        long jOnCallRxReinviteParam_opt_get = pjsua2JNI.OnCallRxReinviteParam_opt_get(this.swigCPtr, this);
        if (jOnCallRxReinviteParam_opt_get == 0) {
            return null;
        }
        return new CallSetting(jOnCallRxReinviteParam_opt_get, false);
    }

    public OnCallRxReinviteParam() {
        this(pjsua2JNI.new_OnCallRxReinviteParam(), true);
    }
}

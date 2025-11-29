package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CallOpParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallOpParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallOpParam callOpParam) {
        if (callOpParam == null) {
            return 0L;
        }
        return callOpParam.swigCPtr;
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
                    pjsua2JNI.delete_CallOpParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setOpt(CallSetting callSetting) {
        pjsua2JNI.CallOpParam_opt_set(this.swigCPtr, this, CallSetting.getCPtr(callSetting), callSetting);
    }

    public CallSetting getOpt() {
        long jCallOpParam_opt_get = pjsua2JNI.CallOpParam_opt_get(this.swigCPtr, this);
        if (jCallOpParam_opt_get == 0) {
            return null;
        }
        return new CallSetting(jCallOpParam_opt_get, false);
    }

    public void setStatusCode(int i) {
        pjsua2JNI.CallOpParam_statusCode_set(this.swigCPtr, this, i);
    }

    public int getStatusCode() {
        return pjsua2JNI.CallOpParam_statusCode_get(this.swigCPtr, this);
    }

    public void setReason(String str) {
        pjsua2JNI.CallOpParam_reason_set(this.swigCPtr, this, str);
    }

    public String getReason() {
        return pjsua2JNI.CallOpParam_reason_get(this.swigCPtr, this);
    }

    public void setOptions(long j) {
        pjsua2JNI.CallOpParam_options_set(this.swigCPtr, this, j);
    }

    public long getOptions() {
        return pjsua2JNI.CallOpParam_options_get(this.swigCPtr, this);
    }

    public void setTxOption(SipTxOption sipTxOption) {
        pjsua2JNI.CallOpParam_txOption_set(this.swigCPtr, this, SipTxOption.getCPtr(sipTxOption), sipTxOption);
    }

    public SipTxOption getTxOption() {
        long jCallOpParam_txOption_get = pjsua2JNI.CallOpParam_txOption_get(this.swigCPtr, this);
        if (jCallOpParam_txOption_get == 0) {
            return null;
        }
        return new SipTxOption(jCallOpParam_txOption_get, false);
    }

    public void setSdp(SdpSession sdpSession) {
        pjsua2JNI.CallOpParam_sdp_set(this.swigCPtr, this, SdpSession.getCPtr(sdpSession), sdpSession);
    }

    public SdpSession getSdp() {
        long jCallOpParam_sdp_get = pjsua2JNI.CallOpParam_sdp_get(this.swigCPtr, this);
        if (jCallOpParam_sdp_get == 0) {
            return null;
        }
        return new SdpSession(jCallOpParam_sdp_get, false);
    }

    public CallOpParam(boolean z) {
        this(pjsua2JNI.new_CallOpParam__SWIG_0(z), true);
    }

    public CallOpParam() {
        this(pjsua2JNI.new_CallOpParam__SWIG_1(), true);
    }
}

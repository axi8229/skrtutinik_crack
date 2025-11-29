package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnIncomingSubscribeParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnIncomingSubscribeParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnIncomingSubscribeParam onIncomingSubscribeParam) {
        if (onIncomingSubscribeParam == null) {
            return 0L;
        }
        return onIncomingSubscribeParam.swigCPtr;
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
                    pjsua2JNI.delete_OnIncomingSubscribeParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSrvPres(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnIncomingSubscribeParam_srvPres_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getSrvPres() {
        long jOnIncomingSubscribeParam_srvPres_get = pjsua2JNI.OnIncomingSubscribeParam_srvPres_get(this.swigCPtr, this);
        if (jOnIncomingSubscribeParam_srvPres_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnIncomingSubscribeParam_srvPres_get, false);
    }

    public void setFromUri(String str) {
        pjsua2JNI.OnIncomingSubscribeParam_fromUri_set(this.swigCPtr, this, str);
    }

    public String getFromUri() {
        return pjsua2JNI.OnIncomingSubscribeParam_fromUri_get(this.swigCPtr, this);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnIncomingSubscribeParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnIncomingSubscribeParam_rdata_get = pjsua2JNI.OnIncomingSubscribeParam_rdata_get(this.swigCPtr, this);
        if (jOnIncomingSubscribeParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnIncomingSubscribeParam_rdata_get, false);
    }

    public void setCode(int i) {
        pjsua2JNI.OnIncomingSubscribeParam_code_set(this.swigCPtr, this, i);
    }

    public int getCode() {
        return pjsua2JNI.OnIncomingSubscribeParam_code_get(this.swigCPtr, this);
    }

    public void setReason(String str) {
        pjsua2JNI.OnIncomingSubscribeParam_reason_set(this.swigCPtr, this, str);
    }

    public String getReason() {
        return pjsua2JNI.OnIncomingSubscribeParam_reason_get(this.swigCPtr, this);
    }

    public void setTxOption(SipTxOption sipTxOption) {
        pjsua2JNI.OnIncomingSubscribeParam_txOption_set(this.swigCPtr, this, SipTxOption.getCPtr(sipTxOption), sipTxOption);
    }

    public SipTxOption getTxOption() {
        long jOnIncomingSubscribeParam_txOption_get = pjsua2JNI.OnIncomingSubscribeParam_txOption_get(this.swigCPtr, this);
        if (jOnIncomingSubscribeParam_txOption_get == 0) {
            return null;
        }
        return new SipTxOption(jOnIncomingSubscribeParam_txOption_get, false);
    }

    public OnIncomingSubscribeParam() {
        this(pjsua2JNI.new_OnIncomingSubscribeParam(), true);
    }
}

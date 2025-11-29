package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class PresNotifyParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected PresNotifyParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PresNotifyParam presNotifyParam) {
        if (presNotifyParam == null) {
            return 0L;
        }
        return presNotifyParam.swigCPtr;
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
                    pjsua2JNI.delete_PresNotifyParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSrvPres(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.PresNotifyParam_srvPres_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getSrvPres() {
        long jPresNotifyParam_srvPres_get = pjsua2JNI.PresNotifyParam_srvPres_get(this.swigCPtr, this);
        if (jPresNotifyParam_srvPres_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jPresNotifyParam_srvPres_get, false);
    }

    public void setState(int i) {
        pjsua2JNI.PresNotifyParam_state_set(this.swigCPtr, this, i);
    }

    public int getState() {
        return pjsua2JNI.PresNotifyParam_state_get(this.swigCPtr, this);
    }

    public void setStateStr(String str) {
        pjsua2JNI.PresNotifyParam_stateStr_set(this.swigCPtr, this, str);
    }

    public String getStateStr() {
        return pjsua2JNI.PresNotifyParam_stateStr_get(this.swigCPtr, this);
    }

    public void setReason(String str) {
        pjsua2JNI.PresNotifyParam_reason_set(this.swigCPtr, this, str);
    }

    public String getReason() {
        return pjsua2JNI.PresNotifyParam_reason_get(this.swigCPtr, this);
    }

    public void setWithBody(boolean z) {
        pjsua2JNI.PresNotifyParam_withBody_set(this.swigCPtr, this, z);
    }

    public boolean getWithBody() {
        return pjsua2JNI.PresNotifyParam_withBody_get(this.swigCPtr, this);
    }

    public void setTxOption(SipTxOption sipTxOption) {
        pjsua2JNI.PresNotifyParam_txOption_set(this.swigCPtr, this, SipTxOption.getCPtr(sipTxOption), sipTxOption);
    }

    public SipTxOption getTxOption() {
        long jPresNotifyParam_txOption_get = pjsua2JNI.PresNotifyParam_txOption_get(this.swigCPtr, this);
        if (jPresNotifyParam_txOption_get == 0) {
            return null;
        }
        return new SipTxOption(jPresNotifyParam_txOption_get, false);
    }

    public PresNotifyParam() {
        this(pjsua2JNI.new_PresNotifyParam(), true);
    }
}

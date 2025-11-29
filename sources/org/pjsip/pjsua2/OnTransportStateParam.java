package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnTransportStateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnTransportStateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnTransportStateParam onTransportStateParam) {
        if (onTransportStateParam == null) {
            return 0L;
        }
        return onTransportStateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnTransportStateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setHnd(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnTransportStateParam_hnd_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getHnd() {
        long jOnTransportStateParam_hnd_get = pjsua2JNI.OnTransportStateParam_hnd_get(this.swigCPtr, this);
        if (jOnTransportStateParam_hnd_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnTransportStateParam_hnd_get, false);
    }

    public void setType(String str) {
        pjsua2JNI.OnTransportStateParam_type_set(this.swigCPtr, this, str);
    }

    public String getType() {
        return pjsua2JNI.OnTransportStateParam_type_get(this.swigCPtr, this);
    }

    public void setState(int i) {
        pjsua2JNI.OnTransportStateParam_state_set(this.swigCPtr, this, i);
    }

    public int getState() {
        return pjsua2JNI.OnTransportStateParam_state_get(this.swigCPtr, this);
    }

    public void setLastError(int i) {
        pjsua2JNI.OnTransportStateParam_lastError_set(this.swigCPtr, this, i);
    }

    public int getLastError() {
        return pjsua2JNI.OnTransportStateParam_lastError_get(this.swigCPtr, this);
    }

    public void setTlsInfo(TlsInfo tlsInfo) {
        pjsua2JNI.OnTransportStateParam_tlsInfo_set(this.swigCPtr, this, TlsInfo.getCPtr(tlsInfo), tlsInfo);
    }

    public TlsInfo getTlsInfo() {
        long jOnTransportStateParam_tlsInfo_get = pjsua2JNI.OnTransportStateParam_tlsInfo_get(this.swigCPtr, this);
        if (jOnTransportStateParam_tlsInfo_get == 0) {
            return null;
        }
        return new TlsInfo(jOnTransportStateParam_tlsInfo_get, false);
    }

    public OnTransportStateParam() {
        this(pjsua2JNI.new_OnTransportStateParam(), true);
    }
}

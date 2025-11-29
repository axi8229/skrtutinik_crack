package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnRegStateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnRegStateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnRegStateParam onRegStateParam) {
        if (onRegStateParam == null) {
            return 0L;
        }
        return onRegStateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnRegStateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setStatus(int i) {
        pjsua2JNI.OnRegStateParam_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.OnRegStateParam_status_get(this.swigCPtr, this);
    }

    public void setCode(int i) {
        pjsua2JNI.OnRegStateParam_code_set(this.swigCPtr, this, i);
    }

    public int getCode() {
        return pjsua2JNI.OnRegStateParam_code_get(this.swigCPtr, this);
    }

    public void setReason(String str) {
        pjsua2JNI.OnRegStateParam_reason_set(this.swigCPtr, this, str);
    }

    public String getReason() {
        return pjsua2JNI.OnRegStateParam_reason_get(this.swigCPtr, this);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnRegStateParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnRegStateParam_rdata_get = pjsua2JNI.OnRegStateParam_rdata_get(this.swigCPtr, this);
        if (jOnRegStateParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnRegStateParam_rdata_get, false);
    }

    public void setExpiration(long j) {
        pjsua2JNI.OnRegStateParam_expiration_set(this.swigCPtr, this, j);
    }

    public long getExpiration() {
        return pjsua2JNI.OnRegStateParam_expiration_get(this.swigCPtr, this);
    }

    public OnRegStateParam() {
        this(pjsua2JNI.new_OnRegStateParam(), true);
    }
}

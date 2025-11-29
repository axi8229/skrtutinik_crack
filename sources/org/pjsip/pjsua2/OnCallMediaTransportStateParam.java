package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallMediaTransportStateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallMediaTransportStateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallMediaTransportStateParam onCallMediaTransportStateParam) {
        if (onCallMediaTransportStateParam == null) {
            return 0L;
        }
        return onCallMediaTransportStateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallMediaTransportStateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMedIdx(long j) {
        pjsua2JNI.OnCallMediaTransportStateParam_medIdx_set(this.swigCPtr, this, j);
    }

    public long getMedIdx() {
        return pjsua2JNI.OnCallMediaTransportStateParam_medIdx_get(this.swigCPtr, this);
    }

    public void setState(int i) {
        pjsua2JNI.OnCallMediaTransportStateParam_state_set(this.swigCPtr, this, i);
    }

    public int getState() {
        return pjsua2JNI.OnCallMediaTransportStateParam_state_get(this.swigCPtr, this);
    }

    public void setStatus(int i) {
        pjsua2JNI.OnCallMediaTransportStateParam_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.OnCallMediaTransportStateParam_status_get(this.swigCPtr, this);
    }

    public void setSipErrorCode(int i) {
        pjsua2JNI.OnCallMediaTransportStateParam_sipErrorCode_set(this.swigCPtr, this, i);
    }

    public int getSipErrorCode() {
        return pjsua2JNI.OnCallMediaTransportStateParam_sipErrorCode_get(this.swigCPtr, this);
    }

    public OnCallMediaTransportStateParam() {
        this(pjsua2JNI.new_OnCallMediaTransportStateParam(), true);
    }
}

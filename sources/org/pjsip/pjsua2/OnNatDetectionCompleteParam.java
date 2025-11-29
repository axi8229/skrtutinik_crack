package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnNatDetectionCompleteParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnNatDetectionCompleteParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnNatDetectionCompleteParam onNatDetectionCompleteParam) {
        if (onNatDetectionCompleteParam == null) {
            return 0L;
        }
        return onNatDetectionCompleteParam.swigCPtr;
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
                    pjsua2JNI.delete_OnNatDetectionCompleteParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setStatus(int i) {
        pjsua2JNI.OnNatDetectionCompleteParam_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.OnNatDetectionCompleteParam_status_get(this.swigCPtr, this);
    }

    public void setReason(String str) {
        pjsua2JNI.OnNatDetectionCompleteParam_reason_set(this.swigCPtr, this, str);
    }

    public String getReason() {
        return pjsua2JNI.OnNatDetectionCompleteParam_reason_get(this.swigCPtr, this);
    }

    public void setNatType(int i) {
        pjsua2JNI.OnNatDetectionCompleteParam_natType_set(this.swigCPtr, this, i);
    }

    public int getNatType() {
        return pjsua2JNI.OnNatDetectionCompleteParam_natType_get(this.swigCPtr, this);
    }

    public void setNatTypeName(String str) {
        pjsua2JNI.OnNatDetectionCompleteParam_natTypeName_set(this.swigCPtr, this, str);
    }

    public String getNatTypeName() {
        return pjsua2JNI.OnNatDetectionCompleteParam_natTypeName_get(this.swigCPtr, this);
    }

    public OnNatDetectionCompleteParam() {
        this(pjsua2JNI.new_OnNatDetectionCompleteParam(), true);
    }
}

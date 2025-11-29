package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnDtmfEventParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnDtmfEventParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnDtmfEventParam onDtmfEventParam) {
        if (onDtmfEventParam == null) {
            return 0L;
        }
        return onDtmfEventParam.swigCPtr;
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
                    pjsua2JNI.delete_OnDtmfEventParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMethod(int i) {
        pjsua2JNI.OnDtmfEventParam_method_set(this.swigCPtr, this, i);
    }

    public int getMethod() {
        return pjsua2JNI.OnDtmfEventParam_method_get(this.swigCPtr, this);
    }

    public void setTimestamp(long j) {
        pjsua2JNI.OnDtmfEventParam_timestamp_set(this.swigCPtr, this, j);
    }

    public long getTimestamp() {
        return pjsua2JNI.OnDtmfEventParam_timestamp_get(this.swigCPtr, this);
    }

    public void setDigit(String str) {
        pjsua2JNI.OnDtmfEventParam_digit_set(this.swigCPtr, this, str);
    }

    public String getDigit() {
        return pjsua2JNI.OnDtmfEventParam_digit_get(this.swigCPtr, this);
    }

    public void setDuration(long j) {
        pjsua2JNI.OnDtmfEventParam_duration_set(this.swigCPtr, this, j);
    }

    public long getDuration() {
        return pjsua2JNI.OnDtmfEventParam_duration_get(this.swigCPtr, this);
    }

    public void setFlags(long j) {
        pjsua2JNI.OnDtmfEventParam_flags_set(this.swigCPtr, this, j);
    }

    public long getFlags() {
        return pjsua2JNI.OnDtmfEventParam_flags_get(this.swigCPtr, this);
    }

    public OnDtmfEventParam() {
        this(pjsua2JNI.new_OnDtmfEventParam(), true);
    }
}

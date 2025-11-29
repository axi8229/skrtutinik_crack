package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnDtmfDigitParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnDtmfDigitParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnDtmfDigitParam onDtmfDigitParam) {
        if (onDtmfDigitParam == null) {
            return 0L;
        }
        return onDtmfDigitParam.swigCPtr;
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
                    pjsua2JNI.delete_OnDtmfDigitParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMethod(int i) {
        pjsua2JNI.OnDtmfDigitParam_method_set(this.swigCPtr, this, i);
    }

    public int getMethod() {
        return pjsua2JNI.OnDtmfDigitParam_method_get(this.swigCPtr, this);
    }

    public void setDigit(String str) {
        pjsua2JNI.OnDtmfDigitParam_digit_set(this.swigCPtr, this, str);
    }

    public String getDigit() {
        return pjsua2JNI.OnDtmfDigitParam_digit_get(this.swigCPtr, this);
    }

    public void setDuration(long j) {
        pjsua2JNI.OnDtmfDigitParam_duration_set(this.swigCPtr, this, j);
    }

    public long getDuration() {
        return pjsua2JNI.OnDtmfDigitParam_duration_get(this.swigCPtr, this);
    }

    public OnDtmfDigitParam() {
        this(pjsua2JNI.new_OnDtmfDigitParam(), true);
    }
}

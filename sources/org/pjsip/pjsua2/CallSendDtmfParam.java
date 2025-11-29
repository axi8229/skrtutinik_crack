package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CallSendDtmfParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallSendDtmfParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallSendDtmfParam callSendDtmfParam) {
        if (callSendDtmfParam == null) {
            return 0L;
        }
        return callSendDtmfParam.swigCPtr;
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
                    pjsua2JNI.delete_CallSendDtmfParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMethod(int i) {
        pjsua2JNI.CallSendDtmfParam_method_set(this.swigCPtr, this, i);
    }

    public int getMethod() {
        return pjsua2JNI.CallSendDtmfParam_method_get(this.swigCPtr, this);
    }

    public void setDuration(long j) {
        pjsua2JNI.CallSendDtmfParam_duration_set(this.swigCPtr, this, j);
    }

    public long getDuration() {
        return pjsua2JNI.CallSendDtmfParam_duration_get(this.swigCPtr, this);
    }

    public void setDigits(String str) {
        pjsua2JNI.CallSendDtmfParam_digits_set(this.swigCPtr, this, str);
    }

    public String getDigits() {
        return pjsua2JNI.CallSendDtmfParam_digits_get(this.swigCPtr, this);
    }

    public CallSendDtmfParam() {
        this(pjsua2JNI.new_CallSendDtmfParam(), true);
    }
}

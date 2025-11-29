package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CallSendRequestParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallSendRequestParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallSendRequestParam callSendRequestParam) {
        if (callSendRequestParam == null) {
            return 0L;
        }
        return callSendRequestParam.swigCPtr;
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
                    pjsua2JNI.delete_CallSendRequestParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMethod(String str) {
        pjsua2JNI.CallSendRequestParam_method_set(this.swigCPtr, this, str);
    }

    public String getMethod() {
        return pjsua2JNI.CallSendRequestParam_method_get(this.swigCPtr, this);
    }

    public void setTxOption(SipTxOption sipTxOption) {
        pjsua2JNI.CallSendRequestParam_txOption_set(this.swigCPtr, this, SipTxOption.getCPtr(sipTxOption), sipTxOption);
    }

    public SipTxOption getTxOption() {
        long jCallSendRequestParam_txOption_get = pjsua2JNI.CallSendRequestParam_txOption_get(this.swigCPtr, this);
        if (jCallSendRequestParam_txOption_get == 0) {
            return null;
        }
        return new SipTxOption(jCallSendRequestParam_txOption_get, false);
    }

    public CallSendRequestParam() {
        this(pjsua2JNI.new_CallSendRequestParam(), true);
    }
}

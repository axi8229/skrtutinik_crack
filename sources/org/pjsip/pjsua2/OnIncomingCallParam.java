package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnIncomingCallParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnIncomingCallParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnIncomingCallParam onIncomingCallParam) {
        if (onIncomingCallParam == null) {
            return 0L;
        }
        return onIncomingCallParam.swigCPtr;
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
                    pjsua2JNI.delete_OnIncomingCallParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setCallId(int i) {
        pjsua2JNI.OnIncomingCallParam_callId_set(this.swigCPtr, this, i);
    }

    public int getCallId() {
        return pjsua2JNI.OnIncomingCallParam_callId_get(this.swigCPtr, this);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnIncomingCallParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnIncomingCallParam_rdata_get = pjsua2JNI.OnIncomingCallParam_rdata_get(this.swigCPtr, this);
        if (jOnIncomingCallParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnIncomingCallParam_rdata_get, false);
    }

    public OnIncomingCallParam() {
        this(pjsua2JNI.new_OnIncomingCallParam(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallStateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallStateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallStateParam onCallStateParam) {
        if (onCallStateParam == null) {
            return 0L;
        }
        return onCallStateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallStateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setE(SipEvent sipEvent) {
        pjsua2JNI.OnCallStateParam_e_set(this.swigCPtr, this, SipEvent.getCPtr(sipEvent), sipEvent);
    }

    public SipEvent getE() {
        long jOnCallStateParam_e_get = pjsua2JNI.OnCallStateParam_e_get(this.swigCPtr, this);
        if (jOnCallStateParam_e_get == 0) {
            return null;
        }
        return new SipEvent(jOnCallStateParam_e_get, false);
    }

    public OnCallStateParam() {
        this(pjsua2JNI.new_OnCallStateParam(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallTsxStateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallTsxStateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallTsxStateParam onCallTsxStateParam) {
        if (onCallTsxStateParam == null) {
            return 0L;
        }
        return onCallTsxStateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallTsxStateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setE(SipEvent sipEvent) {
        pjsua2JNI.OnCallTsxStateParam_e_set(this.swigCPtr, this, SipEvent.getCPtr(sipEvent), sipEvent);
    }

    public SipEvent getE() {
        long jOnCallTsxStateParam_e_get = pjsua2JNI.OnCallTsxStateParam_e_get(this.swigCPtr, this);
        if (jOnCallTsxStateParam_e_get == 0) {
            return null;
        }
        return new SipEvent(jOnCallTsxStateParam_e_get, false);
    }

    public OnCallTsxStateParam() {
        this(pjsua2JNI.new_OnCallTsxStateParam(), true);
    }
}

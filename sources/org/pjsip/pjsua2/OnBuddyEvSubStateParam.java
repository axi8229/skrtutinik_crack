package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnBuddyEvSubStateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnBuddyEvSubStateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnBuddyEvSubStateParam onBuddyEvSubStateParam) {
        if (onBuddyEvSubStateParam == null) {
            return 0L;
        }
        return onBuddyEvSubStateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnBuddyEvSubStateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setE(SipEvent sipEvent) {
        pjsua2JNI.OnBuddyEvSubStateParam_e_set(this.swigCPtr, this, SipEvent.getCPtr(sipEvent), sipEvent);
    }

    public SipEvent getE() {
        long jOnBuddyEvSubStateParam_e_get = pjsua2JNI.OnBuddyEvSubStateParam_e_get(this.swigCPtr, this);
        if (jOnBuddyEvSubStateParam_e_get == 0) {
            return null;
        }
        return new SipEvent(jOnBuddyEvSubStateParam_e_get, false);
    }

    public OnBuddyEvSubStateParam() {
        this(pjsua2JNI.new_OnBuddyEvSubStateParam(), true);
    }
}

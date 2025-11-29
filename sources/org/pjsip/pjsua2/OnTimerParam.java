package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnTimerParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnTimerParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnTimerParam onTimerParam) {
        if (onTimerParam == null) {
            return 0L;
        }
        return onTimerParam.swigCPtr;
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
                    pjsua2JNI.delete_OnTimerParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUserData(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnTimerParam_userData_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUserData() {
        long jOnTimerParam_userData_get = pjsua2JNI.OnTimerParam_userData_get(this.swigCPtr, this);
        if (jOnTimerParam_userData_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnTimerParam_userData_get, false);
    }

    public void setMsecDelay(long j) {
        pjsua2JNI.OnTimerParam_msecDelay_set(this.swigCPtr, this, j);
    }

    public long getMsecDelay() {
        return pjsua2JNI.OnTimerParam_msecDelay_get(this.swigCPtr, this);
    }

    public OnTimerParam() {
        this(pjsua2JNI.new_OnTimerParam(), true);
    }
}

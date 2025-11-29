package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnRegStartedParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnRegStartedParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnRegStartedParam onRegStartedParam) {
        if (onRegStartedParam == null) {
            return 0L;
        }
        return onRegStartedParam.swigCPtr;
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
                    pjsua2JNI.delete_OnRegStartedParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRenew(boolean z) {
        pjsua2JNI.OnRegStartedParam_renew_set(this.swigCPtr, this, z);
    }

    public boolean getRenew() {
        return pjsua2JNI.OnRegStartedParam_renew_get(this.swigCPtr, this);
    }

    public OnRegStartedParam() {
        this(pjsua2JNI.new_OnRegStartedParam(), true);
    }
}

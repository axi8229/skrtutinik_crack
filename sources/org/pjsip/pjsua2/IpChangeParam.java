package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class IpChangeParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected IpChangeParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IpChangeParam ipChangeParam) {
        if (ipChangeParam == null) {
            return 0L;
        }
        return ipChangeParam.swigCPtr;
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
                    pjsua2JNI.delete_IpChangeParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRestartListener(boolean z) {
        pjsua2JNI.IpChangeParam_restartListener_set(this.swigCPtr, this, z);
    }

    public boolean getRestartListener() {
        return pjsua2JNI.IpChangeParam_restartListener_get(this.swigCPtr, this);
    }

    public void setRestartLisDelay(long j) {
        pjsua2JNI.IpChangeParam_restartLisDelay_set(this.swigCPtr, this, j);
    }

    public long getRestartLisDelay() {
        return pjsua2JNI.IpChangeParam_restartLisDelay_get(this.swigCPtr, this);
    }

    public IpChangeParam() {
        this(pjsua2JNI.new_IpChangeParam(), true);
    }
}

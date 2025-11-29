package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CallVidSetStreamParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallVidSetStreamParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallVidSetStreamParam callVidSetStreamParam) {
        if (callVidSetStreamParam == null) {
            return 0L;
        }
        return callVidSetStreamParam.swigCPtr;
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
                    pjsua2JNI.delete_CallVidSetStreamParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMedIdx(int i) {
        pjsua2JNI.CallVidSetStreamParam_medIdx_set(this.swigCPtr, this, i);
    }

    public int getMedIdx() {
        return pjsua2JNI.CallVidSetStreamParam_medIdx_get(this.swigCPtr, this);
    }

    public void setDir(int i) {
        pjsua2JNI.CallVidSetStreamParam_dir_set(this.swigCPtr, this, i);
    }

    public int getDir() {
        return pjsua2JNI.CallVidSetStreamParam_dir_get(this.swigCPtr, this);
    }

    public void setCapDev(int i) {
        pjsua2JNI.CallVidSetStreamParam_capDev_set(this.swigCPtr, this, i);
    }

    public int getCapDev() {
        return pjsua2JNI.CallVidSetStreamParam_capDev_get(this.swigCPtr, this);
    }

    public CallVidSetStreamParam() {
        this(pjsua2JNI.new_CallVidSetStreamParam(), true);
    }
}

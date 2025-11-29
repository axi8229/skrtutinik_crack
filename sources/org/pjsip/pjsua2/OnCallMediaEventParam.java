package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallMediaEventParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallMediaEventParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallMediaEventParam onCallMediaEventParam) {
        if (onCallMediaEventParam == null) {
            return 0L;
        }
        return onCallMediaEventParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallMediaEventParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMedIdx(long j) {
        pjsua2JNI.OnCallMediaEventParam_medIdx_set(this.swigCPtr, this, j);
    }

    public long getMedIdx() {
        return pjsua2JNI.OnCallMediaEventParam_medIdx_get(this.swigCPtr, this);
    }

    public void setEv(MediaEvent mediaEvent) {
        pjsua2JNI.OnCallMediaEventParam_ev_set(this.swigCPtr, this, MediaEvent.getCPtr(mediaEvent), mediaEvent);
    }

    public MediaEvent getEv() {
        long jOnCallMediaEventParam_ev_get = pjsua2JNI.OnCallMediaEventParam_ev_get(this.swigCPtr, this);
        if (jOnCallMediaEventParam_ev_get == 0) {
            return null;
        }
        return new MediaEvent(jOnCallMediaEventParam_ev_get, false);
    }

    public OnCallMediaEventParam() {
        this(pjsua2JNI.new_OnCallMediaEventParam(), true);
    }
}

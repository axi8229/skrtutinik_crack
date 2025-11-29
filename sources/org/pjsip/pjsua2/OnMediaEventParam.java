package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnMediaEventParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnMediaEventParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnMediaEventParam onMediaEventParam) {
        if (onMediaEventParam == null) {
            return 0L;
        }
        return onMediaEventParam.swigCPtr;
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
                    pjsua2JNI.delete_OnMediaEventParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setEv(MediaEvent mediaEvent) {
        pjsua2JNI.OnMediaEventParam_ev_set(this.swigCPtr, this, MediaEvent.getCPtr(mediaEvent), mediaEvent);
    }

    public MediaEvent getEv() {
        long jOnMediaEventParam_ev_get = pjsua2JNI.OnMediaEventParam_ev_get(this.swigCPtr, this);
        if (jOnMediaEventParam_ev_get == 0) {
            return null;
        }
        return new MediaEvent(jOnMediaEventParam_ev_get, false);
    }

    public OnMediaEventParam() {
        this(pjsua2JNI.new_OnMediaEventParam(), true);
    }
}

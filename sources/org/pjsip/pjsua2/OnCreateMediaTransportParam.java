package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCreateMediaTransportParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCreateMediaTransportParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCreateMediaTransportParam onCreateMediaTransportParam) {
        if (onCreateMediaTransportParam == null) {
            return 0L;
        }
        return onCreateMediaTransportParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCreateMediaTransportParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMediaIdx(long j) {
        pjsua2JNI.OnCreateMediaTransportParam_mediaIdx_set(this.swigCPtr, this, j);
    }

    public long getMediaIdx() {
        return pjsua2JNI.OnCreateMediaTransportParam_mediaIdx_get(this.swigCPtr, this);
    }

    public void setMediaTp(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnCreateMediaTransportParam_mediaTp_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getMediaTp() {
        long jOnCreateMediaTransportParam_mediaTp_get = pjsua2JNI.OnCreateMediaTransportParam_mediaTp_get(this.swigCPtr, this);
        if (jOnCreateMediaTransportParam_mediaTp_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnCreateMediaTransportParam_mediaTp_get, false);
    }

    public void setFlags(long j) {
        pjsua2JNI.OnCreateMediaTransportParam_flags_set(this.swigCPtr, this, j);
    }

    public long getFlags() {
        return pjsua2JNI.OnCreateMediaTransportParam_flags_get(this.swigCPtr, this);
    }

    public OnCreateMediaTransportParam() {
        this(pjsua2JNI.new_OnCreateMediaTransportParam(), true);
    }
}

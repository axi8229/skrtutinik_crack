package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnStreamCreatedParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnStreamCreatedParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnStreamCreatedParam onStreamCreatedParam) {
        if (onStreamCreatedParam == null) {
            return 0L;
        }
        return onStreamCreatedParam.swigCPtr;
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
                    pjsua2JNI.delete_OnStreamCreatedParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setStream(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnStreamCreatedParam_stream_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getStream() {
        long jOnStreamCreatedParam_stream_get = pjsua2JNI.OnStreamCreatedParam_stream_get(this.swigCPtr, this);
        if (jOnStreamCreatedParam_stream_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnStreamCreatedParam_stream_get, false);
    }

    public void setStreamIdx(long j) {
        pjsua2JNI.OnStreamCreatedParam_streamIdx_set(this.swigCPtr, this, j);
    }

    public long getStreamIdx() {
        return pjsua2JNI.OnStreamCreatedParam_streamIdx_get(this.swigCPtr, this);
    }

    public void setDestroyPort(boolean z) {
        pjsua2JNI.OnStreamCreatedParam_destroyPort_set(this.swigCPtr, this, z);
    }

    public boolean getDestroyPort() {
        return pjsua2JNI.OnStreamCreatedParam_destroyPort_get(this.swigCPtr, this);
    }

    public void setPPort(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnStreamCreatedParam_pPort_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPPort() {
        long jOnStreamCreatedParam_pPort_get = pjsua2JNI.OnStreamCreatedParam_pPort_get(this.swigCPtr, this);
        if (jOnStreamCreatedParam_pPort_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnStreamCreatedParam_pPort_get, false);
    }

    public OnStreamCreatedParam() {
        this(pjsua2JNI.new_OnStreamCreatedParam(), true);
    }
}

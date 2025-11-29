package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnStreamDestroyedParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnStreamDestroyedParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnStreamDestroyedParam onStreamDestroyedParam) {
        if (onStreamDestroyedParam == null) {
            return 0L;
        }
        return onStreamDestroyedParam.swigCPtr;
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
                    pjsua2JNI.delete_OnStreamDestroyedParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setStream(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnStreamDestroyedParam_stream_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getStream() {
        long jOnStreamDestroyedParam_stream_get = pjsua2JNI.OnStreamDestroyedParam_stream_get(this.swigCPtr, this);
        if (jOnStreamDestroyedParam_stream_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnStreamDestroyedParam_stream_get, false);
    }

    public void setStreamIdx(long j) {
        pjsua2JNI.OnStreamDestroyedParam_streamIdx_set(this.swigCPtr, this, j);
    }

    public long getStreamIdx() {
        return pjsua2JNI.OnStreamDestroyedParam_streamIdx_get(this.swigCPtr, this);
    }

    public OnStreamDestroyedParam() {
        this(pjsua2JNI.new_OnStreamDestroyedParam(), true);
    }
}

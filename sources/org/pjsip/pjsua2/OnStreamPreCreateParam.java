package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnStreamPreCreateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnStreamPreCreateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnStreamPreCreateParam onStreamPreCreateParam) {
        if (onStreamPreCreateParam == null) {
            return 0L;
        }
        return onStreamPreCreateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnStreamPreCreateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setStreamIdx(long j) {
        pjsua2JNI.OnStreamPreCreateParam_streamIdx_set(this.swigCPtr, this, j);
    }

    public long getStreamIdx() {
        return pjsua2JNI.OnStreamPreCreateParam_streamIdx_get(this.swigCPtr, this);
    }

    public void setStreamInfo(StreamInfo streamInfo) {
        pjsua2JNI.OnStreamPreCreateParam_streamInfo_set(this.swigCPtr, this, StreamInfo.getCPtr(streamInfo), streamInfo);
    }

    public StreamInfo getStreamInfo() {
        long jOnStreamPreCreateParam_streamInfo_get = pjsua2JNI.OnStreamPreCreateParam_streamInfo_get(this.swigCPtr, this);
        if (jOnStreamPreCreateParam_streamInfo_get == 0) {
            return null;
        }
        return new StreamInfo(jOnStreamPreCreateParam_streamInfo_get, false);
    }

    public OnStreamPreCreateParam() {
        this(pjsua2JNI.new_OnStreamPreCreateParam(), true);
    }
}

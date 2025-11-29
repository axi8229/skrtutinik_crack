package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoMediaTransmitParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoMediaTransmitParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoMediaTransmitParam videoMediaTransmitParam) {
        if (videoMediaTransmitParam == null) {
            return 0L;
        }
        return videoMediaTransmitParam.swigCPtr;
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
                    pjsua2JNI.delete_VideoMediaTransmitParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public VideoMediaTransmitParam() {
        this(pjsua2JNI.new_VideoMediaTransmitParam(), true);
    }
}

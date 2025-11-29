package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoSwitchParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoSwitchParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoSwitchParam videoSwitchParam) {
        if (videoSwitchParam == null) {
            return 0L;
        }
        return videoSwitchParam.swigCPtr;
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
                    pjsua2JNI.delete_VideoSwitchParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTarget_id(int i) {
        pjsua2JNI.VideoSwitchParam_target_id_set(this.swigCPtr, this, i);
    }

    public int getTarget_id() {
        return pjsua2JNI.VideoSwitchParam_target_id_get(this.swigCPtr, this);
    }

    public VideoSwitchParam() {
        this(pjsua2JNI.new_VideoSwitchParam(), true);
    }
}

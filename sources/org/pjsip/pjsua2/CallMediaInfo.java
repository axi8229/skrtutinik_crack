package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CallMediaInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallMediaInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallMediaInfo callMediaInfo) {
        if (callMediaInfo == null) {
            return 0L;
        }
        return callMediaInfo.swigCPtr;
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
                    pjsua2JNI.delete_CallMediaInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndex(long j) {
        pjsua2JNI.CallMediaInfo_index_set(this.swigCPtr, this, j);
    }

    public long getIndex() {
        return pjsua2JNI.CallMediaInfo_index_get(this.swigCPtr, this);
    }

    public void setType(int i) {
        pjsua2JNI.CallMediaInfo_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.CallMediaInfo_type_get(this.swigCPtr, this);
    }

    public void setDir(int i) {
        pjsua2JNI.CallMediaInfo_dir_set(this.swigCPtr, this, i);
    }

    public int getDir() {
        return pjsua2JNI.CallMediaInfo_dir_get(this.swigCPtr, this);
    }

    public void setStatus(int i) {
        pjsua2JNI.CallMediaInfo_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.CallMediaInfo_status_get(this.swigCPtr, this);
    }

    public void setAudioConfSlot(int i) {
        pjsua2JNI.CallMediaInfo_audioConfSlot_set(this.swigCPtr, this, i);
    }

    public int getAudioConfSlot() {
        return pjsua2JNI.CallMediaInfo_audioConfSlot_get(this.swigCPtr, this);
    }

    public void setVideoIncomingWindowId(int i) {
        pjsua2JNI.CallMediaInfo_videoIncomingWindowId_set(this.swigCPtr, this, i);
    }

    public int getVideoIncomingWindowId() {
        return pjsua2JNI.CallMediaInfo_videoIncomingWindowId_get(this.swigCPtr, this);
    }

    public void setVideoWindow(VideoWindow videoWindow) {
        pjsua2JNI.CallMediaInfo_videoWindow_set(this.swigCPtr, this, VideoWindow.getCPtr(videoWindow), videoWindow);
    }

    public VideoWindow getVideoWindow() {
        long jCallMediaInfo_videoWindow_get = pjsua2JNI.CallMediaInfo_videoWindow_get(this.swigCPtr, this);
        if (jCallMediaInfo_videoWindow_get == 0) {
            return null;
        }
        return new VideoWindow(jCallMediaInfo_videoWindow_get, false);
    }

    public void setVideoCapDev(int i) {
        pjsua2JNI.CallMediaInfo_videoCapDev_set(this.swigCPtr, this, i);
    }

    public int getVideoCapDev() {
        return pjsua2JNI.CallMediaInfo_videoCapDev_get(this.swigCPtr, this);
    }

    public CallMediaInfo() {
        this(pjsua2JNI.new_CallMediaInfo(), true);
    }
}

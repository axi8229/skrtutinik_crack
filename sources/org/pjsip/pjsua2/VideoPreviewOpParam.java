package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoPreviewOpParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoPreviewOpParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoPreviewOpParam videoPreviewOpParam) {
        if (videoPreviewOpParam == null) {
            return 0L;
        }
        return videoPreviewOpParam.swigCPtr;
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
                    pjsua2JNI.delete_VideoPreviewOpParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRendId(int i) {
        pjsua2JNI.VideoPreviewOpParam_rendId_set(this.swigCPtr, this, i);
    }

    public int getRendId() {
        return pjsua2JNI.VideoPreviewOpParam_rendId_get(this.swigCPtr, this);
    }

    public void setShow(boolean z) {
        pjsua2JNI.VideoPreviewOpParam_show_set(this.swigCPtr, this, z);
    }

    public boolean getShow() {
        return pjsua2JNI.VideoPreviewOpParam_show_get(this.swigCPtr, this);
    }

    public void setWindowFlags(long j) {
        pjsua2JNI.VideoPreviewOpParam_windowFlags_set(this.swigCPtr, this, j);
    }

    public long getWindowFlags() {
        return pjsua2JNI.VideoPreviewOpParam_windowFlags_get(this.swigCPtr, this);
    }

    public void setFormat(MediaFormat mediaFormat) {
        pjsua2JNI.VideoPreviewOpParam_format_set(this.swigCPtr, this, MediaFormat.getCPtr(mediaFormat), mediaFormat);
    }

    public MediaFormat getFormat() {
        long jVideoPreviewOpParam_format_get = pjsua2JNI.VideoPreviewOpParam_format_get(this.swigCPtr, this);
        if (jVideoPreviewOpParam_format_get == 0) {
            return null;
        }
        return new MediaFormat(jVideoPreviewOpParam_format_get, false);
    }

    public void setWindow(VideoWindowHandle videoWindowHandle) {
        pjsua2JNI.VideoPreviewOpParam_window_set(this.swigCPtr, this, VideoWindowHandle.getCPtr(videoWindowHandle), videoWindowHandle);
    }

    public VideoWindowHandle getWindow() {
        long jVideoPreviewOpParam_window_get = pjsua2JNI.VideoPreviewOpParam_window_get(this.swigCPtr, this);
        if (jVideoPreviewOpParam_window_get == 0) {
            return null;
        }
        return new VideoWindowHandle(jVideoPreviewOpParam_window_get, false);
    }

    public VideoPreviewOpParam() {
        this(pjsua2JNI.new_VideoPreviewOpParam(), true);
    }
}

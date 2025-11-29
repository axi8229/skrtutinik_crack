package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoPreview {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoPreview(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoPreview videoPreview) {
        if (videoPreview == null) {
            return 0L;
        }
        return videoPreview.swigCPtr;
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
                    pjsua2JNI.delete_VideoPreview(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public VideoPreview(int i) {
        this(pjsua2JNI.new_VideoPreview(i), true);
    }

    public boolean hasNative() {
        return pjsua2JNI.VideoPreview_hasNative(this.swigCPtr, this);
    }

    public void start(VideoPreviewOpParam videoPreviewOpParam) throws Exception {
        pjsua2JNI.VideoPreview_start(this.swigCPtr, this, VideoPreviewOpParam.getCPtr(videoPreviewOpParam), videoPreviewOpParam);
    }

    public void stop() throws Exception {
        pjsua2JNI.VideoPreview_stop(this.swigCPtr, this);
    }

    public VideoWindow getVideoWindow() {
        return new VideoWindow(pjsua2JNI.VideoPreview_getVideoWindow(this.swigCPtr, this), true);
    }

    public VideoMedia getVideoMedia() throws Exception {
        return new VideoMedia(pjsua2JNI.VideoPreview_getVideoMedia(this.swigCPtr, this), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoWindow {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoWindow(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoWindow videoWindow) {
        if (videoWindow == null) {
            return 0L;
        }
        return videoWindow.swigCPtr;
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
                    pjsua2JNI.delete_VideoWindow(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public VideoWindow(int i) {
        this(pjsua2JNI.new_VideoWindow(i), true);
    }

    public VideoWindowInfo getInfo() throws Exception {
        return new VideoWindowInfo(pjsua2JNI.VideoWindow_getInfo(this.swigCPtr, this), true);
    }

    public VideoMedia getVideoMedia() throws Exception {
        return new VideoMedia(pjsua2JNI.VideoWindow_getVideoMedia(this.swigCPtr, this), true);
    }

    public void Show(boolean z) throws Exception {
        pjsua2JNI.VideoWindow_Show(this.swigCPtr, this, z);
    }

    public void setPos(MediaCoordinate mediaCoordinate) throws Exception {
        pjsua2JNI.VideoWindow_setPos(this.swigCPtr, this, MediaCoordinate.getCPtr(mediaCoordinate), mediaCoordinate);
    }

    public void setSize(MediaSize mediaSize) throws Exception {
        pjsua2JNI.VideoWindow_setSize(this.swigCPtr, this, MediaSize.getCPtr(mediaSize), mediaSize);
    }

    public void rotate(int i) throws Exception {
        pjsua2JNI.VideoWindow_rotate(this.swigCPtr, this, i);
    }

    public void setWindow(VideoWindowHandle videoWindowHandle) throws Exception {
        pjsua2JNI.VideoWindow_setWindow(this.swigCPtr, this, VideoWindowHandle.getCPtr(videoWindowHandle), videoWindowHandle);
    }

    public void setFullScreen(boolean z) throws Exception {
        pjsua2JNI.VideoWindow_setFullScreen(this.swigCPtr, this, z);
    }

    public void setFullScreen2(int i) throws Exception {
        pjsua2JNI.VideoWindow_setFullScreen2(this.swigCPtr, this, i);
    }
}

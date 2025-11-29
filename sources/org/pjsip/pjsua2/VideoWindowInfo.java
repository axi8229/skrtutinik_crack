package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoWindowInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoWindowInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoWindowInfo videoWindowInfo) {
        if (videoWindowInfo == null) {
            return 0L;
        }
        return videoWindowInfo.swigCPtr;
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
                    pjsua2JNI.delete_VideoWindowInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIsNative(boolean z) {
        pjsua2JNI.VideoWindowInfo_isNative_set(this.swigCPtr, this, z);
    }

    public boolean getIsNative() {
        return pjsua2JNI.VideoWindowInfo_isNative_get(this.swigCPtr, this);
    }

    public void setWinHandle(VideoWindowHandle videoWindowHandle) {
        pjsua2JNI.VideoWindowInfo_winHandle_set(this.swigCPtr, this, VideoWindowHandle.getCPtr(videoWindowHandle), videoWindowHandle);
    }

    public VideoWindowHandle getWinHandle() {
        long jVideoWindowInfo_winHandle_get = pjsua2JNI.VideoWindowInfo_winHandle_get(this.swigCPtr, this);
        if (jVideoWindowInfo_winHandle_get == 0) {
            return null;
        }
        return new VideoWindowHandle(jVideoWindowInfo_winHandle_get, false);
    }

    public void setRenderDeviceId(int i) {
        pjsua2JNI.VideoWindowInfo_renderDeviceId_set(this.swigCPtr, this, i);
    }

    public int getRenderDeviceId() {
        return pjsua2JNI.VideoWindowInfo_renderDeviceId_get(this.swigCPtr, this);
    }

    public void setShow(boolean z) {
        pjsua2JNI.VideoWindowInfo_show_set(this.swigCPtr, this, z);
    }

    public boolean getShow() {
        return pjsua2JNI.VideoWindowInfo_show_get(this.swigCPtr, this);
    }

    public void setPos(MediaCoordinate mediaCoordinate) {
        pjsua2JNI.VideoWindowInfo_pos_set(this.swigCPtr, this, MediaCoordinate.getCPtr(mediaCoordinate), mediaCoordinate);
    }

    public MediaCoordinate getPos() {
        long jVideoWindowInfo_pos_get = pjsua2JNI.VideoWindowInfo_pos_get(this.swigCPtr, this);
        if (jVideoWindowInfo_pos_get == 0) {
            return null;
        }
        return new MediaCoordinate(jVideoWindowInfo_pos_get, false);
    }

    public void setSize(MediaSize mediaSize) {
        pjsua2JNI.VideoWindowInfo_size_set(this.swigCPtr, this, MediaSize.getCPtr(mediaSize), mediaSize);
    }

    public MediaSize getSize() {
        long jVideoWindowInfo_size_get = pjsua2JNI.VideoWindowInfo_size_get(this.swigCPtr, this);
        if (jVideoWindowInfo_size_get == 0) {
            return null;
        }
        return new MediaSize(jVideoWindowInfo_size_get, false);
    }

    public VideoWindowInfo() {
        this(pjsua2JNI.new_VideoWindowInfo(), true);
    }
}

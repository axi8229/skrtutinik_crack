package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VidDevManager {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VidDevManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VidDevManager vidDevManager) {
        if (vidDevManager == null) {
            return 0L;
        }
        return vidDevManager.swigCPtr;
    }

    public synchronized void delete() {
        try {
            if (this.swigCPtr != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    throw new UnsupportedOperationException("C++ destructor does not have public access");
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void initSubsys() throws Exception {
        pjsua2JNI.VidDevManager_initSubsys(this.swigCPtr, this);
    }

    public void refreshDevs() throws Exception {
        pjsua2JNI.VidDevManager_refreshDevs(this.swigCPtr, this);
    }

    public long getDevCount() {
        return pjsua2JNI.VidDevManager_getDevCount(this.swigCPtr, this);
    }

    public VideoDevInfo getDevInfo(int i) throws Exception {
        return new VideoDevInfo(pjsua2JNI.VidDevManager_getDevInfo(this.swigCPtr, this, i), true);
    }

    public VideoDevInfoVector2 enumDev2() throws Exception {
        return new VideoDevInfoVector2(pjsua2JNI.VidDevManager_enumDev2(this.swigCPtr, this), true);
    }

    public int lookupDev(String str, String str2) throws Exception {
        return pjsua2JNI.VidDevManager_lookupDev(this.swigCPtr, this, str, str2);
    }

    public String capName(int i) {
        return pjsua2JNI.VidDevManager_capName(this.swigCPtr, this, i);
    }

    public void setFormat(int i, MediaFormatVideo mediaFormatVideo, boolean z) throws Exception {
        pjsua2JNI.VidDevManager_setFormat(this.swigCPtr, this, i, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo, z);
    }

    public MediaFormatVideo getFormat(int i) throws Exception {
        return new MediaFormatVideo(pjsua2JNI.VidDevManager_getFormat(this.swigCPtr, this, i), true);
    }

    public void setInputScale(int i, MediaSize mediaSize, boolean z) throws Exception {
        pjsua2JNI.VidDevManager_setInputScale(this.swigCPtr, this, i, MediaSize.getCPtr(mediaSize), mediaSize, z);
    }

    public MediaSize getInputScale(int i) throws Exception {
        return new MediaSize(pjsua2JNI.VidDevManager_getInputScale(this.swigCPtr, this, i), true);
    }

    public void setOutputWindowFlags(int i, int i2, boolean z) throws Exception {
        pjsua2JNI.VidDevManager_setOutputWindowFlags(this.swigCPtr, this, i, i2, z);
    }

    public int getOutputWindowFlags(int i) throws Exception {
        return pjsua2JNI.VidDevManager_getOutputWindowFlags(this.swigCPtr, this, i);
    }

    public void switchDev(int i, VideoSwitchParam videoSwitchParam) throws Exception {
        pjsua2JNI.VidDevManager_switchDev(this.swigCPtr, this, i, VideoSwitchParam.getCPtr(videoSwitchParam), videoSwitchParam);
    }

    public boolean isCaptureActive(int i) {
        return pjsua2JNI.VidDevManager_isCaptureActive(this.swigCPtr, this, i);
    }

    public void setCaptureOrient(int i, int i2, boolean z) throws Exception {
        pjsua2JNI.VidDevManager_setCaptureOrient__SWIG_0(this.swigCPtr, this, i, i2, z);
    }

    public void setCaptureOrient(int i, int i2) throws Exception {
        pjsua2JNI.VidDevManager_setCaptureOrient__SWIG_1(this.swigCPtr, this, i, i2);
    }
}

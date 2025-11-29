package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoDevInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoDevInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoDevInfo videoDevInfo) {
        if (videoDevInfo == null) {
            return 0L;
        }
        return videoDevInfo.swigCPtr;
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
                    pjsua2JNI.delete_VideoDevInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setId(int i) {
        pjsua2JNI.VideoDevInfo_id_set(this.swigCPtr, this, i);
    }

    public int getId() {
        return pjsua2JNI.VideoDevInfo_id_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        pjsua2JNI.VideoDevInfo_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.VideoDevInfo_name_get(this.swigCPtr, this);
    }

    public void setDriver(String str) {
        pjsua2JNI.VideoDevInfo_driver_set(this.swigCPtr, this, str);
    }

    public String getDriver() {
        return pjsua2JNI.VideoDevInfo_driver_get(this.swigCPtr, this);
    }

    public void setDir(int i) {
        pjsua2JNI.VideoDevInfo_dir_set(this.swigCPtr, this, i);
    }

    public int getDir() {
        return pjsua2JNI.VideoDevInfo_dir_get(this.swigCPtr, this);
    }

    public void setCaps(long j) {
        pjsua2JNI.VideoDevInfo_caps_set(this.swigCPtr, this, j);
    }

    public long getCaps() {
        return pjsua2JNI.VideoDevInfo_caps_get(this.swigCPtr, this);
    }

    public void setFmt(MediaFormatVideoVector mediaFormatVideoVector) {
        pjsua2JNI.VideoDevInfo_fmt_set(this.swigCPtr, this, MediaFormatVideoVector.getCPtr(mediaFormatVideoVector), mediaFormatVideoVector);
    }

    public MediaFormatVideoVector getFmt() {
        long jVideoDevInfo_fmt_get = pjsua2JNI.VideoDevInfo_fmt_get(this.swigCPtr, this);
        if (jVideoDevInfo_fmt_get == 0) {
            return null;
        }
        return new MediaFormatVideoVector(jVideoDevInfo_fmt_get, false);
    }

    public VideoDevInfo() {
        this(pjsua2JNI.new_VideoDevInfo(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AudioDevInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioDevInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioDevInfo audioDevInfo) {
        if (audioDevInfo == null) {
            return 0L;
        }
        return audioDevInfo.swigCPtr;
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
                    pjsua2JNI.delete_AudioDevInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setName(String str) {
        pjsua2JNI.AudioDevInfo_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.AudioDevInfo_name_get(this.swigCPtr, this);
    }

    public void setInputCount(long j) {
        pjsua2JNI.AudioDevInfo_inputCount_set(this.swigCPtr, this, j);
    }

    public long getInputCount() {
        return pjsua2JNI.AudioDevInfo_inputCount_get(this.swigCPtr, this);
    }

    public void setOutputCount(long j) {
        pjsua2JNI.AudioDevInfo_outputCount_set(this.swigCPtr, this, j);
    }

    public long getOutputCount() {
        return pjsua2JNI.AudioDevInfo_outputCount_get(this.swigCPtr, this);
    }

    public void setDefaultSamplesPerSec(long j) {
        pjsua2JNI.AudioDevInfo_defaultSamplesPerSec_set(this.swigCPtr, this, j);
    }

    public long getDefaultSamplesPerSec() {
        return pjsua2JNI.AudioDevInfo_defaultSamplesPerSec_get(this.swigCPtr, this);
    }

    public void setDriver(String str) {
        pjsua2JNI.AudioDevInfo_driver_set(this.swigCPtr, this, str);
    }

    public String getDriver() {
        return pjsua2JNI.AudioDevInfo_driver_get(this.swigCPtr, this);
    }

    public void setCaps(long j) {
        pjsua2JNI.AudioDevInfo_caps_set(this.swigCPtr, this, j);
    }

    public long getCaps() {
        return pjsua2JNI.AudioDevInfo_caps_get(this.swigCPtr, this);
    }

    public void setRoutes(long j) {
        pjsua2JNI.AudioDevInfo_routes_set(this.swigCPtr, this, j);
    }

    public long getRoutes() {
        return pjsua2JNI.AudioDevInfo_routes_get(this.swigCPtr, this);
    }

    public void setExtFmt(MediaFormatAudioVector mediaFormatAudioVector) {
        pjsua2JNI.AudioDevInfo_extFmt_set(this.swigCPtr, this, MediaFormatAudioVector.getCPtr(mediaFormatAudioVector), mediaFormatAudioVector);
    }

    public MediaFormatAudioVector getExtFmt() {
        long jAudioDevInfo_extFmt_get = pjsua2JNI.AudioDevInfo_extFmt_get(this.swigCPtr, this);
        if (jAudioDevInfo_extFmt_get == 0) {
            return null;
        }
        return new MediaFormatAudioVector(jAudioDevInfo_extFmt_get, false);
    }

    public AudioDevInfo() {
        this(pjsua2JNI.new_AudioDevInfo(), true);
    }
}

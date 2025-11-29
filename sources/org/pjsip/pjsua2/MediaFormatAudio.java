package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaFormatAudio extends MediaFormat {
    private transient long swigCPtr;

    protected MediaFormatAudio(long j, boolean z) {
        super(pjsua2JNI.MediaFormatAudio_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaFormatAudio mediaFormatAudio) {
        if (mediaFormatAudio == null) {
            return 0L;
        }
        return mediaFormatAudio.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.MediaFormat
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.MediaFormat
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_MediaFormatAudio(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setClockRate(long j) {
        pjsua2JNI.MediaFormatAudio_clockRate_set(this.swigCPtr, this, j);
    }

    public long getClockRate() {
        return pjsua2JNI.MediaFormatAudio_clockRate_get(this.swigCPtr, this);
    }

    public void setChannelCount(long j) {
        pjsua2JNI.MediaFormatAudio_channelCount_set(this.swigCPtr, this, j);
    }

    public long getChannelCount() {
        return pjsua2JNI.MediaFormatAudio_channelCount_get(this.swigCPtr, this);
    }

    public void setFrameTimeUsec(long j) {
        pjsua2JNI.MediaFormatAudio_frameTimeUsec_set(this.swigCPtr, this, j);
    }

    public long getFrameTimeUsec() {
        return pjsua2JNI.MediaFormatAudio_frameTimeUsec_get(this.swigCPtr, this);
    }

    public void setBitsPerSample(long j) {
        pjsua2JNI.MediaFormatAudio_bitsPerSample_set(this.swigCPtr, this, j);
    }

    public long getBitsPerSample() {
        return pjsua2JNI.MediaFormatAudio_bitsPerSample_get(this.swigCPtr, this);
    }

    public void setAvgBps(long j) {
        pjsua2JNI.MediaFormatAudio_avgBps_set(this.swigCPtr, this, j);
    }

    public long getAvgBps() {
        return pjsua2JNI.MediaFormatAudio_avgBps_get(this.swigCPtr, this);
    }

    public void setMaxBps(long j) {
        pjsua2JNI.MediaFormatAudio_maxBps_set(this.swigCPtr, this, j);
    }

    public long getMaxBps() {
        return pjsua2JNI.MediaFormatAudio_maxBps_get(this.swigCPtr, this);
    }

    public MediaFormatAudio() {
        this(pjsua2JNI.new_MediaFormatAudio(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AudioMediaPlayerInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioMediaPlayerInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioMediaPlayerInfo audioMediaPlayerInfo) {
        if (audioMediaPlayerInfo == null) {
            return 0L;
        }
        return audioMediaPlayerInfo.swigCPtr;
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
                    pjsua2JNI.delete_AudioMediaPlayerInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFormatId(int i) {
        pjsua2JNI.AudioMediaPlayerInfo_formatId_set(this.swigCPtr, this, i);
    }

    public int getFormatId() {
        return pjsua2JNI.AudioMediaPlayerInfo_formatId_get(this.swigCPtr, this);
    }

    public void setPayloadBitsPerSample(long j) {
        pjsua2JNI.AudioMediaPlayerInfo_payloadBitsPerSample_set(this.swigCPtr, this, j);
    }

    public long getPayloadBitsPerSample() {
        return pjsua2JNI.AudioMediaPlayerInfo_payloadBitsPerSample_get(this.swigCPtr, this);
    }

    public void setSizeBytes(long j) {
        pjsua2JNI.AudioMediaPlayerInfo_sizeBytes_set(this.swigCPtr, this, j);
    }

    public long getSizeBytes() {
        return pjsua2JNI.AudioMediaPlayerInfo_sizeBytes_get(this.swigCPtr, this);
    }

    public void setSizeSamples(long j) {
        pjsua2JNI.AudioMediaPlayerInfo_sizeSamples_set(this.swigCPtr, this, j);
    }

    public long getSizeSamples() {
        return pjsua2JNI.AudioMediaPlayerInfo_sizeSamples_get(this.swigCPtr, this);
    }

    public AudioMediaPlayerInfo() {
        this(pjsua2JNI.new_AudioMediaPlayerInfo(), true);
    }
}

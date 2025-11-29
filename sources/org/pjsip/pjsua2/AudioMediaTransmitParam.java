package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AudioMediaTransmitParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioMediaTransmitParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioMediaTransmitParam audioMediaTransmitParam) {
        if (audioMediaTransmitParam == null) {
            return 0L;
        }
        return audioMediaTransmitParam.swigCPtr;
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
                    pjsua2JNI.delete_AudioMediaTransmitParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setLevel(float f) {
        pjsua2JNI.AudioMediaTransmitParam_level_set(this.swigCPtr, this, f);
    }

    public float getLevel() {
        return pjsua2JNI.AudioMediaTransmitParam_level_get(this.swigCPtr, this);
    }

    public AudioMediaTransmitParam() {
        this(pjsua2JNI.new_AudioMediaTransmitParam(), true);
    }
}

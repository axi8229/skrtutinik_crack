package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class ExtraAudioDevice extends AudioMedia {
    private transient long swigCPtr;

    protected ExtraAudioDevice(long j, boolean z) {
        super(pjsua2JNI.ExtraAudioDevice_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ExtraAudioDevice extraAudioDevice) {
        if (extraAudioDevice == null) {
            return 0L;
        }
        return extraAudioDevice.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.AudioMedia, org.pjsip.pjsua2.Media
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.AudioMedia, org.pjsip.pjsua2.Media
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_ExtraAudioDevice(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public ExtraAudioDevice(int i, int i2) {
        this(pjsua2JNI.new_ExtraAudioDevice(i, i2), true);
    }

    public void open() {
        pjsua2JNI.ExtraAudioDevice_open(this.swigCPtr, this);
    }

    public void close() {
        pjsua2JNI.ExtraAudioDevice_close(this.swigCPtr, this);
    }

    public boolean isOpened() {
        return pjsua2JNI.ExtraAudioDevice_isOpened(this.swigCPtr, this);
    }
}

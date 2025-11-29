package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AudioMedia extends Media {
    private transient long swigCPtr;

    protected AudioMedia(long j, boolean z) {
        super(pjsua2JNI.AudioMedia_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioMedia audioMedia) {
        if (audioMedia == null) {
            return 0L;
        }
        return audioMedia.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.Media
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.Media
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_AudioMedia(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public ConfPortInfo getPortInfo() throws Exception {
        return new ConfPortInfo(pjsua2JNI.AudioMedia_getPortInfo(this.swigCPtr, this), true);
    }

    public int getPortId() {
        return pjsua2JNI.AudioMedia_getPortId(this.swigCPtr, this);
    }

    public static ConfPortInfo getPortInfoFromId(int i) throws Exception {
        return new ConfPortInfo(pjsua2JNI.AudioMedia_getPortInfoFromId(i), true);
    }

    public void startTransmit(AudioMedia audioMedia) throws Exception {
        pjsua2JNI.AudioMedia_startTransmit(this.swigCPtr, this, getCPtr(audioMedia), audioMedia);
    }

    public void startTransmit2(AudioMedia audioMedia, AudioMediaTransmitParam audioMediaTransmitParam) throws Exception {
        pjsua2JNI.AudioMedia_startTransmit2(this.swigCPtr, this, getCPtr(audioMedia), audioMedia, AudioMediaTransmitParam.getCPtr(audioMediaTransmitParam), audioMediaTransmitParam);
    }

    public void stopTransmit(AudioMedia audioMedia) throws Exception {
        pjsua2JNI.AudioMedia_stopTransmit(this.swigCPtr, this, getCPtr(audioMedia), audioMedia);
    }

    public void adjustRxLevel(float f) throws Exception {
        pjsua2JNI.AudioMedia_adjustRxLevel(this.swigCPtr, this, f);
    }

    public void adjustTxLevel(float f) throws Exception {
        pjsua2JNI.AudioMedia_adjustTxLevel(this.swigCPtr, this, f);
    }

    public long getRxLevel() throws Exception {
        return pjsua2JNI.AudioMedia_getRxLevel(this.swigCPtr, this);
    }

    public long getTxLevel() throws Exception {
        return pjsua2JNI.AudioMedia_getTxLevel(this.swigCPtr, this);
    }

    public static AudioMedia typecastFromMedia(Media media) {
        long jAudioMedia_typecastFromMedia = pjsua2JNI.AudioMedia_typecastFromMedia(Media.getCPtr(media), media);
        if (jAudioMedia_typecastFromMedia == 0) {
            return null;
        }
        return new AudioMedia(jAudioMedia_typecastFromMedia, false);
    }

    public AudioMedia() {
        this(pjsua2JNI.new_AudioMedia(), true);
    }
}

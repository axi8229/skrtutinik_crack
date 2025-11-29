package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AudioMediaRecorder extends AudioMedia {
    private transient long swigCPtr;

    protected AudioMediaRecorder(long j, boolean z) {
        super(pjsua2JNI.AudioMediaRecorder_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioMediaRecorder audioMediaRecorder) {
        if (audioMediaRecorder == null) {
            return 0L;
        }
        return audioMediaRecorder.swigCPtr;
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
                    pjsua2JNI.delete_AudioMediaRecorder(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public AudioMediaRecorder() {
        this(pjsua2JNI.new_AudioMediaRecorder(), true);
    }

    public void createRecorder(String str, long j, int i, long j2) throws Exception {
        pjsua2JNI.AudioMediaRecorder_createRecorder__SWIG_0(this.swigCPtr, this, str, j, i, j2);
    }

    public void createRecorder(String str, long j, int i) throws Exception {
        pjsua2JNI.AudioMediaRecorder_createRecorder__SWIG_1(this.swigCPtr, this, str, j, i);
    }

    public void createRecorder(String str, long j) throws Exception {
        pjsua2JNI.AudioMediaRecorder_createRecorder__SWIG_2(this.swigCPtr, this, str, j);
    }

    public void createRecorder(String str) throws Exception {
        pjsua2JNI.AudioMediaRecorder_createRecorder__SWIG_3(this.swigCPtr, this, str);
    }

    public static AudioMediaRecorder typecastFromAudioMedia(AudioMedia audioMedia) {
        long jAudioMediaRecorder_typecastFromAudioMedia = pjsua2JNI.AudioMediaRecorder_typecastFromAudioMedia(AudioMedia.getCPtr(audioMedia), audioMedia);
        if (jAudioMediaRecorder_typecastFromAudioMedia == 0) {
            return null;
        }
        return new AudioMediaRecorder(jAudioMediaRecorder_typecastFromAudioMedia, false);
    }
}

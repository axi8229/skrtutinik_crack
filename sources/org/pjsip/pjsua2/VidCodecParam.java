package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VidCodecParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VidCodecParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VidCodecParam vidCodecParam) {
        if (vidCodecParam == null) {
            return 0L;
        }
        return vidCodecParam.swigCPtr;
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
                    pjsua2JNI.delete_VidCodecParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDir(int i) {
        pjsua2JNI.VidCodecParam_dir_set(this.swigCPtr, this, i);
    }

    public int getDir() {
        return pjsua2JNI.VidCodecParam_dir_get(this.swigCPtr, this);
    }

    public void setPacking(int i) {
        pjsua2JNI.VidCodecParam_packing_set(this.swigCPtr, this, i);
    }

    public int getPacking() {
        return pjsua2JNI.VidCodecParam_packing_get(this.swigCPtr, this);
    }

    public void setEncFmt(MediaFormatVideo mediaFormatVideo) {
        pjsua2JNI.VidCodecParam_encFmt_set(this.swigCPtr, this, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo);
    }

    public MediaFormatVideo getEncFmt() {
        long jVidCodecParam_encFmt_get = pjsua2JNI.VidCodecParam_encFmt_get(this.swigCPtr, this);
        if (jVidCodecParam_encFmt_get == 0) {
            return null;
        }
        return new MediaFormatVideo(jVidCodecParam_encFmt_get, false);
    }

    public void setEncFmtp(CodecFmtpVector codecFmtpVector) {
        pjsua2JNI.VidCodecParam_encFmtp_set(this.swigCPtr, this, CodecFmtpVector.getCPtr(codecFmtpVector), codecFmtpVector);
    }

    public CodecFmtpVector getEncFmtp() {
        long jVidCodecParam_encFmtp_get = pjsua2JNI.VidCodecParam_encFmtp_get(this.swigCPtr, this);
        if (jVidCodecParam_encFmtp_get == 0) {
            return null;
        }
        return new CodecFmtpVector(jVidCodecParam_encFmtp_get, false);
    }

    public void setEncMtu(long j) {
        pjsua2JNI.VidCodecParam_encMtu_set(this.swigCPtr, this, j);
    }

    public long getEncMtu() {
        return pjsua2JNI.VidCodecParam_encMtu_get(this.swigCPtr, this);
    }

    public void setDecFmt(MediaFormatVideo mediaFormatVideo) {
        pjsua2JNI.VidCodecParam_decFmt_set(this.swigCPtr, this, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo);
    }

    public MediaFormatVideo getDecFmt() {
        long jVidCodecParam_decFmt_get = pjsua2JNI.VidCodecParam_decFmt_get(this.swigCPtr, this);
        if (jVidCodecParam_decFmt_get == 0) {
            return null;
        }
        return new MediaFormatVideo(jVidCodecParam_decFmt_get, false);
    }

    public void setDecFmtp(CodecFmtpVector codecFmtpVector) {
        pjsua2JNI.VidCodecParam_decFmtp_set(this.swigCPtr, this, CodecFmtpVector.getCPtr(codecFmtpVector), codecFmtpVector);
    }

    public CodecFmtpVector getDecFmtp() {
        long jVidCodecParam_decFmtp_get = pjsua2JNI.VidCodecParam_decFmtp_get(this.swigCPtr, this);
        if (jVidCodecParam_decFmtp_get == 0) {
            return null;
        }
        return new CodecFmtpVector(jVidCodecParam_decFmtp_get, false);
    }

    public void setIgnoreFmtp(boolean z) {
        pjsua2JNI.VidCodecParam_ignoreFmtp_set(this.swigCPtr, this, z);
    }

    public boolean getIgnoreFmtp() {
        return pjsua2JNI.VidCodecParam_ignoreFmtp_get(this.swigCPtr, this);
    }

    public VidCodecParam() {
        this(pjsua2JNI.new_VidCodecParam(), true);
    }
}

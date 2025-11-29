package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CodecParamSetting {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecParamSetting(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecParamSetting codecParamSetting) {
        if (codecParamSetting == null) {
            return 0L;
        }
        return codecParamSetting.swigCPtr;
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
                    pjsua2JNI.delete_CodecParamSetting(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFrmPerPkt(long j) {
        pjsua2JNI.CodecParamSetting_frmPerPkt_set(this.swigCPtr, this, j);
    }

    public long getFrmPerPkt() {
        return pjsua2JNI.CodecParamSetting_frmPerPkt_get(this.swigCPtr, this);
    }

    public void setVad(boolean z) {
        pjsua2JNI.CodecParamSetting_vad_set(this.swigCPtr, this, z);
    }

    public boolean getVad() {
        return pjsua2JNI.CodecParamSetting_vad_get(this.swigCPtr, this);
    }

    public void setCng(boolean z) {
        pjsua2JNI.CodecParamSetting_cng_set(this.swigCPtr, this, z);
    }

    public boolean getCng() {
        return pjsua2JNI.CodecParamSetting_cng_get(this.swigCPtr, this);
    }

    public void setPenh(boolean z) {
        pjsua2JNI.CodecParamSetting_penh_set(this.swigCPtr, this, z);
    }

    public boolean getPenh() {
        return pjsua2JNI.CodecParamSetting_penh_get(this.swigCPtr, this);
    }

    public void setPlc(boolean z) {
        pjsua2JNI.CodecParamSetting_plc_set(this.swigCPtr, this, z);
    }

    public boolean getPlc() {
        return pjsua2JNI.CodecParamSetting_plc_get(this.swigCPtr, this);
    }

    public void setReserved(boolean z) {
        pjsua2JNI.CodecParamSetting_reserved_set(this.swigCPtr, this, z);
    }

    public boolean getReserved() {
        return pjsua2JNI.CodecParamSetting_reserved_get(this.swigCPtr, this);
    }

    public void setEncFmtp(CodecFmtpVector codecFmtpVector) {
        pjsua2JNI.CodecParamSetting_encFmtp_set(this.swigCPtr, this, CodecFmtpVector.getCPtr(codecFmtpVector), codecFmtpVector);
    }

    public CodecFmtpVector getEncFmtp() {
        long jCodecParamSetting_encFmtp_get = pjsua2JNI.CodecParamSetting_encFmtp_get(this.swigCPtr, this);
        if (jCodecParamSetting_encFmtp_get == 0) {
            return null;
        }
        return new CodecFmtpVector(jCodecParamSetting_encFmtp_get, false);
    }

    public void setDecFmtp(CodecFmtpVector codecFmtpVector) {
        pjsua2JNI.CodecParamSetting_decFmtp_set(this.swigCPtr, this, CodecFmtpVector.getCPtr(codecFmtpVector), codecFmtpVector);
    }

    public CodecFmtpVector getDecFmtp() {
        long jCodecParamSetting_decFmtp_get = pjsua2JNI.CodecParamSetting_decFmtp_get(this.swigCPtr, this);
        if (jCodecParamSetting_decFmtp_get == 0) {
            return null;
        }
        return new CodecFmtpVector(jCodecParamSetting_decFmtp_get, false);
    }

    public void setPacketLoss(long j) {
        pjsua2JNI.CodecParamSetting_packetLoss_set(this.swigCPtr, this, j);
    }

    public long getPacketLoss() {
        return pjsua2JNI.CodecParamSetting_packetLoss_get(this.swigCPtr, this);
    }

    public void setComplexity(long j) {
        pjsua2JNI.CodecParamSetting_complexity_set(this.swigCPtr, this, j);
    }

    public long getComplexity() {
        return pjsua2JNI.CodecParamSetting_complexity_get(this.swigCPtr, this);
    }

    public void setCbr(boolean z) {
        pjsua2JNI.CodecParamSetting_cbr_set(this.swigCPtr, this, z);
    }

    public boolean getCbr() {
        return pjsua2JNI.CodecParamSetting_cbr_get(this.swigCPtr, this);
    }

    public CodecParamSetting() {
        this(pjsua2JNI.new_CodecParamSetting(), true);
    }
}

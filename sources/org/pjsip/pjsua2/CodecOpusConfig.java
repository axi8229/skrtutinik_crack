package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CodecOpusConfig {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecOpusConfig(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecOpusConfig codecOpusConfig) {
        if (codecOpusConfig == null) {
            return 0L;
        }
        return codecOpusConfig.swigCPtr;
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
                    pjsua2JNI.delete_CodecOpusConfig(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSample_rate(long j) {
        pjsua2JNI.CodecOpusConfig_sample_rate_set(this.swigCPtr, this, j);
    }

    public long getSample_rate() {
        return pjsua2JNI.CodecOpusConfig_sample_rate_get(this.swigCPtr, this);
    }

    public void setChannel_cnt(long j) {
        pjsua2JNI.CodecOpusConfig_channel_cnt_set(this.swigCPtr, this, j);
    }

    public long getChannel_cnt() {
        return pjsua2JNI.CodecOpusConfig_channel_cnt_get(this.swigCPtr, this);
    }

    public void setFrm_ptime(long j) {
        pjsua2JNI.CodecOpusConfig_frm_ptime_set(this.swigCPtr, this, j);
    }

    public long getFrm_ptime() {
        return pjsua2JNI.CodecOpusConfig_frm_ptime_get(this.swigCPtr, this);
    }

    public void setBit_rate(long j) {
        pjsua2JNI.CodecOpusConfig_bit_rate_set(this.swigCPtr, this, j);
    }

    public long getBit_rate() {
        return pjsua2JNI.CodecOpusConfig_bit_rate_get(this.swigCPtr, this);
    }

    public void setPacket_loss(long j) {
        pjsua2JNI.CodecOpusConfig_packet_loss_set(this.swigCPtr, this, j);
    }

    public long getPacket_loss() {
        return pjsua2JNI.CodecOpusConfig_packet_loss_get(this.swigCPtr, this);
    }

    public void setComplexity(long j) {
        pjsua2JNI.CodecOpusConfig_complexity_set(this.swigCPtr, this, j);
    }

    public long getComplexity() {
        return pjsua2JNI.CodecOpusConfig_complexity_get(this.swigCPtr, this);
    }

    public void setCbr(boolean z) {
        pjsua2JNI.CodecOpusConfig_cbr_set(this.swigCPtr, this, z);
    }

    public boolean getCbr() {
        return pjsua2JNI.CodecOpusConfig_cbr_get(this.swigCPtr, this);
    }

    public CodecOpusConfig() {
        this(pjsua2JNI.new_CodecOpusConfig(), true);
    }
}

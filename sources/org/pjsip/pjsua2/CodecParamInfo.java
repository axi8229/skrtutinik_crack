package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CodecParamInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecParamInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecParamInfo codecParamInfo) {
        if (codecParamInfo == null) {
            return 0L;
        }
        return codecParamInfo.swigCPtr;
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
                    pjsua2JNI.delete_CodecParamInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setClockRate(long j) {
        pjsua2JNI.CodecParamInfo_clockRate_set(this.swigCPtr, this, j);
    }

    public long getClockRate() {
        return pjsua2JNI.CodecParamInfo_clockRate_get(this.swigCPtr, this);
    }

    public void setChannelCnt(long j) {
        pjsua2JNI.CodecParamInfo_channelCnt_set(this.swigCPtr, this, j);
    }

    public long getChannelCnt() {
        return pjsua2JNI.CodecParamInfo_channelCnt_get(this.swigCPtr, this);
    }

    public void setAvgBps(long j) {
        pjsua2JNI.CodecParamInfo_avgBps_set(this.swigCPtr, this, j);
    }

    public long getAvgBps() {
        return pjsua2JNI.CodecParamInfo_avgBps_get(this.swigCPtr, this);
    }

    public void setMaxBps(long j) {
        pjsua2JNI.CodecParamInfo_maxBps_set(this.swigCPtr, this, j);
    }

    public long getMaxBps() {
        return pjsua2JNI.CodecParamInfo_maxBps_get(this.swigCPtr, this);
    }

    public void setMaxRxFrameSize(long j) {
        pjsua2JNI.CodecParamInfo_maxRxFrameSize_set(this.swigCPtr, this, j);
    }

    public long getMaxRxFrameSize() {
        return pjsua2JNI.CodecParamInfo_maxRxFrameSize_get(this.swigCPtr, this);
    }

    public void setFrameLen(long j) {
        pjsua2JNI.CodecParamInfo_frameLen_set(this.swigCPtr, this, j);
    }

    public long getFrameLen() {
        return pjsua2JNI.CodecParamInfo_frameLen_get(this.swigCPtr, this);
    }

    public void setEncFrameLen(long j) {
        pjsua2JNI.CodecParamInfo_encFrameLen_set(this.swigCPtr, this, j);
    }

    public long getEncFrameLen() {
        return pjsua2JNI.CodecParamInfo_encFrameLen_get(this.swigCPtr, this);
    }

    public void setPcmBitsPerSample(long j) {
        pjsua2JNI.CodecParamInfo_pcmBitsPerSample_set(this.swigCPtr, this, j);
    }

    public long getPcmBitsPerSample() {
        return pjsua2JNI.CodecParamInfo_pcmBitsPerSample_get(this.swigCPtr, this);
    }

    public void setPt(long j) {
        pjsua2JNI.CodecParamInfo_pt_set(this.swigCPtr, this, j);
    }

    public long getPt() {
        return pjsua2JNI.CodecParamInfo_pt_get(this.swigCPtr, this);
    }

    public void setFmtId(int i) {
        pjsua2JNI.CodecParamInfo_fmtId_set(this.swigCPtr, this, i);
    }

    public int getFmtId() {
        return pjsua2JNI.CodecParamInfo_fmtId_get(this.swigCPtr, this);
    }

    public CodecParamInfo() {
        this(pjsua2JNI.new_CodecParamInfo(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class StreamInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StreamInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StreamInfo streamInfo) {
        if (streamInfo == null) {
            return 0L;
        }
        return streamInfo.swigCPtr;
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
                    pjsua2JNI.delete_StreamInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setType(int i) {
        pjsua2JNI.StreamInfo_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.StreamInfo_type_get(this.swigCPtr, this);
    }

    public void setProto(int i) {
        pjsua2JNI.StreamInfo_proto_set(this.swigCPtr, this, i);
    }

    public int getProto() {
        return pjsua2JNI.StreamInfo_proto_get(this.swigCPtr, this);
    }

    public void setDir(int i) {
        pjsua2JNI.StreamInfo_dir_set(this.swigCPtr, this, i);
    }

    public int getDir() {
        return pjsua2JNI.StreamInfo_dir_get(this.swigCPtr, this);
    }

    public void setRemoteRtpAddress(String str) {
        pjsua2JNI.StreamInfo_remoteRtpAddress_set(this.swigCPtr, this, str);
    }

    public String getRemoteRtpAddress() {
        return pjsua2JNI.StreamInfo_remoteRtpAddress_get(this.swigCPtr, this);
    }

    public void setRemoteRtcpAddress(String str) {
        pjsua2JNI.StreamInfo_remoteRtcpAddress_set(this.swigCPtr, this, str);
    }

    public String getRemoteRtcpAddress() {
        return pjsua2JNI.StreamInfo_remoteRtcpAddress_get(this.swigCPtr, this);
    }

    public void setTxPt(long j) {
        pjsua2JNI.StreamInfo_txPt_set(this.swigCPtr, this, j);
    }

    public long getTxPt() {
        return pjsua2JNI.StreamInfo_txPt_get(this.swigCPtr, this);
    }

    public void setRxPt(long j) {
        pjsua2JNI.StreamInfo_rxPt_set(this.swigCPtr, this, j);
    }

    public long getRxPt() {
        return pjsua2JNI.StreamInfo_rxPt_get(this.swigCPtr, this);
    }

    public void setCodecName(String str) {
        pjsua2JNI.StreamInfo_codecName_set(this.swigCPtr, this, str);
    }

    public String getCodecName() {
        return pjsua2JNI.StreamInfo_codecName_get(this.swigCPtr, this);
    }

    public void setCodecClockRate(long j) {
        pjsua2JNI.StreamInfo_codecClockRate_set(this.swigCPtr, this, j);
    }

    public long getCodecClockRate() {
        return pjsua2JNI.StreamInfo_codecClockRate_get(this.swigCPtr, this);
    }

    public void setAudCodecParam(CodecParam codecParam) {
        pjsua2JNI.StreamInfo_audCodecParam_set(this.swigCPtr, this, CodecParam.getCPtr(codecParam), codecParam);
    }

    public CodecParam getAudCodecParam() {
        long jStreamInfo_audCodecParam_get = pjsua2JNI.StreamInfo_audCodecParam_get(this.swigCPtr, this);
        if (jStreamInfo_audCodecParam_get == 0) {
            return null;
        }
        return new CodecParam(jStreamInfo_audCodecParam_get, false);
    }

    public void setVidCodecParam(VidCodecParam vidCodecParam) {
        pjsua2JNI.StreamInfo_vidCodecParam_set(this.swigCPtr, this, VidCodecParam.getCPtr(vidCodecParam), vidCodecParam);
    }

    public VidCodecParam getVidCodecParam() {
        long jStreamInfo_vidCodecParam_get = pjsua2JNI.StreamInfo_vidCodecParam_get(this.swigCPtr, this);
        if (jStreamInfo_vidCodecParam_get == 0) {
            return null;
        }
        return new VidCodecParam(jStreamInfo_vidCodecParam_get, false);
    }

    public void setJbInit(int i) {
        pjsua2JNI.StreamInfo_jbInit_set(this.swigCPtr, this, i);
    }

    public int getJbInit() {
        return pjsua2JNI.StreamInfo_jbInit_get(this.swigCPtr, this);
    }

    public void setJbMinPre(int i) {
        pjsua2JNI.StreamInfo_jbMinPre_set(this.swigCPtr, this, i);
    }

    public int getJbMinPre() {
        return pjsua2JNI.StreamInfo_jbMinPre_get(this.swigCPtr, this);
    }

    public void setJbMaxPre(int i) {
        pjsua2JNI.StreamInfo_jbMaxPre_set(this.swigCPtr, this, i);
    }

    public int getJbMaxPre() {
        return pjsua2JNI.StreamInfo_jbMaxPre_get(this.swigCPtr, this);
    }

    public void setJbMax(int i) {
        pjsua2JNI.StreamInfo_jbMax_set(this.swigCPtr, this, i);
    }

    public int getJbMax() {
        return pjsua2JNI.StreamInfo_jbMax_get(this.swigCPtr, this);
    }

    public void setJbDiscardAlgo(SWIGTYPE_p_pjmedia_jb_discard_algo sWIGTYPE_p_pjmedia_jb_discard_algo) {
        pjsua2JNI.StreamInfo_jbDiscardAlgo_set(this.swigCPtr, this, SWIGTYPE_p_pjmedia_jb_discard_algo.getCPtr(sWIGTYPE_p_pjmedia_jb_discard_algo));
    }

    public SWIGTYPE_p_pjmedia_jb_discard_algo getJbDiscardAlgo() {
        return new SWIGTYPE_p_pjmedia_jb_discard_algo(pjsua2JNI.StreamInfo_jbDiscardAlgo_get(this.swigCPtr, this), true);
    }

    public void setRtcpSdesByeDisabled(boolean z) {
        pjsua2JNI.StreamInfo_rtcpSdesByeDisabled_set(this.swigCPtr, this, z);
    }

    public boolean getRtcpSdesByeDisabled() {
        return pjsua2JNI.StreamInfo_rtcpSdesByeDisabled_get(this.swigCPtr, this);
    }

    public StreamInfo() {
        this(pjsua2JNI.new_StreamInfo(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class RtcpStat {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RtcpStat(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RtcpStat rtcpStat) {
        if (rtcpStat == null) {
            return 0L;
        }
        return rtcpStat.swigCPtr;
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
                    pjsua2JNI.delete_RtcpStat(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setStart(TimeVal timeVal) {
        pjsua2JNI.RtcpStat_start_set(this.swigCPtr, this, TimeVal.getCPtr(timeVal), timeVal);
    }

    public TimeVal getStart() {
        long jRtcpStat_start_get = pjsua2JNI.RtcpStat_start_get(this.swigCPtr, this);
        if (jRtcpStat_start_get == 0) {
            return null;
        }
        return new TimeVal(jRtcpStat_start_get, false);
    }

    public void setTxStat(RtcpStreamStat rtcpStreamStat) {
        pjsua2JNI.RtcpStat_txStat_set(this.swigCPtr, this, RtcpStreamStat.getCPtr(rtcpStreamStat), rtcpStreamStat);
    }

    public RtcpStreamStat getTxStat() {
        long jRtcpStat_txStat_get = pjsua2JNI.RtcpStat_txStat_get(this.swigCPtr, this);
        if (jRtcpStat_txStat_get == 0) {
            return null;
        }
        return new RtcpStreamStat(jRtcpStat_txStat_get, false);
    }

    public void setRxStat(RtcpStreamStat rtcpStreamStat) {
        pjsua2JNI.RtcpStat_rxStat_set(this.swigCPtr, this, RtcpStreamStat.getCPtr(rtcpStreamStat), rtcpStreamStat);
    }

    public RtcpStreamStat getRxStat() {
        long jRtcpStat_rxStat_get = pjsua2JNI.RtcpStat_rxStat_get(this.swigCPtr, this);
        if (jRtcpStat_rxStat_get == 0) {
            return null;
        }
        return new RtcpStreamStat(jRtcpStat_rxStat_get, false);
    }

    public void setRttUsec(MathStat mathStat) {
        pjsua2JNI.RtcpStat_rttUsec_set(this.swigCPtr, this, MathStat.getCPtr(mathStat), mathStat);
    }

    public MathStat getRttUsec() {
        long jRtcpStat_rttUsec_get = pjsua2JNI.RtcpStat_rttUsec_get(this.swigCPtr, this);
        if (jRtcpStat_rttUsec_get == 0) {
            return null;
        }
        return new MathStat(jRtcpStat_rttUsec_get, false);
    }

    public void setRtpTxLastTs(long j) {
        pjsua2JNI.RtcpStat_rtpTxLastTs_set(this.swigCPtr, this, j);
    }

    public long getRtpTxLastTs() {
        return pjsua2JNI.RtcpStat_rtpTxLastTs_get(this.swigCPtr, this);
    }

    public void setRtpTxLastSeq(int i) {
        pjsua2JNI.RtcpStat_rtpTxLastSeq_set(this.swigCPtr, this, i);
    }

    public int getRtpTxLastSeq() {
        return pjsua2JNI.RtcpStat_rtpTxLastSeq_get(this.swigCPtr, this);
    }

    public void setRxIpdvUsec(MathStat mathStat) {
        pjsua2JNI.RtcpStat_rxIpdvUsec_set(this.swigCPtr, this, MathStat.getCPtr(mathStat), mathStat);
    }

    public MathStat getRxIpdvUsec() {
        long jRtcpStat_rxIpdvUsec_get = pjsua2JNI.RtcpStat_rxIpdvUsec_get(this.swigCPtr, this);
        if (jRtcpStat_rxIpdvUsec_get == 0) {
            return null;
        }
        return new MathStat(jRtcpStat_rxIpdvUsec_get, false);
    }

    public void setRxRawJitterUsec(MathStat mathStat) {
        pjsua2JNI.RtcpStat_rxRawJitterUsec_set(this.swigCPtr, this, MathStat.getCPtr(mathStat), mathStat);
    }

    public MathStat getRxRawJitterUsec() {
        long jRtcpStat_rxRawJitterUsec_get = pjsua2JNI.RtcpStat_rxRawJitterUsec_get(this.swigCPtr, this);
        if (jRtcpStat_rxRawJitterUsec_get == 0) {
            return null;
        }
        return new MathStat(jRtcpStat_rxRawJitterUsec_get, false);
    }

    public void setPeerSdes(RtcpSdes rtcpSdes) {
        pjsua2JNI.RtcpStat_peerSdes_set(this.swigCPtr, this, RtcpSdes.getCPtr(rtcpSdes), rtcpSdes);
    }

    public RtcpSdes getPeerSdes() {
        long jRtcpStat_peerSdes_get = pjsua2JNI.RtcpStat_peerSdes_get(this.swigCPtr, this);
        if (jRtcpStat_peerSdes_get == 0) {
            return null;
        }
        return new RtcpSdes(jRtcpStat_peerSdes_get, false);
    }

    public RtcpStat() {
        this(pjsua2JNI.new_RtcpStat(), true);
    }
}

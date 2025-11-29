package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class RtcpStreamStat {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RtcpStreamStat(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RtcpStreamStat rtcpStreamStat) {
        if (rtcpStreamStat == null) {
            return 0L;
        }
        return rtcpStreamStat.swigCPtr;
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
                    pjsua2JNI.delete_RtcpStreamStat(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUpdate(TimeVal timeVal) {
        pjsua2JNI.RtcpStreamStat_update_set(this.swigCPtr, this, TimeVal.getCPtr(timeVal), timeVal);
    }

    public TimeVal getUpdate() {
        long jRtcpStreamStat_update_get = pjsua2JNI.RtcpStreamStat_update_get(this.swigCPtr, this);
        if (jRtcpStreamStat_update_get == 0) {
            return null;
        }
        return new TimeVal(jRtcpStreamStat_update_get, false);
    }

    public void setUpdateCount(long j) {
        pjsua2JNI.RtcpStreamStat_updateCount_set(this.swigCPtr, this, j);
    }

    public long getUpdateCount() {
        return pjsua2JNI.RtcpStreamStat_updateCount_get(this.swigCPtr, this);
    }

    public void setPkt(long j) {
        pjsua2JNI.RtcpStreamStat_pkt_set(this.swigCPtr, this, j);
    }

    public long getPkt() {
        return pjsua2JNI.RtcpStreamStat_pkt_get(this.swigCPtr, this);
    }

    public void setBytes(long j) {
        pjsua2JNI.RtcpStreamStat_bytes_set(this.swigCPtr, this, j);
    }

    public long getBytes() {
        return pjsua2JNI.RtcpStreamStat_bytes_get(this.swigCPtr, this);
    }

    public void setDiscard(long j) {
        pjsua2JNI.RtcpStreamStat_discard_set(this.swigCPtr, this, j);
    }

    public long getDiscard() {
        return pjsua2JNI.RtcpStreamStat_discard_get(this.swigCPtr, this);
    }

    public void setLoss(long j) {
        pjsua2JNI.RtcpStreamStat_loss_set(this.swigCPtr, this, j);
    }

    public long getLoss() {
        return pjsua2JNI.RtcpStreamStat_loss_get(this.swigCPtr, this);
    }

    public void setReorder(long j) {
        pjsua2JNI.RtcpStreamStat_reorder_set(this.swigCPtr, this, j);
    }

    public long getReorder() {
        return pjsua2JNI.RtcpStreamStat_reorder_get(this.swigCPtr, this);
    }

    public void setDup(long j) {
        pjsua2JNI.RtcpStreamStat_dup_set(this.swigCPtr, this, j);
    }

    public long getDup() {
        return pjsua2JNI.RtcpStreamStat_dup_get(this.swigCPtr, this);
    }

    public void setLossPeriodUsec(MathStat mathStat) {
        pjsua2JNI.RtcpStreamStat_lossPeriodUsec_set(this.swigCPtr, this, MathStat.getCPtr(mathStat), mathStat);
    }

    public MathStat getLossPeriodUsec() {
        long jRtcpStreamStat_lossPeriodUsec_get = pjsua2JNI.RtcpStreamStat_lossPeriodUsec_get(this.swigCPtr, this);
        if (jRtcpStreamStat_lossPeriodUsec_get == 0) {
            return null;
        }
        return new MathStat(jRtcpStreamStat_lossPeriodUsec_get, false);
    }

    public void setLossType(LossType lossType) {
        pjsua2JNI.RtcpStreamStat_lossType_set(this.swigCPtr, this, LossType.getCPtr(lossType), lossType);
    }

    public LossType getLossType() {
        long jRtcpStreamStat_lossType_get = pjsua2JNI.RtcpStreamStat_lossType_get(this.swigCPtr, this);
        if (jRtcpStreamStat_lossType_get == 0) {
            return null;
        }
        return new LossType(jRtcpStreamStat_lossType_get, false);
    }

    public void setJitterUsec(MathStat mathStat) {
        pjsua2JNI.RtcpStreamStat_jitterUsec_set(this.swigCPtr, this, MathStat.getCPtr(mathStat), mathStat);
    }

    public MathStat getJitterUsec() {
        long jRtcpStreamStat_jitterUsec_get = pjsua2JNI.RtcpStreamStat_jitterUsec_get(this.swigCPtr, this);
        if (jRtcpStreamStat_jitterUsec_get == 0) {
            return null;
        }
        return new MathStat(jRtcpStreamStat_jitterUsec_get, false);
    }

    public RtcpStreamStat() {
        this(pjsua2JNI.new_RtcpStreamStat(), true);
    }
}

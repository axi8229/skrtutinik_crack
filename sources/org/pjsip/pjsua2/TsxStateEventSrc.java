package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TsxStateEventSrc {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TsxStateEventSrc(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TsxStateEventSrc tsxStateEventSrc) {
        if (tsxStateEventSrc == null) {
            return 0L;
        }
        return tsxStateEventSrc.swigCPtr;
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
                    pjsua2JNI.delete_TsxStateEventSrc(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.TsxStateEventSrc_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jTsxStateEventSrc_rdata_get = pjsua2JNI.TsxStateEventSrc_rdata_get(this.swigCPtr, this);
        if (jTsxStateEventSrc_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jTsxStateEventSrc_rdata_get, false);
    }

    public void setTdata(SipTxData sipTxData) {
        pjsua2JNI.TsxStateEventSrc_tdata_set(this.swigCPtr, this, SipTxData.getCPtr(sipTxData), sipTxData);
    }

    public SipTxData getTdata() {
        long jTsxStateEventSrc_tdata_get = pjsua2JNI.TsxStateEventSrc_tdata_get(this.swigCPtr, this);
        if (jTsxStateEventSrc_tdata_get == 0) {
            return null;
        }
        return new SipTxData(jTsxStateEventSrc_tdata_get, false);
    }

    public void setTimer(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.TsxStateEventSrc_timer_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getTimer() {
        long jTsxStateEventSrc_timer_get = pjsua2JNI.TsxStateEventSrc_timer_get(this.swigCPtr, this);
        if (jTsxStateEventSrc_timer_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jTsxStateEventSrc_timer_get, false);
    }

    public void setStatus(int i) {
        pjsua2JNI.TsxStateEventSrc_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.TsxStateEventSrc_status_get(this.swigCPtr, this);
    }

    public void setData(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.TsxStateEventSrc_data_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getData() {
        long jTsxStateEventSrc_data_get = pjsua2JNI.TsxStateEventSrc_data_get(this.swigCPtr, this);
        if (jTsxStateEventSrc_data_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jTsxStateEventSrc_data_get, false);
    }

    public TsxStateEventSrc() {
        this(pjsua2JNI.new_TsxStateEventSrc(), true);
    }
}

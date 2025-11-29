package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TxMsgEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TxMsgEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TxMsgEvent txMsgEvent) {
        if (txMsgEvent == null) {
            return 0L;
        }
        return txMsgEvent.swigCPtr;
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
                    pjsua2JNI.delete_TxMsgEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTdata(SipTxData sipTxData) {
        pjsua2JNI.TxMsgEvent_tdata_set(this.swigCPtr, this, SipTxData.getCPtr(sipTxData), sipTxData);
    }

    public SipTxData getTdata() {
        long jTxMsgEvent_tdata_get = pjsua2JNI.TxMsgEvent_tdata_get(this.swigCPtr, this);
        if (jTxMsgEvent_tdata_get == 0) {
            return null;
        }
        return new SipTxData(jTxMsgEvent_tdata_get, false);
    }

    public TxMsgEvent() {
        this(pjsua2JNI.new_TxMsgEvent(), true);
    }
}

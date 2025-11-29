package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TxErrorEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TxErrorEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TxErrorEvent txErrorEvent) {
        if (txErrorEvent == null) {
            return 0L;
        }
        return txErrorEvent.swigCPtr;
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
                    pjsua2JNI.delete_TxErrorEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTdata(SipTxData sipTxData) {
        pjsua2JNI.TxErrorEvent_tdata_set(this.swigCPtr, this, SipTxData.getCPtr(sipTxData), sipTxData);
    }

    public SipTxData getTdata() {
        long jTxErrorEvent_tdata_get = pjsua2JNI.TxErrorEvent_tdata_get(this.swigCPtr, this);
        if (jTxErrorEvent_tdata_get == 0) {
            return null;
        }
        return new SipTxData(jTxErrorEvent_tdata_get, false);
    }

    public void setTsx(SipTransaction sipTransaction) {
        pjsua2JNI.TxErrorEvent_tsx_set(this.swigCPtr, this, SipTransaction.getCPtr(sipTransaction), sipTransaction);
    }

    public SipTransaction getTsx() {
        long jTxErrorEvent_tsx_get = pjsua2JNI.TxErrorEvent_tsx_get(this.swigCPtr, this);
        if (jTxErrorEvent_tsx_get == 0) {
            return null;
        }
        return new SipTransaction(jTxErrorEvent_tsx_get, false);
    }

    public TxErrorEvent() {
        this(pjsua2JNI.new_TxErrorEvent(), true);
    }
}

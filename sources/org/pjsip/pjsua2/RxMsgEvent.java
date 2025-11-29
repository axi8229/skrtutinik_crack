package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class RxMsgEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RxMsgEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RxMsgEvent rxMsgEvent) {
        if (rxMsgEvent == null) {
            return 0L;
        }
        return rxMsgEvent.swigCPtr;
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
                    pjsua2JNI.delete_RxMsgEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.RxMsgEvent_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jRxMsgEvent_rdata_get = pjsua2JNI.RxMsgEvent_rdata_get(this.swigCPtr, this);
        if (jRxMsgEvent_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jRxMsgEvent_rdata_get, false);
    }

    public RxMsgEvent() {
        this(pjsua2JNI.new_RxMsgEvent(), true);
    }
}

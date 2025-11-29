package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipEventBody {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipEventBody(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipEventBody sipEventBody) {
        if (sipEventBody == null) {
            return 0L;
        }
        return sipEventBody.swigCPtr;
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
                    pjsua2JNI.delete_SipEventBody(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTimer(TimerEvent timerEvent) {
        pjsua2JNI.SipEventBody_timer_set(this.swigCPtr, this, TimerEvent.getCPtr(timerEvent), timerEvent);
    }

    public TimerEvent getTimer() {
        long jSipEventBody_timer_get = pjsua2JNI.SipEventBody_timer_get(this.swigCPtr, this);
        if (jSipEventBody_timer_get == 0) {
            return null;
        }
        return new TimerEvent(jSipEventBody_timer_get, false);
    }

    public void setTsxState(TsxStateEvent tsxStateEvent) {
        pjsua2JNI.SipEventBody_tsxState_set(this.swigCPtr, this, TsxStateEvent.getCPtr(tsxStateEvent), tsxStateEvent);
    }

    public TsxStateEvent getTsxState() {
        long jSipEventBody_tsxState_get = pjsua2JNI.SipEventBody_tsxState_get(this.swigCPtr, this);
        if (jSipEventBody_tsxState_get == 0) {
            return null;
        }
        return new TsxStateEvent(jSipEventBody_tsxState_get, false);
    }

    public void setTxMsg(TxMsgEvent txMsgEvent) {
        pjsua2JNI.SipEventBody_txMsg_set(this.swigCPtr, this, TxMsgEvent.getCPtr(txMsgEvent), txMsgEvent);
    }

    public TxMsgEvent getTxMsg() {
        long jSipEventBody_txMsg_get = pjsua2JNI.SipEventBody_txMsg_get(this.swigCPtr, this);
        if (jSipEventBody_txMsg_get == 0) {
            return null;
        }
        return new TxMsgEvent(jSipEventBody_txMsg_get, false);
    }

    public void setTxError(TxErrorEvent txErrorEvent) {
        pjsua2JNI.SipEventBody_txError_set(this.swigCPtr, this, TxErrorEvent.getCPtr(txErrorEvent), txErrorEvent);
    }

    public TxErrorEvent getTxError() {
        long jSipEventBody_txError_get = pjsua2JNI.SipEventBody_txError_get(this.swigCPtr, this);
        if (jSipEventBody_txError_get == 0) {
            return null;
        }
        return new TxErrorEvent(jSipEventBody_txError_get, false);
    }

    public void setRxMsg(RxMsgEvent rxMsgEvent) {
        pjsua2JNI.SipEventBody_rxMsg_set(this.swigCPtr, this, RxMsgEvent.getCPtr(rxMsgEvent), rxMsgEvent);
    }

    public RxMsgEvent getRxMsg() {
        long jSipEventBody_rxMsg_get = pjsua2JNI.SipEventBody_rxMsg_get(this.swigCPtr, this);
        if (jSipEventBody_rxMsg_get == 0) {
            return null;
        }
        return new RxMsgEvent(jSipEventBody_rxMsg_get, false);
    }

    public void setUser(UserEvent userEvent) {
        pjsua2JNI.SipEventBody_user_set(this.swigCPtr, this, UserEvent.getCPtr(userEvent), userEvent);
    }

    public UserEvent getUser() {
        long jSipEventBody_user_get = pjsua2JNI.SipEventBody_user_get(this.swigCPtr, this);
        if (jSipEventBody_user_get == 0) {
            return null;
        }
        return new UserEvent(jSipEventBody_user_get, false);
    }

    public SipEventBody() {
        this(pjsua2JNI.new_SipEventBody(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SendTypingIndicationParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SendTypingIndicationParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SendTypingIndicationParam sendTypingIndicationParam) {
        if (sendTypingIndicationParam == null) {
            return 0L;
        }
        return sendTypingIndicationParam.swigCPtr;
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
                    pjsua2JNI.delete_SendTypingIndicationParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIsTyping(boolean z) {
        pjsua2JNI.SendTypingIndicationParam_isTyping_set(this.swigCPtr, this, z);
    }

    public boolean getIsTyping() {
        return pjsua2JNI.SendTypingIndicationParam_isTyping_get(this.swigCPtr, this);
    }

    public void setTxOption(SipTxOption sipTxOption) {
        pjsua2JNI.SendTypingIndicationParam_txOption_set(this.swigCPtr, this, SipTxOption.getCPtr(sipTxOption), sipTxOption);
    }

    public SipTxOption getTxOption() {
        long jSendTypingIndicationParam_txOption_get = pjsua2JNI.SendTypingIndicationParam_txOption_get(this.swigCPtr, this);
        if (jSendTypingIndicationParam_txOption_get == 0) {
            return null;
        }
        return new SipTxOption(jSendTypingIndicationParam_txOption_get, false);
    }

    public SendTypingIndicationParam() {
        this(pjsua2JNI.new_SendTypingIndicationParam(), true);
    }
}

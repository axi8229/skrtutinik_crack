package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipTransaction {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipTransaction(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipTransaction sipTransaction) {
        if (sipTransaction == null) {
            return 0L;
        }
        return sipTransaction.swigCPtr;
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
                    pjsua2JNI.delete_SipTransaction(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRole(int i) {
        pjsua2JNI.SipTransaction_role_set(this.swigCPtr, this, i);
    }

    public int getRole() {
        return pjsua2JNI.SipTransaction_role_get(this.swigCPtr, this);
    }

    public void setMethod(String str) {
        pjsua2JNI.SipTransaction_method_set(this.swigCPtr, this, str);
    }

    public String getMethod() {
        return pjsua2JNI.SipTransaction_method_get(this.swigCPtr, this);
    }

    public void setStatusCode(int i) {
        pjsua2JNI.SipTransaction_statusCode_set(this.swigCPtr, this, i);
    }

    public int getStatusCode() {
        return pjsua2JNI.SipTransaction_statusCode_get(this.swigCPtr, this);
    }

    public void setStatusText(String str) {
        pjsua2JNI.SipTransaction_statusText_set(this.swigCPtr, this, str);
    }

    public String getStatusText() {
        return pjsua2JNI.SipTransaction_statusText_get(this.swigCPtr, this);
    }

    public void setState(int i) {
        pjsua2JNI.SipTransaction_state_set(this.swigCPtr, this, i);
    }

    public int getState() {
        return pjsua2JNI.SipTransaction_state_get(this.swigCPtr, this);
    }

    public void setLastTx(SipTxData sipTxData) {
        pjsua2JNI.SipTransaction_lastTx_set(this.swigCPtr, this, SipTxData.getCPtr(sipTxData), sipTxData);
    }

    public SipTxData getLastTx() {
        long jSipTransaction_lastTx_get = pjsua2JNI.SipTransaction_lastTx_get(this.swigCPtr, this);
        if (jSipTransaction_lastTx_get == 0) {
            return null;
        }
        return new SipTxData(jSipTransaction_lastTx_get, false);
    }

    public void setPjTransaction(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.SipTransaction_pjTransaction_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPjTransaction() {
        long jSipTransaction_pjTransaction_get = pjsua2JNI.SipTransaction_pjTransaction_get(this.swigCPtr, this);
        if (jSipTransaction_pjTransaction_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jSipTransaction_pjTransaction_get, false);
    }

    public SipTransaction() {
        this(pjsua2JNI.new_SipTransaction(), true);
    }
}

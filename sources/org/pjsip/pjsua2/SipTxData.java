package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipTxData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipTxData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipTxData sipTxData) {
        if (sipTxData == null) {
            return 0L;
        }
        return sipTxData.swigCPtr;
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
                    pjsua2JNI.delete_SipTxData(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setInfo(String str) {
        pjsua2JNI.SipTxData_info_set(this.swigCPtr, this, str);
    }

    public String getInfo() {
        return pjsua2JNI.SipTxData_info_get(this.swigCPtr, this);
    }

    public void setWholeMsg(String str) {
        pjsua2JNI.SipTxData_wholeMsg_set(this.swigCPtr, this, str);
    }

    public String getWholeMsg() {
        return pjsua2JNI.SipTxData_wholeMsg_get(this.swigCPtr, this);
    }

    public void setDstAddress(String str) {
        pjsua2JNI.SipTxData_dstAddress_set(this.swigCPtr, this, str);
    }

    public String getDstAddress() {
        return pjsua2JNI.SipTxData_dstAddress_get(this.swigCPtr, this);
    }

    public void setPjTxData(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.SipTxData_pjTxData_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPjTxData() {
        long jSipTxData_pjTxData_get = pjsua2JNI.SipTxData_pjTxData_get(this.swigCPtr, this);
        if (jSipTxData_pjTxData_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jSipTxData_pjTxData_get, false);
    }

    public SipTxData() {
        this(pjsua2JNI.new_SipTxData(), true);
    }
}

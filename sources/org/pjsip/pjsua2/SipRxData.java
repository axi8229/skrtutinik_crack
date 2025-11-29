package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipRxData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipRxData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipRxData sipRxData) {
        if (sipRxData == null) {
            return 0L;
        }
        return sipRxData.swigCPtr;
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
                    pjsua2JNI.delete_SipRxData(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setInfo(String str) {
        pjsua2JNI.SipRxData_info_set(this.swigCPtr, this, str);
    }

    public String getInfo() {
        return pjsua2JNI.SipRxData_info_get(this.swigCPtr, this);
    }

    public void setWholeMsg(String str) {
        pjsua2JNI.SipRxData_wholeMsg_set(this.swigCPtr, this, str);
    }

    public String getWholeMsg() {
        return pjsua2JNI.SipRxData_wholeMsg_get(this.swigCPtr, this);
    }

    public void setSrcAddress(String str) {
        pjsua2JNI.SipRxData_srcAddress_set(this.swigCPtr, this, str);
    }

    public String getSrcAddress() {
        return pjsua2JNI.SipRxData_srcAddress_get(this.swigCPtr, this);
    }

    public void setPjRxData(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.SipRxData_pjRxData_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPjRxData() {
        long jSipRxData_pjRxData_get = pjsua2JNI.SipRxData_pjRxData_get(this.swigCPtr, this);
        if (jSipRxData_pjRxData_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jSipRxData_pjRxData_get, false);
    }

    public SipRxData() {
        this(pjsua2JNI.new_SipRxData(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnTypingIndicationParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnTypingIndicationParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnTypingIndicationParam onTypingIndicationParam) {
        if (onTypingIndicationParam == null) {
            return 0L;
        }
        return onTypingIndicationParam.swigCPtr;
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
                    pjsua2JNI.delete_OnTypingIndicationParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFromUri(String str) {
        pjsua2JNI.OnTypingIndicationParam_fromUri_set(this.swigCPtr, this, str);
    }

    public String getFromUri() {
        return pjsua2JNI.OnTypingIndicationParam_fromUri_get(this.swigCPtr, this);
    }

    public void setToUri(String str) {
        pjsua2JNI.OnTypingIndicationParam_toUri_set(this.swigCPtr, this, str);
    }

    public String getToUri() {
        return pjsua2JNI.OnTypingIndicationParam_toUri_get(this.swigCPtr, this);
    }

    public void setContactUri(String str) {
        pjsua2JNI.OnTypingIndicationParam_contactUri_set(this.swigCPtr, this, str);
    }

    public String getContactUri() {
        return pjsua2JNI.OnTypingIndicationParam_contactUri_get(this.swigCPtr, this);
    }

    public void setIsTyping(boolean z) {
        pjsua2JNI.OnTypingIndicationParam_isTyping_set(this.swigCPtr, this, z);
    }

    public boolean getIsTyping() {
        return pjsua2JNI.OnTypingIndicationParam_isTyping_get(this.swigCPtr, this);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnTypingIndicationParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnTypingIndicationParam_rdata_get = pjsua2JNI.OnTypingIndicationParam_rdata_get(this.swigCPtr, this);
        if (jOnTypingIndicationParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnTypingIndicationParam_rdata_get, false);
    }

    public OnTypingIndicationParam() {
        this(pjsua2JNI.new_OnTypingIndicationParam(), true);
    }
}

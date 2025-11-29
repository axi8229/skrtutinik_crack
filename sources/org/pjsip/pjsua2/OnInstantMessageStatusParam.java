package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnInstantMessageStatusParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnInstantMessageStatusParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnInstantMessageStatusParam onInstantMessageStatusParam) {
        if (onInstantMessageStatusParam == null) {
            return 0L;
        }
        return onInstantMessageStatusParam.swigCPtr;
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
                    pjsua2JNI.delete_OnInstantMessageStatusParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUserData(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnInstantMessageStatusParam_userData_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUserData() {
        long jOnInstantMessageStatusParam_userData_get = pjsua2JNI.OnInstantMessageStatusParam_userData_get(this.swigCPtr, this);
        if (jOnInstantMessageStatusParam_userData_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnInstantMessageStatusParam_userData_get, false);
    }

    public void setToUri(String str) {
        pjsua2JNI.OnInstantMessageStatusParam_toUri_set(this.swigCPtr, this, str);
    }

    public String getToUri() {
        return pjsua2JNI.OnInstantMessageStatusParam_toUri_get(this.swigCPtr, this);
    }

    public void setMsgBody(String str) {
        pjsua2JNI.OnInstantMessageStatusParam_msgBody_set(this.swigCPtr, this, str);
    }

    public String getMsgBody() {
        return pjsua2JNI.OnInstantMessageStatusParam_msgBody_get(this.swigCPtr, this);
    }

    public void setCode(int i) {
        pjsua2JNI.OnInstantMessageStatusParam_code_set(this.swigCPtr, this, i);
    }

    public int getCode() {
        return pjsua2JNI.OnInstantMessageStatusParam_code_get(this.swigCPtr, this);
    }

    public void setReason(String str) {
        pjsua2JNI.OnInstantMessageStatusParam_reason_set(this.swigCPtr, this, str);
    }

    public String getReason() {
        return pjsua2JNI.OnInstantMessageStatusParam_reason_get(this.swigCPtr, this);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnInstantMessageStatusParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnInstantMessageStatusParam_rdata_get = pjsua2JNI.OnInstantMessageStatusParam_rdata_get(this.swigCPtr, this);
        if (jOnInstantMessageStatusParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnInstantMessageStatusParam_rdata_get, false);
    }

    public OnInstantMessageStatusParam() {
        this(pjsua2JNI.new_OnInstantMessageStatusParam(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnInstantMessageParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnInstantMessageParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnInstantMessageParam onInstantMessageParam) {
        if (onInstantMessageParam == null) {
            return 0L;
        }
        return onInstantMessageParam.swigCPtr;
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
                    pjsua2JNI.delete_OnInstantMessageParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFromUri(String str) {
        pjsua2JNI.OnInstantMessageParam_fromUri_set(this.swigCPtr, this, str);
    }

    public String getFromUri() {
        return pjsua2JNI.OnInstantMessageParam_fromUri_get(this.swigCPtr, this);
    }

    public void setToUri(String str) {
        pjsua2JNI.OnInstantMessageParam_toUri_set(this.swigCPtr, this, str);
    }

    public String getToUri() {
        return pjsua2JNI.OnInstantMessageParam_toUri_get(this.swigCPtr, this);
    }

    public void setContactUri(String str) {
        pjsua2JNI.OnInstantMessageParam_contactUri_set(this.swigCPtr, this, str);
    }

    public String getContactUri() {
        return pjsua2JNI.OnInstantMessageParam_contactUri_get(this.swigCPtr, this);
    }

    public void setContentType(String str) {
        pjsua2JNI.OnInstantMessageParam_contentType_set(this.swigCPtr, this, str);
    }

    public String getContentType() {
        return pjsua2JNI.OnInstantMessageParam_contentType_get(this.swigCPtr, this);
    }

    public void setMsgBody(String str) {
        pjsua2JNI.OnInstantMessageParam_msgBody_set(this.swigCPtr, this, str);
    }

    public String getMsgBody() {
        return pjsua2JNI.OnInstantMessageParam_msgBody_get(this.swigCPtr, this);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnInstantMessageParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnInstantMessageParam_rdata_get = pjsua2JNI.OnInstantMessageParam_rdata_get(this.swigCPtr, this);
        if (jOnInstantMessageParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnInstantMessageParam_rdata_get, false);
    }

    public OnInstantMessageParam() {
        this(pjsua2JNI.new_OnInstantMessageParam(), true);
    }
}

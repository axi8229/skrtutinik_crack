package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipTxOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipTxOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipTxOption sipTxOption) {
        if (sipTxOption == null) {
            return 0L;
        }
        return sipTxOption.swigCPtr;
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
                    pjsua2JNI.delete_SipTxOption(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTargetUri(String str) {
        pjsua2JNI.SipTxOption_targetUri_set(this.swigCPtr, this, str);
    }

    public String getTargetUri() {
        return pjsua2JNI.SipTxOption_targetUri_get(this.swigCPtr, this);
    }

    public void setHeaders(SipHeaderVector sipHeaderVector) {
        pjsua2JNI.SipTxOption_headers_set(this.swigCPtr, this, SipHeaderVector.getCPtr(sipHeaderVector), sipHeaderVector);
    }

    public SipHeaderVector getHeaders() {
        long jSipTxOption_headers_get = pjsua2JNI.SipTxOption_headers_get(this.swigCPtr, this);
        if (jSipTxOption_headers_get == 0) {
            return null;
        }
        return new SipHeaderVector(jSipTxOption_headers_get, false);
    }

    public void setContentType(String str) {
        pjsua2JNI.SipTxOption_contentType_set(this.swigCPtr, this, str);
    }

    public String getContentType() {
        return pjsua2JNI.SipTxOption_contentType_get(this.swigCPtr, this);
    }

    public void setMsgBody(String str) {
        pjsua2JNI.SipTxOption_msgBody_set(this.swigCPtr, this, str);
    }

    public String getMsgBody() {
        return pjsua2JNI.SipTxOption_msgBody_get(this.swigCPtr, this);
    }

    public void setMultipartContentType(SipMediaType sipMediaType) {
        pjsua2JNI.SipTxOption_multipartContentType_set(this.swigCPtr, this, SipMediaType.getCPtr(sipMediaType), sipMediaType);
    }

    public SipMediaType getMultipartContentType() {
        long jSipTxOption_multipartContentType_get = pjsua2JNI.SipTxOption_multipartContentType_get(this.swigCPtr, this);
        if (jSipTxOption_multipartContentType_get == 0) {
            return null;
        }
        return new SipMediaType(jSipTxOption_multipartContentType_get, false);
    }

    public void setMultipartParts(SipMultipartPartVector sipMultipartPartVector) {
        pjsua2JNI.SipTxOption_multipartParts_set(this.swigCPtr, this, SipMultipartPartVector.getCPtr(sipMultipartPartVector), sipMultipartPartVector);
    }

    public SipMultipartPartVector getMultipartParts() {
        long jSipTxOption_multipartParts_get = pjsua2JNI.SipTxOption_multipartParts_get(this.swigCPtr, this);
        if (jSipTxOption_multipartParts_get == 0) {
            return null;
        }
        return new SipMultipartPartVector(jSipTxOption_multipartParts_get, false);
    }

    public boolean isEmpty() {
        return pjsua2JNI.SipTxOption_isEmpty(this.swigCPtr, this);
    }

    public SipTxOption() {
        this(pjsua2JNI.new_SipTxOption(), true);
    }
}

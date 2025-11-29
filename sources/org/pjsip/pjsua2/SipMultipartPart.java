package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipMultipartPart {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipMultipartPart(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipMultipartPart sipMultipartPart) {
        if (sipMultipartPart == null) {
            return 0L;
        }
        return sipMultipartPart.swigCPtr;
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
                    pjsua2JNI.delete_SipMultipartPart(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setHeaders(SipHeaderVector sipHeaderVector) {
        pjsua2JNI.SipMultipartPart_headers_set(this.swigCPtr, this, SipHeaderVector.getCPtr(sipHeaderVector), sipHeaderVector);
    }

    public SipHeaderVector getHeaders() {
        long jSipMultipartPart_headers_get = pjsua2JNI.SipMultipartPart_headers_get(this.swigCPtr, this);
        if (jSipMultipartPart_headers_get == 0) {
            return null;
        }
        return new SipHeaderVector(jSipMultipartPart_headers_get, false);
    }

    public void setContentType(SipMediaType sipMediaType) {
        pjsua2JNI.SipMultipartPart_contentType_set(this.swigCPtr, this, SipMediaType.getCPtr(sipMediaType), sipMediaType);
    }

    public SipMediaType getContentType() {
        long jSipMultipartPart_contentType_get = pjsua2JNI.SipMultipartPart_contentType_get(this.swigCPtr, this);
        if (jSipMultipartPart_contentType_get == 0) {
            return null;
        }
        return new SipMediaType(jSipMultipartPart_contentType_get, false);
    }

    public void setBody(String str) {
        pjsua2JNI.SipMultipartPart_body_set(this.swigCPtr, this, str);
    }

    public String getBody() {
        return pjsua2JNI.SipMultipartPart_body_get(this.swigCPtr, this);
    }

    public SipMultipartPart() {
        this(pjsua2JNI.new_SipMultipartPart(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipHeader {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipHeader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipHeader sipHeader) {
        if (sipHeader == null) {
            return 0L;
        }
        return sipHeader.swigCPtr;
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
                    pjsua2JNI.delete_SipHeader(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setHName(String str) {
        pjsua2JNI.SipHeader_hName_set(this.swigCPtr, this, str);
    }

    public String getHName() {
        return pjsua2JNI.SipHeader_hName_get(this.swigCPtr, this);
    }

    public void setHValue(String str) {
        pjsua2JNI.SipHeader_hValue_set(this.swigCPtr, this, str);
    }

    public String getHValue() {
        return pjsua2JNI.SipHeader_hValue_get(this.swigCPtr, this);
    }

    public SipHeader() {
        this(pjsua2JNI.new_SipHeader(), true);
    }
}

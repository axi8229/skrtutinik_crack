package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipMediaType {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipMediaType(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipMediaType sipMediaType) {
        if (sipMediaType == null) {
            return 0L;
        }
        return sipMediaType.swigCPtr;
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
                    pjsua2JNI.delete_SipMediaType(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setType(String str) {
        pjsua2JNI.SipMediaType_type_set(this.swigCPtr, this, str);
    }

    public String getType() {
        return pjsua2JNI.SipMediaType_type_get(this.swigCPtr, this);
    }

    public void setSubType(String str) {
        pjsua2JNI.SipMediaType_subType_set(this.swigCPtr, this, str);
    }

    public String getSubType() {
        return pjsua2JNI.SipMediaType_subType_get(this.swigCPtr, this);
    }

    public SipMediaType() {
        this(pjsua2JNI.new_SipMediaType(), true);
    }
}

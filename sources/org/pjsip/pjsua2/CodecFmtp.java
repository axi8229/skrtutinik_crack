package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CodecFmtp {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecFmtp(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecFmtp codecFmtp) {
        if (codecFmtp == null) {
            return 0L;
        }
        return codecFmtp.swigCPtr;
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
                    pjsua2JNI.delete_CodecFmtp(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setName(String str) {
        pjsua2JNI.CodecFmtp_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.CodecFmtp_name_get(this.swigCPtr, this);
    }

    public void setVal(String str) {
        pjsua2JNI.CodecFmtp_val_set(this.swigCPtr, this, str);
    }

    public String getVal() {
        return pjsua2JNI.CodecFmtp_val_get(this.swigCPtr, this);
    }

    public CodecFmtp() {
        this(pjsua2JNI.new_CodecFmtp(), true);
    }
}

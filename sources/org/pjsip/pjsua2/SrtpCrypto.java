package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SrtpCrypto {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SrtpCrypto(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SrtpCrypto srtpCrypto) {
        if (srtpCrypto == null) {
            return 0L;
        }
        return srtpCrypto.swigCPtr;
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
                    pjsua2JNI.delete_SrtpCrypto(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setKey(String str) {
        pjsua2JNI.SrtpCrypto_key_set(this.swigCPtr, this, str);
    }

    public String getKey() {
        return pjsua2JNI.SrtpCrypto_key_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        pjsua2JNI.SrtpCrypto_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.SrtpCrypto_name_get(this.swigCPtr, this);
    }

    public void setFlags(long j) {
        pjsua2JNI.SrtpCrypto_flags_set(this.swigCPtr, this, j);
    }

    public long getFlags() {
        return pjsua2JNI.SrtpCrypto_flags_get(this.swigCPtr, this);
    }

    public SrtpCrypto() {
        this(pjsua2JNI.new_SrtpCrypto(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SslCertName {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SslCertName(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SslCertName sslCertName) {
        if (sslCertName == null) {
            return 0L;
        }
        return sslCertName.swigCPtr;
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
                    pjsua2JNI.delete_SslCertName(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setType(int i) {
        pjsua2JNI.SslCertName_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.SslCertName_type_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        pjsua2JNI.SslCertName_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.SslCertName_name_get(this.swigCPtr, this);
    }

    public SslCertName() {
        this(pjsua2JNI.new_SslCertName(), true);
    }
}

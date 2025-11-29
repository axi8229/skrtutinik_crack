package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class RegProgressParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RegProgressParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RegProgressParam regProgressParam) {
        if (regProgressParam == null) {
            return 0L;
        }
        return regProgressParam.swigCPtr;
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
                    pjsua2JNI.delete_RegProgressParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIsRegister(boolean z) {
        pjsua2JNI.RegProgressParam_isRegister_set(this.swigCPtr, this, z);
    }

    public boolean getIsRegister() {
        return pjsua2JNI.RegProgressParam_isRegister_get(this.swigCPtr, this);
    }

    public void setCode(int i) {
        pjsua2JNI.RegProgressParam_code_set(this.swigCPtr, this, i);
    }

    public int getCode() {
        return pjsua2JNI.RegProgressParam_code_get(this.swigCPtr, this);
    }

    public RegProgressParam() {
        this(pjsua2JNI.new_RegProgressParam(), true);
    }
}

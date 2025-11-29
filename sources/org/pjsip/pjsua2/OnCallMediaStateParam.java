package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallMediaStateParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallMediaStateParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallMediaStateParam onCallMediaStateParam) {
        if (onCallMediaStateParam == null) {
            return 0L;
        }
        return onCallMediaStateParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallMediaStateParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public OnCallMediaStateParam() {
        this(pjsua2JNI.new_OnCallMediaStateParam(), true);
    }
}

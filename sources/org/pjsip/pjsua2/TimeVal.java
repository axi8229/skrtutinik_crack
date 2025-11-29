package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TimeVal {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TimeVal(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TimeVal timeVal) {
        if (timeVal == null) {
            return 0L;
        }
        return timeVal.swigCPtr;
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
                    pjsua2JNI.delete_TimeVal(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSec(int i) {
        pjsua2JNI.TimeVal_sec_set(this.swigCPtr, this, i);
    }

    public int getSec() {
        return pjsua2JNI.TimeVal_sec_get(this.swigCPtr, this);
    }

    public void setMsec(int i) {
        pjsua2JNI.TimeVal_msec_set(this.swigCPtr, this, i);
    }

    public int getMsec() {
        return pjsua2JNI.TimeVal_msec_get(this.swigCPtr, this);
    }

    public TimeVal() {
        this(pjsua2JNI.new_TimeVal(), true);
    }
}

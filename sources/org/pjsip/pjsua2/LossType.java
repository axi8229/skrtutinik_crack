package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class LossType {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected LossType(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(LossType lossType) {
        if (lossType == null) {
            return 0L;
        }
        return lossType.swigCPtr;
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
                    pjsua2JNI.delete_LossType(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setBurst(long j) {
        pjsua2JNI.LossType_burst_set(this.swigCPtr, this, j);
    }

    public long getBurst() {
        return pjsua2JNI.LossType_burst_get(this.swigCPtr, this);
    }

    public void setRandom(long j) {
        pjsua2JNI.LossType_random_set(this.swigCPtr, this, j);
    }

    public long getRandom() {
        return pjsua2JNI.LossType_random_get(this.swigCPtr, this);
    }

    public LossType() {
        this(pjsua2JNI.new_LossType(), true);
    }
}

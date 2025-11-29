package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class PendingJob {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected PendingJob(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PendingJob pendingJob) {
        if (pendingJob == null) {
            return 0L;
        }
        return pendingJob.swigCPtr;
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
                    pjsua2JNI.delete_PendingJob(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void execute(boolean z) {
        pjsua2JNI.PendingJob_execute(this.swigCPtr, this, z);
    }
}

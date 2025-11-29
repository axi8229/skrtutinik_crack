package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class Media {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected Media(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Media media) {
        if (media == null) {
            return 0L;
        }
        return media.swigCPtr;
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
                    pjsua2JNI.delete_Media(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int getType() {
        return pjsua2JNI.Media_getType(this.swigCPtr, this);
    }
}

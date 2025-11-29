package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaSize {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaSize(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaSize mediaSize) {
        if (mediaSize == null) {
            return 0L;
        }
        return mediaSize.swigCPtr;
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
                    pjsua2JNI.delete_MediaSize(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setW(long j) {
        pjsua2JNI.MediaSize_w_set(this.swigCPtr, this, j);
    }

    public long getW() {
        return pjsua2JNI.MediaSize_w_get(this.swigCPtr, this);
    }

    public void setH(long j) {
        pjsua2JNI.MediaSize_h_set(this.swigCPtr, this, j);
    }

    public long getH() {
        return pjsua2JNI.MediaSize_h_get(this.swigCPtr, this);
    }

    public MediaSize() {
        this(pjsua2JNI.new_MediaSize(), true);
    }
}

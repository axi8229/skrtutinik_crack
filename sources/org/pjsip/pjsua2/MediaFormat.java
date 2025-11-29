package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaFormat {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaFormat(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return 0L;
        }
        return mediaFormat.swigCPtr;
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
                    pjsua2JNI.delete_MediaFormat(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setId(long j) {
        pjsua2JNI.MediaFormat_id_set(this.swigCPtr, this, j);
    }

    public long getId() {
        return pjsua2JNI.MediaFormat_id_get(this.swigCPtr, this);
    }

    public void setType(int i) {
        pjsua2JNI.MediaFormat_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.MediaFormat_type_get(this.swigCPtr, this);
    }

    public MediaFormat() {
        this(pjsua2JNI.new_MediaFormat(), true);
    }
}

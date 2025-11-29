package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaFmtChangedEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaFmtChangedEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaFmtChangedEvent mediaFmtChangedEvent) {
        if (mediaFmtChangedEvent == null) {
            return 0L;
        }
        return mediaFmtChangedEvent.swigCPtr;
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
                    pjsua2JNI.delete_MediaFmtChangedEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setNewWidth(long j) {
        pjsua2JNI.MediaFmtChangedEvent_newWidth_set(this.swigCPtr, this, j);
    }

    public long getNewWidth() {
        return pjsua2JNI.MediaFmtChangedEvent_newWidth_get(this.swigCPtr, this);
    }

    public void setNewHeight(long j) {
        pjsua2JNI.MediaFmtChangedEvent_newHeight_set(this.swigCPtr, this, j);
    }

    public long getNewHeight() {
        return pjsua2JNI.MediaFmtChangedEvent_newHeight_get(this.swigCPtr, this);
    }

    public MediaFmtChangedEvent() {
        this(pjsua2JNI.new_MediaFmtChangedEvent(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AudDevErrorEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudDevErrorEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudDevErrorEvent audDevErrorEvent) {
        if (audDevErrorEvent == null) {
            return 0L;
        }
        return audDevErrorEvent.swigCPtr;
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
                    pjsua2JNI.delete_AudDevErrorEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDir(int i) {
        pjsua2JNI.AudDevErrorEvent_dir_set(this.swigCPtr, this, i);
    }

    public int getDir() {
        return pjsua2JNI.AudDevErrorEvent_dir_get(this.swigCPtr, this);
    }

    public void setId(int i) {
        pjsua2JNI.AudDevErrorEvent_id_set(this.swigCPtr, this, i);
    }

    public int getId() {
        return pjsua2JNI.AudDevErrorEvent_id_get(this.swigCPtr, this);
    }

    public void setStatus(int i) {
        pjsua2JNI.AudDevErrorEvent_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.AudDevErrorEvent_status_get(this.swigCPtr, this);
    }

    public AudDevErrorEvent() {
        this(pjsua2JNI.new_AudDevErrorEvent(), true);
    }
}

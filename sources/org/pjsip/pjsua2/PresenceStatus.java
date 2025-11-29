package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class PresenceStatus {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected PresenceStatus(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PresenceStatus presenceStatus) {
        if (presenceStatus == null) {
            return 0L;
        }
        return presenceStatus.swigCPtr;
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
                    pjsua2JNI.delete_PresenceStatus(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setStatus(int i) {
        pjsua2JNI.PresenceStatus_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.PresenceStatus_status_get(this.swigCPtr, this);
    }

    public void setStatusText(String str) {
        pjsua2JNI.PresenceStatus_statusText_set(this.swigCPtr, this, str);
    }

    public String getStatusText() {
        return pjsua2JNI.PresenceStatus_statusText_get(this.swigCPtr, this);
    }

    public void setActivity(int i) {
        pjsua2JNI.PresenceStatus_activity_set(this.swigCPtr, this, i);
    }

    public int getActivity() {
        return pjsua2JNI.PresenceStatus_activity_get(this.swigCPtr, this);
    }

    public void setNote(String str) {
        pjsua2JNI.PresenceStatus_note_set(this.swigCPtr, this, str);
    }

    public String getNote() {
        return pjsua2JNI.PresenceStatus_note_get(this.swigCPtr, this);
    }

    public void setRpidId(String str) {
        pjsua2JNI.PresenceStatus_rpidId_set(this.swigCPtr, this, str);
    }

    public String getRpidId() {
        return pjsua2JNI.PresenceStatus_rpidId_get(this.swigCPtr, this);
    }

    public PresenceStatus() {
        this(pjsua2JNI.new_PresenceStatus(), true);
    }
}

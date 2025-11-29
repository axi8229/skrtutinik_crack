package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaEventData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaEventData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaEventData mediaEventData) {
        if (mediaEventData == null) {
            return 0L;
        }
        return mediaEventData.swigCPtr;
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
                    pjsua2JNI.delete_MediaEventData(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFmtChanged(MediaFmtChangedEvent mediaFmtChangedEvent) {
        pjsua2JNI.MediaEventData_fmtChanged_set(this.swigCPtr, this, MediaFmtChangedEvent.getCPtr(mediaFmtChangedEvent), mediaFmtChangedEvent);
    }

    public MediaFmtChangedEvent getFmtChanged() {
        long jMediaEventData_fmtChanged_get = pjsua2JNI.MediaEventData_fmtChanged_get(this.swigCPtr, this);
        if (jMediaEventData_fmtChanged_get == 0) {
            return null;
        }
        return new MediaFmtChangedEvent(jMediaEventData_fmtChanged_get, false);
    }

    public void setAudDevError(AudDevErrorEvent audDevErrorEvent) {
        pjsua2JNI.MediaEventData_audDevError_set(this.swigCPtr, this, AudDevErrorEvent.getCPtr(audDevErrorEvent), audDevErrorEvent);
    }

    public AudDevErrorEvent getAudDevError() {
        long jMediaEventData_audDevError_get = pjsua2JNI.MediaEventData_audDevError_get(this.swigCPtr, this);
        if (jMediaEventData_audDevError_get == 0) {
            return null;
        }
        return new AudDevErrorEvent(jMediaEventData_audDevError_get, false);
    }

    public void setPtr(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.MediaEventData_ptr_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPtr() {
        long jMediaEventData_ptr_get = pjsua2JNI.MediaEventData_ptr_get(this.swigCPtr, this);
        if (jMediaEventData_ptr_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jMediaEventData_ptr_get, false);
    }

    public MediaEventData() {
        this(pjsua2JNI.new_MediaEventData(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaEvent mediaEvent) {
        if (mediaEvent == null) {
            return 0L;
        }
        return mediaEvent.swigCPtr;
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
                    pjsua2JNI.delete_MediaEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setType(int i) {
        pjsua2JNI.MediaEvent_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.MediaEvent_type_get(this.swigCPtr, this);
    }

    public void setData(MediaEventData mediaEventData) {
        pjsua2JNI.MediaEvent_data_set(this.swigCPtr, this, MediaEventData.getCPtr(mediaEventData), mediaEventData);
    }

    public MediaEventData getData() {
        long jMediaEvent_data_get = pjsua2JNI.MediaEvent_data_get(this.swigCPtr, this);
        if (jMediaEvent_data_get == 0) {
            return null;
        }
        return new MediaEventData(jMediaEvent_data_get, false);
    }

    public void setPjMediaEvent(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.MediaEvent_pjMediaEvent_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPjMediaEvent() {
        long jMediaEvent_pjMediaEvent_get = pjsua2JNI.MediaEvent_pjMediaEvent_get(this.swigCPtr, this);
        if (jMediaEvent_pjMediaEvent_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jMediaEvent_pjMediaEvent_get, false);
    }

    public MediaEvent() {
        this(pjsua2JNI.new_MediaEvent(), true);
    }
}

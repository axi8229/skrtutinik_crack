package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SipEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SipEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SipEvent sipEvent) {
        if (sipEvent == null) {
            return 0L;
        }
        return sipEvent.swigCPtr;
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
                    pjsua2JNI.delete_SipEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setType(int i) {
        pjsua2JNI.SipEvent_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.SipEvent_type_get(this.swigCPtr, this);
    }

    public void setBody(SipEventBody sipEventBody) {
        pjsua2JNI.SipEvent_body_set(this.swigCPtr, this, SipEventBody.getCPtr(sipEventBody), sipEventBody);
    }

    public SipEventBody getBody() {
        long jSipEvent_body_get = pjsua2JNI.SipEvent_body_get(this.swigCPtr, this);
        if (jSipEvent_body_get == 0) {
            return null;
        }
        return new SipEventBody(jSipEvent_body_get, false);
    }

    public void setPjEvent(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.SipEvent_pjEvent_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPjEvent() {
        long jSipEvent_pjEvent_get = pjsua2JNI.SipEvent_pjEvent_get(this.swigCPtr, this);
        if (jSipEvent_pjEvent_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jSipEvent_pjEvent_get, false);
    }

    public SipEvent() {
        this(pjsua2JNI.new_SipEvent(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallRedirectedParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallRedirectedParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallRedirectedParam onCallRedirectedParam) {
        if (onCallRedirectedParam == null) {
            return 0L;
        }
        return onCallRedirectedParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallRedirectedParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTargetUri(String str) {
        pjsua2JNI.OnCallRedirectedParam_targetUri_set(this.swigCPtr, this, str);
    }

    public String getTargetUri() {
        return pjsua2JNI.OnCallRedirectedParam_targetUri_get(this.swigCPtr, this);
    }

    public void setE(SipEvent sipEvent) {
        pjsua2JNI.OnCallRedirectedParam_e_set(this.swigCPtr, this, SipEvent.getCPtr(sipEvent), sipEvent);
    }

    public SipEvent getE() {
        long jOnCallRedirectedParam_e_get = pjsua2JNI.OnCallRedirectedParam_e_get(this.swigCPtr, this);
        if (jOnCallRedirectedParam_e_get == 0) {
            return null;
        }
        return new SipEvent(jOnCallRedirectedParam_e_get, false);
    }

    public OnCallRedirectedParam() {
        this(pjsua2JNI.new_OnCallRedirectedParam(), true);
    }
}

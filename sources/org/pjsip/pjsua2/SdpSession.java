package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SdpSession {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SdpSession(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SdpSession sdpSession) {
        if (sdpSession == null) {
            return 0L;
        }
        return sdpSession.swigCPtr;
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
                    pjsua2JNI.delete_SdpSession(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setWholeSdp(String str) {
        pjsua2JNI.SdpSession_wholeSdp_set(this.swigCPtr, this, str);
    }

    public String getWholeSdp() {
        return pjsua2JNI.SdpSession_wholeSdp_get(this.swigCPtr, this);
    }

    public void setPjSdpSession(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.SdpSession_pjSdpSession_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPjSdpSession() {
        long jSdpSession_pjSdpSession_get = pjsua2JNI.SdpSession_pjSdpSession_get(this.swigCPtr, this);
        if (jSdpSession_pjSdpSession_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jSdpSession_pjSdpSession_get, false);
    }

    public SdpSession() {
        this(pjsua2JNI.new_SdpSession(), true);
    }
}

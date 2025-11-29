package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallSdpCreatedParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallSdpCreatedParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallSdpCreatedParam onCallSdpCreatedParam) {
        if (onCallSdpCreatedParam == null) {
            return 0L;
        }
        return onCallSdpCreatedParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallSdpCreatedParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSdp(SdpSession sdpSession) {
        pjsua2JNI.OnCallSdpCreatedParam_sdp_set(this.swigCPtr, this, SdpSession.getCPtr(sdpSession), sdpSession);
    }

    public SdpSession getSdp() {
        long jOnCallSdpCreatedParam_sdp_get = pjsua2JNI.OnCallSdpCreatedParam_sdp_get(this.swigCPtr, this);
        if (jOnCallSdpCreatedParam_sdp_get == 0) {
            return null;
        }
        return new SdpSession(jOnCallSdpCreatedParam_sdp_get, false);
    }

    public void setRemSdp(SdpSession sdpSession) {
        pjsua2JNI.OnCallSdpCreatedParam_remSdp_set(this.swigCPtr, this, SdpSession.getCPtr(sdpSession), sdpSession);
    }

    public SdpSession getRemSdp() {
        long jOnCallSdpCreatedParam_remSdp_get = pjsua2JNI.OnCallSdpCreatedParam_remSdp_get(this.swigCPtr, this);
        if (jOnCallSdpCreatedParam_remSdp_get == 0) {
            return null;
        }
        return new SdpSession(jOnCallSdpCreatedParam_remSdp_get, false);
    }

    public OnCallSdpCreatedParam() {
        this(pjsua2JNI.new_OnCallSdpCreatedParam(), true);
    }
}

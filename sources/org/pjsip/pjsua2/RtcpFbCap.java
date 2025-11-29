package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class RtcpFbCap {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RtcpFbCap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RtcpFbCap rtcpFbCap) {
        if (rtcpFbCap == null) {
            return 0L;
        }
        return rtcpFbCap.swigCPtr;
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
                    pjsua2JNI.delete_RtcpFbCap(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setCodecId(String str) {
        pjsua2JNI.RtcpFbCap_codecId_set(this.swigCPtr, this, str);
    }

    public String getCodecId() {
        return pjsua2JNI.RtcpFbCap_codecId_get(this.swigCPtr, this);
    }

    public void setType(int i) {
        pjsua2JNI.RtcpFbCap_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.RtcpFbCap_type_get(this.swigCPtr, this);
    }

    public void setTypeName(String str) {
        pjsua2JNI.RtcpFbCap_typeName_set(this.swigCPtr, this, str);
    }

    public String getTypeName() {
        return pjsua2JNI.RtcpFbCap_typeName_get(this.swigCPtr, this);
    }

    public void setParam(String str) {
        pjsua2JNI.RtcpFbCap_param_set(this.swigCPtr, this, str);
    }

    public String getParam() {
        return pjsua2JNI.RtcpFbCap_param_get(this.swigCPtr, this);
    }

    public RtcpFbCap() {
        this(pjsua2JNI.new_RtcpFbCap(), true);
    }
}

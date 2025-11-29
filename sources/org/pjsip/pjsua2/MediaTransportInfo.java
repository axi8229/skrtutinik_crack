package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaTransportInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaTransportInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaTransportInfo mediaTransportInfo) {
        if (mediaTransportInfo == null) {
            return 0L;
        }
        return mediaTransportInfo.swigCPtr;
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
                    pjsua2JNI.delete_MediaTransportInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setLocalRtpName(String str) {
        pjsua2JNI.MediaTransportInfo_localRtpName_set(this.swigCPtr, this, str);
    }

    public String getLocalRtpName() {
        return pjsua2JNI.MediaTransportInfo_localRtpName_get(this.swigCPtr, this);
    }

    public void setLocalRtcpName(String str) {
        pjsua2JNI.MediaTransportInfo_localRtcpName_set(this.swigCPtr, this, str);
    }

    public String getLocalRtcpName() {
        return pjsua2JNI.MediaTransportInfo_localRtcpName_get(this.swigCPtr, this);
    }

    public void setSrcRtpName(String str) {
        pjsua2JNI.MediaTransportInfo_srcRtpName_set(this.swigCPtr, this, str);
    }

    public String getSrcRtpName() {
        return pjsua2JNI.MediaTransportInfo_srcRtpName_get(this.swigCPtr, this);
    }

    public void setSrcRtcpName(String str) {
        pjsua2JNI.MediaTransportInfo_srcRtcpName_set(this.swigCPtr, this, str);
    }

    public String getSrcRtcpName() {
        return pjsua2JNI.MediaTransportInfo_srcRtcpName_get(this.swigCPtr, this);
    }

    public MediaTransportInfo() {
        this(pjsua2JNI.new_MediaTransportInfo(), true);
    }
}

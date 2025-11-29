package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCreateMediaTransportSrtpParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCreateMediaTransportSrtpParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCreateMediaTransportSrtpParam onCreateMediaTransportSrtpParam) {
        if (onCreateMediaTransportSrtpParam == null) {
            return 0L;
        }
        return onCreateMediaTransportSrtpParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCreateMediaTransportSrtpParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMediaIdx(long j) {
        pjsua2JNI.OnCreateMediaTransportSrtpParam_mediaIdx_set(this.swigCPtr, this, j);
    }

    public long getMediaIdx() {
        return pjsua2JNI.OnCreateMediaTransportSrtpParam_mediaIdx_get(this.swigCPtr, this);
    }

    public void setSrtpUse(int i) {
        pjsua2JNI.OnCreateMediaTransportSrtpParam_srtpUse_set(this.swigCPtr, this, i);
    }

    public int getSrtpUse() {
        return pjsua2JNI.OnCreateMediaTransportSrtpParam_srtpUse_get(this.swigCPtr, this);
    }

    public void setCryptos(SrtpCryptoVector srtpCryptoVector) {
        pjsua2JNI.OnCreateMediaTransportSrtpParam_cryptos_set(this.swigCPtr, this, SrtpCryptoVector.getCPtr(srtpCryptoVector), srtpCryptoVector);
    }

    public SrtpCryptoVector getCryptos() {
        long jOnCreateMediaTransportSrtpParam_cryptos_get = pjsua2JNI.OnCreateMediaTransportSrtpParam_cryptos_get(this.swigCPtr, this);
        if (jOnCreateMediaTransportSrtpParam_cryptos_get == 0) {
            return null;
        }
        return new SrtpCryptoVector(jOnCreateMediaTransportSrtpParam_cryptos_get, false);
    }

    public OnCreateMediaTransportSrtpParam() {
        this(pjsua2JNI.new_OnCreateMediaTransportSrtpParam(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TlsInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TlsInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TlsInfo tlsInfo) {
        if (tlsInfo == null) {
            return 0L;
        }
        return tlsInfo.swigCPtr;
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
                    pjsua2JNI.delete_TlsInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setEstablished(boolean z) {
        pjsua2JNI.TlsInfo_established_set(this.swigCPtr, this, z);
    }

    public boolean getEstablished() {
        return pjsua2JNI.TlsInfo_established_get(this.swigCPtr, this);
    }

    public void setProtocol(long j) {
        pjsua2JNI.TlsInfo_protocol_set(this.swigCPtr, this, j);
    }

    public long getProtocol() {
        return pjsua2JNI.TlsInfo_protocol_get(this.swigCPtr, this);
    }

    public void setCipher(int i) {
        pjsua2JNI.TlsInfo_cipher_set(this.swigCPtr, this, i);
    }

    public int getCipher() {
        return pjsua2JNI.TlsInfo_cipher_get(this.swigCPtr, this);
    }

    public void setCipherName(String str) {
        pjsua2JNI.TlsInfo_cipherName_set(this.swigCPtr, this, str);
    }

    public String getCipherName() {
        return pjsua2JNI.TlsInfo_cipherName_get(this.swigCPtr, this);
    }

    public void setLocalAddr(String str) {
        pjsua2JNI.TlsInfo_localAddr_set(this.swigCPtr, this, str);
    }

    public String getLocalAddr() {
        return pjsua2JNI.TlsInfo_localAddr_get(this.swigCPtr, this);
    }

    public void setRemoteAddr(String str) {
        pjsua2JNI.TlsInfo_remoteAddr_set(this.swigCPtr, this, str);
    }

    public String getRemoteAddr() {
        return pjsua2JNI.TlsInfo_remoteAddr_get(this.swigCPtr, this);
    }

    public void setLocalCertInfo(SslCertInfo sslCertInfo) {
        pjsua2JNI.TlsInfo_localCertInfo_set(this.swigCPtr, this, SslCertInfo.getCPtr(sslCertInfo), sslCertInfo);
    }

    public SslCertInfo getLocalCertInfo() {
        long jTlsInfo_localCertInfo_get = pjsua2JNI.TlsInfo_localCertInfo_get(this.swigCPtr, this);
        if (jTlsInfo_localCertInfo_get == 0) {
            return null;
        }
        return new SslCertInfo(jTlsInfo_localCertInfo_get, false);
    }

    public void setRemoteCertInfo(SslCertInfo sslCertInfo) {
        pjsua2JNI.TlsInfo_remoteCertInfo_set(this.swigCPtr, this, SslCertInfo.getCPtr(sslCertInfo), sslCertInfo);
    }

    public SslCertInfo getRemoteCertInfo() {
        long jTlsInfo_remoteCertInfo_get = pjsua2JNI.TlsInfo_remoteCertInfo_get(this.swigCPtr, this);
        if (jTlsInfo_remoteCertInfo_get == 0) {
            return null;
        }
        return new SslCertInfo(jTlsInfo_remoteCertInfo_get, false);
    }

    public void setVerifyStatus(long j) {
        pjsua2JNI.TlsInfo_verifyStatus_set(this.swigCPtr, this, j);
    }

    public long getVerifyStatus() {
        return pjsua2JNI.TlsInfo_verifyStatus_get(this.swigCPtr, this);
    }

    public void setVerifyMsgs(StringVector stringVector) {
        pjsua2JNI.TlsInfo_verifyMsgs_set(this.swigCPtr, this, StringVector.getCPtr(stringVector), stringVector);
    }

    public StringVector getVerifyMsgs() {
        long jTlsInfo_verifyMsgs_get = pjsua2JNI.TlsInfo_verifyMsgs_get(this.swigCPtr, this);
        if (jTlsInfo_verifyMsgs_get == 0) {
            return null;
        }
        return new StringVector(jTlsInfo_verifyMsgs_get, false);
    }

    public TlsInfo() {
        this(pjsua2JNI.new_TlsInfo(), true);
    }

    public boolean isEmpty() {
        return pjsua2JNI.TlsInfo_isEmpty(this.swigCPtr, this);
    }
}

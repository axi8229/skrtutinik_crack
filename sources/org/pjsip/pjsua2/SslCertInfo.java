package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SslCertInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SslCertInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SslCertInfo sslCertInfo) {
        if (sslCertInfo == null) {
            return 0L;
        }
        return sslCertInfo.swigCPtr;
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
                    pjsua2JNI.delete_SslCertInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setVersion(long j) {
        pjsua2JNI.SslCertInfo_version_set(this.swigCPtr, this, j);
    }

    public long getVersion() {
        return pjsua2JNI.SslCertInfo_version_get(this.swigCPtr, this);
    }

    public void setSerialNo(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        pjsua2JNI.SslCertInfo_serialNo_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getSerialNo() {
        long jSslCertInfo_serialNo_get = pjsua2JNI.SslCertInfo_serialNo_get(this.swigCPtr, this);
        if (jSslCertInfo_serialNo_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(jSslCertInfo_serialNo_get, false);
    }

    public void setSubjectCn(String str) {
        pjsua2JNI.SslCertInfo_subjectCn_set(this.swigCPtr, this, str);
    }

    public String getSubjectCn() {
        return pjsua2JNI.SslCertInfo_subjectCn_get(this.swigCPtr, this);
    }

    public void setSubjectInfo(String str) {
        pjsua2JNI.SslCertInfo_subjectInfo_set(this.swigCPtr, this, str);
    }

    public String getSubjectInfo() {
        return pjsua2JNI.SslCertInfo_subjectInfo_get(this.swigCPtr, this);
    }

    public void setIssuerCn(String str) {
        pjsua2JNI.SslCertInfo_issuerCn_set(this.swigCPtr, this, str);
    }

    public String getIssuerCn() {
        return pjsua2JNI.SslCertInfo_issuerCn_get(this.swigCPtr, this);
    }

    public void setIssuerInfo(String str) {
        pjsua2JNI.SslCertInfo_issuerInfo_set(this.swigCPtr, this, str);
    }

    public String getIssuerInfo() {
        return pjsua2JNI.SslCertInfo_issuerInfo_get(this.swigCPtr, this);
    }

    public void setValidityStart(TimeVal timeVal) {
        pjsua2JNI.SslCertInfo_validityStart_set(this.swigCPtr, this, TimeVal.getCPtr(timeVal), timeVal);
    }

    public TimeVal getValidityStart() {
        long jSslCertInfo_validityStart_get = pjsua2JNI.SslCertInfo_validityStart_get(this.swigCPtr, this);
        if (jSslCertInfo_validityStart_get == 0) {
            return null;
        }
        return new TimeVal(jSslCertInfo_validityStart_get, false);
    }

    public void setValidityEnd(TimeVal timeVal) {
        pjsua2JNI.SslCertInfo_validityEnd_set(this.swigCPtr, this, TimeVal.getCPtr(timeVal), timeVal);
    }

    public TimeVal getValidityEnd() {
        long jSslCertInfo_validityEnd_get = pjsua2JNI.SslCertInfo_validityEnd_get(this.swigCPtr, this);
        if (jSslCertInfo_validityEnd_get == 0) {
            return null;
        }
        return new TimeVal(jSslCertInfo_validityEnd_get, false);
    }

    public void setValidityGmt(boolean z) {
        pjsua2JNI.SslCertInfo_validityGmt_set(this.swigCPtr, this, z);
    }

    public boolean getValidityGmt() {
        return pjsua2JNI.SslCertInfo_validityGmt_get(this.swigCPtr, this);
    }

    public void setSubjectAltName(SslCertNameVector sslCertNameVector) {
        pjsua2JNI.SslCertInfo_subjectAltName_set(this.swigCPtr, this, SslCertNameVector.getCPtr(sslCertNameVector), sslCertNameVector);
    }

    public SslCertNameVector getSubjectAltName() {
        long jSslCertInfo_subjectAltName_get = pjsua2JNI.SslCertInfo_subjectAltName_get(this.swigCPtr, this);
        if (jSslCertInfo_subjectAltName_get == 0) {
            return null;
        }
        return new SslCertNameVector(jSslCertInfo_subjectAltName_get, false);
    }

    public void setRaw(String str) {
        pjsua2JNI.SslCertInfo_raw_set(this.swigCPtr, this, str);
    }

    public String getRaw() {
        return pjsua2JNI.SslCertInfo_raw_get(this.swigCPtr, this);
    }

    public SslCertInfo() {
        this(pjsua2JNI.new_SslCertInfo(), true);
    }

    public boolean isEmpty() {
        return pjsua2JNI.SslCertInfo_isEmpty(this.swigCPtr, this);
    }
}

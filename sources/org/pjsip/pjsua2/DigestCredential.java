package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class DigestCredential {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DigestCredential(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DigestCredential digestCredential) {
        if (digestCredential == null) {
            return 0L;
        }
        return digestCredential.swigCPtr;
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
                    pjsua2JNI.delete_DigestCredential(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRealm(String str) {
        pjsua2JNI.DigestCredential_realm_set(this.swigCPtr, this, str);
    }

    public String getRealm() {
        return pjsua2JNI.DigestCredential_realm_get(this.swigCPtr, this);
    }

    public void setOtherParam(StringToStringMap stringToStringMap) {
        pjsua2JNI.DigestCredential_otherParam_set(this.swigCPtr, this, StringToStringMap.getCPtr(stringToStringMap), stringToStringMap);
    }

    public StringToStringMap getOtherParam() {
        long jDigestCredential_otherParam_get = pjsua2JNI.DigestCredential_otherParam_get(this.swigCPtr, this);
        if (jDigestCredential_otherParam_get == 0) {
            return null;
        }
        return new StringToStringMap(jDigestCredential_otherParam_get, false);
    }

    public void setUsername(String str) {
        pjsua2JNI.DigestCredential_username_set(this.swigCPtr, this, str);
    }

    public String getUsername() {
        return pjsua2JNI.DigestCredential_username_get(this.swigCPtr, this);
    }

    public void setNonce(String str) {
        pjsua2JNI.DigestCredential_nonce_set(this.swigCPtr, this, str);
    }

    public String getNonce() {
        return pjsua2JNI.DigestCredential_nonce_get(this.swigCPtr, this);
    }

    public void setUri(String str) {
        pjsua2JNI.DigestCredential_uri_set(this.swigCPtr, this, str);
    }

    public String getUri() {
        return pjsua2JNI.DigestCredential_uri_get(this.swigCPtr, this);
    }

    public void setResponse(String str) {
        pjsua2JNI.DigestCredential_response_set(this.swigCPtr, this, str);
    }

    public String getResponse() {
        return pjsua2JNI.DigestCredential_response_get(this.swigCPtr, this);
    }

    public void setAlgorithm(String str) {
        pjsua2JNI.DigestCredential_algorithm_set(this.swigCPtr, this, str);
    }

    public String getAlgorithm() {
        return pjsua2JNI.DigestCredential_algorithm_get(this.swigCPtr, this);
    }

    public void setCnonce(String str) {
        pjsua2JNI.DigestCredential_cnonce_set(this.swigCPtr, this, str);
    }

    public String getCnonce() {
        return pjsua2JNI.DigestCredential_cnonce_get(this.swigCPtr, this);
    }

    public void setOpaque(String str) {
        pjsua2JNI.DigestCredential_opaque_set(this.swigCPtr, this, str);
    }

    public String getOpaque() {
        return pjsua2JNI.DigestCredential_opaque_get(this.swigCPtr, this);
    }

    public void setQop(String str) {
        pjsua2JNI.DigestCredential_qop_set(this.swigCPtr, this, str);
    }

    public String getQop() {
        return pjsua2JNI.DigestCredential_qop_get(this.swigCPtr, this);
    }

    public void setNc(String str) {
        pjsua2JNI.DigestCredential_nc_set(this.swigCPtr, this, str);
    }

    public String getNc() {
        return pjsua2JNI.DigestCredential_nc_get(this.swigCPtr, this);
    }

    public DigestCredential() {
        this(pjsua2JNI.new_DigestCredential(), true);
    }
}

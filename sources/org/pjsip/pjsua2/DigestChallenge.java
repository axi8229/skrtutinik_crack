package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class DigestChallenge {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DigestChallenge(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DigestChallenge digestChallenge) {
        if (digestChallenge == null) {
            return 0L;
        }
        return digestChallenge.swigCPtr;
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
                    pjsua2JNI.delete_DigestChallenge(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRealm(String str) {
        pjsua2JNI.DigestChallenge_realm_set(this.swigCPtr, this, str);
    }

    public String getRealm() {
        return pjsua2JNI.DigestChallenge_realm_get(this.swigCPtr, this);
    }

    public void setOtherParam(StringToStringMap stringToStringMap) {
        pjsua2JNI.DigestChallenge_otherParam_set(this.swigCPtr, this, StringToStringMap.getCPtr(stringToStringMap), stringToStringMap);
    }

    public StringToStringMap getOtherParam() {
        long jDigestChallenge_otherParam_get = pjsua2JNI.DigestChallenge_otherParam_get(this.swigCPtr, this);
        if (jDigestChallenge_otherParam_get == 0) {
            return null;
        }
        return new StringToStringMap(jDigestChallenge_otherParam_get, false);
    }

    public void setDomain(String str) {
        pjsua2JNI.DigestChallenge_domain_set(this.swigCPtr, this, str);
    }

    public String getDomain() {
        return pjsua2JNI.DigestChallenge_domain_get(this.swigCPtr, this);
    }

    public void setNonce(String str) {
        pjsua2JNI.DigestChallenge_nonce_set(this.swigCPtr, this, str);
    }

    public String getNonce() {
        return pjsua2JNI.DigestChallenge_nonce_get(this.swigCPtr, this);
    }

    public void setOpaque(String str) {
        pjsua2JNI.DigestChallenge_opaque_set(this.swigCPtr, this, str);
    }

    public String getOpaque() {
        return pjsua2JNI.DigestChallenge_opaque_get(this.swigCPtr, this);
    }

    public void setStale(int i) {
        pjsua2JNI.DigestChallenge_stale_set(this.swigCPtr, this, i);
    }

    public int getStale() {
        return pjsua2JNI.DigestChallenge_stale_get(this.swigCPtr, this);
    }

    public void setAlgorithm(String str) {
        pjsua2JNI.DigestChallenge_algorithm_set(this.swigCPtr, this, str);
    }

    public String getAlgorithm() {
        return pjsua2JNI.DigestChallenge_algorithm_get(this.swigCPtr, this);
    }

    public void setQop(String str) {
        pjsua2JNI.DigestChallenge_qop_set(this.swigCPtr, this, str);
    }

    public String getQop() {
        return pjsua2JNI.DigestChallenge_qop_get(this.swigCPtr, this);
    }

    public DigestChallenge() {
        this(pjsua2JNI.new_DigestChallenge(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCredAuthParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCredAuthParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCredAuthParam onCredAuthParam) {
        if (onCredAuthParam == null) {
            return 0L;
        }
        return onCredAuthParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCredAuthParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDigestChallenge(DigestChallenge digestChallenge) {
        pjsua2JNI.OnCredAuthParam_digestChallenge_set(this.swigCPtr, this, DigestChallenge.getCPtr(digestChallenge), digestChallenge);
    }

    public DigestChallenge getDigestChallenge() {
        long jOnCredAuthParam_digestChallenge_get = pjsua2JNI.OnCredAuthParam_digestChallenge_get(this.swigCPtr, this);
        if (jOnCredAuthParam_digestChallenge_get == 0) {
            return null;
        }
        return new DigestChallenge(jOnCredAuthParam_digestChallenge_get, false);
    }

    public void setCredentialInfo(AuthCredInfo authCredInfo) {
        pjsua2JNI.OnCredAuthParam_credentialInfo_set(this.swigCPtr, this, AuthCredInfo.getCPtr(authCredInfo), authCredInfo);
    }

    public AuthCredInfo getCredentialInfo() {
        long jOnCredAuthParam_credentialInfo_get = pjsua2JNI.OnCredAuthParam_credentialInfo_get(this.swigCPtr, this);
        if (jOnCredAuthParam_credentialInfo_get == 0) {
            return null;
        }
        return new AuthCredInfo(jOnCredAuthParam_credentialInfo_get, false);
    }

    public void setMethod(String str) {
        pjsua2JNI.OnCredAuthParam_method_set(this.swigCPtr, this, str);
    }

    public String getMethod() {
        return pjsua2JNI.OnCredAuthParam_method_get(this.swigCPtr, this);
    }

    public void setDigestCredential(DigestCredential digestCredential) {
        pjsua2JNI.OnCredAuthParam_digestCredential_set(this.swigCPtr, this, DigestCredential.getCPtr(digestCredential), digestCredential);
    }

    public DigestCredential getDigestCredential() {
        long jOnCredAuthParam_digestCredential_get = pjsua2JNI.OnCredAuthParam_digestCredential_get(this.swigCPtr, this);
        if (jOnCredAuthParam_digestCredential_get == 0) {
            return null;
        }
        return new DigestCredential(jOnCredAuthParam_digestCredential_get, false);
    }

    public OnCredAuthParam() {
        this(pjsua2JNI.new_OnCredAuthParam(), true);
    }
}

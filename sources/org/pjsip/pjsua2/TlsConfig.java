package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TlsConfig extends PersistentObject {
    private transient long swigCPtr;

    protected TlsConfig(long j, boolean z) {
        super(pjsua2JNI.TlsConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(TlsConfig tlsConfig) {
        if (tlsConfig == null) {
            return 0L;
        }
        return tlsConfig.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_TlsConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setCaListFile(String str) {
        pjsua2JNI.TlsConfig_CaListFile_set(this.swigCPtr, this, str);
    }

    public String getCaListFile() {
        return pjsua2JNI.TlsConfig_CaListFile_get(this.swigCPtr, this);
    }

    public void setCertFile(String str) {
        pjsua2JNI.TlsConfig_certFile_set(this.swigCPtr, this, str);
    }

    public String getCertFile() {
        return pjsua2JNI.TlsConfig_certFile_get(this.swigCPtr, this);
    }

    public void setPrivKeyFile(String str) {
        pjsua2JNI.TlsConfig_privKeyFile_set(this.swigCPtr, this, str);
    }

    public String getPrivKeyFile() {
        return pjsua2JNI.TlsConfig_privKeyFile_get(this.swigCPtr, this);
    }

    public void setPassword(String str) {
        pjsua2JNI.TlsConfig_password_set(this.swigCPtr, this, str);
    }

    public String getPassword() {
        return pjsua2JNI.TlsConfig_password_get(this.swigCPtr, this);
    }

    public void setCaBuf(String str) {
        pjsua2JNI.TlsConfig_CaBuf_set(this.swigCPtr, this, str);
    }

    public String getCaBuf() {
        return pjsua2JNI.TlsConfig_CaBuf_get(this.swigCPtr, this);
    }

    public void setCertBuf(String str) {
        pjsua2JNI.TlsConfig_certBuf_set(this.swigCPtr, this, str);
    }

    public String getCertBuf() {
        return pjsua2JNI.TlsConfig_certBuf_get(this.swigCPtr, this);
    }

    public void setPrivKeyBuf(String str) {
        pjsua2JNI.TlsConfig_privKeyBuf_set(this.swigCPtr, this, str);
    }

    public String getPrivKeyBuf() {
        return pjsua2JNI.TlsConfig_privKeyBuf_get(this.swigCPtr, this);
    }

    public void setMethod(int i) {
        pjsua2JNI.TlsConfig_method_set(this.swigCPtr, this, i);
    }

    public int getMethod() {
        return pjsua2JNI.TlsConfig_method_get(this.swigCPtr, this);
    }

    public void setProto(long j) {
        pjsua2JNI.TlsConfig_proto_set(this.swigCPtr, this, j);
    }

    public long getProto() {
        return pjsua2JNI.TlsConfig_proto_get(this.swigCPtr, this);
    }

    public void setCiphers(IntVector intVector) {
        pjsua2JNI.TlsConfig_ciphers_set(this.swigCPtr, this, IntVector.getCPtr(intVector), intVector);
    }

    public IntVector getCiphers() {
        long jTlsConfig_ciphers_get = pjsua2JNI.TlsConfig_ciphers_get(this.swigCPtr, this);
        if (jTlsConfig_ciphers_get == 0) {
            return null;
        }
        return new IntVector(jTlsConfig_ciphers_get, false);
    }

    public void setVerifyServer(boolean z) {
        pjsua2JNI.TlsConfig_verifyServer_set(this.swigCPtr, this, z);
    }

    public boolean getVerifyServer() {
        return pjsua2JNI.TlsConfig_verifyServer_get(this.swigCPtr, this);
    }

    public void setVerifyClient(boolean z) {
        pjsua2JNI.TlsConfig_verifyClient_set(this.swigCPtr, this, z);
    }

    public boolean getVerifyClient() {
        return pjsua2JNI.TlsConfig_verifyClient_get(this.swigCPtr, this);
    }

    public void setRequireClientCert(boolean z) {
        pjsua2JNI.TlsConfig_requireClientCert_set(this.swigCPtr, this, z);
    }

    public boolean getRequireClientCert() {
        return pjsua2JNI.TlsConfig_requireClientCert_get(this.swigCPtr, this);
    }

    public void setMsecTimeout(long j) {
        pjsua2JNI.TlsConfig_msecTimeout_set(this.swigCPtr, this, j);
    }

    public long getMsecTimeout() {
        return pjsua2JNI.TlsConfig_msecTimeout_get(this.swigCPtr, this);
    }

    public void setQosType(int i) {
        pjsua2JNI.TlsConfig_qosType_set(this.swigCPtr, this, i);
    }

    public int getQosType() {
        return pjsua2JNI.TlsConfig_qosType_get(this.swigCPtr, this);
    }

    public void setQosParams(pj_qos_params pj_qos_paramsVar) {
        pjsua2JNI.TlsConfig_qosParams_set(this.swigCPtr, this, pj_qos_params.getCPtr(pj_qos_paramsVar), pj_qos_paramsVar);
    }

    public pj_qos_params getQosParams() {
        long jTlsConfig_qosParams_get = pjsua2JNI.TlsConfig_qosParams_get(this.swigCPtr, this);
        if (jTlsConfig_qosParams_get == 0) {
            return null;
        }
        return new pj_qos_params(jTlsConfig_qosParams_get, false);
    }

    public void setQosIgnoreError(boolean z) {
        pjsua2JNI.TlsConfig_qosIgnoreError_set(this.swigCPtr, this, z);
    }

    public boolean getQosIgnoreError() {
        return pjsua2JNI.TlsConfig_qosIgnoreError_get(this.swigCPtr, this);
    }

    public TlsConfig() {
        this(pjsua2JNI.new_TlsConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.TlsConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.TlsConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

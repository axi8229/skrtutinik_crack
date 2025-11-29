package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TransportConfig extends PersistentObject {
    private transient long swigCPtr;

    protected TransportConfig(long j, boolean z) {
        super(pjsua2JNI.TransportConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(TransportConfig transportConfig) {
        if (transportConfig == null) {
            return 0L;
        }
        return transportConfig.swigCPtr;
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
                    pjsua2JNI.delete_TransportConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setPort(long j) {
        pjsua2JNI.TransportConfig_port_set(this.swigCPtr, this, j);
    }

    public long getPort() {
        return pjsua2JNI.TransportConfig_port_get(this.swigCPtr, this);
    }

    public void setPortRange(long j) {
        pjsua2JNI.TransportConfig_portRange_set(this.swigCPtr, this, j);
    }

    public long getPortRange() {
        return pjsua2JNI.TransportConfig_portRange_get(this.swigCPtr, this);
    }

    public void setRandomizePort(boolean z) {
        pjsua2JNI.TransportConfig_randomizePort_set(this.swigCPtr, this, z);
    }

    public boolean getRandomizePort() {
        return pjsua2JNI.TransportConfig_randomizePort_get(this.swigCPtr, this);
    }

    public void setPublicAddress(String str) {
        pjsua2JNI.TransportConfig_publicAddress_set(this.swigCPtr, this, str);
    }

    public String getPublicAddress() {
        return pjsua2JNI.TransportConfig_publicAddress_get(this.swigCPtr, this);
    }

    public void setBoundAddress(String str) {
        pjsua2JNI.TransportConfig_boundAddress_set(this.swigCPtr, this, str);
    }

    public String getBoundAddress() {
        return pjsua2JNI.TransportConfig_boundAddress_get(this.swigCPtr, this);
    }

    public void setTlsConfig(TlsConfig tlsConfig) {
        pjsua2JNI.TransportConfig_tlsConfig_set(this.swigCPtr, this, TlsConfig.getCPtr(tlsConfig), tlsConfig);
    }

    public TlsConfig getTlsConfig() {
        long jTransportConfig_tlsConfig_get = pjsua2JNI.TransportConfig_tlsConfig_get(this.swigCPtr, this);
        if (jTransportConfig_tlsConfig_get == 0) {
            return null;
        }
        return new TlsConfig(jTransportConfig_tlsConfig_get, false);
    }

    public void setQosType(int i) {
        pjsua2JNI.TransportConfig_qosType_set(this.swigCPtr, this, i);
    }

    public int getQosType() {
        return pjsua2JNI.TransportConfig_qosType_get(this.swigCPtr, this);
    }

    public void setQosParams(pj_qos_params pj_qos_paramsVar) {
        pjsua2JNI.TransportConfig_qosParams_set(this.swigCPtr, this, pj_qos_params.getCPtr(pj_qos_paramsVar), pj_qos_paramsVar);
    }

    public pj_qos_params getQosParams() {
        long jTransportConfig_qosParams_get = pjsua2JNI.TransportConfig_qosParams_get(this.swigCPtr, this);
        if (jTransportConfig_qosParams_get == 0) {
            return null;
        }
        return new pj_qos_params(jTransportConfig_qosParams_get, false);
    }

    public TransportConfig() {
        this(pjsua2JNI.new_TransportConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.TransportConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.TransportConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

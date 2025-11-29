package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class UaConfig extends PersistentObject {
    private transient long swigCPtr;

    protected UaConfig(long j, boolean z) {
        super(pjsua2JNI.UaConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(UaConfig uaConfig) {
        if (uaConfig == null) {
            return 0L;
        }
        return uaConfig.swigCPtr;
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
                    pjsua2JNI.delete_UaConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMaxCalls(long j) {
        pjsua2JNI.UaConfig_maxCalls_set(this.swigCPtr, this, j);
    }

    public long getMaxCalls() {
        return pjsua2JNI.UaConfig_maxCalls_get(this.swigCPtr, this);
    }

    public void setThreadCnt(long j) {
        pjsua2JNI.UaConfig_threadCnt_set(this.swigCPtr, this, j);
    }

    public long getThreadCnt() {
        return pjsua2JNI.UaConfig_threadCnt_get(this.swigCPtr, this);
    }

    public void setMainThreadOnly(boolean z) {
        pjsua2JNI.UaConfig_mainThreadOnly_set(this.swigCPtr, this, z);
    }

    public boolean getMainThreadOnly() {
        return pjsua2JNI.UaConfig_mainThreadOnly_get(this.swigCPtr, this);
    }

    public void setNameserver(StringVector stringVector) {
        pjsua2JNI.UaConfig_nameserver_set(this.swigCPtr, this, StringVector.getCPtr(stringVector), stringVector);
    }

    public StringVector getNameserver() {
        long jUaConfig_nameserver_get = pjsua2JNI.UaConfig_nameserver_get(this.swigCPtr, this);
        if (jUaConfig_nameserver_get == 0) {
            return null;
        }
        return new StringVector(jUaConfig_nameserver_get, false);
    }

    public void setOutboundProxies(StringVector stringVector) {
        pjsua2JNI.UaConfig_outboundProxies_set(this.swigCPtr, this, StringVector.getCPtr(stringVector), stringVector);
    }

    public StringVector getOutboundProxies() {
        long jUaConfig_outboundProxies_get = pjsua2JNI.UaConfig_outboundProxies_get(this.swigCPtr, this);
        if (jUaConfig_outboundProxies_get == 0) {
            return null;
        }
        return new StringVector(jUaConfig_outboundProxies_get, false);
    }

    public void setUserAgent(String str) {
        pjsua2JNI.UaConfig_userAgent_set(this.swigCPtr, this, str);
    }

    public String getUserAgent() {
        return pjsua2JNI.UaConfig_userAgent_get(this.swigCPtr, this);
    }

    public void setStunServer(StringVector stringVector) {
        pjsua2JNI.UaConfig_stunServer_set(this.swigCPtr, this, StringVector.getCPtr(stringVector), stringVector);
    }

    public StringVector getStunServer() {
        long jUaConfig_stunServer_get = pjsua2JNI.UaConfig_stunServer_get(this.swigCPtr, this);
        if (jUaConfig_stunServer_get == 0) {
            return null;
        }
        return new StringVector(jUaConfig_stunServer_get, false);
    }

    public void setStunTryIpv6(boolean z) {
        pjsua2JNI.UaConfig_stunTryIpv6_set(this.swigCPtr, this, z);
    }

    public boolean getStunTryIpv6() {
        return pjsua2JNI.UaConfig_stunTryIpv6_get(this.swigCPtr, this);
    }

    public void setStunIgnoreFailure(boolean z) {
        pjsua2JNI.UaConfig_stunIgnoreFailure_set(this.swigCPtr, this, z);
    }

    public boolean getStunIgnoreFailure() {
        return pjsua2JNI.UaConfig_stunIgnoreFailure_get(this.swigCPtr, this);
    }

    public void setNatTypeInSdp(int i) {
        pjsua2JNI.UaConfig_natTypeInSdp_set(this.swigCPtr, this, i);
    }

    public int getNatTypeInSdp() {
        return pjsua2JNI.UaConfig_natTypeInSdp_get(this.swigCPtr, this);
    }

    public void setMwiUnsolicitedEnabled(boolean z) {
        pjsua2JNI.UaConfig_mwiUnsolicitedEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getMwiUnsolicitedEnabled() {
        return pjsua2JNI.UaConfig_mwiUnsolicitedEnabled_get(this.swigCPtr, this);
    }

    public void setEnableUpnp(boolean z) {
        pjsua2JNI.UaConfig_enableUpnp_set(this.swigCPtr, this, z);
    }

    public boolean getEnableUpnp() {
        return pjsua2JNI.UaConfig_enableUpnp_get(this.swigCPtr, this);
    }

    public void setUpnpIfName(String str) {
        pjsua2JNI.UaConfig_upnpIfName_set(this.swigCPtr, this, str);
    }

    public String getUpnpIfName() {
        return pjsua2JNI.UaConfig_upnpIfName_get(this.swigCPtr, this);
    }

    public UaConfig() {
        this(pjsua2JNI.new_UaConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.UaConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.UaConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

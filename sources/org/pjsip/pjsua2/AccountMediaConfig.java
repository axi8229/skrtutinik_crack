package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AccountMediaConfig extends PersistentObject {
    private transient long swigCPtr;

    protected AccountMediaConfig(long j, boolean z) {
        super(pjsua2JNI.AccountMediaConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AccountMediaConfig accountMediaConfig) {
        if (accountMediaConfig == null) {
            return 0L;
        }
        return accountMediaConfig.swigCPtr;
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
                    pjsua2JNI.delete_AccountMediaConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTransportConfig(TransportConfig transportConfig) {
        pjsua2JNI.AccountMediaConfig_transportConfig_set(this.swigCPtr, this, TransportConfig.getCPtr(transportConfig), transportConfig);
    }

    public TransportConfig getTransportConfig() {
        long jAccountMediaConfig_transportConfig_get = pjsua2JNI.AccountMediaConfig_transportConfig_get(this.swigCPtr, this);
        if (jAccountMediaConfig_transportConfig_get == 0) {
            return null;
        }
        return new TransportConfig(jAccountMediaConfig_transportConfig_get, false);
    }

    public void setLockCodecEnabled(boolean z) {
        pjsua2JNI.AccountMediaConfig_lockCodecEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getLockCodecEnabled() {
        return pjsua2JNI.AccountMediaConfig_lockCodecEnabled_get(this.swigCPtr, this);
    }

    public void setStreamKaEnabled(boolean z) {
        pjsua2JNI.AccountMediaConfig_streamKaEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getStreamKaEnabled() {
        return pjsua2JNI.AccountMediaConfig_streamKaEnabled_get(this.swigCPtr, this);
    }

    public void setSrtpUse(int i) {
        pjsua2JNI.AccountMediaConfig_srtpUse_set(this.swigCPtr, this, i);
    }

    public int getSrtpUse() {
        return pjsua2JNI.AccountMediaConfig_srtpUse_get(this.swigCPtr, this);
    }

    public void setSrtpSecureSignaling(int i) {
        pjsua2JNI.AccountMediaConfig_srtpSecureSignaling_set(this.swigCPtr, this, i);
    }

    public int getSrtpSecureSignaling() {
        return pjsua2JNI.AccountMediaConfig_srtpSecureSignaling_get(this.swigCPtr, this);
    }

    public void setSrtpOpt(SrtpOpt srtpOpt) {
        pjsua2JNI.AccountMediaConfig_srtpOpt_set(this.swigCPtr, this, SrtpOpt.getCPtr(srtpOpt), srtpOpt);
    }

    public SrtpOpt getSrtpOpt() {
        long jAccountMediaConfig_srtpOpt_get = pjsua2JNI.AccountMediaConfig_srtpOpt_get(this.swigCPtr, this);
        if (jAccountMediaConfig_srtpOpt_get == 0) {
            return null;
        }
        return new SrtpOpt(jAccountMediaConfig_srtpOpt_get, false);
    }

    public void setIpv6Use(int i) {
        pjsua2JNI.AccountMediaConfig_ipv6Use_set(this.swigCPtr, this, i);
    }

    public int getIpv6Use() {
        return pjsua2JNI.AccountMediaConfig_ipv6Use_get(this.swigCPtr, this);
    }

    public void setRtcpMuxEnabled(boolean z) {
        pjsua2JNI.AccountMediaConfig_rtcpMuxEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getRtcpMuxEnabled() {
        return pjsua2JNI.AccountMediaConfig_rtcpMuxEnabled_get(this.swigCPtr, this);
    }

    public void setRtcpFbConfig(RtcpFbConfig rtcpFbConfig) {
        pjsua2JNI.AccountMediaConfig_rtcpFbConfig_set(this.swigCPtr, this, RtcpFbConfig.getCPtr(rtcpFbConfig), rtcpFbConfig);
    }

    public RtcpFbConfig getRtcpFbConfig() {
        long jAccountMediaConfig_rtcpFbConfig_get = pjsua2JNI.AccountMediaConfig_rtcpFbConfig_get(this.swigCPtr, this);
        if (jAccountMediaConfig_rtcpFbConfig_get == 0) {
            return null;
        }
        return new RtcpFbConfig(jAccountMediaConfig_rtcpFbConfig_get, false);
    }

    public void setRtcpXrEnabled(boolean z) {
        pjsua2JNI.AccountMediaConfig_rtcpXrEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getRtcpXrEnabled() {
        return pjsua2JNI.AccountMediaConfig_rtcpXrEnabled_get(this.swigCPtr, this);
    }

    public void setUseLoopMedTp(boolean z) {
        pjsua2JNI.AccountMediaConfig_useLoopMedTp_set(this.swigCPtr, this, z);
    }

    public boolean getUseLoopMedTp() {
        return pjsua2JNI.AccountMediaConfig_useLoopMedTp_get(this.swigCPtr, this);
    }

    public void setEnableLoopback(boolean z) {
        pjsua2JNI.AccountMediaConfig_enableLoopback_set(this.swigCPtr, this, z);
    }

    public boolean getEnableLoopback() {
        return pjsua2JNI.AccountMediaConfig_enableLoopback_get(this.swigCPtr, this);
    }

    public AccountMediaConfig() {
        this(pjsua2JNI.new_AccountMediaConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountMediaConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountMediaConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

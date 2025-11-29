package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AccountVideoConfig extends PersistentObject {
    private transient long swigCPtr;

    protected AccountVideoConfig(long j, boolean z) {
        super(pjsua2JNI.AccountVideoConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AccountVideoConfig accountVideoConfig) {
        if (accountVideoConfig == null) {
            return 0L;
        }
        return accountVideoConfig.swigCPtr;
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
                    pjsua2JNI.delete_AccountVideoConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setAutoShowIncoming(boolean z) {
        pjsua2JNI.AccountVideoConfig_autoShowIncoming_set(this.swigCPtr, this, z);
    }

    public boolean getAutoShowIncoming() {
        return pjsua2JNI.AccountVideoConfig_autoShowIncoming_get(this.swigCPtr, this);
    }

    public void setAutoTransmitOutgoing(boolean z) {
        pjsua2JNI.AccountVideoConfig_autoTransmitOutgoing_set(this.swigCPtr, this, z);
    }

    public boolean getAutoTransmitOutgoing() {
        return pjsua2JNI.AccountVideoConfig_autoTransmitOutgoing_get(this.swigCPtr, this);
    }

    public void setWindowFlags(long j) {
        pjsua2JNI.AccountVideoConfig_windowFlags_set(this.swigCPtr, this, j);
    }

    public long getWindowFlags() {
        return pjsua2JNI.AccountVideoConfig_windowFlags_get(this.swigCPtr, this);
    }

    public void setDefaultCaptureDevice(int i) {
        pjsua2JNI.AccountVideoConfig_defaultCaptureDevice_set(this.swigCPtr, this, i);
    }

    public int getDefaultCaptureDevice() {
        return pjsua2JNI.AccountVideoConfig_defaultCaptureDevice_get(this.swigCPtr, this);
    }

    public void setDefaultRenderDevice(int i) {
        pjsua2JNI.AccountVideoConfig_defaultRenderDevice_set(this.swigCPtr, this, i);
    }

    public int getDefaultRenderDevice() {
        return pjsua2JNI.AccountVideoConfig_defaultRenderDevice_get(this.swigCPtr, this);
    }

    public void setRateControlMethod(int i) {
        pjsua2JNI.AccountVideoConfig_rateControlMethod_set(this.swigCPtr, this, i);
    }

    public int getRateControlMethod() {
        return pjsua2JNI.AccountVideoConfig_rateControlMethod_get(this.swigCPtr, this);
    }

    public void setRateControlBandwidth(long j) {
        pjsua2JNI.AccountVideoConfig_rateControlBandwidth_set(this.swigCPtr, this, j);
    }

    public long getRateControlBandwidth() {
        return pjsua2JNI.AccountVideoConfig_rateControlBandwidth_get(this.swigCPtr, this);
    }

    public void setStartKeyframeCount(long j) {
        pjsua2JNI.AccountVideoConfig_startKeyframeCount_set(this.swigCPtr, this, j);
    }

    public long getStartKeyframeCount() {
        return pjsua2JNI.AccountVideoConfig_startKeyframeCount_get(this.swigCPtr, this);
    }

    public void setStartKeyframeInterval(long j) {
        pjsua2JNI.AccountVideoConfig_startKeyframeInterval_set(this.swigCPtr, this, j);
    }

    public long getStartKeyframeInterval() {
        return pjsua2JNI.AccountVideoConfig_startKeyframeInterval_get(this.swigCPtr, this);
    }

    public AccountVideoConfig() {
        this(pjsua2JNI.new_AccountVideoConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountVideoConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountVideoConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

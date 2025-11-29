package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AccountCallConfig extends PersistentObject {
    private transient long swigCPtr;

    protected AccountCallConfig(long j, boolean z) {
        super(pjsua2JNI.AccountCallConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AccountCallConfig accountCallConfig) {
        if (accountCallConfig == null) {
            return 0L;
        }
        return accountCallConfig.swigCPtr;
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
                    pjsua2JNI.delete_AccountCallConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setHoldType(int i) {
        pjsua2JNI.AccountCallConfig_holdType_set(this.swigCPtr, this, i);
    }

    public int getHoldType() {
        return pjsua2JNI.AccountCallConfig_holdType_get(this.swigCPtr, this);
    }

    public void setPrackUse(int i) {
        pjsua2JNI.AccountCallConfig_prackUse_set(this.swigCPtr, this, i);
    }

    public int getPrackUse() {
        return pjsua2JNI.AccountCallConfig_prackUse_get(this.swigCPtr, this);
    }

    public void setTimerUse(int i) {
        pjsua2JNI.AccountCallConfig_timerUse_set(this.swigCPtr, this, i);
    }

    public int getTimerUse() {
        return pjsua2JNI.AccountCallConfig_timerUse_get(this.swigCPtr, this);
    }

    public void setTimerMinSESec(long j) {
        pjsua2JNI.AccountCallConfig_timerMinSESec_set(this.swigCPtr, this, j);
    }

    public long getTimerMinSESec() {
        return pjsua2JNI.AccountCallConfig_timerMinSESec_get(this.swigCPtr, this);
    }

    public void setTimerSessExpiresSec(long j) {
        pjsua2JNI.AccountCallConfig_timerSessExpiresSec_set(this.swigCPtr, this, j);
    }

    public long getTimerSessExpiresSec() {
        return pjsua2JNI.AccountCallConfig_timerSessExpiresSec_get(this.swigCPtr, this);
    }

    public AccountCallConfig() {
        this(pjsua2JNI.new_AccountCallConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountCallConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountCallConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AccountConfig extends PersistentObject {
    private transient long swigCPtr;

    protected AccountConfig(long j, boolean z) {
        super(pjsua2JNI.AccountConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AccountConfig accountConfig) {
        if (accountConfig == null) {
            return 0L;
        }
        return accountConfig.swigCPtr;
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
                    pjsua2JNI.delete_AccountConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setPriority(int i) {
        pjsua2JNI.AccountConfig_priority_set(this.swigCPtr, this, i);
    }

    public int getPriority() {
        return pjsua2JNI.AccountConfig_priority_get(this.swigCPtr, this);
    }

    public void setIdUri(String str) {
        pjsua2JNI.AccountConfig_idUri_set(this.swigCPtr, this, str);
    }

    public String getIdUri() {
        return pjsua2JNI.AccountConfig_idUri_get(this.swigCPtr, this);
    }

    public void setRegConfig(AccountRegConfig accountRegConfig) {
        pjsua2JNI.AccountConfig_regConfig_set(this.swigCPtr, this, AccountRegConfig.getCPtr(accountRegConfig), accountRegConfig);
    }

    public AccountRegConfig getRegConfig() {
        long jAccountConfig_regConfig_get = pjsua2JNI.AccountConfig_regConfig_get(this.swigCPtr, this);
        if (jAccountConfig_regConfig_get == 0) {
            return null;
        }
        return new AccountRegConfig(jAccountConfig_regConfig_get, false);
    }

    public void setSipConfig(AccountSipConfig accountSipConfig) {
        pjsua2JNI.AccountConfig_sipConfig_set(this.swigCPtr, this, AccountSipConfig.getCPtr(accountSipConfig), accountSipConfig);
    }

    public AccountSipConfig getSipConfig() {
        long jAccountConfig_sipConfig_get = pjsua2JNI.AccountConfig_sipConfig_get(this.swigCPtr, this);
        if (jAccountConfig_sipConfig_get == 0) {
            return null;
        }
        return new AccountSipConfig(jAccountConfig_sipConfig_get, false);
    }

    public void setCallConfig(AccountCallConfig accountCallConfig) {
        pjsua2JNI.AccountConfig_callConfig_set(this.swigCPtr, this, AccountCallConfig.getCPtr(accountCallConfig), accountCallConfig);
    }

    public AccountCallConfig getCallConfig() {
        long jAccountConfig_callConfig_get = pjsua2JNI.AccountConfig_callConfig_get(this.swigCPtr, this);
        if (jAccountConfig_callConfig_get == 0) {
            return null;
        }
        return new AccountCallConfig(jAccountConfig_callConfig_get, false);
    }

    public void setPresConfig(AccountPresConfig accountPresConfig) {
        pjsua2JNI.AccountConfig_presConfig_set(this.swigCPtr, this, AccountPresConfig.getCPtr(accountPresConfig), accountPresConfig);
    }

    public AccountPresConfig getPresConfig() {
        long jAccountConfig_presConfig_get = pjsua2JNI.AccountConfig_presConfig_get(this.swigCPtr, this);
        if (jAccountConfig_presConfig_get == 0) {
            return null;
        }
        return new AccountPresConfig(jAccountConfig_presConfig_get, false);
    }

    public void setMwiConfig(AccountMwiConfig accountMwiConfig) {
        pjsua2JNI.AccountConfig_mwiConfig_set(this.swigCPtr, this, AccountMwiConfig.getCPtr(accountMwiConfig), accountMwiConfig);
    }

    public AccountMwiConfig getMwiConfig() {
        long jAccountConfig_mwiConfig_get = pjsua2JNI.AccountConfig_mwiConfig_get(this.swigCPtr, this);
        if (jAccountConfig_mwiConfig_get == 0) {
            return null;
        }
        return new AccountMwiConfig(jAccountConfig_mwiConfig_get, false);
    }

    public void setNatConfig(AccountNatConfig accountNatConfig) {
        pjsua2JNI.AccountConfig_natConfig_set(this.swigCPtr, this, AccountNatConfig.getCPtr(accountNatConfig), accountNatConfig);
    }

    public AccountNatConfig getNatConfig() {
        long jAccountConfig_natConfig_get = pjsua2JNI.AccountConfig_natConfig_get(this.swigCPtr, this);
        if (jAccountConfig_natConfig_get == 0) {
            return null;
        }
        return new AccountNatConfig(jAccountConfig_natConfig_get, false);
    }

    public void setMediaConfig(AccountMediaConfig accountMediaConfig) {
        pjsua2JNI.AccountConfig_mediaConfig_set(this.swigCPtr, this, AccountMediaConfig.getCPtr(accountMediaConfig), accountMediaConfig);
    }

    public AccountMediaConfig getMediaConfig() {
        long jAccountConfig_mediaConfig_get = pjsua2JNI.AccountConfig_mediaConfig_get(this.swigCPtr, this);
        if (jAccountConfig_mediaConfig_get == 0) {
            return null;
        }
        return new AccountMediaConfig(jAccountConfig_mediaConfig_get, false);
    }

    public void setVideoConfig(AccountVideoConfig accountVideoConfig) {
        pjsua2JNI.AccountConfig_videoConfig_set(this.swigCPtr, this, AccountVideoConfig.getCPtr(accountVideoConfig), accountVideoConfig);
    }

    public AccountVideoConfig getVideoConfig() {
        long jAccountConfig_videoConfig_get = pjsua2JNI.AccountConfig_videoConfig_get(this.swigCPtr, this);
        if (jAccountConfig_videoConfig_get == 0) {
            return null;
        }
        return new AccountVideoConfig(jAccountConfig_videoConfig_get, false);
    }

    public void setIpChangeConfig(AccountIpChangeConfig accountIpChangeConfig) {
        pjsua2JNI.AccountConfig_ipChangeConfig_set(this.swigCPtr, this, AccountIpChangeConfig.getCPtr(accountIpChangeConfig), accountIpChangeConfig);
    }

    public AccountIpChangeConfig getIpChangeConfig() {
        long jAccountConfig_ipChangeConfig_get = pjsua2JNI.AccountConfig_ipChangeConfig_get(this.swigCPtr, this);
        if (jAccountConfig_ipChangeConfig_get == 0) {
            return null;
        }
        return new AccountIpChangeConfig(jAccountConfig_ipChangeConfig_get, false);
    }

    public AccountConfig() {
        this(pjsua2JNI.new_AccountConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

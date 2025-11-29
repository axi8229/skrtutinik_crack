package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AccountMwiConfig extends PersistentObject {
    private transient long swigCPtr;

    protected AccountMwiConfig(long j, boolean z) {
        super(pjsua2JNI.AccountMwiConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AccountMwiConfig accountMwiConfig) {
        if (accountMwiConfig == null) {
            return 0L;
        }
        return accountMwiConfig.swigCPtr;
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
                    pjsua2JNI.delete_AccountMwiConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setEnabled(boolean z) {
        pjsua2JNI.AccountMwiConfig_enabled_set(this.swigCPtr, this, z);
    }

    public boolean getEnabled() {
        return pjsua2JNI.AccountMwiConfig_enabled_get(this.swigCPtr, this);
    }

    public void setExpirationSec(long j) {
        pjsua2JNI.AccountMwiConfig_expirationSec_set(this.swigCPtr, this, j);
    }

    public long getExpirationSec() {
        return pjsua2JNI.AccountMwiConfig_expirationSec_get(this.swigCPtr, this);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountMwiConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountMwiConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    public AccountMwiConfig() {
        this(pjsua2JNI.new_AccountMwiConfig(), true);
    }
}

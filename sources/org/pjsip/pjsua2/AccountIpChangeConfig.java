package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AccountIpChangeConfig {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AccountIpChangeConfig(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AccountIpChangeConfig accountIpChangeConfig) {
        if (accountIpChangeConfig == null) {
            return 0L;
        }
        return accountIpChangeConfig.swigCPtr;
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
                    pjsua2JNI.delete_AccountIpChangeConfig(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setShutdownTp(boolean z) {
        pjsua2JNI.AccountIpChangeConfig_shutdownTp_set(this.swigCPtr, this, z);
    }

    public boolean getShutdownTp() {
        return pjsua2JNI.AccountIpChangeConfig_shutdownTp_get(this.swigCPtr, this);
    }

    public void setHangupCalls(boolean z) {
        pjsua2JNI.AccountIpChangeConfig_hangupCalls_set(this.swigCPtr, this, z);
    }

    public boolean getHangupCalls() {
        return pjsua2JNI.AccountIpChangeConfig_hangupCalls_get(this.swigCPtr, this);
    }

    public void setReinviteFlags(long j) {
        pjsua2JNI.AccountIpChangeConfig_reinviteFlags_set(this.swigCPtr, this, j);
    }

    public long getReinviteFlags() {
        return pjsua2JNI.AccountIpChangeConfig_reinviteFlags_get(this.swigCPtr, this);
    }

    public void setReinvUseUpdate(long j) {
        pjsua2JNI.AccountIpChangeConfig_reinvUseUpdate_set(this.swigCPtr, this, j);
    }

    public long getReinvUseUpdate() {
        return pjsua2JNI.AccountIpChangeConfig_reinvUseUpdate_get(this.swigCPtr, this);
    }

    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountIpChangeConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.AccountIpChangeConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    public AccountIpChangeConfig() {
        this(pjsua2JNI.new_AccountIpChangeConfig(), true);
    }
}

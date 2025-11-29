package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class AccountInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AccountInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AccountInfo accountInfo) {
        if (accountInfo == null) {
            return 0L;
        }
        return accountInfo.swigCPtr;
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
                    pjsua2JNI.delete_AccountInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setId(int i) {
        pjsua2JNI.AccountInfo_id_set(this.swigCPtr, this, i);
    }

    public int getId() {
        return pjsua2JNI.AccountInfo_id_get(this.swigCPtr, this);
    }

    public void setIsDefault(boolean z) {
        pjsua2JNI.AccountInfo_isDefault_set(this.swigCPtr, this, z);
    }

    public boolean getIsDefault() {
        return pjsua2JNI.AccountInfo_isDefault_get(this.swigCPtr, this);
    }

    public void setUri(String str) {
        pjsua2JNI.AccountInfo_uri_set(this.swigCPtr, this, str);
    }

    public String getUri() {
        return pjsua2JNI.AccountInfo_uri_get(this.swigCPtr, this);
    }

    public void setRegIsConfigured(boolean z) {
        pjsua2JNI.AccountInfo_regIsConfigured_set(this.swigCPtr, this, z);
    }

    public boolean getRegIsConfigured() {
        return pjsua2JNI.AccountInfo_regIsConfigured_get(this.swigCPtr, this);
    }

    public void setRegIsActive(boolean z) {
        pjsua2JNI.AccountInfo_regIsActive_set(this.swigCPtr, this, z);
    }

    public boolean getRegIsActive() {
        return pjsua2JNI.AccountInfo_regIsActive_get(this.swigCPtr, this);
    }

    public void setRegExpiresSec(long j) {
        pjsua2JNI.AccountInfo_regExpiresSec_set(this.swigCPtr, this, j);
    }

    public long getRegExpiresSec() {
        return pjsua2JNI.AccountInfo_regExpiresSec_get(this.swigCPtr, this);
    }

    public void setRegStatus(int i) {
        pjsua2JNI.AccountInfo_regStatus_set(this.swigCPtr, this, i);
    }

    public int getRegStatus() {
        return pjsua2JNI.AccountInfo_regStatus_get(this.swigCPtr, this);
    }

    public void setRegStatusText(String str) {
        pjsua2JNI.AccountInfo_regStatusText_set(this.swigCPtr, this, str);
    }

    public String getRegStatusText() {
        return pjsua2JNI.AccountInfo_regStatusText_get(this.swigCPtr, this);
    }

    public void setRegLastErr(int i) {
        pjsua2JNI.AccountInfo_regLastErr_set(this.swigCPtr, this, i);
    }

    public int getRegLastErr() {
        return pjsua2JNI.AccountInfo_regLastErr_get(this.swigCPtr, this);
    }

    public void setOnlineStatus(boolean z) {
        pjsua2JNI.AccountInfo_onlineStatus_set(this.swigCPtr, this, z);
    }

    public boolean getOnlineStatus() {
        return pjsua2JNI.AccountInfo_onlineStatus_get(this.swigCPtr, this);
    }

    public void setOnlineStatusText(String str) {
        pjsua2JNI.AccountInfo_onlineStatusText_set(this.swigCPtr, this, str);
    }

    public String getOnlineStatusText() {
        return pjsua2JNI.AccountInfo_onlineStatusText_get(this.swigCPtr, this);
    }

    public AccountInfo() {
        this(pjsua2JNI.new_AccountInfo(), true);
    }
}

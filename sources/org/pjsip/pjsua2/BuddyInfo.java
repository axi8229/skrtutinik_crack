package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class BuddyInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected BuddyInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BuddyInfo buddyInfo) {
        if (buddyInfo == null) {
            return 0L;
        }
        return buddyInfo.swigCPtr;
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
                    pjsua2JNI.delete_BuddyInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUri(String str) {
        pjsua2JNI.BuddyInfo_uri_set(this.swigCPtr, this, str);
    }

    public String getUri() {
        return pjsua2JNI.BuddyInfo_uri_get(this.swigCPtr, this);
    }

    public void setContact(String str) {
        pjsua2JNI.BuddyInfo_contact_set(this.swigCPtr, this, str);
    }

    public String getContact() {
        return pjsua2JNI.BuddyInfo_contact_get(this.swigCPtr, this);
    }

    public void setPresMonitorEnabled(boolean z) {
        pjsua2JNI.BuddyInfo_presMonitorEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getPresMonitorEnabled() {
        return pjsua2JNI.BuddyInfo_presMonitorEnabled_get(this.swigCPtr, this);
    }

    public void setSubState(int i) {
        pjsua2JNI.BuddyInfo_subState_set(this.swigCPtr, this, i);
    }

    public int getSubState() {
        return pjsua2JNI.BuddyInfo_subState_get(this.swigCPtr, this);
    }

    public void setSubStateName(String str) {
        pjsua2JNI.BuddyInfo_subStateName_set(this.swigCPtr, this, str);
    }

    public String getSubStateName() {
        return pjsua2JNI.BuddyInfo_subStateName_get(this.swigCPtr, this);
    }

    public void setSubTermCode(int i) {
        pjsua2JNI.BuddyInfo_subTermCode_set(this.swigCPtr, this, i);
    }

    public int getSubTermCode() {
        return pjsua2JNI.BuddyInfo_subTermCode_get(this.swigCPtr, this);
    }

    public void setSubTermReason(String str) {
        pjsua2JNI.BuddyInfo_subTermReason_set(this.swigCPtr, this, str);
    }

    public String getSubTermReason() {
        return pjsua2JNI.BuddyInfo_subTermReason_get(this.swigCPtr, this);
    }

    public void setPresStatus(PresenceStatus presenceStatus) {
        pjsua2JNI.BuddyInfo_presStatus_set(this.swigCPtr, this, PresenceStatus.getCPtr(presenceStatus), presenceStatus);
    }

    public PresenceStatus getPresStatus() {
        long jBuddyInfo_presStatus_get = pjsua2JNI.BuddyInfo_presStatus_get(this.swigCPtr, this);
        if (jBuddyInfo_presStatus_get == 0) {
            return null;
        }
        return new PresenceStatus(jBuddyInfo_presStatus_get, false);
    }

    public BuddyInfo() {
        this(pjsua2JNI.new_BuddyInfo(), true);
    }
}

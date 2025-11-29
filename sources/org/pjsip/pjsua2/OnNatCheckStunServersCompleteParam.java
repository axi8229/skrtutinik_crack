package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnNatCheckStunServersCompleteParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnNatCheckStunServersCompleteParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnNatCheckStunServersCompleteParam onNatCheckStunServersCompleteParam) {
        if (onNatCheckStunServersCompleteParam == null) {
            return 0L;
        }
        return onNatCheckStunServersCompleteParam.swigCPtr;
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
                    pjsua2JNI.delete_OnNatCheckStunServersCompleteParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUserData(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.OnNatCheckStunServersCompleteParam_userData_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUserData() {
        long jOnNatCheckStunServersCompleteParam_userData_get = pjsua2JNI.OnNatCheckStunServersCompleteParam_userData_get(this.swigCPtr, this);
        if (jOnNatCheckStunServersCompleteParam_userData_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOnNatCheckStunServersCompleteParam_userData_get, false);
    }

    public void setStatus(int i) {
        pjsua2JNI.OnNatCheckStunServersCompleteParam_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.OnNatCheckStunServersCompleteParam_status_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        pjsua2JNI.OnNatCheckStunServersCompleteParam_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.OnNatCheckStunServersCompleteParam_name_get(this.swigCPtr, this);
    }

    public void setAddr(String str) {
        pjsua2JNI.OnNatCheckStunServersCompleteParam_addr_set(this.swigCPtr, this, str);
    }

    public String getAddr() {
        return pjsua2JNI.OnNatCheckStunServersCompleteParam_addr_get(this.swigCPtr, this);
    }

    public OnNatCheckStunServersCompleteParam() {
        this(pjsua2JNI.new_OnNatCheckStunServersCompleteParam(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnIpChangeProgressParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnIpChangeProgressParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnIpChangeProgressParam onIpChangeProgressParam) {
        if (onIpChangeProgressParam == null) {
            return 0L;
        }
        return onIpChangeProgressParam.swigCPtr;
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
                    pjsua2JNI.delete_OnIpChangeProgressParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setOp(int i) {
        pjsua2JNI.OnIpChangeProgressParam_op_set(this.swigCPtr, this, i);
    }

    public int getOp() {
        return pjsua2JNI.OnIpChangeProgressParam_op_get(this.swigCPtr, this);
    }

    public void setStatus(int i) {
        pjsua2JNI.OnIpChangeProgressParam_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return pjsua2JNI.OnIpChangeProgressParam_status_get(this.swigCPtr, this);
    }

    public void setTransportId(int i) {
        pjsua2JNI.OnIpChangeProgressParam_transportId_set(this.swigCPtr, this, i);
    }

    public int getTransportId() {
        return pjsua2JNI.OnIpChangeProgressParam_transportId_get(this.swigCPtr, this);
    }

    public void setAccId(int i) {
        pjsua2JNI.OnIpChangeProgressParam_accId_set(this.swigCPtr, this, i);
    }

    public int getAccId() {
        return pjsua2JNI.OnIpChangeProgressParam_accId_get(this.swigCPtr, this);
    }

    public void setCallId(int i) {
        pjsua2JNI.OnIpChangeProgressParam_callId_set(this.swigCPtr, this, i);
    }

    public int getCallId() {
        return pjsua2JNI.OnIpChangeProgressParam_callId_get(this.swigCPtr, this);
    }

    public void setRegInfo(RegProgressParam regProgressParam) {
        pjsua2JNI.OnIpChangeProgressParam_regInfo_set(this.swigCPtr, this, RegProgressParam.getCPtr(regProgressParam), regProgressParam);
    }

    public RegProgressParam getRegInfo() {
        long jOnIpChangeProgressParam_regInfo_get = pjsua2JNI.OnIpChangeProgressParam_regInfo_get(this.swigCPtr, this);
        if (jOnIpChangeProgressParam_regInfo_get == 0) {
            return null;
        }
        return new RegProgressParam(jOnIpChangeProgressParam_regInfo_get, false);
    }

    public OnIpChangeProgressParam() {
        this(pjsua2JNI.new_OnIpChangeProgressParam(), true);
    }
}

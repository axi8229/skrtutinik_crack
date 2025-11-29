package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnMwiInfoParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnMwiInfoParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnMwiInfoParam onMwiInfoParam) {
        if (onMwiInfoParam == null) {
            return 0L;
        }
        return onMwiInfoParam.swigCPtr;
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
                    pjsua2JNI.delete_OnMwiInfoParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setState(int i) {
        pjsua2JNI.OnMwiInfoParam_state_set(this.swigCPtr, this, i);
    }

    public int getState() {
        return pjsua2JNI.OnMwiInfoParam_state_get(this.swigCPtr, this);
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnMwiInfoParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnMwiInfoParam_rdata_get = pjsua2JNI.OnMwiInfoParam_rdata_get(this.swigCPtr, this);
        if (jOnMwiInfoParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnMwiInfoParam_rdata_get, false);
    }

    public OnMwiInfoParam() {
        this(pjsua2JNI.new_OnMwiInfoParam(), true);
    }
}

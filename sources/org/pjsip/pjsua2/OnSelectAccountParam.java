package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnSelectAccountParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnSelectAccountParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnSelectAccountParam onSelectAccountParam) {
        if (onSelectAccountParam == null) {
            return 0L;
        }
        return onSelectAccountParam.swigCPtr;
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
                    pjsua2JNI.delete_OnSelectAccountParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRdata(SipRxData sipRxData) {
        pjsua2JNI.OnSelectAccountParam_rdata_set(this.swigCPtr, this, SipRxData.getCPtr(sipRxData), sipRxData);
    }

    public SipRxData getRdata() {
        long jOnSelectAccountParam_rdata_get = pjsua2JNI.OnSelectAccountParam_rdata_get(this.swigCPtr, this);
        if (jOnSelectAccountParam_rdata_get == 0) {
            return null;
        }
        return new SipRxData(jOnSelectAccountParam_rdata_get, false);
    }

    public void setAccountIndex(int i) {
        pjsua2JNI.OnSelectAccountParam_accountIndex_set(this.swigCPtr, this, i);
    }

    public int getAccountIndex() {
        return pjsua2JNI.OnSelectAccountParam_accountIndex_get(this.swigCPtr, this);
    }

    public OnSelectAccountParam() {
        this(pjsua2JNI.new_OnSelectAccountParam(), true);
    }
}

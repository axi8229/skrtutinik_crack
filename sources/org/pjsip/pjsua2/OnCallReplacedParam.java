package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallReplacedParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallReplacedParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallReplacedParam onCallReplacedParam) {
        if (onCallReplacedParam == null) {
            return 0L;
        }
        return onCallReplacedParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallReplacedParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setNewCallId(int i) {
        pjsua2JNI.OnCallReplacedParam_newCallId_set(this.swigCPtr, this, i);
    }

    public int getNewCallId() {
        return pjsua2JNI.OnCallReplacedParam_newCallId_get(this.swigCPtr, this);
    }

    public void setNewCall(Call call) {
        pjsua2JNI.OnCallReplacedParam_newCall_set(this.swigCPtr, this, Call.getCPtr(call), call);
    }

    public Call getNewCall() {
        long jOnCallReplacedParam_newCall_get = pjsua2JNI.OnCallReplacedParam_newCall_get(this.swigCPtr, this);
        if (jOnCallReplacedParam_newCall_get == 0) {
            return null;
        }
        return new Call(jOnCallReplacedParam_newCall_get, false);
    }

    public OnCallReplacedParam() {
        this(pjsua2JNI.new_OnCallReplacedParam(), true);
    }
}

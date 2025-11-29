package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class OnCallTransferRequestParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OnCallTransferRequestParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OnCallTransferRequestParam onCallTransferRequestParam) {
        if (onCallTransferRequestParam == null) {
            return 0L;
        }
        return onCallTransferRequestParam.swigCPtr;
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
                    pjsua2JNI.delete_OnCallTransferRequestParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDstUri(String str) {
        pjsua2JNI.OnCallTransferRequestParam_dstUri_set(this.swigCPtr, this, str);
    }

    public String getDstUri() {
        return pjsua2JNI.OnCallTransferRequestParam_dstUri_get(this.swigCPtr, this);
    }

    public void setStatusCode(int i) {
        pjsua2JNI.OnCallTransferRequestParam_statusCode_set(this.swigCPtr, this, i);
    }

    public int getStatusCode() {
        return pjsua2JNI.OnCallTransferRequestParam_statusCode_get(this.swigCPtr, this);
    }

    public void setOpt(CallSetting callSetting) {
        pjsua2JNI.OnCallTransferRequestParam_opt_set(this.swigCPtr, this, CallSetting.getCPtr(callSetting), callSetting);
    }

    public CallSetting getOpt() {
        long jOnCallTransferRequestParam_opt_get = pjsua2JNI.OnCallTransferRequestParam_opt_get(this.swigCPtr, this);
        if (jOnCallTransferRequestParam_opt_get == 0) {
            return null;
        }
        return new CallSetting(jOnCallTransferRequestParam_opt_get, false);
    }

    public void setNewCall(Call call) {
        pjsua2JNI.OnCallTransferRequestParam_newCall_set(this.swigCPtr, this, Call.getCPtr(call), call);
    }

    public Call getNewCall() {
        long jOnCallTransferRequestParam_newCall_get = pjsua2JNI.OnCallTransferRequestParam_newCall_get(this.swigCPtr, this);
        if (jOnCallTransferRequestParam_newCall_get == 0) {
            return null;
        }
        return new Call(jOnCallTransferRequestParam_newCall_get, false);
    }

    public OnCallTransferRequestParam() {
        this(pjsua2JNI.new_OnCallTransferRequestParam(), true);
    }
}

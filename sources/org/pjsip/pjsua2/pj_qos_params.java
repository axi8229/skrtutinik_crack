package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class pj_qos_params {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected pj_qos_params(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(pj_qos_params pj_qos_paramsVar) {
        if (pj_qos_paramsVar == null) {
            return 0L;
        }
        return pj_qos_paramsVar.swigCPtr;
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
                    pjsua2JNI.delete_pj_qos_params(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFlags(short s) {
        pjsua2JNI.pj_qos_params_flags_set(this.swigCPtr, this, s);
    }

    public short getFlags() {
        return pjsua2JNI.pj_qos_params_flags_get(this.swigCPtr, this);
    }

    public void setDscp_val(short s) {
        pjsua2JNI.pj_qos_params_dscp_val_set(this.swigCPtr, this, s);
    }

    public short getDscp_val() {
        return pjsua2JNI.pj_qos_params_dscp_val_get(this.swigCPtr, this);
    }

    public void setSo_prio(short s) {
        pjsua2JNI.pj_qos_params_so_prio_set(this.swigCPtr, this, s);
    }

    public short getSo_prio() {
        return pjsua2JNI.pj_qos_params_so_prio_get(this.swigCPtr, this);
    }

    public void setWmm_prio(int i) {
        pjsua2JNI.pj_qos_params_wmm_prio_set(this.swigCPtr, this, i);
    }

    public int getWmm_prio() {
        return pjsua2JNI.pj_qos_params_wmm_prio_get(this.swigCPtr, this);
    }

    public pj_qos_params() {
        this(pjsua2JNI.new_pj_qos_params(), true);
    }
}

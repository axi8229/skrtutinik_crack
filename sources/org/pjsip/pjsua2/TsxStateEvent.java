package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TsxStateEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TsxStateEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TsxStateEvent tsxStateEvent) {
        if (tsxStateEvent == null) {
            return 0L;
        }
        return tsxStateEvent.swigCPtr;
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
                    pjsua2JNI.delete_TsxStateEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSrc(TsxStateEventSrc tsxStateEventSrc) {
        pjsua2JNI.TsxStateEvent_src_set(this.swigCPtr, this, TsxStateEventSrc.getCPtr(tsxStateEventSrc), tsxStateEventSrc);
    }

    public TsxStateEventSrc getSrc() {
        long jTsxStateEvent_src_get = pjsua2JNI.TsxStateEvent_src_get(this.swigCPtr, this);
        if (jTsxStateEvent_src_get == 0) {
            return null;
        }
        return new TsxStateEventSrc(jTsxStateEvent_src_get, false);
    }

    public void setTsx(SipTransaction sipTransaction) {
        pjsua2JNI.TsxStateEvent_tsx_set(this.swigCPtr, this, SipTransaction.getCPtr(sipTransaction), sipTransaction);
    }

    public SipTransaction getTsx() {
        long jTsxStateEvent_tsx_get = pjsua2JNI.TsxStateEvent_tsx_get(this.swigCPtr, this);
        if (jTsxStateEvent_tsx_get == 0) {
            return null;
        }
        return new SipTransaction(jTsxStateEvent_tsx_get, false);
    }

    public void setPrevState(int i) {
        pjsua2JNI.TsxStateEvent_prevState_set(this.swigCPtr, this, i);
    }

    public int getPrevState() {
        return pjsua2JNI.TsxStateEvent_prevState_get(this.swigCPtr, this);
    }

    public void setType(int i) {
        pjsua2JNI.TsxStateEvent_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return pjsua2JNI.TsxStateEvent_type_get(this.swigCPtr, this);
    }

    public TsxStateEvent() {
        this(pjsua2JNI.new_TsxStateEvent(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class TimerEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TimerEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TimerEvent timerEvent) {
        if (timerEvent == null) {
            return 0L;
        }
        return timerEvent.swigCPtr;
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
                    pjsua2JNI.delete_TimerEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setEntry(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.TimerEvent_entry_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getEntry() {
        long jTimerEvent_entry_get = pjsua2JNI.TimerEvent_entry_get(this.swigCPtr, this);
        if (jTimerEvent_entry_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jTimerEvent_entry_get, false);
    }

    public TimerEvent() {
        this(pjsua2JNI.new_TimerEvent(), true);
    }
}

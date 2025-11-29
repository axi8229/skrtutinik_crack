package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class LogWriter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected LogWriter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(LogWriter logWriter) {
        if (logWriter == null) {
            return 0L;
        }
        return logWriter.swigCPtr;
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
                    pjsua2JNI.delete_LogWriter(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        pjsua2JNI.LogWriter_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        pjsua2JNI.LogWriter_change_ownership(this, this.swigCPtr, true);
    }

    public void write(LogEntry logEntry) {
        pjsua2JNI.LogWriter_write(this.swigCPtr, this, LogEntry.getCPtr(logEntry), logEntry);
    }

    public LogWriter() {
        this(pjsua2JNI.new_LogWriter(), true);
        pjsua2JNI.LogWriter_director_connect(this, this.swigCPtr, true, true);
    }
}

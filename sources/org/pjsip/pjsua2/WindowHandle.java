package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class WindowHandle {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected WindowHandle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(WindowHandle windowHandle) {
        if (windowHandle == null) {
            return 0L;
        }
        return windowHandle.swigCPtr;
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
                    pjsua2JNI.delete_WindowHandle(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setWindow(Object obj) {
        pjsua2JNI.WindowHandle_setWindow(this.swigCPtr, this, obj);
    }

    public WindowHandle() {
        this(pjsua2JNI.new_WindowHandle(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoWindowHandle {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VideoWindowHandle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoWindowHandle videoWindowHandle) {
        if (videoWindowHandle == null) {
            return 0L;
        }
        return videoWindowHandle.swigCPtr;
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
                    pjsua2JNI.delete_VideoWindowHandle(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setType(SWIGTYPE_p_pjmedia_vid_dev_hwnd_type sWIGTYPE_p_pjmedia_vid_dev_hwnd_type) {
        pjsua2JNI.VideoWindowHandle_type_set(this.swigCPtr, this, SWIGTYPE_p_pjmedia_vid_dev_hwnd_type.getCPtr(sWIGTYPE_p_pjmedia_vid_dev_hwnd_type));
    }

    public SWIGTYPE_p_pjmedia_vid_dev_hwnd_type getType() {
        return new SWIGTYPE_p_pjmedia_vid_dev_hwnd_type(pjsua2JNI.VideoWindowHandle_type_get(this.swigCPtr, this), true);
    }

    public void setHandle(WindowHandle windowHandle) {
        pjsua2JNI.VideoWindowHandle_handle_set(this.swigCPtr, this, WindowHandle.getCPtr(windowHandle), windowHandle);
    }

    public WindowHandle getHandle() {
        long jVideoWindowHandle_handle_get = pjsua2JNI.VideoWindowHandle_handle_get(this.swigCPtr, this);
        if (jVideoWindowHandle_handle_get == 0) {
            return null;
        }
        return new WindowHandle(jVideoWindowHandle_handle_get, false);
    }

    public VideoWindowHandle() {
        this(pjsua2JNI.new_VideoWindowHandle(), true);
    }
}

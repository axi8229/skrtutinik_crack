package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CallSetting {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallSetting(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallSetting callSetting) {
        if (callSetting == null) {
            return 0L;
        }
        return callSetting.swigCPtr;
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
                    pjsua2JNI.delete_CallSetting(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFlag(long j) {
        pjsua2JNI.CallSetting_flag_set(this.swigCPtr, this, j);
    }

    public long getFlag() {
        return pjsua2JNI.CallSetting_flag_get(this.swigCPtr, this);
    }

    public void setReqKeyframeMethod(long j) {
        pjsua2JNI.CallSetting_reqKeyframeMethod_set(this.swigCPtr, this, j);
    }

    public long getReqKeyframeMethod() {
        return pjsua2JNI.CallSetting_reqKeyframeMethod_get(this.swigCPtr, this);
    }

    public void setAudioCount(long j) {
        pjsua2JNI.CallSetting_audioCount_set(this.swigCPtr, this, j);
    }

    public long getAudioCount() {
        return pjsua2JNI.CallSetting_audioCount_get(this.swigCPtr, this);
    }

    public void setVideoCount(long j) {
        pjsua2JNI.CallSetting_videoCount_set(this.swigCPtr, this, j);
    }

    public long getVideoCount() {
        return pjsua2JNI.CallSetting_videoCount_get(this.swigCPtr, this);
    }

    public void setMediaDir(IntVector intVector) {
        pjsua2JNI.CallSetting_mediaDir_set(this.swigCPtr, this, IntVector.getCPtr(intVector), intVector);
    }

    public IntVector getMediaDir() {
        long jCallSetting_mediaDir_get = pjsua2JNI.CallSetting_mediaDir_get(this.swigCPtr, this);
        if (jCallSetting_mediaDir_get == 0) {
            return null;
        }
        return new IntVector(jCallSetting_mediaDir_get, false);
    }

    public CallSetting(boolean z) {
        this(pjsua2JNI.new_CallSetting__SWIG_0(z), true);
    }

    public CallSetting() {
        this(pjsua2JNI.new_CallSetting__SWIG_1(), true);
    }

    public boolean isEmpty() {
        return pjsua2JNI.CallSetting_isEmpty(this.swigCPtr, this);
    }
}

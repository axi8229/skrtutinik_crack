package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CodecInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecInfo codecInfo) {
        if (codecInfo == null) {
            return 0L;
        }
        return codecInfo.swigCPtr;
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
                    pjsua2JNI.delete_CodecInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setCodecId(String str) {
        pjsua2JNI.CodecInfo_codecId_set(this.swigCPtr, this, str);
    }

    public String getCodecId() {
        return pjsua2JNI.CodecInfo_codecId_get(this.swigCPtr, this);
    }

    public void setPriority(short s) {
        pjsua2JNI.CodecInfo_priority_set(this.swigCPtr, this, s);
    }

    public short getPriority() {
        return pjsua2JNI.CodecInfo_priority_get(this.swigCPtr, this);
    }

    public void setDesc(String str) {
        pjsua2JNI.CodecInfo_desc_set(this.swigCPtr, this, str);
    }

    public String getDesc() {
        return pjsua2JNI.CodecInfo_desc_get(this.swigCPtr, this);
    }

    public CodecInfo() {
        this(pjsua2JNI.new_CodecInfo(), true);
    }
}

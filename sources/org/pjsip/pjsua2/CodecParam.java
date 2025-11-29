package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CodecParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CodecParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CodecParam codecParam) {
        if (codecParam == null) {
            return 0L;
        }
        return codecParam.swigCPtr;
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
                    pjsua2JNI.delete_CodecParam(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setInfo(CodecParamInfo codecParamInfo) {
        pjsua2JNI.CodecParam_info_set(this.swigCPtr, this, CodecParamInfo.getCPtr(codecParamInfo), codecParamInfo);
    }

    public CodecParamInfo getInfo() {
        long jCodecParam_info_get = pjsua2JNI.CodecParam_info_get(this.swigCPtr, this);
        if (jCodecParam_info_get == 0) {
            return null;
        }
        return new CodecParamInfo(jCodecParam_info_get, false);
    }

    public void setSetting(CodecParamSetting codecParamSetting) {
        pjsua2JNI.CodecParam_setting_set(this.swigCPtr, this, CodecParamSetting.getCPtr(codecParamSetting), codecParamSetting);
    }

    public CodecParamSetting getSetting() {
        long jCodecParam_setting_get = pjsua2JNI.CodecParam_setting_get(this.swigCPtr, this);
        if (jCodecParam_setting_get == 0) {
            return null;
        }
        return new CodecParamSetting(jCodecParam_setting_get, false);
    }

    public CodecParam() {
        this(pjsua2JNI.new_CodecParam(), true);
    }
}

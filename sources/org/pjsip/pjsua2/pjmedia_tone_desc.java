package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class pjmedia_tone_desc {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected pjmedia_tone_desc(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(pjmedia_tone_desc pjmedia_tone_descVar) {
        if (pjmedia_tone_descVar == null) {
            return 0L;
        }
        return pjmedia_tone_descVar.swigCPtr;
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
                    pjsua2JNI.delete_pjmedia_tone_desc(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setFreq1(short s) {
        pjsua2JNI.pjmedia_tone_desc_freq1_set(this.swigCPtr, this, s);
    }

    public short getFreq1() {
        return pjsua2JNI.pjmedia_tone_desc_freq1_get(this.swigCPtr, this);
    }

    public void setFreq2(short s) {
        pjsua2JNI.pjmedia_tone_desc_freq2_set(this.swigCPtr, this, s);
    }

    public short getFreq2() {
        return pjsua2JNI.pjmedia_tone_desc_freq2_get(this.swigCPtr, this);
    }

    public void setOn_msec(short s) {
        pjsua2JNI.pjmedia_tone_desc_on_msec_set(this.swigCPtr, this, s);
    }

    public short getOn_msec() {
        return pjsua2JNI.pjmedia_tone_desc_on_msec_get(this.swigCPtr, this);
    }

    public void setOff_msec(short s) {
        pjsua2JNI.pjmedia_tone_desc_off_msec_set(this.swigCPtr, this, s);
    }

    public short getOff_msec() {
        return pjsua2JNI.pjmedia_tone_desc_off_msec_get(this.swigCPtr, this);
    }

    public void setVolume(short s) {
        pjsua2JNI.pjmedia_tone_desc_volume_set(this.swigCPtr, this, s);
    }

    public short getVolume() {
        return pjsua2JNI.pjmedia_tone_desc_volume_get(this.swigCPtr, this);
    }

    public void setFlags(short s) {
        pjsua2JNI.pjmedia_tone_desc_flags_set(this.swigCPtr, this, s);
    }

    public short getFlags() {
        return pjsua2JNI.pjmedia_tone_desc_flags_get(this.swigCPtr, this);
    }

    public pjmedia_tone_desc() {
        this(pjsua2JNI.new_pjmedia_tone_desc(), true);
    }
}

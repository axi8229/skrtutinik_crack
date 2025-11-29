package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class ToneDigitMapDigit {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ToneDigitMapDigit(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ToneDigitMapDigit toneDigitMapDigit) {
        if (toneDigitMapDigit == null) {
            return 0L;
        }
        return toneDigitMapDigit.swigCPtr;
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
                    pjsua2JNI.delete_ToneDigitMapDigit(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDigit(String str) {
        pjsua2JNI.ToneDigitMapDigit_digit_set(this.swigCPtr, this, str);
    }

    public String getDigit() {
        return pjsua2JNI.ToneDigitMapDigit_digit_get(this.swigCPtr, this);
    }

    public void setFreq1(int i) {
        pjsua2JNI.ToneDigitMapDigit_freq1_set(this.swigCPtr, this, i);
    }

    public int getFreq1() {
        return pjsua2JNI.ToneDigitMapDigit_freq1_get(this.swigCPtr, this);
    }

    public void setFreq2(int i) {
        pjsua2JNI.ToneDigitMapDigit_freq2_set(this.swigCPtr, this, i);
    }

    public int getFreq2() {
        return pjsua2JNI.ToneDigitMapDigit_freq2_get(this.swigCPtr, this);
    }

    public ToneDigitMapDigit() {
        this(pjsua2JNI.new_ToneDigitMapDigit(), true);
    }
}

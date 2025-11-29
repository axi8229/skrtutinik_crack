package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class ToneDigit extends pjmedia_tone_digit {
    private transient long swigCPtr;

    protected ToneDigit(long j, boolean z) {
        super(pjsua2JNI.ToneDigit_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ToneDigit toneDigit) {
        if (toneDigit == null) {
            return 0L;
        }
        return toneDigit.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.pjmedia_tone_digit
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.pjmedia_tone_digit
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_ToneDigit(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public ToneDigit() {
        this(pjsua2JNI.new_ToneDigit(), true);
    }
}

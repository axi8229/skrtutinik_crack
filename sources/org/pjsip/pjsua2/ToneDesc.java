package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class ToneDesc extends pjmedia_tone_desc {
    private transient long swigCPtr;

    protected ToneDesc(long j, boolean z) {
        super(pjsua2JNI.ToneDesc_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ToneDesc toneDesc) {
        if (toneDesc == null) {
            return 0L;
        }
        return toneDesc.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.pjmedia_tone_desc
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.pjmedia_tone_desc
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_ToneDesc(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public ToneDesc() {
        this(pjsua2JNI.new_ToneDesc(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class ConfPortInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ConfPortInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ConfPortInfo confPortInfo) {
        if (confPortInfo == null) {
            return 0L;
        }
        return confPortInfo.swigCPtr;
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
                    pjsua2JNI.delete_ConfPortInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setPortId(int i) {
        pjsua2JNI.ConfPortInfo_portId_set(this.swigCPtr, this, i);
    }

    public int getPortId() {
        return pjsua2JNI.ConfPortInfo_portId_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        pjsua2JNI.ConfPortInfo_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.ConfPortInfo_name_get(this.swigCPtr, this);
    }

    public void setFormat(MediaFormatAudio mediaFormatAudio) {
        pjsua2JNI.ConfPortInfo_format_set(this.swigCPtr, this, MediaFormatAudio.getCPtr(mediaFormatAudio), mediaFormatAudio);
    }

    public MediaFormatAudio getFormat() {
        long jConfPortInfo_format_get = pjsua2JNI.ConfPortInfo_format_get(this.swigCPtr, this);
        if (jConfPortInfo_format_get == 0) {
            return null;
        }
        return new MediaFormatAudio(jConfPortInfo_format_get, false);
    }

    public void setTxLevelAdj(float f) {
        pjsua2JNI.ConfPortInfo_txLevelAdj_set(this.swigCPtr, this, f);
    }

    public float getTxLevelAdj() {
        return pjsua2JNI.ConfPortInfo_txLevelAdj_get(this.swigCPtr, this);
    }

    public void setRxLevelAdj(float f) {
        pjsua2JNI.ConfPortInfo_rxLevelAdj_set(this.swigCPtr, this, f);
    }

    public float getRxLevelAdj() {
        return pjsua2JNI.ConfPortInfo_rxLevelAdj_get(this.swigCPtr, this);
    }

    public void setListeners(IntVector intVector) {
        pjsua2JNI.ConfPortInfo_listeners_set(this.swigCPtr, this, IntVector.getCPtr(intVector), intVector);
    }

    public IntVector getListeners() {
        long jConfPortInfo_listeners_get = pjsua2JNI.ConfPortInfo_listeners_get(this.swigCPtr, this);
        if (jConfPortInfo_listeners_get == 0) {
            return null;
        }
        return new IntVector(jConfPortInfo_listeners_get, false);
    }

    public ConfPortInfo() {
        this(pjsua2JNI.new_ConfPortInfo(), true);
    }
}

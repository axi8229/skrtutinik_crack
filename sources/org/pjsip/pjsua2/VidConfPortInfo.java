package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VidConfPortInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VidConfPortInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VidConfPortInfo vidConfPortInfo) {
        if (vidConfPortInfo == null) {
            return 0L;
        }
        return vidConfPortInfo.swigCPtr;
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
                    pjsua2JNI.delete_VidConfPortInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setPortId(int i) {
        pjsua2JNI.VidConfPortInfo_portId_set(this.swigCPtr, this, i);
    }

    public int getPortId() {
        return pjsua2JNI.VidConfPortInfo_portId_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        pjsua2JNI.VidConfPortInfo_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return pjsua2JNI.VidConfPortInfo_name_get(this.swigCPtr, this);
    }

    public void setFormat(MediaFormatVideo mediaFormatVideo) {
        pjsua2JNI.VidConfPortInfo_format_set(this.swigCPtr, this, MediaFormatVideo.getCPtr(mediaFormatVideo), mediaFormatVideo);
    }

    public MediaFormatVideo getFormat() {
        long jVidConfPortInfo_format_get = pjsua2JNI.VidConfPortInfo_format_get(this.swigCPtr, this);
        if (jVidConfPortInfo_format_get == 0) {
            return null;
        }
        return new MediaFormatVideo(jVidConfPortInfo_format_get, false);
    }

    public void setListeners(IntVector intVector) {
        pjsua2JNI.VidConfPortInfo_listeners_set(this.swigCPtr, this, IntVector.getCPtr(intVector), intVector);
    }

    public IntVector getListeners() {
        long jVidConfPortInfo_listeners_get = pjsua2JNI.VidConfPortInfo_listeners_get(this.swigCPtr, this);
        if (jVidConfPortInfo_listeners_get == 0) {
            return null;
        }
        return new IntVector(jVidConfPortInfo_listeners_get, false);
    }

    public void setTransmitters(IntVector intVector) {
        pjsua2JNI.VidConfPortInfo_transmitters_set(this.swigCPtr, this, IntVector.getCPtr(intVector), intVector);
    }

    public IntVector getTransmitters() {
        long jVidConfPortInfo_transmitters_get = pjsua2JNI.VidConfPortInfo_transmitters_get(this.swigCPtr, this);
        if (jVidConfPortInfo_transmitters_get == 0) {
            return null;
        }
        return new IntVector(jVidConfPortInfo_transmitters_get, false);
    }

    public VidConfPortInfo() {
        this(pjsua2JNI.new_VidConfPortInfo(), true);
    }
}

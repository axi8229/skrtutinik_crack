package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class VideoMedia extends Media {
    private transient long swigCPtr;

    protected VideoMedia(long j, boolean z) {
        super(pjsua2JNI.VideoMedia_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoMedia videoMedia) {
        if (videoMedia == null) {
            return 0L;
        }
        return videoMedia.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.Media
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.Media
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_VideoMedia(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public VidConfPortInfo getPortInfo() throws Exception {
        return new VidConfPortInfo(pjsua2JNI.VideoMedia_getPortInfo(this.swigCPtr, this), true);
    }

    public int getPortId() {
        return pjsua2JNI.VideoMedia_getPortId(this.swigCPtr, this);
    }

    public static VidConfPortInfo getPortInfoFromId(int i) throws Exception {
        return new VidConfPortInfo(pjsua2JNI.VideoMedia_getPortInfoFromId(i), true);
    }

    public void startTransmit(VideoMedia videoMedia, VideoMediaTransmitParam videoMediaTransmitParam) throws Exception {
        pjsua2JNI.VideoMedia_startTransmit(this.swigCPtr, this, getCPtr(videoMedia), videoMedia, VideoMediaTransmitParam.getCPtr(videoMediaTransmitParam), videoMediaTransmitParam);
    }

    public void stopTransmit(VideoMedia videoMedia) throws Exception {
        pjsua2JNI.VideoMedia_stopTransmit(this.swigCPtr, this, getCPtr(videoMedia), videoMedia);
    }

    public void update() throws Exception {
        pjsua2JNI.VideoMedia_update(this.swigCPtr, this);
    }

    public VideoMedia() {
        this(pjsua2JNI.new_VideoMedia(), true);
    }
}

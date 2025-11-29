package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class RtcpFbConfig extends PersistentObject {
    private transient long swigCPtr;

    protected RtcpFbConfig(long j, boolean z) {
        super(pjsua2JNI.RtcpFbConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(RtcpFbConfig rtcpFbConfig) {
        if (rtcpFbConfig == null) {
            return 0L;
        }
        return rtcpFbConfig.swigCPtr;
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    protected void finalize() {
        delete();
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_RtcpFbConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDontUseAvpf(boolean z) {
        pjsua2JNI.RtcpFbConfig_dontUseAvpf_set(this.swigCPtr, this, z);
    }

    public boolean getDontUseAvpf() {
        return pjsua2JNI.RtcpFbConfig_dontUseAvpf_get(this.swigCPtr, this);
    }

    public void setCaps(RtcpFbCapVector rtcpFbCapVector) {
        pjsua2JNI.RtcpFbConfig_caps_set(this.swigCPtr, this, RtcpFbCapVector.getCPtr(rtcpFbCapVector), rtcpFbCapVector);
    }

    public RtcpFbCapVector getCaps() {
        long jRtcpFbConfig_caps_get = pjsua2JNI.RtcpFbConfig_caps_get(this.swigCPtr, this);
        if (jRtcpFbConfig_caps_get == 0) {
            return null;
        }
        return new RtcpFbCapVector(jRtcpFbConfig_caps_get, false);
    }

    public RtcpFbConfig() {
        this(pjsua2JNI.new_RtcpFbConfig(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.RtcpFbConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.RtcpFbConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class EpConfig extends PersistentObject {
    private transient long swigCPtr;

    protected EpConfig(long j, boolean z) {
        super(pjsua2JNI.EpConfig_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(EpConfig epConfig) {
        if (epConfig == null) {
            return 0L;
        }
        return epConfig.swigCPtr;
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
                    pjsua2JNI.delete_EpConfig(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUaConfig(UaConfig uaConfig) {
        pjsua2JNI.EpConfig_uaConfig_set(this.swigCPtr, this, UaConfig.getCPtr(uaConfig), uaConfig);
    }

    public UaConfig getUaConfig() {
        long jEpConfig_uaConfig_get = pjsua2JNI.EpConfig_uaConfig_get(this.swigCPtr, this);
        if (jEpConfig_uaConfig_get == 0) {
            return null;
        }
        return new UaConfig(jEpConfig_uaConfig_get, false);
    }

    public void setLogConfig(LogConfig logConfig) {
        pjsua2JNI.EpConfig_logConfig_set(this.swigCPtr, this, LogConfig.getCPtr(logConfig), logConfig);
    }

    public LogConfig getLogConfig() {
        long jEpConfig_logConfig_get = pjsua2JNI.EpConfig_logConfig_get(this.swigCPtr, this);
        if (jEpConfig_logConfig_get == 0) {
            return null;
        }
        return new LogConfig(jEpConfig_logConfig_get, false);
    }

    public void setMedConfig(MediaConfig mediaConfig) {
        pjsua2JNI.EpConfig_medConfig_set(this.swigCPtr, this, MediaConfig.getCPtr(mediaConfig), mediaConfig);
    }

    public MediaConfig getMedConfig() {
        long jEpConfig_medConfig_get = pjsua2JNI.EpConfig_medConfig_get(this.swigCPtr, this);
        if (jEpConfig_medConfig_get == 0) {
            return null;
        }
        return new MediaConfig(jEpConfig_medConfig_get, false);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.EpConfig_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.EpConfig_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    public EpConfig() {
        this(pjsua2JNI.new_EpConfig(), true);
    }
}

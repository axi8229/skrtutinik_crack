package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class SrtpOpt extends PersistentObject {
    private transient long swigCPtr;

    protected SrtpOpt(long j, boolean z) {
        super(pjsua2JNI.SrtpOpt_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(SrtpOpt srtpOpt) {
        if (srtpOpt == null) {
            return 0L;
        }
        return srtpOpt.swigCPtr;
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
                    pjsua2JNI.delete_SrtpOpt(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setCryptos(SrtpCryptoVector srtpCryptoVector) {
        pjsua2JNI.SrtpOpt_cryptos_set(this.swigCPtr, this, SrtpCryptoVector.getCPtr(srtpCryptoVector), srtpCryptoVector);
    }

    public SrtpCryptoVector getCryptos() {
        long jSrtpOpt_cryptos_get = pjsua2JNI.SrtpOpt_cryptos_get(this.swigCPtr, this);
        if (jSrtpOpt_cryptos_get == 0) {
            return null;
        }
        return new SrtpCryptoVector(jSrtpOpt_cryptos_get, false);
    }

    public void setKeyings(IntVector intVector) {
        pjsua2JNI.SrtpOpt_keyings_set(this.swigCPtr, this, IntVector.getCPtr(intVector), intVector);
    }

    public IntVector getKeyings() {
        long jSrtpOpt_keyings_get = pjsua2JNI.SrtpOpt_keyings_get(this.swigCPtr, this);
        if (jSrtpOpt_keyings_get == 0) {
            return null;
        }
        return new IntVector(jSrtpOpt_keyings_get, false);
    }

    public SrtpOpt() {
        this(pjsua2JNI.new_SrtpOpt(), true);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.SrtpOpt_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    @Override // org.pjsip.pjsua2.PersistentObject
    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.SrtpOpt_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

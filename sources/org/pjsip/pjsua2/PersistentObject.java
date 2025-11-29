package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class PersistentObject {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected PersistentObject(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PersistentObject persistentObject) {
        if (persistentObject == null) {
            return 0L;
        }
        return persistentObject.swigCPtr;
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
                    pjsua2JNI.delete_PersistentObject(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void readObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.PersistentObject_readObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }

    public void writeObject(ContainerNode containerNode) throws Exception {
        pjsua2JNI.PersistentObject_writeObject(this.swigCPtr, this, ContainerNode.getCPtr(containerNode), containerNode);
    }
}

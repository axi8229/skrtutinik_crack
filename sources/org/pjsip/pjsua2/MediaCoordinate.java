package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class MediaCoordinate {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MediaCoordinate(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MediaCoordinate mediaCoordinate) {
        if (mediaCoordinate == null) {
            return 0L;
        }
        return mediaCoordinate.swigCPtr;
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
                    pjsua2JNI.delete_MediaCoordinate(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setX(int i) {
        pjsua2JNI.MediaCoordinate_x_set(this.swigCPtr, this, i);
    }

    public int getX() {
        return pjsua2JNI.MediaCoordinate_x_get(this.swigCPtr, this);
    }

    public void setY(int i) {
        pjsua2JNI.MediaCoordinate_y_set(this.swigCPtr, this, i);
    }

    public int getY() {
        return pjsua2JNI.MediaCoordinate_y_get(this.swigCPtr, this);
    }

    public MediaCoordinate() {
        this(pjsua2JNI.new_MediaCoordinate(), true);
    }
}

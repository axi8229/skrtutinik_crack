package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class UserEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected UserEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(UserEvent userEvent) {
        if (userEvent == null) {
            return 0L;
        }
        return userEvent.swigCPtr;
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
                    pjsua2JNI.delete_UserEvent(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUser1(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.UserEvent_user1_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUser1() {
        long jUserEvent_user1_get = pjsua2JNI.UserEvent_user1_get(this.swigCPtr, this);
        if (jUserEvent_user1_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jUserEvent_user1_get, false);
    }

    public void setUser2(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.UserEvent_user2_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUser2() {
        long jUserEvent_user2_get = pjsua2JNI.UserEvent_user2_get(this.swigCPtr, this);
        if (jUserEvent_user2_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jUserEvent_user2_get, false);
    }

    public void setUser3(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.UserEvent_user3_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUser3() {
        long jUserEvent_user3_get = pjsua2JNI.UserEvent_user3_get(this.swigCPtr, this);
        if (jUserEvent_user3_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jUserEvent_user3_get, false);
    }

    public void setUser4(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.UserEvent_user4_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUser4() {
        long jUserEvent_user4_get = pjsua2JNI.UserEvent_user4_get(this.swigCPtr, this);
        if (jUserEvent_user4_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jUserEvent_user4_get, false);
    }

    public UserEvent() {
        this(pjsua2JNI.new_UserEvent(), true);
    }
}

package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class FindBuddyMatch {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected FindBuddyMatch(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FindBuddyMatch findBuddyMatch) {
        if (findBuddyMatch == null) {
            return 0L;
        }
        return findBuddyMatch.swigCPtr;
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
                    pjsua2JNI.delete_FindBuddyMatch(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        pjsua2JNI.FindBuddyMatch_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        pjsua2JNI.FindBuddyMatch_change_ownership(this, this.swigCPtr, true);
    }

    public boolean match(String str, Buddy buddy) {
        return getClass() == FindBuddyMatch.class ? pjsua2JNI.FindBuddyMatch_match(this.swigCPtr, this, str, Buddy.getCPtr(buddy), buddy) : pjsua2JNI.FindBuddyMatch_matchSwigExplicitFindBuddyMatch(this.swigCPtr, this, str, Buddy.getCPtr(buddy), buddy);
    }

    public FindBuddyMatch() {
        this(pjsua2JNI.new_FindBuddyMatch(), true);
        pjsua2JNI.FindBuddyMatch_director_connect(this, this.swigCPtr, true, true);
    }
}

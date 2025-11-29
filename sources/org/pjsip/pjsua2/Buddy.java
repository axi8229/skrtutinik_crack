package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class Buddy {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected Buddy(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Buddy buddy) {
        if (buddy == null) {
            return 0L;
        }
        return buddy.swigCPtr;
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
                    pjsua2JNI.delete_Buddy(j);
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
        pjsua2JNI.Buddy_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        pjsua2JNI.Buddy_change_ownership(this, this.swigCPtr, true);
    }

    public Buddy() {
        this(pjsua2JNI.new_Buddy(), true);
        pjsua2JNI.Buddy_director_connect(this, this.swigCPtr, true, true);
    }

    public void create(Account account, BuddyConfig buddyConfig) throws Exception {
        pjsua2JNI.Buddy_create(this.swigCPtr, this, Account.getCPtr(account), account, BuddyConfig.getCPtr(buddyConfig), buddyConfig);
    }

    public boolean isValid() {
        return pjsua2JNI.Buddy_isValid(this.swigCPtr, this);
    }

    public int getId() {
        return pjsua2JNI.Buddy_getId(this.swigCPtr, this);
    }

    public BuddyInfo getInfo() throws Exception {
        return new BuddyInfo(pjsua2JNI.Buddy_getInfo(this.swigCPtr, this), true);
    }

    public void subscribePresence(boolean z) throws Exception {
        pjsua2JNI.Buddy_subscribePresence(this.swigCPtr, this, z);
    }

    public void updatePresence() throws Exception {
        pjsua2JNI.Buddy_updatePresence(this.swigCPtr, this);
    }

    public void sendInstantMessage(SendInstantMessageParam sendInstantMessageParam) throws Exception {
        pjsua2JNI.Buddy_sendInstantMessage(this.swigCPtr, this, SendInstantMessageParam.getCPtr(sendInstantMessageParam), sendInstantMessageParam);
    }

    public void sendTypingIndication(SendTypingIndicationParam sendTypingIndicationParam) throws Exception {
        pjsua2JNI.Buddy_sendTypingIndication(this.swigCPtr, this, SendTypingIndicationParam.getCPtr(sendTypingIndicationParam), sendTypingIndicationParam);
    }

    public void onBuddyState() {
        if (getClass() == Buddy.class) {
            pjsua2JNI.Buddy_onBuddyState(this.swigCPtr, this);
        } else {
            pjsua2JNI.Buddy_onBuddyStateSwigExplicitBuddy(this.swigCPtr, this);
        }
    }

    public void onBuddyEvSubState(OnBuddyEvSubStateParam onBuddyEvSubStateParam) {
        if (getClass() == Buddy.class) {
            pjsua2JNI.Buddy_onBuddyEvSubState(this.swigCPtr, this, OnBuddyEvSubStateParam.getCPtr(onBuddyEvSubStateParam), onBuddyEvSubStateParam);
        } else {
            pjsua2JNI.Buddy_onBuddyEvSubStateSwigExplicitBuddy(this.swigCPtr, this, OnBuddyEvSubStateParam.getCPtr(onBuddyEvSubStateParam), onBuddyEvSubStateParam);
        }
    }
}

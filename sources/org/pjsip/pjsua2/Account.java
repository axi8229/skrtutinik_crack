package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class Account {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected Account(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Account account) {
        if (account == null) {
            return 0L;
        }
        return account.swigCPtr;
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
                    pjsua2JNI.delete_Account(j);
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
        pjsua2JNI.Account_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        pjsua2JNI.Account_change_ownership(this, this.swigCPtr, true);
    }

    public Account() {
        this(pjsua2JNI.new_Account(), true);
        pjsua2JNI.Account_director_connect(this, this.swigCPtr, true, true);
    }

    public void create(AccountConfig accountConfig, boolean z) throws Exception {
        pjsua2JNI.Account_create__SWIG_0(this.swigCPtr, this, AccountConfig.getCPtr(accountConfig), accountConfig, z);
    }

    public void create(AccountConfig accountConfig) throws Exception {
        pjsua2JNI.Account_create__SWIG_1(this.swigCPtr, this, AccountConfig.getCPtr(accountConfig), accountConfig);
    }

    public void shutdown() {
        pjsua2JNI.Account_shutdown(this.swigCPtr, this);
    }

    public void modify(AccountConfig accountConfig) throws Exception {
        pjsua2JNI.Account_modify(this.swigCPtr, this, AccountConfig.getCPtr(accountConfig), accountConfig);
    }

    public boolean isValid() {
        return pjsua2JNI.Account_isValid(this.swigCPtr, this);
    }

    public void setDefault() throws Exception {
        pjsua2JNI.Account_setDefault(this.swigCPtr, this);
    }

    public boolean isDefault() {
        return pjsua2JNI.Account_isDefault(this.swigCPtr, this);
    }

    public int getId() {
        return pjsua2JNI.Account_getId(this.swigCPtr, this);
    }

    public static Account lookup(int i) {
        long jAccount_lookup = pjsua2JNI.Account_lookup(i);
        if (jAccount_lookup == 0) {
            return null;
        }
        return new Account(jAccount_lookup, false);
    }

    public AccountInfo getInfo() throws Exception {
        return new AccountInfo(pjsua2JNI.Account_getInfo(this.swigCPtr, this), true);
    }

    public void setRegistration(boolean z) throws Exception {
        pjsua2JNI.Account_setRegistration(this.swigCPtr, this, z);
    }

    public void setOnlineStatus(PresenceStatus presenceStatus) throws Exception {
        pjsua2JNI.Account_setOnlineStatus(this.swigCPtr, this, PresenceStatus.getCPtr(presenceStatus), presenceStatus);
    }

    public void setTransport(int i) throws Exception {
        pjsua2JNI.Account_setTransport(this.swigCPtr, this, i);
    }

    public void presNotify(PresNotifyParam presNotifyParam) throws Exception {
        pjsua2JNI.Account_presNotify(this.swigCPtr, this, PresNotifyParam.getCPtr(presNotifyParam), presNotifyParam);
    }

    public BuddyVector2 enumBuddies2() throws Exception {
        return new BuddyVector2(pjsua2JNI.Account_enumBuddies2(this.swigCPtr, this), true);
    }

    public Buddy findBuddy2(String str) throws Exception {
        return new Buddy(pjsua2JNI.Account_findBuddy2(this.swigCPtr, this, str), true);
    }

    public void onIncomingCall(OnIncomingCallParam onIncomingCallParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onIncomingCall(this.swigCPtr, this, OnIncomingCallParam.getCPtr(onIncomingCallParam), onIncomingCallParam);
        } else {
            pjsua2JNI.Account_onIncomingCallSwigExplicitAccount(this.swigCPtr, this, OnIncomingCallParam.getCPtr(onIncomingCallParam), onIncomingCallParam);
        }
    }

    public void onRegStarted(OnRegStartedParam onRegStartedParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onRegStarted(this.swigCPtr, this, OnRegStartedParam.getCPtr(onRegStartedParam), onRegStartedParam);
        } else {
            pjsua2JNI.Account_onRegStartedSwigExplicitAccount(this.swigCPtr, this, OnRegStartedParam.getCPtr(onRegStartedParam), onRegStartedParam);
        }
    }

    public void onRegState(OnRegStateParam onRegStateParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onRegState(this.swigCPtr, this, OnRegStateParam.getCPtr(onRegStateParam), onRegStateParam);
        } else {
            pjsua2JNI.Account_onRegStateSwigExplicitAccount(this.swigCPtr, this, OnRegStateParam.getCPtr(onRegStateParam), onRegStateParam);
        }
    }

    public void onIncomingSubscribe(OnIncomingSubscribeParam onIncomingSubscribeParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onIncomingSubscribe(this.swigCPtr, this, OnIncomingSubscribeParam.getCPtr(onIncomingSubscribeParam), onIncomingSubscribeParam);
        } else {
            pjsua2JNI.Account_onIncomingSubscribeSwigExplicitAccount(this.swigCPtr, this, OnIncomingSubscribeParam.getCPtr(onIncomingSubscribeParam), onIncomingSubscribeParam);
        }
    }

    public void onInstantMessage(OnInstantMessageParam onInstantMessageParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onInstantMessage(this.swigCPtr, this, OnInstantMessageParam.getCPtr(onInstantMessageParam), onInstantMessageParam);
        } else {
            pjsua2JNI.Account_onInstantMessageSwigExplicitAccount(this.swigCPtr, this, OnInstantMessageParam.getCPtr(onInstantMessageParam), onInstantMessageParam);
        }
    }

    public void onInstantMessageStatus(OnInstantMessageStatusParam onInstantMessageStatusParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onInstantMessageStatus(this.swigCPtr, this, OnInstantMessageStatusParam.getCPtr(onInstantMessageStatusParam), onInstantMessageStatusParam);
        } else {
            pjsua2JNI.Account_onInstantMessageStatusSwigExplicitAccount(this.swigCPtr, this, OnInstantMessageStatusParam.getCPtr(onInstantMessageStatusParam), onInstantMessageStatusParam);
        }
    }

    public void onTypingIndication(OnTypingIndicationParam onTypingIndicationParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onTypingIndication(this.swigCPtr, this, OnTypingIndicationParam.getCPtr(onTypingIndicationParam), onTypingIndicationParam);
        } else {
            pjsua2JNI.Account_onTypingIndicationSwigExplicitAccount(this.swigCPtr, this, OnTypingIndicationParam.getCPtr(onTypingIndicationParam), onTypingIndicationParam);
        }
    }

    public void onMwiInfo(OnMwiInfoParam onMwiInfoParam) {
        if (getClass() == Account.class) {
            pjsua2JNI.Account_onMwiInfo(this.swigCPtr, this, OnMwiInfoParam.getCPtr(onMwiInfoParam), onMwiInfoParam);
        } else {
            pjsua2JNI.Account_onMwiInfoSwigExplicitAccount(this.swigCPtr, this, OnMwiInfoParam.getCPtr(onMwiInfoParam), onMwiInfoParam);
        }
    }
}

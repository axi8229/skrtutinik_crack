package com.axmor.axvoip.mojo.pjm.facade;

import com.axmor.ash.toolset.data.result.error.AshError;

/* loaded from: classes.dex */
public interface PjmAccount {

    public interface AccountListener {
        void onCallCompleted(PjmCall pjmCall);

        void onIncomingCall(PjmCall pjmCall);
    }

    public enum AccountState {
        UNREGISTERED,
        TRANSITION,
        REGISTERED
    }

    public interface RegistrationListener {
        void onRegistrationFailed(AshError ashError);

        void onStateUpdated(AccountState accountState);
    }

    boolean isAlive();

    void register(PjmAccountRegConfig pjmAccountRegConfig);

    void shutdown();
}

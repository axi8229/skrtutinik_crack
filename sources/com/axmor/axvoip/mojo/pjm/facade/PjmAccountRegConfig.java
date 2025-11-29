package com.axmor.axvoip.mojo.pjm.facade;

import com.axmor.ash.toolset.data.result.error.AshError;
import com.axmor.axvoip.mojo.pjm.facade.PjmAccount;
import lombok.NonNull;
import org.pjsip.pjsua2.AccountConfig;

/* loaded from: classes.dex */
public final class PjmAccountRegConfig {

    @NonNull
    private final AccountConfig accountConfig;
    private final PjmAccount.AccountListener accountListener;
    private boolean deactivated = false;
    private final PjmAccount.RegistrationListener registrationListener;

    public PjmAccountRegConfig(@NonNull AccountConfig accountConfig, PjmAccount.RegistrationListener registrationListener, PjmAccount.AccountListener accountListener) {
        if (accountConfig == null) {
            throw new NullPointerException("accountConfig is marked non-null but is null");
        }
        this.accountConfig = accountConfig;
        this.registrationListener = registrationListener;
        this.accountListener = accountListener;
    }

    @NonNull
    public AccountConfig getAccountConfig() {
        return this.accountConfig;
    }

    public void onDeactivated() {
        this.deactivated = true;
    }

    public void onRegState(@NonNull PjmAccount.AccountState accountState) {
        if (accountState == null) {
            throw new NullPointerException("state is marked non-null but is null");
        }
        if (this.deactivated) {
            return;
        }
        this.registrationListener.onStateUpdated(accountState);
    }

    public void onRegFailed(@NonNull AshError ashError) {
        if (ashError == null) {
            throw new NullPointerException("error is marked non-null but is null");
        }
        if (this.deactivated) {
            return;
        }
        this.registrationListener.onRegistrationFailed(ashError);
    }

    public void onIncomingCall(@NonNull PjmCall pjmCall) {
        if (pjmCall == null) {
            throw new NullPointerException("call is marked non-null but is null");
        }
        if (this.deactivated) {
            return;
        }
        this.accountListener.onIncomingCall(pjmCall);
    }

    public void onCallCompleted(@NonNull PjmCall pjmCall) {
        if (pjmCall == null) {
            throw new NullPointerException("call is marked non-null but is null");
        }
        if (this.deactivated) {
            return;
        }
        this.accountListener.onCallCompleted(pjmCall);
    }

    public void delete() {
        this.accountConfig.delete();
    }
}

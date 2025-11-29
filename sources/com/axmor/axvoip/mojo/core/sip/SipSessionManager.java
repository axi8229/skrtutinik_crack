package com.axmor.axvoip.mojo.core.sip;

import android.util.Log;
import com.axmor.ash.toolset.data.result.AshResult;
import com.axmor.ash.toolset.data.result.AsyncResultListener;
import com.axmor.ash.toolset.data.result.error.AshError;
import com.axmor.ash.toolset.service.CompositeContext;
import com.axmor.ash.toolset.utils.AshAssert;
import com.axmor.ash.toolset.utils.Lambda$Code1;
import com.axmor.axvoip.mojo.core.sip.SipSession;
import com.axmor.axvoip.mojo.pjm.common.PjmEndpointConfig;
import com.axmor.axvoip.mojo.pjm.common.PjmErrors;
import com.axmor.axvoip.mojo.pjm.common.PjmStartupException;
import com.axmor.axvoip.mojo.pjm.endpoint.PjmAccessPoint;
import com.axmor.axvoip.mojo.pjm.facade.PjmAccount;
import com.axmor.axvoip.mojo.pjm.facade.PjmEndpoint;
import lombok.NonNull;
import org.greenrobot.eventbus.EventBus;
import org.pjsip.pjsua2.AccountConfig;

/* loaded from: classes.dex */
final class SipSessionManager implements SipSessionInternal {
    private static final String TAG = "SipSessionManager";

    @NonNull
    private final CompositeContext context;

    @NonNull
    private final Lambda$Code1<AshError> unexpectedShutdownHandler;
    private final Object $lock = new Object[0];
    private PjmEndpoint endpoint = null;
    private AccountInitializer accountInitializer = null;
    private AccountSessionManager accountSession = null;
    private SipSession.SipState state = SipSession.SipState.UNREGISTERED;
    private boolean destroyed = false;
    private final PjmAccount.RegistrationListener accountRegistrationListener = new PjmAccount.RegistrationListener() { // from class: com.axmor.axvoip.mojo.core.sip.SipSessionManager.2
        @Override // com.axmor.axvoip.mojo.pjm.facade.PjmAccount.RegistrationListener
        public void onStateUpdated(@NonNull PjmAccount.AccountState accountState) {
            if (accountState == null) {
                throw new NullPointerException("state is marked non-null but is null");
            }
            int i = AnonymousClass3.$SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmAccount$AccountState[accountState.ordinal()];
            if (i == 1) {
                SipSessionManager.this.clearState();
                Log.d(SipSessionManager.TAG, "onStateUpdated: UNREGISTERED");
            } else if (i == 2) {
                SipSessionManager.this.setState(SipSession.SipState.REGISTRATION_IN_PROGRESS);
                Log.d(SipSessionManager.TAG, "onStateUpdated: REGISTRATION_IN_PROGRESS");
            } else {
                if (i == 3) {
                    SipSessionManager.this.setState(SipSession.SipState.REGISTERED);
                    Log.d(SipSessionManager.TAG, "onStateUpdated: REGISTERED");
                    return;
                }
                throw new RuntimeException("Unknown account state.");
            }
        }

        @Override // com.axmor.axvoip.mojo.pjm.facade.PjmAccount.RegistrationListener
        public void onRegistrationFailed(@NonNull AshError ashError) {
            if (ashError == null) {
                throw new NullPointerException("error is marked non-null but is null");
            }
            SipSessionManager.this.setRegistrationError(ashError);
        }
    };

    public SipSessionManager(@NonNull CompositeContext compositeContext, @NonNull Lambda$Code1<AshError> lambda$Code1) {
        if (compositeContext == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (lambda$Code1 == null) {
            throw new NullPointerException("unexpectedShutdownHandler is marked non-null but is null");
        }
        this.context = compositeContext;
        this.unexpectedShutdownHandler = lambda$Code1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AccountInitializer {
        private boolean canceled = false;

        @NonNull
        private final AccountConfig config;

        public AccountInitializer(@NonNull AccountConfig accountConfig) {
            if (accountConfig == null) {
                throw new NullPointerException("config is marked non-null but is null");
            }
            this.config = accountConfig;
        }

        void onAccount(@NonNull PjmAccount pjmAccount) {
            if (pjmAccount == null) {
                throw new NullPointerException("account is marked non-null but is null");
            }
            if (this.canceled) {
                pjmAccount.shutdown();
            } else {
                AshAssert.aTrue(this == SipSessionManager.this.accountInitializer);
                SipSessionManager.this.onGotIdleAccount(pjmAccount, this.config);
            }
        }

        void cancel() {
            if (this.canceled) {
                return;
            }
            this.canceled = true;
            this.config.delete();
        }
    }

    @Override // com.axmor.axvoip.mojo.core.sip.SipSession
    public SipSession.SipState getState() {
        SipSession.SipState sipState;
        synchronized (this.$lock) {
            sipState = this.state;
        }
        return sipState;
    }

    @Override // com.axmor.axvoip.mojo.core.sip.SipSession
    public AccountSession getAccountSession() {
        AccountSessionManager accountSessionManager;
        synchronized (this.$lock) {
            accountSessionManager = this.accountSession;
        }
        return accountSessionManager;
    }

    @Override // com.axmor.axvoip.mojo.core.sip.SipSession
    public void activate(@NonNull PjmEndpointConfig pjmEndpointConfig, @NonNull AccountConfig accountConfig) {
        synchronized (this.$lock) {
            try {
                if (pjmEndpointConfig == null) {
                    throw new NullPointerException("endpointConfig is marked non-null but is null");
                }
                if (accountConfig == null) {
                    throw new NullPointerException("accountConfig is marked non-null but is null");
                }
                AshAssert.aFalse(this.destroyed);
                if (this.destroyed) {
                    pjmEndpointConfig.delete();
                    accountConfig.delete();
                    return;
                }
                AccountSessionManager accountSessionManager = this.accountSession;
                if (accountSessionManager != null) {
                    accountSessionManager.destroy();
                    this.accountSession = null;
                }
                AccountInitializer accountInitializer = this.accountInitializer;
                boolean z = accountInitializer != null;
                if (accountInitializer != null) {
                    accountInitializer.cancel();
                    this.accountInitializer = null;
                }
                setState(SipSession.SipState.REGISTRATION_IN_PROGRESS);
                if (this.endpoint == null) {
                    try {
                        this.endpoint = PjmAccessPoint.acquireEndpoint(pjmEndpointConfig, 3000L);
                    } catch (PjmStartupException e) {
                        this.unexpectedShutdownHandler.invoke(PjmErrors.Domains.ENDPOINT.error().debugDescription(e.toString()).build());
                        destroy();
                        return;
                    }
                }
                final AccountInitializer accountInitializer2 = new AccountInitializer(accountConfig);
                this.accountInitializer = accountInitializer2;
                if (z) {
                    return;
                }
                this.endpoint.makeIdleAccount(new AsyncResultListener() { // from class: com.axmor.axvoip.mojo.core.sip.SipSessionManager$$ExternalSyntheticLambda0
                    @Override // com.axmor.ash.toolset.data.result.AsyncResultListener
                    public final void onResult(AshResult ashResult) {
                        this.f$0.lambda$activate$0(accountInitializer2, ashResult);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$activate$0(AccountInitializer accountInitializer, AshResult ashResult) {
        if (!ashResult.isSuccess()) {
            accountInitializer.cancel();
            this.unexpectedShutdownHandler.invoke(ashResult.getError());
            destroy();
        } else {
            if (this.accountInitializer != accountInitializer) {
                accountInitializer.cancel();
            }
            AccountInitializer accountInitializer2 = this.accountInitializer;
            if (accountInitializer2 != null) {
                accountInitializer2.onAccount((PjmAccount) ashResult.getData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGotIdleAccount(PjmAccount pjmAccount, AccountConfig accountConfig) {
        synchronized (this.$lock) {
            try {
                AshAssert.aFalse(this.destroyed);
                if (this.destroyed) {
                    accountConfig.delete();
                    return;
                }
                AshAssert.aNonNull(this.endpoint);
                if (this.endpoint == null) {
                    return;
                }
                this.accountInitializer = null;
                AccountSessionManager accountSessionManager = new AccountSessionManager(this.context, pjmAccount);
                this.accountSession = accountSessionManager;
                accountSessionManager.register(accountConfig, this.accountRegistrationListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.core.sip.SipSessionInternal
    public void destroy() {
        synchronized (this.$lock) {
            try {
                if (this.destroyed) {
                    return;
                }
                deactivate();
                this.destroyed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void deactivate() {
        synchronized (this.$lock) {
            try {
                AshAssert.aFalse(this.destroyed);
                if (this.destroyed) {
                    return;
                }
                AccountInitializer accountInitializer = this.accountInitializer;
                if (accountInitializer != null) {
                    accountInitializer.cancel();
                    this.accountInitializer = null;
                }
                AccountSessionManager accountSessionManager = this.accountSession;
                if (accountSessionManager != null) {
                    accountSessionManager.destroy();
                    this.accountSession = null;
                }
                PjmEndpoint pjmEndpoint = this.endpoint;
                if (pjmEndpoint != null) {
                    pjmEndpoint.shutdown();
                    this.endpoint = null;
                }
                clearState();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(@NonNull SipSession.SipState sipState) {
        synchronized (this.$lock) {
            try {
                if (sipState == null) {
                    throw new NullPointerException("state is marked non-null but is null");
                }
                AshAssert.aFalse(SipSession.SipState.UNREGISTERED == sipState);
                this.state = sipState;
                clearError();
                this.context.eventBus().postSticky(new SipSession.SipStateUpdate(sipState));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        synchronized (this.$lock) {
            SipSession.SipState sipState = SipSession.SipState.UNREGISTERED;
            this.state = sipState;
            clearError();
            this.context.eventBus().removeStickyEvent(SipSession.SipStateUpdate.class);
            this.context.eventBus().post(new SipSession.SipStateUpdate(sipState));
        }
    }

    private void clearError() {
        synchronized (this.$lock) {
            this.context.eventBus().removeStickyEvent(SipSession.SipRegFailedEvent.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegistrationError(@NonNull AshError ashError) {
        synchronized (this.$lock) {
            try {
                if (ashError == null) {
                    throw new NullPointerException("error is marked non-null but is null");
                }
                clearState();
                final EventBus eventBus = this.context.eventBus();
                eventBus.postSticky(new SipSession.SipRegFailedEvent(ashError) { // from class: com.axmor.axvoip.mojo.core.sip.SipSessionManager.1
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: com.axmor.axvoip.mojo.core.sip.SipSessionManager$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmAccount$AccountState;

        static {
            int[] iArr = new int[PjmAccount.AccountState.values().length];
            $SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmAccount$AccountState = iArr;
            try {
                iArr[PjmAccount.AccountState.UNREGISTERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmAccount$AccountState[PjmAccount.AccountState.TRANSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmAccount$AccountState[PjmAccount.AccountState.REGISTERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}

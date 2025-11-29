package com.axmor.axvoip.mojo.pjm.endpoint;

import com.axmor.ash.toolset.data.result.error.AshError;
import com.axmor.ash.toolset.utils.AshAssert;
import com.axmor.ash.toolset.utils.Lambda$Code0;
import com.axmor.ash.toolset.utils.Lambda$Code1;
import com.axmor.ash.toolset.utils.Lambda$FactoryCode2;
import com.axmor.axvoip.mojo.pjm.common.PjmErrors;
import com.axmor.axvoip.mojo.pjm.common.PjmSipStatus;
import com.axmor.axvoip.mojo.pjm.endpoint.Bridge;
import com.axmor.axvoip.mojo.pjm.endpoint.CallBridge;
import com.axmor.axvoip.mojo.pjm.facade.PjmAccount;
import com.axmor.axvoip.mojo.pjm.facade.PjmAccountRegConfig;
import com.axmor.axvoip.mojo.pjm.facade.PjmCallType;
import lombok.NonNull;
import org.pjsip.pjsua2.OnIncomingCallParam;
import org.pjsip.pjsua2.OnRegStartedParam;
import org.pjsip.pjsua2.OnRegStateParam;

/* loaded from: classes.dex */
final class AccountBridge implements Bridge.Entity, PjmAccount {
    private final Bridge bridge;
    private final Object $lock = new Object[0];
    private PjmAccountRegConfig config = null;
    private PjmAccount.AccountState state = PjmAccount.AccountState.UNREGISTERED;
    private Account account = null;
    private int bridgedCallIdFactory = 0;

    public AccountBridge(@NonNull EndpointServices endpointServices, @NonNull Lambda$Code1<Bridge> lambda$Code1) {
        if (endpointServices == null) {
            throw new NullPointerException("endpointServices is marked non-null but is null");
        }
        if (lambda$Code1 == null) {
            throw new NullPointerException("deletedHandler is marked non-null but is null");
        }
        Bridge bridge = new Bridge(endpointServices, new Lambda$Code0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$$ExternalSyntheticLambda1
            @Override // com.axmor.ash.toolset.utils.Lambda$Code0
            public final void invoke() {
                this.f$0.doShutdown();
            }
        }, new Lambda$Code0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$$ExternalSyntheticLambda2
            @Override // com.axmor.ash.toolset.utils.Lambda$Code0
            public final void invoke() {
                this.f$0.doDelete();
            }
        }, lambda$Code1);
        this.bridge = bridge;
        bridge.enableLogging(AccountBridge.class.getSimpleName());
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmAccount
    public boolean isAlive() {
        boolean z;
        synchronized (this.$lock) {
            z = !this.bridge.isDestroyed();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateUpdated(PjmAccount.AccountState accountState) {
        synchronized (this.$lock) {
            try {
                this.state = accountState;
                PjmAccountRegConfig pjmAccountRegConfig = this.config;
                if (pjmAccountRegConfig != null) {
                    pjmAccountRegConfig.onRegState(accountState);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void setRegistrationFailed(AshError ashError) {
        synchronized (this.$lock) {
            try {
                this.state = PjmAccount.AccountState.UNREGISTERED;
                PjmAccountRegConfig pjmAccountRegConfig = this.config;
                if (pjmAccountRegConfig != null) {
                    pjmAccountRegConfig.onRegFailed(ashError);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmAccount
    public void register(@NonNull final PjmAccountRegConfig pjmAccountRegConfig) {
        synchronized (this.$lock) {
            try {
                if (pjmAccountRegConfig == null) {
                    throw new NullPointerException("config is marked non-null but is null");
                }
                AshAssert.aTrue(isAlive());
                AshAssert.aTrue(PjmAccount.AccountState.TRANSITION != this.state);
                if (isAlive()) {
                    this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$register$0(pjmAccountRegConfig);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doRegister, reason: merged with bridge method [inline-methods] */
    public void lambda$register$0(PjmAccountRegConfig pjmAccountRegConfig) {
        synchronized (this.$lock) {
            try {
                if (!isAlive()) {
                    pjmAccountRegConfig.delete();
                    return;
                }
                setStateUpdated(PjmAccount.AccountState.TRANSITION);
                PjmAccountRegConfig pjmAccountRegConfig2 = this.config;
                this.config = null;
                try {
                    try {
                        Account account = this.account;
                        if (account == null) {
                            Account account2 = new Account();
                            this.account = account2;
                            account2.create(pjmAccountRegConfig.getAccountConfig());
                        } else {
                            account.modify(pjmAccountRegConfig.getAccountConfig());
                        }
                        this.config = pjmAccountRegConfig;
                    } catch (Exception e) {
                        this.bridge.log("doRegister::failed", e);
                        pjmAccountRegConfig.delete();
                        setRegistrationFailed(PjmErrors.Domains.ACCOUNT.error().code(0L).debugDescription(e.toString()).build());
                        if (pjmAccountRegConfig2 != null) {
                        }
                    }
                    if (pjmAccountRegConfig2 != null) {
                        pjmAccountRegConfig2.delete();
                    }
                } catch (Throwable th) {
                    if (pjmAccountRegConfig2 != null) {
                        pjmAccountRegConfig2.delete();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmAccount
    public void shutdown() {
        synchronized (this.$lock) {
            try {
                PjmAccountRegConfig pjmAccountRegConfig = this.config;
                if (pjmAccountRegConfig != null) {
                    pjmAccountRegConfig.onDeactivated();
                }
                this.bridge.shutdown();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doShutdown() {
        synchronized (this.$lock) {
            try {
                Account account = this.account;
                if (account == null) {
                    this.bridge.shutdownCompleted();
                    return;
                }
                if (PjmAccount.AccountState.TRANSITION != this.state && !account.unregister()) {
                    this.bridge.shutdownCompleted();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDelete() {
        synchronized (this.$lock) {
            try {
                Account account = this.account;
                if (account != null) {
                    account.delete();
                    this.account = null;
                }
                PjmAccountRegConfig pjmAccountRegConfig = this.config;
                if (pjmAccountRegConfig != null) {
                    pjmAccountRegConfig.delete();
                    this.config = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRegState(Account.RegState regState) {
        Account account;
        synchronized (this.$lock) {
            try {
                this.bridge.log("handleRegState");
                if (!isAlive()) {
                    if (regState.isUnregistered() || (account = this.account) == null || !account.unregister()) {
                        this.bridge.shutdownCompleted();
                    }
                    return;
                }
                if (!regState.isSuccess()) {
                    setRegistrationFailed(regState.getError().build());
                } else {
                    setStateUpdated(regState.getRegState());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIncomingCall(@NonNull CallBridge callBridge) {
        synchronized (this.$lock) {
            try {
                if (callBridge == null) {
                    throw new NullPointerException("call is marked non-null but is null");
                }
                if (isAlive()) {
                    AshAssert.aNonNull(this.config);
                    PjmAccountRegConfig pjmAccountRegConfig = this.config;
                    if (pjmAccountRegConfig != null) {
                        pjmAccountRegConfig.onIncomingCall(callBridge);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallCompleted(@NonNull CallBridge callBridge) {
        synchronized (this.$lock) {
            try {
                if (callBridge == null) {
                    throw new NullPointerException("call is marked non-null but is null");
                }
                if (isAlive()) {
                    AshAssert.aNonNull(this.config);
                    PjmAccountRegConfig pjmAccountRegConfig = this.config;
                    if (pjmAccountRegConfig != null) {
                        pjmAccountRegConfig.onCallCompleted(callBridge);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class Account extends org.pjsip.pjsua2.Account {
        private Account() {
        }

        class RegState {
            private final int code;

            @NonNull
            private final String reason;
            private final boolean unregistered;

            public RegState(int i, boolean z, @NonNull String str) {
                if (str == null) {
                    throw new NullPointerException("reason is marked non-null but is null");
                }
                this.code = i;
                this.unregistered = z;
                this.reason = str;
            }

            public boolean isUnregistered() {
                return this.unregistered;
            }

            public boolean isSuccess() {
                return PjmSipStatus.isSuccess(this.code);
            }

            public PjmAccount.AccountState getRegState() {
                return this.unregistered ? PjmAccount.AccountState.UNREGISTERED : PjmAccount.AccountState.REGISTERED;
            }

            public AshError.Builder getError() {
                AshAssert.aFalse(isSuccess());
                return PjmErrors.Domains.ACCOUNT.error().code(this.code).debugDescription(this.reason);
            }
        }

        @Override // org.pjsip.pjsua2.Account
        public void onRegStarted(OnRegStartedParam onRegStartedParam) {
            AccountBridge.this.bridge.log("AccountImpl::onRegStarted");
            AccountBridge.this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$Account$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onRegStarted$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRegStarted$0() {
            AccountBridge.this.setStateUpdated(PjmAccount.AccountState.TRANSITION);
        }

        @Override // org.pjsip.pjsua2.Account
        public void onRegState(OnRegStateParam onRegStateParam) {
            AccountBridge.this.bridge.log("AccountImpl::onRegState");
            final RegState regState = new RegState(onRegStateParam.getCode(), PjmSipStatus.isUnregistered(onRegStateParam), onRegStateParam.getReason());
            AccountBridge.this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$Account$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onRegState$1(regState);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRegState$1(RegState regState) {
            AccountBridge.this.handleRegState(regState);
        }

        @Override // org.pjsip.pjsua2.Account
        public void onIncomingCall(final OnIncomingCallParam onIncomingCallParam) {
            AccountBridge.this.bridge.log("AccountImpl::onIncomingCall");
            final CallBridge callBridge = (CallBridge) AccountBridge.this.bridge.addChild(new Lambda$FactoryCode2() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$Account$$ExternalSyntheticLambda2
                @Override // com.axmor.ash.toolset.utils.Lambda$FactoryCode2
                public final Object produce(Object obj, Object obj2) {
                    return this.f$0.lambda$onIncomingCall$4(onIncomingCallParam, (EndpointServices) obj, (Lambda$Code1) obj2);
                }
            });
            if (callBridge == null) {
                AccountBridge.this.bridge.log("AccountImpl::onIncomingCall::account-destroyed");
            } else {
                AccountBridge.this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$Account$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onIncomingCall$5(callBridge);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onIncomingCall$2(CallBridge callBridge) {
            AccountBridge.this.handleCallCompleted(callBridge);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onIncomingCall$3(final CallBridge callBridge) {
            AccountBridge.this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$Account$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onIncomingCall$2(callBridge);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ CallBridge lambda$onIncomingCall$4(OnIncomingCallParam onIncomingCallParam, EndpointServices endpointServices, Lambda$Code1 lambda$Code1) {
            Lambda$Code1 lambda$Code12 = new Lambda$Code1() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.AccountBridge$Account$$ExternalSyntheticLambda0
                @Override // com.axmor.ash.toolset.utils.Lambda$Code1
                public final void invoke(Object obj) {
                    this.f$0.lambda$onIncomingCall$3((CallBridge) obj);
                }
            };
            AccountBridge accountBridge = AccountBridge.this;
            int i = accountBridge.bridgedCallIdFactory;
            accountBridge.bridgedCallIdFactory = i + 1;
            return new CallBridge(new CallBridge.Config(i, endpointServices, lambda$Code1, lambda$Code12, AccountBridge.this.account, PjmCallType.INCOMING, onIncomingCallParam.getCallId()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onIncomingCall$5(CallBridge callBridge) {
            AccountBridge.this.handleIncomingCall(callBridge);
        }

        public boolean unregister() {
            AccountBridge.this.bridge.log("AccountImpl::unregister");
            try {
                setRegistration(false);
                return true;
            } catch (Exception e) {
                AccountBridge.this.bridge.log("AccountImpl::unregister::failed", e);
                return false;
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.endpoint.Bridge.Entity
    public Bridge getBridge() {
        Bridge bridge;
        synchronized (this.$lock) {
            bridge = this.bridge;
        }
        return bridge;
    }
}

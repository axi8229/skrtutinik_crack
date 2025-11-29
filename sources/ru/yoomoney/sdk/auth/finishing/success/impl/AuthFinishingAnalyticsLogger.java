package ru.yoomoney.sdk.auth.finishing.success.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.LoginFail;
import ru.yoomoney.sdk.auth.analytics.LoginSuccess;
import ru.yoomoney.sdk.auth.analytics.MigrationSuccess;
import ru.yoomoney.sdk.auth.analytics.RegistrationSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsEsiaLoginSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsEsiaMigrationSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsEsiaRegistrationSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsSberIDLoginSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsSberIDMigrationSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsSberIDRegistrationSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsVKIDLoginSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsVKIDMigrationSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsVKIDRegistrationSuccess;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountSuccessResult;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0015\u001a\u00020\u0016*\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0017\u001a\u00020\u0016*\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0018\u001a\u00020\u0016*\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingAnalyticsLogger;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleProgressState", "", "action", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "invoke", "state", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", "onFailProcessEvent", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "onSuccessProcessEvent", "bindSocialAccountResult", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "sendBindSocialAccountEnrollmentEventIfNeeded", "sendBindSocialAccountLoginEventIfNeeded", "sendBindSocialAccountMigrationEventIfNeeded", "isEsiaBinded", "", "isSberIdBinded", "isVKIdBinded", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingAnalyticsLogger implements AuthFinishingSuccess.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.ENROLLMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.REGISTRATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProcessType.MIGRATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AuthFinishingAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleProgressState(AuthFinishingSuccess.Action action) {
        if (action instanceof AuthFinishingSuccess.Action.SuccessAccount) {
            AuthFinishingSuccess.Action.SuccessAccount successAccount = (AuthFinishingSuccess.Action.SuccessAccount) action;
            onSuccessProcessEvent(successAccount.getProcessType(), successAccount.getBindSocialAccountResult());
        } else if (action instanceof AuthFinishingSuccess.Action.FailAccount) {
            onFailProcessEvent(((AuthFinishingSuccess.Action.FailAccount) action).getProcessType());
        }
    }

    private final boolean isEsiaBinded(BindSocialAccountResult bindSocialAccountResult) {
        return (bindSocialAccountResult instanceof BindSocialAccountSuccessResult) && bindSocialAccountResult.getService() == OauthServiceProvider.ESIA;
    }

    private final boolean isSberIdBinded(BindSocialAccountResult bindSocialAccountResult) {
        return (bindSocialAccountResult instanceof BindSocialAccountSuccessResult) && bindSocialAccountResult.getService() == OauthServiceProvider.SBER;
    }

    private final boolean isVKIdBinded(BindSocialAccountResult bindSocialAccountResult) {
        return (bindSocialAccountResult instanceof BindSocialAccountSuccessResult) && bindSocialAccountResult.getService() == OauthServiceProvider.VK;
    }

    private final void onFailProcessEvent(ProcessType processType) {
        LoginFail loginFail = WhenMappings.$EnumSwitchMapping$0[processType.ordinal()] == 1 ? LoginFail.INSTANCE : null;
        if (loginFail != null) {
            this.analyticsLogger.onNewEvent(loginFail);
        }
    }

    private final void onSuccessProcessEvent(ProcessType processType, BindSocialAccountResult bindSocialAccountResult) {
        int i = WhenMappings.$EnumSwitchMapping$0[processType.ordinal()];
        if (i == 1) {
            this.analyticsLogger.onNewEvent(LoginSuccess.INSTANCE);
            sendBindSocialAccountLoginEventIfNeeded(bindSocialAccountResult);
        } else if (i == 2 || i == 3) {
            this.analyticsLogger.onNewEvent(RegistrationSuccess.INSTANCE);
            sendBindSocialAccountEnrollmentEventIfNeeded(bindSocialAccountResult);
        } else {
            if (i != 4) {
                return;
            }
            this.analyticsLogger.onNewEvent(MigrationSuccess.INSTANCE);
            sendBindSocialAccountMigrationEventIfNeeded(bindSocialAccountResult);
        }
    }

    private final void sendBindSocialAccountEnrollmentEventIfNeeded(BindSocialAccountResult bindSocialAccountResult) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        if (isSberIdBinded(bindSocialAccountResult)) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsSberIDRegistrationSuccess.INSTANCE;
        } else if (isVKIdBinded(bindSocialAccountResult)) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsVKIDRegistrationSuccess.INSTANCE;
        } else {
            if (!isEsiaBinded(bindSocialAccountResult)) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsEsiaRegistrationSuccess.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void sendBindSocialAccountLoginEventIfNeeded(BindSocialAccountResult bindSocialAccountResult) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        if (isSberIdBinded(bindSocialAccountResult)) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsSberIDLoginSuccess.INSTANCE;
        } else if (isVKIdBinded(bindSocialAccountResult)) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsVKIDLoginSuccess.INSTANCE;
        } else {
            if (!isEsiaBinded(bindSocialAccountResult)) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsEsiaLoginSuccess.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void sendBindSocialAccountMigrationEventIfNeeded(BindSocialAccountResult bindSocialAccountResult) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        if (isSberIdBinded(bindSocialAccountResult)) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsSberIDMigrationSuccess.INSTANCE;
        } else if (isVKIdBinded(bindSocialAccountResult)) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsVKIDMigrationSuccess.INSTANCE;
        } else {
            if (!isEsiaBinded(bindSocialAccountResult)) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsEsiaMigrationSuccess.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    @Override // ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess.AnalyticsLogger
    public void invoke(AuthFinishingSuccess.State state, AuthFinishingSuccess.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof AuthFinishingSuccess.State.Progress) {
            handleProgressState(action);
        }
    }
}

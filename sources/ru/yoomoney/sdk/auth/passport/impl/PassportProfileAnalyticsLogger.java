package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.ProfileChangeEmailSuccess;
import ru.yoomoney.sdk.auth.analytics.ProfileChangePhoneSuccess;
import ru.yoomoney.sdk.auth.analytics.ProfileSetEmailSuccess;
import ru.yoomoney.sdk.auth.analytics.ProfileViewPersonalData;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsEsiaAddFromProfileSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsEsiaDeleteFromProfileSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsSberIDAddFromProfileSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsSberIDDeleteFromProfileSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsVKIDAddFromProfileSuccess;
import ru.yoomoney.sdk.auth.analytics.SocialAccountsVKIDDeleteFromProfileSuccess;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.passport.PassportProfile;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/passport/impl/PassportProfileAnalyticsLogger;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;Lru/yoomoney/sdk/auth/ResultData;)V", "handleAccountSuccessActionWithInitState", "", "action", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountSuccess;", "handleBindSocialAccountSuccessActionWithBindingProcessState", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$BindSocialAccountSuccess;", "handleBindingProcessState", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "handleInitState", "handleLoadingState", "handleUnbindSocialAccountSuccessActionWithLoadingState", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$UnbindSocialAccountSuccess;", "invoke", "state", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfileAnalyticsLogger implements PassportProfile.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;
    private final ResultData resultData;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.CHANGE_PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OauthServiceProvider.values().length];
            try {
                iArr2[OauthServiceProvider.SBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[OauthServiceProvider.VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OauthServiceProvider.ESIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public PassportProfileAnalyticsLogger(AnalyticsLogger analyticsLogger, ResultData resultData) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        this.analyticsLogger = analyticsLogger;
        this.resultData = resultData;
    }

    private final void handleAccountSuccessActionWithInitState(PassportProfile.Action.AccountSuccess action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        ProcessType processType = action.getProcessType();
        int i = processType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[processType.ordinal()];
        if (i == 1) {
            this.analyticsLogger.onNewEvent(this.resultData.getUserHasEmail() ? ProfileChangeEmailSuccess.INSTANCE : ProfileSetEmailSuccess.INSTANCE);
            return;
        }
        if (i != 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = ProfileViewPersonalData.INSTANCE;
        } else {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = ProfileChangePhoneSuccess.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleBindSocialAccountSuccessActionWithBindingProcessState(PassportProfile.Action.BindSocialAccountSuccess action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$1[action.getBindedServiceProvider().ordinal()];
        if (i == 1) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsSberIDAddFromProfileSuccess.INSTANCE;
        } else if (i == 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsVKIDAddFromProfileSuccess.INSTANCE;
        } else {
            if (i != 3) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsEsiaAddFromProfileSuccess.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleBindingProcessState(PassportProfile.Action action) {
        if (action instanceof PassportProfile.Action.BindSocialAccountSuccess) {
            handleBindSocialAccountSuccessActionWithBindingProcessState((PassportProfile.Action.BindSocialAccountSuccess) action);
        }
    }

    private final void handleInitState(PassportProfile.Action action) {
        if (action instanceof PassportProfile.Action.AccountSuccess) {
            handleAccountSuccessActionWithInitState((PassportProfile.Action.AccountSuccess) action);
        }
    }

    private final void handleLoadingState(PassportProfile.Action action) {
        if (action instanceof PassportProfile.Action.UnbindSocialAccountSuccess) {
            handleUnbindSocialAccountSuccessActionWithLoadingState((PassportProfile.Action.UnbindSocialAccountSuccess) action);
        }
    }

    private final void handleUnbindSocialAccountSuccessActionWithLoadingState(PassportProfile.Action.UnbindSocialAccountSuccess action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$1[action.getUnbindedServiceProvider().ordinal()];
        if (i == 1) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsSberIDDeleteFromProfileSuccess.INSTANCE;
        } else if (i == 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsVKIDDeleteFromProfileSuccess.INSTANCE;
        } else {
            if (i != 3) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = SocialAccountsEsiaDeleteFromProfileSuccess.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    @Override // ru.yoomoney.sdk.auth.passport.PassportProfile.AnalyticsLogger
    public void invoke(PassportProfile.State state, PassportProfile.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof PassportProfile.State.Init) {
            handleInitState(action);
        } else if (state instanceof PassportProfile.State.Loading) {
            handleLoadingState(action);
        } else if (state instanceof PassportProfile.State.BindingProcess) {
            handleBindingProcessState(action);
        }
    }
}

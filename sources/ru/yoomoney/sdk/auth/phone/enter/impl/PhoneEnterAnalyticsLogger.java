package ru.yoomoney.sdk.auth.phone.enter.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.MigrationEnterPhone;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordEnterPhone;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordTapOnGetSms;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordTapOnLostAccessToPhone;
import ru.yoomoney.sdk.auth.analytics.RegistrationEnterPhone;
import ru.yoomoney.sdk.auth.analytics.RegistrationTapOnGetSms;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/impl/PhoneEnterAnalyticsLogger;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleCheckExpiration", "", "action", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CheckExpiration;", "handleContentState", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "handleLoadDataAction", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$LoadData;", "handleLoadingState", "handlePreLoadState", "handleTwoFaAction", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SendAnalyticsFromTwoFa;", "invoke", "state", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneEnterAnalyticsLogger implements PhoneEnter.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.ENROLLMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.REGISTRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.MIGRATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PhoneEnterAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleCheckExpiration(PhoneEnter.Action.CheckExpiration action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1 || i == 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationTapOnGetSms.INSTANCE;
        } else {
            if (i != 4) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordTapOnGetSms.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleContentState(PhoneEnter.Action action) {
        if (action instanceof PhoneEnter.Action.CheckExpiration) {
            handleCheckExpiration((PhoneEnter.Action.CheckExpiration) action);
        } else if (action instanceof PhoneEnter.Action.ClickToPhoneDisabled) {
            this.analyticsLogger.onNewEvent(RecoveryPasswordTapOnLostAccessToPhone.INSTANCE);
        }
    }

    private final void handleLoadDataAction(PhoneEnter.Action.LoadData action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1 || i == 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationEnterPhone.INSTANCE;
        } else if (i == 3) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = MigrationEnterPhone.INSTANCE;
        } else {
            if (i != 4) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordEnterPhone.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleLoadingState(PhoneEnter.Action action) {
        if (action instanceof PhoneEnter.Action.LoadData) {
            handleLoadDataAction((PhoneEnter.Action.LoadData) action);
        }
    }

    private final void handlePreLoadState(PhoneEnter.Action action) {
        if (action instanceof PhoneEnter.Action.LoadData) {
            handleLoadDataAction((PhoneEnter.Action.LoadData) action);
        }
    }

    private final void handleTwoFaAction(PhoneEnter.Action.SendAnalyticsFromTwoFa action) {
        if (WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()] == 2) {
            this.analyticsLogger.onNewEvent(action.getEvent());
        }
    }

    @Override // ru.yoomoney.sdk.auth.phone.enter.PhoneEnter.AnalyticsLogger
    public void invoke(PhoneEnter.State state, PhoneEnter.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof PhoneEnter.State.PreLoad) {
            handlePreLoadState(action);
        } else if (state instanceof PhoneEnter.State.Loading) {
            handleLoadingState(action);
        } else if (state instanceof PhoneEnter.State.Content) {
            handleContentState(action);
        }
        if (action instanceof PhoneEnter.Action.SendAnalyticsFromTwoFa) {
            handleTwoFaAction((PhoneEnter.Action.SendAnalyticsFromTwoFa) action);
        }
    }
}

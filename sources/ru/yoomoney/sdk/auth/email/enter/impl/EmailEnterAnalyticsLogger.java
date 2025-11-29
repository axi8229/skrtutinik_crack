package ru.yoomoney.sdk.auth.email.enter.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.MigrationEnterEmail;
import ru.yoomoney.sdk.auth.analytics.RegistrationConfirmEmail;
import ru.yoomoney.sdk.auth.analytics.RegistrationEnterEmail;
import ru.yoomoney.sdk.auth.analytics.RegistrationSuccessSentEmail;
import ru.yoomoney.sdk.auth.api.ProcessKt;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/impl/EmailEnterAnalyticsLogger;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleContentState", "", "action", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "handleSendAnalyticsForScreen", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendAnalyticsForScreen;", "handleSendEmailRegistrationSuccess", "handleSendEmailSuccess", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmailSuccess;", "handleTwoFaAction", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendAnalyticsFromTwoFa;", "invoke", "state", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailEnterAnalyticsLogger implements EmailEnter.AnalyticsLogger {
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EmailEnterAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleContentState(EmailEnter.Action action) {
        if (action instanceof EmailEnter.Action.SendAnalyticsForScreen) {
            handleSendAnalyticsForScreen((EmailEnter.Action.SendAnalyticsForScreen) action);
        }
    }

    private final void handleSendAnalyticsForScreen(EmailEnter.Action.SendAnalyticsForScreen action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1 || i == 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationEnterEmail.INSTANCE;
        } else {
            if (i != 3) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = MigrationEnterEmail.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleSendEmailRegistrationSuccess() {
        this.analyticsLogger.onNewEvent(RegistrationSuccessSentEmail.INSTANCE);
    }

    private final void handleSendEmailSuccess(EmailEnter.Action.SendEmailSuccess action) {
        if (WhenMappings.$EnumSwitchMapping$0[ProcessKt.toProcessType(action.getProcess()).ordinal()] == 1) {
            this.analyticsLogger.onNewEvent(RegistrationSuccessSentEmail.INSTANCE);
        }
    }

    private final void handleTwoFaAction(EmailEnter.Action.SendAnalyticsFromTwoFa action) {
        if (WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()] == 2) {
            this.analyticsLogger.onNewEvent(RegistrationConfirmEmail.INSTANCE);
        }
    }

    @Override // ru.yoomoney.sdk.auth.email.enter.EmailEnter.AnalyticsLogger
    public void invoke(EmailEnter.State state, EmailEnter.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof EmailEnter.State.Content) {
            handleContentState(action);
        }
        if (action instanceof EmailEnter.Action.SendAnalyticsFromTwoFa) {
            handleTwoFaAction((EmailEnter.Action.SendAnalyticsFromTwoFa) action);
        } else if (action instanceof EmailEnter.Action.SendEmailSuccess) {
            handleSendEmailSuccess((EmailEnter.Action.SendEmailSuccess) action);
        } else if (action instanceof EmailEnter.Action.SendEmailRegistrationSuccess) {
            handleSendEmailRegistrationSuccess();
        }
    }
}

package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.MigrationConfirmEmail;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordConfirmEmail;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordSuccessSentEmailCode;
import ru.yoomoney.sdk.auth.analytics.RegistrationConfirmEmail;
import ru.yoomoney.sdk.auth.analytics.RegistrationSuccessSentEmailCode;
import ru.yoomoney.sdk.auth.analytics.RegistrationTapOnAnotherEmail;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmEmail;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/impl/EmailConfirmAnalyticsLogger;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleConfirmEmailSuccess", "", "action", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$ConfirmEmailSuccess;", "handleInvalidState", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "handleProgressState", "handleSendAnalyticsForScreen", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$SendAnalyticsForScreen;", "invoke", "state", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailConfirmAnalyticsLogger implements EmailConfirm.AnalyticsLogger {
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

    public EmailConfirmAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleConfirmEmailSuccess(EmailConfirm.Action.ConfirmEmailSuccess action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        if ((action.getProcess() instanceof EnrollmentProcess) && !(action.getProcess() instanceof EnrollmentProcessConfirmEmail)) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationSuccessSentEmailCode.INSTANCE;
        } else {
            if (!(action.getProcess() instanceof PasswordRecoveryProcess) || (action.getProcess() instanceof PasswordRecoveryProcessConfirmEmail)) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordSuccessSentEmailCode.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleInvalidState(EmailConfirm.Action action) {
        if (action instanceof EmailConfirm.Action.SendAnalyticsForScreen) {
            handleSendAnalyticsForScreen((EmailConfirm.Action.SendAnalyticsForScreen) action);
        }
    }

    private final void handleProgressState(EmailConfirm.Action action) {
        if (action instanceof EmailConfirm.Action.ConfirmEmailSuccess) {
            handleConfirmEmailSuccess((EmailConfirm.Action.ConfirmEmailSuccess) action);
        }
    }

    private final void handleSendAnalyticsForScreen(EmailConfirm.Action.SendAnalyticsForScreen action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1 || i == 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationConfirmEmail.INSTANCE;
        } else if (i == 3) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = MigrationConfirmEmail.INSTANCE;
        } else {
            if (i != 4) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordConfirmEmail.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.AnalyticsLogger
    public void invoke(EmailConfirm.State state, EmailConfirm.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof EmailConfirm.State.Invalid) {
            handleInvalidState(action);
        } else if (state instanceof EmailConfirm.State.Progress) {
            handleProgressState(action);
        }
        if (action instanceof EmailConfirm.Action.ToEmailEntered) {
            this.analyticsLogger.onNewEvent(RegistrationTapOnAnotherEmail.INSTANCE);
        }
    }
}

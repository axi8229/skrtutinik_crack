package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.LoginEnterSmsCode;
import ru.yoomoney.sdk.auth.analytics.LoginSuccessSentSmsCode;
import ru.yoomoney.sdk.auth.analytics.MigrationEnterSmsCode;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordEnterSmsCode;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordSuccessSentSmsCode;
import ru.yoomoney.sdk.auth.analytics.RegistrationEnterSmsCode;
import ru.yoomoney.sdk.auth.analytics.RegistrationSuccessSentSmsCode;
import ru.yoomoney.sdk.auth.api.ProcessKt;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/impl/PhoneConfirmAnalyticsLogger;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleConfirmPhoneSuccess", "", "action", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$ConfirmPhoneSuccess;", "handleContentState", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "handleProgressState", "handleSendAnalyticsForScreen", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$SendAnalyticsForScreen;", "invoke", "state", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneConfirmAnalyticsLogger implements PhoneConfirm.AnalyticsLogger {
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
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PhoneConfirmAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleConfirmPhoneSuccess(PhoneConfirm.Action.ConfirmPhoneSuccess action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[ProcessKt.toProcessType(action.getProcess()).ordinal()];
        if (i == 1) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = LoginSuccessSentSmsCode.INSTANCE;
        } else if (i == 2 || i == 3) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationSuccessSentSmsCode.INSTANCE;
        } else {
            if (i != 5) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordSuccessSentSmsCode.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleContentState(PhoneConfirm.Action action) {
        if (action instanceof PhoneConfirm.Action.SendAnalyticsForScreen) {
            handleSendAnalyticsForScreen((PhoneConfirm.Action.SendAnalyticsForScreen) action);
        }
    }

    private final void handleProgressState(PhoneConfirm.Action action) {
        if (action instanceof PhoneConfirm.Action.ConfirmPhoneSuccess) {
            handleConfirmPhoneSuccess((PhoneConfirm.Action.ConfirmPhoneSuccess) action);
        }
    }

    private final void handleSendAnalyticsForScreen(PhoneConfirm.Action.SendAnalyticsForScreen action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = LoginEnterSmsCode.INSTANCE;
        } else if (i == 2 || i == 3) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationEnterSmsCode.INSTANCE;
        } else if (i == 4) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = MigrationEnterSmsCode.INSTANCE;
        } else {
            if (i != 5) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordEnterSmsCode.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.AnalyticsLogger
    public void invoke(PhoneConfirm.State state, PhoneConfirm.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof PhoneConfirm.State.Content) {
            handleContentState(action);
        } else if (state instanceof PhoneConfirm.State.Progress) {
            handleProgressState(action);
        }
    }
}

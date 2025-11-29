package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.MigrationEnterPassword;
import ru.yoomoney.sdk.auth.analytics.ProfileRecoveryPasswordSuccess;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordSuccessSetPassword;
import ru.yoomoney.sdk.auth.analytics.RegistrationEnterPassword;
import ru.yoomoney.sdk.auth.analytics.RegistrationEnterPasswordTapOnEye;
import ru.yoomoney.sdk.auth.analytics.RegistrationSuccessSetPassword;
import ru.yoomoney.sdk.auth.api.ProcessKt;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.router.auth.AuthRouterImpl;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002J \u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00122\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/impl/PasswordCreateAnalyticsLogger;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "routerType", "Lkotlin/reflect/KClass;", "Lru/yoomoney/sdk/auth/router/Router;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;Lkotlin/reflect/KClass;)V", "handleFillingPasswordState", "", "action", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "handleFillingPasswordStateDisplayPasswordAction", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$DisplayPassword;", "handleFillingPasswordStateSendAnalyticsForScreenAction", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SendAnalyticsForScreen;", "handleProgressState", "handleSetPasswordSuccess", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetPasswordSuccess;", "invoke", "state", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordCreateAnalyticsLogger implements PasswordCreate.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;
    private final KClass<? extends Router> routerType;

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

    public PasswordCreateAnalyticsLogger(AnalyticsLogger analyticsLogger, KClass<? extends Router> routerType) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        Intrinsics.checkNotNullParameter(routerType, "routerType");
        this.analyticsLogger = analyticsLogger;
        this.routerType = routerType;
    }

    private final void handleFillingPasswordState(PasswordCreate.Action action) {
        if (action instanceof PasswordCreate.Action.SendAnalyticsForScreen) {
            handleFillingPasswordStateSendAnalyticsForScreenAction((PasswordCreate.Action.SendAnalyticsForScreen) action);
        } else if (action instanceof PasswordCreate.Action.DisplayPassword) {
            handleFillingPasswordStateDisplayPasswordAction((PasswordCreate.Action.DisplayPassword) action);
        }
    }

    private final void handleFillingPasswordStateDisplayPasswordAction(PasswordCreate.Action.DisplayPassword action) {
        if (WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()] == 2) {
            this.analyticsLogger.onNewEvent(RegistrationEnterPasswordTapOnEye.INSTANCE);
        }
    }

    private final void handleFillingPasswordStateSendAnalyticsForScreenAction(PasswordCreate.Action.SendAnalyticsForScreen action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1 || i == 2) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationEnterPassword.INSTANCE;
        } else {
            if (i != 3) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = MigrationEnterPassword.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleProgressState(PasswordCreate.Action action, KClass<? extends Router> routerType) {
        if (action instanceof PasswordCreate.Action.SetPasswordSuccess) {
            handleSetPasswordSuccess((PasswordCreate.Action.SetPasswordSuccess) action, routerType);
        } else if (action instanceof PasswordCreate.Action.RegistrationSetPasswordSuccess) {
            this.analyticsLogger.onNewEvent(RegistrationSuccessSetPassword.INSTANCE);
        }
    }

    private final void handleSetPasswordSuccess(PasswordCreate.Action.SetPasswordSuccess action, KClass<? extends Router> routerType) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[ProcessKt.toProcessType(action.getProcess()).ordinal()];
        if (i == 1) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationSuccessSetPassword.INSTANCE;
        } else {
            if (i != 4) {
                return;
            }
            if (Intrinsics.areEqual(routerType, Reflection.getOrCreateKotlinClass(AuthRouterImpl.class))) {
                analyticsLogger = this.analyticsLogger;
                analyticsEvent = RecoveryPasswordSuccessSetPassword.INSTANCE;
            } else {
                analyticsLogger = this.analyticsLogger;
                analyticsEvent = ProfileRecoveryPasswordSuccess.INSTANCE;
            }
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    @Override // ru.yoomoney.sdk.auth.password.create.PasswordCreate.AnalyticsLogger
    public void invoke(PasswordCreate.State state, PasswordCreate.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof PasswordCreate.State.Content) {
            handleFillingPasswordState(action);
        } else if (state instanceof PasswordCreate.State.Progress) {
            handleProgressState(action, this.routerType);
        }
    }
}

package ru.yoomoney.sdk.auth.password.enter.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.LoginEnterPassword;
import ru.yoomoney.sdk.auth.analytics.LoginEnterPasswordSuccess;
import ru.yoomoney.sdk.auth.analytics.LoginTapOnLostPassword;
import ru.yoomoney.sdk.auth.api.ProcessKt;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/impl/PasswordEnterAnalyticsLogger;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleContentState", "", "action", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;", "handleProgressState", "invoke", "state", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordEnterAnalyticsLogger implements PasswordEnter.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;

    public PasswordEnterAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleContentState(PasswordEnter.Action action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        if ((action instanceof PasswordEnter.Action.SendAnalyticsForScreen) && ((PasswordEnter.Action.SendAnalyticsForScreen) action).getProcessType() == ProcessType.LOGIN) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = LoginEnterPassword.INSTANCE;
        } else {
            if (!(action instanceof PasswordEnter.Action.PasswordRecovery)) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = LoginTapOnLostPassword.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleProgressState(PasswordEnter.Action action) {
        if ((action instanceof PasswordEnter.Action.EnterPasswordSuccess) && ProcessKt.toProcessType(((PasswordEnter.Action.EnterPasswordSuccess) action).getProcess()) == ProcessType.LOGIN) {
            this.analyticsLogger.onNewEvent(LoginEnterPasswordSuccess.INSTANCE);
        }
    }

    @Override // ru.yoomoney.sdk.auth.password.enter.PasswordEnter.AnalyticsLogger
    public void invoke(PasswordEnter.State state, PasswordEnter.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof PasswordEnter.State.Content) {
            handleContentState(action);
        } else if (state instanceof PasswordEnter.State.Progress) {
            handleProgressState(action);
        }
    }
}

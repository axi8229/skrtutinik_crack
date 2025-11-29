package ru.yoomoney.sdk.auth.password.finish.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.ProfileChangePasswordSuccess;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinish;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/password/finish/impl/PasswordFinishAnalyticsLogger;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "invoke", "", "state", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State;", "action", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordFinishAnalyticsLogger implements PasswordFinish.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;

    public PasswordFinishAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    @Override // ru.yoomoney.sdk.auth.password.finish.PasswordFinish.AnalyticsLogger
    public void invoke(PasswordFinish.State state, PasswordFinish.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof PasswordFinish.Action.SendAnalyticsForScreen) || ((PasswordFinish.Action.SendAnalyticsForScreen) action).getProcessType() == ProcessType.PASSWORD_RECOVERY) {
            return;
        }
        this.analyticsLogger.onNewEvent(ProfileChangePasswordSuccess.INSTANCE);
    }
}

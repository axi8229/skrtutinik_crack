package ru.yoomoney.sdk.two_fa.phoneCall.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.two_fa.analytics.RegistrationEnterCallCode;
import ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall;

/* compiled from: PhoneCallAnalyticsLogger.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallAnalyticsLogger;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;)V", "handleInitState", "", "action", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;", "invoke", "state", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneCallAnalyticsLogger implements PhoneCall.AnalyticsLogger {
    public static final int $stable = 8;
    private final AnalyticsLogger analyticsLogger;

    public PhoneCallAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    @Override // ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall.AnalyticsLogger
    public void invoke(PhoneCall.State state, PhoneCall.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof PhoneCall.State.Init) {
            handleInitState(action);
        }
    }

    private final void handleInitState(PhoneCall.Action action) {
        if (action instanceof PhoneCall.Action.SendAnalyticsForScreen) {
            this.analyticsLogger.onNewEvent(RegistrationEnterCallCode.INSTANCE);
        }
    }
}

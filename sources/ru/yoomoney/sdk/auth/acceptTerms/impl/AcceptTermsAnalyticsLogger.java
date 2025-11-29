package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.RegistrationAcceptTerms;
import ru.yoomoney.sdk.auth.analytics.RegistrationAcceptTermsTapOnNext;
import ru.yoomoney.sdk.auth.api.ProcessType;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsAnalyticsLogger;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleContentState", "", "action", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;", "handleSendAnalyticsForScreen", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action$SendAnalyticsForScreen;", "invoke", "state", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptTermsAnalyticsLogger implements AcceptTerms.AnalyticsLogger {
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AcceptTermsAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleContentState(AcceptTerms.Action action) {
        if (action instanceof AcceptTerms.Action.SendAnalyticsForScreen) {
            handleSendAnalyticsForScreen((AcceptTerms.Action.SendAnalyticsForScreen) action);
        } else if (action instanceof AcceptTerms.Action.Accept) {
            this.analyticsLogger.onNewEvent(RegistrationAcceptTermsTapOnNext.INSTANCE);
        }
    }

    private final void handleSendAnalyticsForScreen(AcceptTerms.Action.SendAnalyticsForScreen action) {
        if (WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()] == 1) {
            this.analyticsLogger.onNewEvent(RegistrationAcceptTerms.INSTANCE);
        }
    }

    @Override // ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms.AnalyticsLogger
    public void invoke(AcceptTerms.State state, AcceptTerms.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof AcceptTerms.State.Content) {
            handleContentState(action);
        }
    }
}

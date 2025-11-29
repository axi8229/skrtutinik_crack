package ru.yoomoney.sdk.auth.yandexAcquire.webView.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.MigrationAcquireYandexAccountMigrated;
import ru.yoomoney.sdk.auth.analytics.MigrationAcquireYandexAccountNotRegistered;
import ru.yoomoney.sdk.auth.analytics.MigrationAcquireYandexRedirectInMigration;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessFailure;
import ru.yoomoney.sdk.auth.api.model.NotNeedMigration;
import ru.yoomoney.sdk.auth.api.model.NotRegistered;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebView;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/impl/YandexAcquireWebViewAnalyticsLogger;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "invoke", "", "state", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "action", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireWebViewAnalyticsLogger implements YandexAcquireWebView.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;

    public YandexAcquireWebViewAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    @Override // ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebView.AnalyticsLogger
    public void invoke(YandexAcquireWebView.State state, YandexAcquireWebView.Action action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if ((state instanceof YandexAcquireWebView.State.Loading) && (action instanceof YandexAcquireWebView.Action.AcquireSuccess)) {
            YandexAcquireWebView.Action.AcquireSuccess acquireSuccess = (YandexAcquireWebView.Action.AcquireSuccess) action;
            if (acquireSuccess.getProcess() instanceof MigrationProcessFailure) {
                ProcessError error = ((MigrationProcessFailure) acquireSuccess.getProcess()).getError();
                if (Intrinsics.areEqual(error, NotNeedMigration.INSTANCE)) {
                    analyticsLogger = this.analyticsLogger;
                    analyticsEvent = MigrationAcquireYandexAccountMigrated.INSTANCE;
                } else {
                    if (!Intrinsics.areEqual(error, NotRegistered.INSTANCE)) {
                        return;
                    }
                    analyticsLogger = this.analyticsLogger;
                    analyticsEvent = MigrationAcquireYandexAccountNotRegistered.INSTANCE;
                }
            } else {
                analyticsLogger = this.analyticsLogger;
                analyticsEvent = MigrationAcquireYandexRedirectInMigration.INSTANCE;
            }
            analyticsLogger.onNewEvent(analyticsEvent);
        }
    }
}

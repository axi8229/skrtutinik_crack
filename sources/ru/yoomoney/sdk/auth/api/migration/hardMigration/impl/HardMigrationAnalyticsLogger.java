package ru.yoomoney.sdk.auth.api.migration.hardMigration.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.MigrationWhyMigrateScreenAuthorization;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/impl/HardMigrationAnalyticsLogger;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "invoke", "", "state", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State;", "action", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HardMigrationAnalyticsLogger implements HardMigration.AnalyticsLogger {
    public HardMigrationAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        analyticsLogger.onNewEvent(MigrationWhyMigrateScreenAuthorization.INSTANCE);
    }

    @Override // ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration.AnalyticsLogger
    public void invoke(HardMigration.State state, HardMigration.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
    }
}

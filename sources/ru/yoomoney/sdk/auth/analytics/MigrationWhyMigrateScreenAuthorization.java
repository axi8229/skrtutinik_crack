package ru.yoomoney.sdk.auth.analytics;

import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/analytics/MigrationWhyMigrateScreenAuthorization;", "Lru/yoomoney/sdk/auth/analytics/AnalyticsEvent;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MigrationWhyMigrateScreenAuthorization extends AnalyticsEvent {
    public static final MigrationWhyMigrateScreenAuthorization INSTANCE = new MigrationWhyMigrateScreenAuthorization();

    private MigrationWhyMigrateScreenAuthorization() {
        super(AnalyticsEventKt.MIGRATION_WHY_MIGRATE_SCREEN_EVENT_NAME, MapsKt.mapOf(TuplesKt.to("referer", "authorization")), null);
    }
}

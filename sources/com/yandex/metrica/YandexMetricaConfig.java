package com.yandex.metrica;

import android.location.Location;
import com.yandex.metrica.impl.ob.A2;
import com.yandex.metrica.impl.ob.C1086m1;
import com.yandex.metrica.impl.ob.Hn;
import com.yandex.metrica.impl.ob.Kn;
import com.yandex.metrica.impl.ob.Ln;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class YandexMetricaConfig {
    public final String apiKey;
    public final Boolean appOpenTrackingEnabled;
    public final String appVersion;
    public final Boolean crashReporting;
    public final Map<String, String> errorEnvironment;
    public final Boolean firstActivationAsUpdate;
    public final Location location;
    public final Boolean locationTracking;
    public final Boolean logs;
    public final Integer maxReportsInDatabaseCount;
    public final Boolean nativeCrashReporting;
    public final PreloadInfo preloadInfo;
    public final Boolean revenueAutoTrackingEnabled;
    public final Integer sessionTimeout;
    public final Boolean sessionsAutoTrackingEnabled;
    public final Boolean statisticsSending;
    public final String userProfileID;

    public static class Builder {
        private static final Kn<String> r = new Hn(new Ln());
        private final String a;
        private String b;
        private Integer c;
        private Boolean d;
        private Boolean e;
        private Location f;
        private Boolean g;
        private Boolean h;
        private PreloadInfo i;
        private Boolean j;
        private Boolean k;
        private Integer l;
        private LinkedHashMap<String, String> m = new LinkedHashMap<>();
        private String n;
        private Boolean o;
        private Boolean p;
        private Boolean q;

        protected Builder(String str) {
            ((Hn) r).a(str);
            this.a = str;
        }

        public YandexMetricaConfig build() {
            return new YandexMetricaConfig(this);
        }

        public Builder handleFirstActivationAsUpdate(boolean z) {
            this.j = Boolean.valueOf(z);
            return this;
        }

        public Builder withAppOpenTrackingEnabled(boolean z) {
            this.q = Boolean.valueOf(z);
            return this;
        }

        public Builder withAppVersion(String str) {
            this.b = str;
            return this;
        }

        public Builder withCrashReporting(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }

        public Builder withErrorEnvironmentValue(String str, String str2) {
            this.m.put(str, str2);
            return this;
        }

        public Builder withLocation(Location location) {
            this.f = location;
            return this;
        }

        public Builder withLocationTracking(boolean z) {
            this.g = Boolean.valueOf(z);
            return this;
        }

        public Builder withLogs() {
            this.h = Boolean.TRUE;
            return this;
        }

        public Builder withMaxReportsInDatabaseCount(int i) {
            this.l = Integer.valueOf(i);
            return this;
        }

        public Builder withNativeCrashReporting(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        public Builder withPreloadInfo(PreloadInfo preloadInfo) {
            this.i = preloadInfo;
            return this;
        }

        public Builder withRevenueAutoTrackingEnabled(boolean z) {
            this.o = Boolean.valueOf(z);
            return this;
        }

        public Builder withSessionTimeout(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public Builder withSessionsAutoTrackingEnabled(boolean z) {
            this.p = Boolean.valueOf(z);
            return this;
        }

        public Builder withStatisticsSending(boolean z) {
            this.k = Boolean.valueOf(z);
            return this;
        }

        public Builder withUserProfileID(String str) {
            this.n = str;
            return this;
        }
    }

    protected YandexMetricaConfig(Builder builder) {
        this.apiKey = builder.a;
        this.appVersion = builder.b;
        this.sessionTimeout = builder.c;
        this.crashReporting = builder.d;
        this.nativeCrashReporting = builder.e;
        this.location = builder.f;
        this.locationTracking = builder.g;
        this.logs = builder.h;
        this.preloadInfo = builder.i;
        this.firstActivationAsUpdate = builder.j;
        this.statisticsSending = builder.k;
        this.maxReportsInDatabaseCount = builder.l;
        this.errorEnvironment = A2.e(builder.m);
        this.userProfileID = builder.n;
        this.revenueAutoTrackingEnabled = builder.o;
        this.sessionsAutoTrackingEnabled = builder.p;
        this.appOpenTrackingEnabled = builder.q;
    }

    public static Builder createBuilderFromConfig(YandexMetricaConfig yandexMetricaConfig) {
        Builder builderNewConfigBuilder = newConfigBuilder(yandexMetricaConfig.apiKey);
        if (A2.a((Object) yandexMetricaConfig.appVersion)) {
            builderNewConfigBuilder.withAppVersion(yandexMetricaConfig.appVersion);
        }
        if (A2.a(yandexMetricaConfig.sessionTimeout)) {
            builderNewConfigBuilder.withSessionTimeout(yandexMetricaConfig.sessionTimeout.intValue());
        }
        if (A2.a(yandexMetricaConfig.crashReporting)) {
            builderNewConfigBuilder.withCrashReporting(yandexMetricaConfig.crashReporting.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.nativeCrashReporting)) {
            builderNewConfigBuilder.withNativeCrashReporting(yandexMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.location)) {
            builderNewConfigBuilder.withLocation(yandexMetricaConfig.location);
        }
        if (A2.a(yandexMetricaConfig.locationTracking)) {
            builderNewConfigBuilder.withLocationTracking(yandexMetricaConfig.locationTracking.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.logs) && yandexMetricaConfig.logs.booleanValue()) {
            builderNewConfigBuilder.withLogs();
        }
        if (A2.a(yandexMetricaConfig.preloadInfo)) {
            builderNewConfigBuilder.withPreloadInfo(yandexMetricaConfig.preloadInfo);
        }
        if (A2.a(yandexMetricaConfig.firstActivationAsUpdate)) {
            builderNewConfigBuilder.handleFirstActivationAsUpdate(yandexMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.statisticsSending)) {
            builderNewConfigBuilder.withStatisticsSending(yandexMetricaConfig.statisticsSending.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.maxReportsInDatabaseCount)) {
            builderNewConfigBuilder.withMaxReportsInDatabaseCount(yandexMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        if (A2.a((Object) yandexMetricaConfig.errorEnvironment)) {
            for (Map.Entry<String, String> entry : yandexMetricaConfig.errorEnvironment.entrySet()) {
                builderNewConfigBuilder.withErrorEnvironmentValue(entry.getKey(), entry.getValue());
            }
        }
        if (A2.a((Object) yandexMetricaConfig.userProfileID)) {
            builderNewConfigBuilder.withUserProfileID(yandexMetricaConfig.userProfileID);
        }
        if (A2.a(yandexMetricaConfig.revenueAutoTrackingEnabled)) {
            builderNewConfigBuilder.withRevenueAutoTrackingEnabled(yandexMetricaConfig.revenueAutoTrackingEnabled.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.sessionsAutoTrackingEnabled)) {
            builderNewConfigBuilder.withSessionsAutoTrackingEnabled(yandexMetricaConfig.sessionsAutoTrackingEnabled.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.appOpenTrackingEnabled)) {
            builderNewConfigBuilder.withAppOpenTrackingEnabled(yandexMetricaConfig.appOpenTrackingEnabled.booleanValue());
        }
        return builderNewConfigBuilder;
    }

    public static YandexMetricaConfig fromJson(String str) {
        return new C1086m1().a(str);
    }

    public static Builder newConfigBuilder(String str) {
        return new Builder(str);
    }

    public String toJson() {
        return new C1086m1().a(this);
    }

    protected YandexMetricaConfig(YandexMetricaConfig yandexMetricaConfig) {
        this.apiKey = yandexMetricaConfig.apiKey;
        this.appVersion = yandexMetricaConfig.appVersion;
        this.sessionTimeout = yandexMetricaConfig.sessionTimeout;
        this.crashReporting = yandexMetricaConfig.crashReporting;
        this.nativeCrashReporting = yandexMetricaConfig.nativeCrashReporting;
        this.location = yandexMetricaConfig.location;
        this.locationTracking = yandexMetricaConfig.locationTracking;
        this.logs = yandexMetricaConfig.logs;
        this.preloadInfo = yandexMetricaConfig.preloadInfo;
        this.firstActivationAsUpdate = yandexMetricaConfig.firstActivationAsUpdate;
        this.statisticsSending = yandexMetricaConfig.statisticsSending;
        this.maxReportsInDatabaseCount = yandexMetricaConfig.maxReportsInDatabaseCount;
        this.errorEnvironment = yandexMetricaConfig.errorEnvironment;
        this.userProfileID = yandexMetricaConfig.userProfileID;
        this.revenueAutoTrackingEnabled = yandexMetricaConfig.revenueAutoTrackingEnabled;
        this.sessionsAutoTrackingEnabled = yandexMetricaConfig.sessionsAutoTrackingEnabled;
        this.appOpenTrackingEnabled = yandexMetricaConfig.appOpenTrackingEnabled;
    }
}

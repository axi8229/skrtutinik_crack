package com.yandex.metrica;

import com.yandex.metrica.impl.ob.A2;
import com.yandex.metrica.impl.ob.Hn;
import com.yandex.metrica.impl.ob.Kn;
import com.yandex.metrica.impl.ob.Ln;

/* loaded from: classes3.dex */
public class ReporterConfig {
    public final String apiKey;
    public final Boolean logs;
    public final Integer maxReportsInDatabaseCount;
    public final Integer sessionTimeout;
    public final Boolean statisticsSending;
    public final String userProfileID;

    public static class Builder {
        private static final Kn<String> g = new Hn(new Ln());
        private final String a;
        private Integer b;
        private Boolean c;
        private Boolean d;
        private Integer e;
        private String f;

        Builder(String str) {
            ((Hn) g).a(str);
            this.a = str;
        }

        public ReporterConfig build() {
            return new ReporterConfig(this);
        }

        public Builder withLogs() {
            this.c = Boolean.TRUE;
            return this;
        }

        public Builder withMaxReportsInDatabaseCount(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public Builder withSessionTimeout(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public Builder withStatisticsSending(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }

        public Builder withUserProfileID(String str) {
            this.f = str;
            return this;
        }
    }

    ReporterConfig(Builder builder) {
        this.apiKey = builder.a;
        this.sessionTimeout = builder.b;
        this.logs = builder.c;
        this.statisticsSending = builder.d;
        this.maxReportsInDatabaseCount = builder.e;
        this.userProfileID = builder.f;
    }

    public static Builder createBuilderFromConfig(ReporterConfig reporterConfig) {
        Builder builderNewConfigBuilder = newConfigBuilder(reporterConfig.apiKey);
        if (A2.a(reporterConfig.sessionTimeout)) {
            builderNewConfigBuilder.withSessionTimeout(reporterConfig.sessionTimeout.intValue());
        }
        if (A2.a(reporterConfig.logs) && reporterConfig.logs.booleanValue()) {
            builderNewConfigBuilder.withLogs();
        }
        if (A2.a(reporterConfig.statisticsSending)) {
            builderNewConfigBuilder.withStatisticsSending(reporterConfig.statisticsSending.booleanValue());
        }
        if (A2.a(reporterConfig.maxReportsInDatabaseCount)) {
            builderNewConfigBuilder.withMaxReportsInDatabaseCount(reporterConfig.maxReportsInDatabaseCount.intValue());
        }
        if (A2.a((Object) reporterConfig.userProfileID)) {
            builderNewConfigBuilder.withUserProfileID(reporterConfig.userProfileID);
        }
        return builderNewConfigBuilder;
    }

    public static Builder newConfigBuilder(String str) {
        return new Builder(str);
    }

    ReporterConfig(ReporterConfig reporterConfig) {
        this.apiKey = reporterConfig.apiKey;
        this.sessionTimeout = reporterConfig.sessionTimeout;
        this.logs = reporterConfig.logs;
        this.statisticsSending = reporterConfig.statisticsSending;
        this.maxReportsInDatabaseCount = reporterConfig.maxReportsInDatabaseCount;
        this.userProfileID = reporterConfig.userProfileID;
    }
}

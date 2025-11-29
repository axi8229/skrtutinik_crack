package com.yandex.metrica;

import android.location.Location;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.impl.ob.A2;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class i extends YandexMetricaConfig {
    public final String a;
    public final Map<String, String> b;
    public final String c;
    public final List<String> d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Map<String, String> h;
    public final Boolean i;
    public final Boolean j;
    public final Boolean k;

    public static final class b {
        private YandexMetricaConfig.Builder a;
        private String b;
        private List<String> c;
        private Integer d;
        private Map<String, String> e;
        public String f;
        private Integer g;
        private Integer h;
        private LinkedHashMap<String, String> i = new LinkedHashMap<>();
        private Boolean j;
        private Boolean k;
        private Boolean l;

        protected b(String str) {
            this.a = YandexMetricaConfig.newConfigBuilder(str);
        }

        static /* synthetic */ void c(b bVar) {
        }

        static /* synthetic */ c e(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ void f(b bVar) {
        }

        public b a(c cVar) {
            return this;
        }

        public b c(String str) {
            this.a.withUserProfileID(str);
            return this;
        }

        public b f(boolean z) {
            this.a.withNativeCrashReporting(z);
            return this;
        }

        public b a(String str) {
            this.a.withAppVersion(str);
            return this;
        }

        public b b(boolean z) {
            this.l = Boolean.valueOf(z);
            return this;
        }

        public b c(int i) {
            this.h = Integer.valueOf(i);
            return this;
        }

        public b d(boolean z) {
            this.a.withCrashReporting(z);
            return this;
        }

        public b e(int i) {
            this.a.withSessionTimeout(i);
            return this;
        }

        public b g(boolean z) {
            this.k = Boolean.valueOf(z);
            return this;
        }

        public b h(boolean z) {
            this.a.withRevenueAutoTrackingEnabled(z);
            return this;
        }

        public b i(boolean z) {
            this.a.withSessionsAutoTrackingEnabled(z);
            return this;
        }

        public b j(boolean z) {
            this.a.withStatisticsSending(z);
            return this;
        }

        public b a(Location location) {
            this.a.withLocation(location);
            return this;
        }

        public b b() {
            this.a.withLogs();
            return this;
        }

        public b c(boolean z) {
            this.a.withAppOpenTrackingEnabled(z);
            return this;
        }

        public b d(int i) {
            this.a.withMaxReportsInDatabaseCount(i);
            return this;
        }

        public b e(boolean z) {
            this.a.withLocationTracking(z);
            return this;
        }

        public b a(List<String> list) {
            this.c = list;
            return this;
        }

        public b b(String str, String str2) {
            this.a.withErrorEnvironmentValue(str, str2);
            return this;
        }

        public b a(int i) {
            if (i >= 0) {
                this.d = Integer.valueOf(i);
                return this;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid %1$s. %1$s should be positive.", "App Build Number"));
        }

        public b b(String str) {
            this.b = str;
            return this;
        }

        public b b(int i) {
            this.g = Integer.valueOf(i);
            return this;
        }

        public b a(Map<String, String> map, Boolean bool) {
            this.j = bool;
            this.e = map;
            return this;
        }

        public b a(PreloadInfo preloadInfo) {
            this.a.withPreloadInfo(preloadInfo);
            return this;
        }

        public b a(boolean z) {
            this.a.handleFirstActivationAsUpdate(z);
            return this;
        }

        public b a(String str, String str2) {
            this.i.put(str, str2);
            return this;
        }

        public i a() {
            return new i(this);
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public i(YandexMetricaConfig yandexMetricaConfig) {
        super(yandexMetricaConfig);
        this.a = null;
        this.b = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.c = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.d = null;
        this.k = null;
    }

    public static b a(YandexMetricaConfig yandexMetricaConfig) {
        b bVar = new b(yandexMetricaConfig.apiKey);
        if (A2.a((Object) yandexMetricaConfig.appVersion)) {
            bVar.a(yandexMetricaConfig.appVersion);
        }
        if (A2.a(yandexMetricaConfig.sessionTimeout)) {
            bVar.e(yandexMetricaConfig.sessionTimeout.intValue());
        }
        if (A2.a(yandexMetricaConfig.crashReporting)) {
            bVar.d(yandexMetricaConfig.crashReporting.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.nativeCrashReporting)) {
            bVar.f(yandexMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.location)) {
            bVar.a(yandexMetricaConfig.location);
        }
        if (A2.a(yandexMetricaConfig.locationTracking)) {
            bVar.e(yandexMetricaConfig.locationTracking.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.logs) && yandexMetricaConfig.logs.booleanValue()) {
            bVar.b();
        }
        if (A2.a(yandexMetricaConfig.preloadInfo)) {
            bVar.a(yandexMetricaConfig.preloadInfo);
        }
        if (A2.a(yandexMetricaConfig.firstActivationAsUpdate)) {
            bVar.a(yandexMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.statisticsSending)) {
            bVar.j(yandexMetricaConfig.statisticsSending.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.maxReportsInDatabaseCount)) {
            bVar.d(yandexMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        if (A2.a((Object) yandexMetricaConfig.errorEnvironment)) {
            for (Map.Entry<String, String> entry : yandexMetricaConfig.errorEnvironment.entrySet()) {
                bVar.b(entry.getKey(), entry.getValue());
            }
        }
        if (A2.a((Object) yandexMetricaConfig.userProfileID)) {
            bVar.c(yandexMetricaConfig.userProfileID);
        }
        if (A2.a(yandexMetricaConfig.revenueAutoTrackingEnabled)) {
            bVar.h(yandexMetricaConfig.revenueAutoTrackingEnabled.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.sessionsAutoTrackingEnabled)) {
            bVar.i(yandexMetricaConfig.sessionsAutoTrackingEnabled.booleanValue());
        }
        if (A2.a(yandexMetricaConfig.appOpenTrackingEnabled)) {
            bVar.c(yandexMetricaConfig.appOpenTrackingEnabled.booleanValue());
        }
        if (yandexMetricaConfig instanceof i) {
            i iVar = (i) yandexMetricaConfig;
            if (A2.a((Object) iVar.d)) {
                bVar.a(iVar.d);
            }
            if (A2.a((Object) null)) {
                bVar.a((c) null);
            }
            A2.a((Object) null);
        }
        return bVar;
    }

    private i(b bVar) {
        super(bVar.a);
        this.e = bVar.d;
        List list = bVar.c;
        this.d = list == null ? null : A2.c(list);
        this.a = bVar.b;
        Map map = bVar.e;
        this.b = map != null ? A2.e(map) : null;
        this.g = bVar.h;
        this.f = bVar.g;
        this.c = bVar.f;
        this.h = A2.e(bVar.i);
        this.i = bVar.j;
        this.j = bVar.k;
        b.c(bVar);
        this.k = bVar.l;
        b.e(bVar);
        b.f(bVar);
    }
}

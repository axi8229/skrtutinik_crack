package com.yandex.metrica;

import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.impl.ob.A2;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class e extends ReporterConfig {
    public final Integer a;
    public final Integer b;
    public final Map<String, String> c;

    public static class a {
        ReporterConfig.Builder a;
        Integer b;
        Integer c;
        LinkedHashMap<String, String> d = new LinkedHashMap<>();

        public a(String str) {
            this.a = ReporterConfig.newConfigBuilder(str);
        }

        public a a(int i) {
            this.a.withMaxReportsInDatabaseCount(i);
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    e(a aVar) {
        super(aVar.a);
        this.b = aVar.b;
        this.a = aVar.c;
        LinkedHashMap<String, String> linkedHashMap = aVar.d;
        this.c = linkedHashMap == null ? null : A2.e(linkedHashMap);
    }

    public static e a(ReporterConfig reporterConfig) {
        return reporterConfig instanceof e ? (e) reporterConfig : new e(reporterConfig);
    }

    public static a a(e eVar) {
        a aVar = new a(eVar.apiKey);
        if (A2.a(eVar.sessionTimeout)) {
            aVar.a.withSessionTimeout(eVar.sessionTimeout.intValue());
        }
        if (A2.a(eVar.logs) && eVar.logs.booleanValue()) {
            aVar.a.withLogs();
        }
        if (A2.a(eVar.statisticsSending)) {
            aVar.a.withStatisticsSending(eVar.statisticsSending.booleanValue());
        }
        if (A2.a(eVar.maxReportsInDatabaseCount)) {
            aVar.a.withMaxReportsInDatabaseCount(eVar.maxReportsInDatabaseCount.intValue());
        }
        if (A2.a(eVar.a)) {
            Integer num = eVar.a;
            num.intValue();
            aVar.c = num;
        }
        if (A2.a(eVar.b)) {
            Integer num2 = eVar.b;
            num2.intValue();
            aVar.b = num2;
        }
        if (A2.a((Object) eVar.c)) {
            for (Map.Entry<String, String> entry : eVar.c.entrySet()) {
                aVar.d.put(entry.getKey(), entry.getValue());
            }
        }
        if (A2.a((Object) eVar.userProfileID)) {
            aVar.a.withUserProfileID(eVar.userProfileID);
        }
        return aVar;
    }

    private e(ReporterConfig reporterConfig) {
        super(reporterConfig);
        if (reporterConfig instanceof e) {
            e eVar = (e) reporterConfig;
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            return;
        }
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public static a a(String str) {
        return new a(str);
    }
}

package com.yandex.metrica.impl.ob;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.ob.C1199qf;
import com.yandex.metrica.impl.ob.E;
import com.yandex.metrica.impl.ob.X7;
import java.util.List;
import java.util.Locale;

/* renamed from: com.yandex.metrica.impl.ob.j8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1018j8 {
    public static final int a = YandexMetrica.getLibraryApiLevel();
    private static final N7 b;
    private static final P7 c;
    private static final M7 d;

    /* renamed from: com.yandex.metrica.impl.ob.j8$a */
    public interface a {
        public static final List<String> a = A2.a("incremental_id", "timestamp", RemoteMessageConst.DATA);

        /* renamed from: com.yandex.metrica.impl.ob.j8$a$a, reason: collision with other inner class name */
        public interface InterfaceC0291a {
            public static final String a;
            public static final String b;

            static {
                Locale locale = Locale.US;
                a = String.format(locale, "CREATE TABLE IF NOT EXISTS %s (incremental_id INTEGER NOT NULL,timestamp INTEGER, data TEXT)", "lbs_dat");
                b = String.format(locale, "DROP TABLE IF EXISTS %s", "lbs_dat");
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.j8$a$b */
        public interface b {
            public static final String a;
            public static final String b;

            static {
                Locale locale = Locale.US;
                a = String.format(locale, "CREATE TABLE IF NOT EXISTS %s (incremental_id INTEGER NOT NULL,timestamp INTEGER, data TEXT)", "l_dat");
                b = String.format(locale, "DROP TABLE IF EXISTS %s", "l_dat");
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.j8$b */
    public static final class b {
        public static final List<String> a = A2.a("data_key", AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }

    /* renamed from: com.yandex.metrica.impl.ob.j8$c */
    public interface c {
        public static final List<String> a = A2.a("key", AppMeasurementSdk.ConditionalUserProperty.VALUE, "type");
    }

    /* renamed from: com.yandex.metrica.impl.ob.j8$d */
    public static final class d {
        public static final List<String> a = A2.a("id", "number", "global_number", "number_of_type", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "type", CrashHianalyticsData.TIME, "session_id", "wifi_network_info", "cell_info", "location_info", "error_environment", "user_info", "session_type", "app_environment", "app_environment_revision", "truncated", "connection_type", "cellular_connection_type", "custom_type", "wifi_access_point", "encrypting_mode", "profile_id", "first_occurrence_status", "battery_charge_type", "collection_mode", "has_omitted_data", "call_state", "source", "attribution_id_changed", "open_id", "extras");
        public static final String b = "CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY,name TEXT,value TEXT,number INTEGER,global_number INTEGER,number_of_type INTEGER,type INTEGER,time INTEGER,session_id TEXT,wifi_network_info TEXT DEFAULT '',cell_info TEXT DEFAULT '',location_info TEXT DEFAULT '',error_environment TEXT,user_info TEXT,session_type INTEGER DEFAULT " + EnumC0917f6.FOREGROUND.a() + ",app_environment TEXT DEFAULT '{}',app_environment_revision INTEGER DEFAULT 0,truncated INTEGER DEFAULT 0,connection_type INTEGER DEFAULT 2,cellular_connection_type TEXT,custom_type INTEGER DEFAULT 0, wifi_access_point TEXT, encrypting_mode INTEGER DEFAULT " + Em.NONE.a() + ", profile_id TEXT, first_occurrence_status INTEGER DEFAULT 0, battery_charge_type INTEGER DEFAULT " + E.b.a.UNKNOWN.a() + ", collection_mode TEXT, has_omitted_data INTEGER DEFAULT -1, call_state INTEGER DEFAULT 0, source INTEGER DEFAULT 0, attribution_id_changed INTEGER DEFAULT 0, open_id INTEGER DEFAULT " + new C1199qf.d.a().w + ", extras BLOB )";
    }

    /* renamed from: com.yandex.metrica.impl.ob.j8$e */
    public static final class e {
        public static final List<String> a = A2.a("id", "start_time", "network_info", "report_request_parameters", "server_time_offset", "type", "obtained_before_first_sync");
        public static final String b = "CREATE TABLE IF NOT EXISTS sessions (id INTEGER,start_time INTEGER,network_info TEXT,report_request_parameters TEXT,server_time_offset INTEGER,type INTEGER DEFAULT " + EnumC0917f6.FOREGROUND.a() + ",obtained_before_first_sync INTEGER DEFAULT 0 )";
        public static final String c;
        public static final String d;

        static {
            Locale locale = Locale.US;
            c = String.format(locale, "SELECT DISTINCT %s  FROM %s WHERE %s >=0 AND (SELECT count() FROM %5$s WHERE %5$s.%6$s = %2$s.%3$s AND %5$s.%7$s = %2$s.%4$s) > 0 ORDER BY %3$s LIMIT 1", "report_request_parameters", "sessions", "id", "type", "reports", "session_id", "session_type");
            d = String.format(locale, "(select count(%s.%s) from %s where %s.%s = %s.%s) = 0 and cast(%s as integer) < ?", "reports", "id", "reports", "reports", "session_id", "sessions", "id", "id");
        }
    }

    static {
        N7 n7 = new N7();
        b = n7;
        P7 p7 = new P7();
        c = p7;
        d = new M7(n7, p7, new X7.b());
    }

    public static M7 a() {
        return d;
    }
}

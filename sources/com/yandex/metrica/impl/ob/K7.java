package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import com.yandex.metrica.CounterConfiguration;
import java.util.List;

/* loaded from: classes3.dex */
public class K7 {
    private final CounterConfiguration.b a;
    private final C1012j2 b;

    static class a {
        public final List<ContentValues> a;
        public final int b;

        a(List<ContentValues> list, int i) {
            this.a = list;
            this.b = i;
        }
    }

    public enum b {
        BAD_REQUEST("bad_request"),
        DB_OVERFLOW("db_overflow");

        private final String a;

        b(String str) {
            this.a = str;
        }
    }

    public K7(CounterConfiguration.b bVar) {
        this(bVar, F0.g().p());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.yandex.metrica.impl.ob.K7.a a(android.database.sqlite.SQLiteDatabase r18, java.lang.String r19, java.lang.String r20, com.yandex.metrica.impl.ob.K7.b r21, java.lang.String r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.K7.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, com.yandex.metrica.impl.ob.K7$b, java.lang.String, boolean):com.yandex.metrica.impl.ob.K7$a");
    }

    K7(CounterConfiguration.b bVar, C1012j2 c1012j2) {
        this.a = bVar;
        this.b = c1012j2;
    }
}

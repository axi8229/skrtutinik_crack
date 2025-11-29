package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.C1018j8;
import com.yandex.metrica.impl.ob.C1158on;
import com.yandex.metrica.impl.ob.C1230s;
import com.yandex.metrica.impl.ob.C1297ui;
import com.yandex.metrica.impl.ob.K7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public class L7 {
    private static final HashSet<Integer> o;
    private final ReentrantReadWriteLock a;
    private final Lock b;
    private final Lock c;
    private final O7 d;
    private final a e;
    private final Object f;
    private final List<ContentValues> g;
    private final Context h;
    private final L3 i;
    private final AtomicLong j;
    private final List<InterfaceC1121nb> k;
    private final K7 l;
    private volatile qn<C1297ui.b, Object> m;
    private final rn<C1297ui.b, Object> n;

    private class a extends Lm {
        private final L3 b;

        a(L3 l3) {
            this.b = l3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            while (isRunning()) {
                try {
                } catch (Throwable unused) {
                    stopRunning();
                }
                synchronized (this) {
                    try {
                        if (L7.a(L7.this)) {
                            wait();
                        }
                        synchronized (L7.this.f) {
                            arrayList = new ArrayList(L7.this.g);
                            L7.this.g.clear();
                        }
                        L7.this.a(arrayList);
                        synchronized (this) {
                            try {
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    arrayList2.add(Integer.valueOf(L7.this.a((ContentValues) it.next())));
                                }
                                Iterator it2 = L7.this.k.iterator();
                                while (it2.hasNext()) {
                                    ((InterfaceC1121nb) it2.next()).a(arrayList2);
                                }
                                this.b.l().c();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    static {
        HashSet<Integer> hashSet = new HashSet<>();
        o = hashSet;
        hashSet.add(Integer.valueOf(EnumC0787a1.EVENT_TYPE_INIT.b()));
        hashSet.add(Integer.valueOf(EnumC0787a1.EVENT_TYPE_START.b()));
    }

    public L7(L3 l3, O7 o7, K7 k7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock;
        this.b = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
        this.f = new Object();
        this.g = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.j = atomicLong;
        this.k = new ArrayList();
        this.n = new rn<>();
        this.d = o7;
        this.h = l3.g();
        this.i = l3;
        this.l = k7;
        atomicLong.set(d());
        a aVar = new a(l3);
        this.e = aVar;
        aVar.setName(a(l3));
        a(l3.w());
    }

    public void e() {
        this.e.start();
    }

    private void a(C1178pi c1178pi) {
        C1297ui.a aVar = null;
        C1297ui.a aVar2 = (!c1178pi.f().o || c1178pi.Q() == null) ? null : c1178pi.Q().b;
        if (c1178pi.f().o && c1178pi.Q() != null) {
            aVar = c1178pi.Q().a;
        }
        EnumMap enumMap = new EnumMap(C1297ui.b.class);
        enumMap.put((EnumMap) C1297ui.b.WIFI, (C1297ui.b) (aVar2 == null ? new sn() : new yn(new xn(new Bn(), new Cn()), new SystemTimeProvider(), aVar2.a, aVar2.b)));
        enumMap.put((EnumMap) C1297ui.b.CELL, (C1297ui.b) (aVar == null ? new sn() : new yn(new xn(new C1158on.a(), new pn()), new SystemTimeProvider(), aVar.a, aVar.b)));
        this.m = new qn<>(enumMap);
    }

    private long d() {
        SQLiteDatabase readableDatabase;
        this.b.lock();
        try {
            readableDatabase = this.d.getReadableDatabase();
        } catch (Throwable unused) {
        }
        long jA = readableDatabase != null ? C0810b.a(readableDatabase, "reports") : 0L;
        this.b.unlock();
        return jA;
    }

    public Cursor b(long j, EnumC0917f6 enumC0917f6) throws SQLiteException {
        SQLiteDatabase readableDatabase;
        this.b.lock();
        try {
            readableDatabase = this.d.getReadableDatabase();
        } catch (Throwable unused) {
        }
        Cursor cursorQuery = readableDatabase != null ? readableDatabase.query("reports", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(enumC0917f6.a())}, null, null, "number ASC", null) : null;
        this.b.unlock();
        return cursorQuery;
    }

    public long c() {
        this.b.lock();
        try {
            return this.j.get();
        } finally {
            this.b.unlock();
        }
    }

    public List<ContentValues> b() {
        ArrayList arrayList = new ArrayList();
        this.b.lock();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
                if (readableDatabase != null) {
                    cursorRawQuery = readableDatabase.rawQuery(C1018j8.e.c, null);
                    while (cursorRawQuery.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues);
                        arrayList.add(contentValues);
                    }
                }
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
            return arrayList;
        } finally {
            A2.a(cursorRawQuery);
            this.b.unlock();
        }
    }

    public long a(Set<Integer> set) {
        this.b.lock();
        Cursor cursorRawQuery = null;
        long j = 0;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                StringBuilder sb = new StringBuilder("SELECT count() FROM reports");
                if (!set.isEmpty()) {
                    sb.append(" WHERE ");
                }
                int i = 0;
                for (Integer num : set) {
                    if (i > 0) {
                        sb.append(" OR ");
                    }
                    sb.append("type == " + num);
                    i++;
                }
                cursorRawQuery = readableDatabase.rawQuery(sb.toString(), null);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
            }
        } catch (Throwable unused) {
        }
        A2.a(cursorRawQuery);
        this.b.unlock();
        return j;
    }

    public void b(C1178pi c1178pi) {
        a(c1178pi);
    }

    public void a(InterfaceC1121nb interfaceC1121nb) {
        this.k.add(interfaceC1121nb);
    }

    private static String a(P3 p3) {
        return "DatabaseWorker [" + ((L3) p3).e().c() + "]";
    }

    public void a(long j, EnumC0917f6 enumC0917f6, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j));
        contentValues.put("start_time", Long.valueOf(j2));
        contentValues.put("server_time_offset", Long.valueOf(C0933fm.c().a()));
        contentValues.put("obtained_before_first_sync", Boolean.valueOf(C0933fm.c().e()));
        contentValues.put("type", Integer.valueOf(enumC0917f6.a()));
        new C0986i0(this.h).a(this.i.m()).a(contentValues).a();
        this.c.lock();
        try {
            SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.insertOrThrow("sessions", null, contentValues);
            }
        } catch (Throwable unused) {
        }
        this.c.unlock();
    }

    public void a(Bm bm, int i, C0842c6 c0842c6, C1230s.a aVar, O3 o3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", Long.valueOf(c0842c6.a()));
        contentValues.put("global_number", Integer.valueOf(C1399z0.d(i) ? o3.a() : 0));
        contentValues.put("number_of_type", Integer.valueOf(o3.a(i)));
        contentValues.put(CrashHianalyticsData.TIME, Long.valueOf(c0842c6.b()));
        contentValues.put("session_id", Long.valueOf(c0842c6.c()));
        contentValues.put("session_type", Integer.valueOf(c0842c6.d().a()));
        new C0986i0(this.h).a(this.i.m()).a(contentValues).a(bm, aVar, o.contains(Integer.valueOf(i)) ? this.n : this.m);
        synchronized (this.f) {
            this.g.add(contentValues);
        }
        synchronized (this.e) {
            this.e.notifyAll();
        }
    }

    public int a(long j) {
        SQLiteDatabase writableDatabase;
        this.c.lock();
        try {
            int i = C1018j8.a;
            writableDatabase = this.d.getWritableDatabase();
        } catch (Throwable unused) {
        }
        int iDelete = writableDatabase != null ? writableDatabase.delete("sessions", C1018j8.e.d, new String[]{String.valueOf(j)}) : 0;
        this.c.unlock();
        return iDelete;
    }

    public void a() {
        SQLiteDatabase writableDatabase;
        try {
            this.c.lock();
            if (this.j.get() > this.i.m().J() && (writableDatabase = this.d.getWritableDatabase()) != null) {
                this.j.addAndGet(-a(writableDatabase));
            }
        } catch (Throwable unused) {
        }
        this.c.unlock();
    }

    private int a(SQLiteDatabase sQLiteDatabase) {
        try {
            String str = String.format("%1$s IN (SELECT %1$s FROM %2$s ORDER BY CASE WHEN %3$s IN (%4$s) THEN 2 WHEN %3$s IN (%5$s) THEN 1 ELSE 0 END, %6$s LIMIT (SELECT count() FROM %2$s) / %7$s)", "id", "reports", "type", TextUtils.join(", ", C1399z0.i), TextUtils.join(", ", C1399z0.j), "id", 10);
            return this.l.a(sQLiteDatabase, "reports", str, K7.b.DB_OVERFLOW, this.i.e().a(), true).b;
        } catch (Throwable th) {
            ((C1127nh) C1152oh.a()).reportError("deleteExcessiveReports exception", th);
            return 0;
        }
    }

    public void a(long j, int i, int i2, boolean z) throws SQLiteException {
        List<ContentValues> list;
        if (i2 <= 0) {
            return;
        }
        this.c.lock();
        try {
            String str = String.format(Locale.US, "%1$s = %2$s AND %3$s = %4$s AND %5$s <= (SELECT %5$s FROM %6$s WHERE %1$s = %2$s AND %3$s = %4$s ORDER BY %5$s ASC LIMIT %7$s, 1)", "session_id", Long.toString(j), "session_type", Integer.toString(i), "id", "reports", Integer.toString(i2 - 1));
            SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
            if (writableDatabase != null) {
                K7.a aVarA = this.l.a(writableDatabase, "reports", str, K7.b.BAD_REQUEST, this.i.e().a(), z);
                if (aVarA.a != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<ContentValues> it = aVarA.a.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(a(it.next())));
                    }
                    Iterator<InterfaceC1121nb> it2 = this.k.iterator();
                    while (it2.hasNext()) {
                        it2.next().b(arrayList);
                    }
                }
                if (this.i.q().isEnabled() && (list = aVarA.a) != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        a(list.get(i3), "Event removed from db");
                    }
                }
                this.j.addAndGet(-aVarA.b);
            }
        } catch (Throwable unused) {
        }
        this.c.unlock();
    }

    public Cursor a(Map<String, String> map) {
        SQLiteDatabase readableDatabase;
        this.b.lock();
        try {
            readableDatabase = this.d.getReadableDatabase();
        } catch (Throwable unused) {
        }
        Cursor cursorQuery = readableDatabase != null ? readableDatabase.query("sessions", null, a("id >= ?", map), a(new String[]{Long.toString(0L)}, map), null, null, "id ASC", null) : null;
        this.b.unlock();
        return cursorQuery;
    }

    void a(List<ContentValues> list) {
        SQLiteDatabase writableDatabase;
        if (list.isEmpty()) {
            return;
        }
        this.c.lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.d.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.beginTransaction();
                    for (ContentValues contentValues : list) {
                        writableDatabase.insertOrThrow("reports", null, contentValues);
                        this.j.incrementAndGet();
                        a(contentValues, "Event saved to db");
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.j.get();
                } catch (Throwable unused) {
                    sQLiteDatabase = writableDatabase;
                    writableDatabase = sQLiteDatabase;
                    A2.a(writableDatabase);
                    this.c.unlock();
                }
            }
        } catch (Throwable unused2) {
        }
        A2.a(writableDatabase);
        this.c.unlock();
    }

    public ContentValues a(long j, EnumC0917f6 enumC0917f6) {
        ContentValues contentValues = new ContentValues();
        this.b.lock();
        Cursor cursorRawQuery = null;
        try {
            SQLiteDatabase readableDatabase = this.d.getReadableDatabase();
            if (readableDatabase != null) {
                cursorRawQuery = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(enumC0917f6.a())), null);
                if (cursorRawQuery.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues2);
                    contentValues = contentValues2;
                }
            }
            A2.a(cursorRawQuery);
            this.b.unlock();
        } catch (Throwable unused) {
            A2.a(cursorRawQuery);
            this.b.unlock();
        }
        return contentValues;
    }

    private static String a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        for (String str2 : map.keySet()) {
            sb.append(sb.length() > 0 ? " AND " : "");
            sb.append(str2 + " = ? ");
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return null;
        }
        return sb.toString();
    }

    private static String[] a(String[] strArr, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private void a(ContentValues contentValues, String str) {
        Integer asInteger = contentValues.getAsInteger("type");
        if (C1399z0.c(asInteger != null ? asInteger.intValue() : -1)) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(": ");
            String asString = contentValues.getAsString(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (asString == null) {
                asString = "";
            }
            sb.append(asString);
            String asString2 = contentValues.getAsString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            String str2 = asString2 != null ? asString2 : "";
            if (C1399z0.e(a(contentValues)) && !TextUtils.isEmpty(str2)) {
                sb.append(" with value ");
                sb.append(str2);
            }
            this.i.q().i(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ContentValues contentValues) {
        return contentValues.getAsInteger("type").intValue();
    }

    static boolean a(L7 l7) {
        boolean zIsEmpty;
        synchronized (l7.f) {
            zIsEmpty = l7.g.isEmpty();
        }
        return zIsEmpty;
    }
}

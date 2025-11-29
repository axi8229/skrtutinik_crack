package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public abstract class J7 {
    private final O7 a;
    private final C0794a8 b;
    private final ContentValues f = new ContentValues();
    private final AtomicLong c = new AtomicLong(d());
    private final AtomicLong d = new AtomicLong(a(Long.MAX_VALUE));
    private final AtomicLong e = new AtomicLong(a());

    J7(O7 o7, C0794a8 c0794a8) {
        this.a = o7;
        this.b = c0794a8;
    }

    private long d() {
        try {
            SQLiteDatabase readableDatabase = this.a.getReadableDatabase();
            if (readableDatabase != null) {
                return C0810b.a(readableDatabase, e());
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    protected abstract long a();

    public synchronized void a(long j, String str) {
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase != null) {
                this.f.clear();
                this.f.put("incremental_id", Long.valueOf(this.e.get() + 1));
                this.f.put("timestamp", Long.valueOf(j));
                this.f.put(RemoteMessageConst.DATA, str);
                if (writableDatabase.insert(e(), null, this.f) != -1) {
                    this.c.incrementAndGet();
                    this.e.incrementAndGet();
                    b(this.e.get());
                    if (this.d.get() > j) {
                        this.d.set(j);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long b() {
        return this.d.get();
    }

    protected abstract void b(long j);

    public long c() {
        return this.c.get();
    }

    public abstract String e();

    C0794a8 f() {
        return this.b;
    }

    public synchronized int b(int i) {
        int iDelete = 0;
        if (i < 1) {
            return 0;
        }
        String str = String.format(Locale.US, "%1$s <= (select max(%1$s) from (select %1$s from %2$s order by %1$s limit ?))", "incremental_id", e());
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase != null && (iDelete = writableDatabase.delete(e(), str, new String[]{String.valueOf(i)})) > 0) {
                this.c.getAndAdd(-iDelete);
                this.d.set(a(Long.MAX_VALUE));
            }
        } catch (Throwable unused) {
        }
        return iDelete;
    }

    public synchronized int c(long j) {
        int iDelete;
        String str = String.format(Locale.US, "%s <= ?", "incremental_id");
        iDelete = 0;
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase != null && (iDelete = writableDatabase.delete(e(), str, new String[]{String.valueOf(j)})) > 0) {
                this.c.getAndAdd(-iDelete);
                this.d.set(a(Long.MAX_VALUE));
            }
        } catch (Throwable unused) {
        }
        return iDelete;
    }

    public long a(long j) {
        String str = String.format(Locale.US, "Select min(%s) from %s", "timestamp", e());
        Cursor cursorRawQuery = null;
        try {
            SQLiteDatabase readableDatabase = this.a.getReadableDatabase();
            if (readableDatabase != null) {
                cursorRawQuery = readableDatabase.rawQuery(str, null);
                if (cursorRawQuery.moveToFirst()) {
                    long j2 = cursorRawQuery.getLong(0);
                    if (j2 != 0) {
                        j = j2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        A2.a(cursorRawQuery);
        return j;
    }

    public synchronized Map<Long, String> a(int i) {
        LinkedHashMap linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase readableDatabase = this.a.getReadableDatabase();
            if (readableDatabase != null) {
                cursorQuery = readableDatabase.query(e(), new String[]{"incremental_id", RemoteMessageConst.DATA}, null, null, null, null, "incremental_id ASC", String.valueOf(i));
                while (cursorQuery.moveToNext()) {
                    this.f.clear();
                    try {
                        C0810b.a(cursorQuery, this.f);
                    } catch (Throwable unused) {
                    }
                    Long asLong = this.f.getAsLong("incremental_id");
                    String asString = this.f.getAsString(RemoteMessageConst.DATA);
                    if (asLong != null && asString != null) {
                        linkedHashMap.put(asLong, asString);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        A2.a(cursorQuery);
        return linkedHashMap;
    }
}

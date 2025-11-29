package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.Closeable;

/* loaded from: classes3.dex */
public class O7 extends SQLiteOpenHelper implements Closeable {
    private final String a;
    private final C0858cm b;
    protected final X7 c;

    public O7(Context context, String str, X7 x7) {
        this(context, str, x7, Ul.a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.forceE(th, "", new Object[0]);
            this.b.forceW("Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.a);
            ((C1127nh) C1152oh.a()).reportError("db_read_error", th);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.forceE(th, "", new Object[0]);
            this.b.forceW("Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.a);
            ((C1127nh) C1152oh.a()).reportError("db_write_error", th);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.c.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.c.a(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        this.c.b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.c.b(sQLiteDatabase, i, i2);
    }

    O7(Context context, String str, X7 x7, C0858cm c0858cm) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, C1018j8.a);
        this.c = x7;
        this.a = str;
        this.b = c0858cm;
    }
}

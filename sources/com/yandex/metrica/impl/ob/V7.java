package com.yandex.metrica.impl.ob;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class V7 {
    private final InterfaceC0944g8 a;

    public V7(O7 o7, String str) {
        this(new C0994i8(o7), str);
    }

    public void a() {
        SQLiteDatabase sQLiteDatabaseA;
        try {
            sQLiteDatabaseA = this.a.a();
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.execSQL("DROP TABLE IF EXISTS permissions");
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            sQLiteDatabaseA = null;
        }
        this.a.a(sQLiteDatabaseA);
    }

    public List<Bd> b() {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorQuery;
        try {
            sQLiteDatabaseA = this.a.a();
            if (sQLiteDatabaseA != null) {
                try {
                    cursorQuery = sQLiteDatabaseA.query("permissions", null, null, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                ArrayList arrayList = new ArrayList();
                                do {
                                    arrayList.add(new Bd(cursorQuery.getString(cursorQuery.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME)), cursorQuery.getLong(cursorQuery.getColumnIndex("granted")) == 1));
                                } while (cursorQuery.moveToNext());
                                this.a.a(sQLiteDatabaseA);
                                A2.a(cursorQuery);
                                return arrayList;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable unused2) {
                }
            } else {
                cursorQuery = null;
            }
        } catch (Throwable unused3) {
            sQLiteDatabaseA = null;
            cursorQuery = null;
        }
        this.a.a(sQLiteDatabaseA);
        A2.a(cursorQuery);
        return null;
    }

    V7(InterfaceC0944g8 interfaceC0944g8, String str) {
        this.a = interfaceC0944g8;
    }
}

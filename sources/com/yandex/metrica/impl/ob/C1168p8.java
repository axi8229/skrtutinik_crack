package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import com.yandex.metrica.impl.ob.C1018j8;
import java.sql.SQLException;

/* renamed from: com.yandex.metrica.impl.ob.p8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1168p8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
        sQLiteDatabase.execSQL(C1018j8.d.b);
        sQLiteDatabase.execSQL(C1018j8.e.b);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
    }
}

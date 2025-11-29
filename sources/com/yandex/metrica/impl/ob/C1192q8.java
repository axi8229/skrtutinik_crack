package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;

/* renamed from: com.yandex.metrica.impl.ob.q8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1192q8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS reports");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessions");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
    }
}

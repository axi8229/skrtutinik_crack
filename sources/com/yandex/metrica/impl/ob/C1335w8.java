package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;

/* renamed from: com.yandex.metrica.impl.ob.w8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1335w8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
    }
}

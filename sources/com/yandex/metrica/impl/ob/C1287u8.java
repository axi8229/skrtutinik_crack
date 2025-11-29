package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import com.yandex.metrica.impl.ob.C1018j8;
import java.sql.SQLException;

/* renamed from: com.yandex.metrica.impl.ob.u8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1287u8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS startup");
        sQLiteDatabase.execSQL(C1018j8.a.b.b);
        sQLiteDatabase.execSQL(C1018j8.a.InterfaceC0291a.b);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS permissions");
    }
}

package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class F8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN environment TEXT ");
        sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN user_info TEXT ");
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE ");
        sb.append("reports");
        sb.append(" ADD COLUMN ");
        sb.append("session_type");
        sb.append(" INTEGER DEFAULT ");
        EnumC0917f6 enumC0917f6 = EnumC0917f6.FOREGROUND;
        sb.append(enumC0917f6.a());
        sQLiteDatabase.execSQL(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE ");
        sb2.append("reports");
        sb2.append(" SET ");
        sb2.append("session_type");
        sb2.append(" = ");
        EnumC0917f6 enumC0917f62 = EnumC0917f6.BACKGROUND;
        sb2.append(enumC0917f62.a());
        sb2.append(" WHERE ");
        sb2.append("session_id");
        sb2.append(" = ");
        sb2.append(-2L);
        sQLiteDatabase.execSQL(sb2.toString());
        sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN server_time_offset INTEGER ");
        sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN type INTEGER DEFAULT " + enumC0917f6.a());
        sQLiteDatabase.execSQL("UPDATE sessions SET type = " + enumC0917f62.a() + " WHERE id = -2");
    }
}

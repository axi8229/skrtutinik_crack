package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class I8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException, android.database.SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN connection_type INTEGER DEFAULT 2");
        sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN cellular_connection_type TEXT ");
    }
}

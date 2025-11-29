package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class L8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException, android.database.SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN obtained_before_first_sync INTEGER DEFAULT 0");
    }
}

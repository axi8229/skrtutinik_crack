package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class P8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
        sQLiteDatabase.delete("reports", "session_id = ?", new String[]{String.valueOf(-2L)});
        sQLiteDatabase.delete("sessions", "id = ?", new String[]{String.valueOf(-2L)});
    }
}

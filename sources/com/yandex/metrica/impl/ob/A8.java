package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import com.yandex.metrica.impl.ob.C1018j8;
import java.sql.SQLException;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class A8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException, android.database.SQLException {
        sQLiteDatabase.execSQL(C1018j8.a.b.a);
    }
}

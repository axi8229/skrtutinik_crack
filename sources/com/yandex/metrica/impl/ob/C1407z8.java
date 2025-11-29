package com.yandex.metrica.impl.ob;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.yandex.metrica.impl.ob.z8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1407z8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS permissions (name TEXT PRIMARY KEY,granted INTEGER)");
    }
}

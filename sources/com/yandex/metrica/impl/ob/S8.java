package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.metrica.impl.ob.E;
import java.sql.SQLException;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class S8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException, android.database.SQLException {
        Locale locale = Locale.US;
        sQLiteDatabase.execSQL(String.format(locale, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", "reports", "battery_charge_type", Integer.valueOf(E.b.a.UNKNOWN.a())));
        sQLiteDatabase.execSQL(String.format(locale, "ALTER TABLE %s ADD COLUMN %s TEXT", "reports", "collection_mode"));
        sQLiteDatabase.execSQL(String.format(locale, "UPDATE %s SET %s = \"\" WHERE %s == %d AND %2$s != \"\" AND %2$s IS NOT NULL", "reports", AppMeasurementSdk.ConditionalUserProperty.VALUE, "type", Integer.valueOf(EnumC0787a1.EVENT_TYPE_START.b())));
    }
}

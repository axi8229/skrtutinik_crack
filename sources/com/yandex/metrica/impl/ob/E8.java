package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.impl.ob.C1018j8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class E8 extends AbstractC1043k8 {
    @Override // com.yandex.metrica.impl.ob.AbstractC1043k8
    public void a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessions_BACKUP (id INTEGER,start_time INTEGER,connection_type INTEGER,network_type TEXT,country_code INTEGER,operator_id INTEGER,lac INTEGER,report_request_parameters TEXT );");
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(",");
        sb.append("start_time");
        sb.append(",");
        sb.append("connection_type");
        sb.append(",");
        sb.append("network_type");
        sb.append(",");
        sb.append("country_code");
        sb.append(",");
        sb.append("operator_id");
        sb.append(",");
        sb.append("lac");
        sb.append(",");
        sb.append("report_request_parameters");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("INSERT INTO ");
        sb2.append("sessions_BACKUP");
        sb2.append(" SELECT ");
        sb2.append((CharSequence) sb);
        sb2.append(" FROM ");
        sb2.append("sessions");
        sb2.append(";");
        sQLiteDatabase.execSQL(sb2.toString());
        sQLiteDatabase.execSQL("DROP TABLE sessions;");
        sQLiteDatabase.execSQL(C1018j8.e.b);
        Cursor cursor = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM sessions_BACKUP", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("id");
                    arrayList.add("start_time");
                    arrayList.add("report_request_parameters");
                    ContentValues contentValues2 = new ContentValues(contentValues);
                    for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                        if (!arrayList.contains(entry.getKey())) {
                            contentValues2.remove(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        contentValues.remove((String) it.next());
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("conn_type", contentValues.getAsInteger("connection_type"));
                    jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_NET_TYPE, contentValues.get("network_type"));
                    jSONObject.putOpt("operator_id", contentValues.get("operator_id"));
                    jSONObject.putOpt("lac", contentValues.get("lac"));
                    jSONObject.putOpt("country_code", contentValues.get("country_code"));
                    contentValues2.put("network_info", jSONObject.toString());
                    sQLiteDatabase.insertOrThrow("sessions", null, contentValues2);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    A2.a(cursor);
                    throw th;
                }
            }
            A2.a(cursorRawQuery);
            sQLiteDatabase.execSQL("DROP TABLE sessions_BACKUP;");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN wifi_network_info TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN cell_info TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN location_info TEXT DEFAULT ''");
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

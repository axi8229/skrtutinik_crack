package com.yandex.metrica.impl.ob;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Z7 implements Y7 {
    private final HashMap<String, List<String>> a;

    public Z7(String str, HashMap<String, List<String>> map) {
        this.a = map;
    }

    public boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            boolean zEquals = true;
            for (Map.Entry<String, List<String>> entry : this.a.entrySet()) {
                try {
                    Cursor cursorQuery = sQLiteDatabase.query(entry.getKey(), null, null, null, null, null, null);
                    if (cursorQuery == null) {
                        A2.a(cursorQuery);
                        return false;
                    }
                    entry.getKey();
                    List<String> value = entry.getValue();
                    List listAsList = Arrays.asList(cursorQuery.getColumnNames());
                    Collections.sort(listAsList);
                    zEquals &= value.equals(listAsList);
                    A2.a(cursorQuery);
                } catch (Throwable th) {
                    A2.a((Cursor) null);
                    throw th;
                }
            }
            return zEquals;
        } catch (Throwable unused) {
            return false;
        }
    }
}

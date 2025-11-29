package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1306v3;
import java.util.HashMap;

/* renamed from: com.yandex.metrica.impl.ob.a2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0788a2 implements InterfaceC0813b2<C1306v3.a> {
    private final Context a;

    public C0788a2(Context context) {
        this.a = context;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0813b2, kotlin.jvm.functions.Function0
    public Object invoke() {
        Cursor cursorQuery;
        String string;
        String string2;
        C1306v3.a aVar = null;
        try {
            cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.yandex.preinstallsatellite.appmetrica.provider/clids"), null, null, null, null);
            try {
                if (cursorQuery != null) {
                    HashMap map = new HashMap();
                    while (cursorQuery.moveToNext()) {
                        try {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("clid_key"));
                            string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("clid_value"));
                        } catch (Throwable unused) {
                        }
                        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                            C0963h2.a("Invalid clid {%s : %s}", string, string2);
                        } else {
                            map.put(string, string2);
                        }
                    }
                    C0963h2.a("Clids from satellite: %s", map);
                    C1306v3.a aVar2 = new C1306v3.a(map, EnumC1279u0.SATELLITE);
                    A2.a(cursorQuery);
                    aVar = aVar2;
                } else {
                    C0963h2.a("No Satellite content provider found", new Object[0]);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    C0963h2.a(th, "Error while getting satellite clids", new Object[0]);
                    return aVar;
                } finally {
                    A2.a(cursorQuery);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        return aVar;
    }
}

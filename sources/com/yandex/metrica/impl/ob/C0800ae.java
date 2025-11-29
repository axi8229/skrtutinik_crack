package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.ae, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0800ae implements InterfaceC0813b2<C0900ee> {
    private final Context a;

    public C0800ae(Context context) {
        this.a = context;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0813b2, kotlin.jvm.functions.Function0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0900ee invoke() {
        Cursor cursorQuery;
        try {
            cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.yandex.preinstallsatellite.appmetrica.provider/preload_info"), null, null, null, null);
            try {
                if (cursorQuery == null) {
                    C0963h2.a("No Satellite content provider found", new Object[0]);
                } else {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("tracking_id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("additional_parameters"));
                        JSONObject jSONObject = !TextUtils.isEmpty(string2) ? new JSONObject(string2) : new JSONObject();
                        C0963h2.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject);
                        C0900ee c0900ee = new C0900ee(string, jSONObject, !TextUtils.isEmpty(string), false, EnumC1279u0.SATELLITE);
                        A2.a(cursorQuery);
                        return c0900ee;
                    }
                    C0963h2.a("No Preload Info data in Satellite content provider", new Object[0]);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        A2.a(cursorQuery);
        return null;
    }
}

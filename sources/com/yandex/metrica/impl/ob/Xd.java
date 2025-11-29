package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Xd implements W<C0900ee> {
    @Override // com.yandex.metrica.impl.ob.W, kotlin.jvm.functions.Function1
    public Object invoke(ContentValues contentValues) {
        ContentValues contentValues2 = contentValues;
        String asString = contentValues2.getAsString("tracking_id");
        C0900ee c0900ee = null;
        if (TextUtils.isEmpty(asString)) {
            C0963h2.b("Tracking id is empty", new Object[0]);
        } else {
            try {
                String asString2 = contentValues2.getAsString("additional_params");
                if (TextUtils.isEmpty(asString2)) {
                    C0963h2.b("No additional params", new Object[0]);
                } else {
                    JSONObject jSONObject = new JSONObject(asString2);
                    if (jSONObject.length() == 0) {
                        C0963h2.b("Additional params are empty", new Object[0]);
                    } else {
                        C0963h2.a("Successfully parsed preload info. Tracking id = %s, additionalParams = %s", asString, jSONObject);
                        c0900ee = new C0900ee(asString, jSONObject, true, false, EnumC1279u0.RETAIL);
                    }
                }
            } catch (Throwable th) {
                C0963h2.a(th, "Could not parse additional parameters", new Object[0]);
            }
        }
        return c0900ee;
    }
}

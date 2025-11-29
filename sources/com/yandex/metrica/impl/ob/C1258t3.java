package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.t3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1258t3 implements W<Map<String, ? extends String>> {
    @Override // com.yandex.metrica.impl.ob.W, kotlin.jvm.functions.Function1
    public Object invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap<String, String> mapD = Tl.d(asString);
        if (Tl.d(mapD)) {
            return mapD;
        }
        C0963h2.b("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}

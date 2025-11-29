package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.Cf;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.fe, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0925fe implements ProtobufConverter {
    private final C0875de a = new C0875de();

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Cf.a fromModel(C0900ee c0900ee) {
        Cf.a aVar = new Cf.a();
        if (!TextUtils.isEmpty(c0900ee.a)) {
            aVar.a = c0900ee.a;
        }
        aVar.b = c0900ee.b.toString();
        aVar.c = c0900ee.c;
        aVar.d = c0900ee.d;
        aVar.e = this.a.fromModel(c0900ee.e).intValue();
        return aVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0900ee toModel(Cf.a aVar) {
        JSONObject jSONObject;
        String str = aVar.a;
        String str2 = aVar.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
        } else {
            jSONObject = new JSONObject();
        }
        return new C0900ee(str, jSONObject, aVar.c, aVar.d, this.a.toModel(Integer.valueOf(aVar.e)));
    }
}

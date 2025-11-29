package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.Cf;
import com.yandex.metrica.impl.ob.Ud;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sd implements ProtobufConverter {
    private final C0875de a;

    public Sd() {
        this(new C0875de());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Cf.b fromModel(Ud.a aVar) {
        Cf.b bVar = new Cf.b();
        if (!TextUtils.isEmpty(aVar.a)) {
            bVar.a = aVar.a;
        }
        bVar.b = aVar.b.toString();
        bVar.c = this.a.fromModel(aVar.c).intValue();
        return bVar;
    }

    Sd(C0875de c0875de) {
        this.a = c0875de;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Ud.a toModel(Cf.b bVar) {
        JSONObject jSONObject;
        String str = bVar.a;
        String str2 = bVar.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
        } else {
            jSONObject = new JSONObject();
        }
        return new Ud.a(str, jSONObject, this.a.toModel(Integer.valueOf(bVar.c)));
    }
}

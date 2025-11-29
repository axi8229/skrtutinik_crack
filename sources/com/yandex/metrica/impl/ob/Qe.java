package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Qe implements Kn<String> {
    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(String str) {
        String str2 = str;
        return str2 == null ? In.a(this, "key is null") : str2.startsWith("appmetrica") ? In.a(this, "key starts with appmetrica") : str2.length() > 200 ? In.a(this, "key length more then 200 characters") : In.a(this);
    }
}

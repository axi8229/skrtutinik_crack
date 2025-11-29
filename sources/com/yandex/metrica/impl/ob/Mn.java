package com.yandex.metrica.impl.ob;

import java.util.Map;

/* loaded from: classes3.dex */
public class Mn implements Kn<String> {
    private final Map<String, ?> a;

    public Mn(Map<String, ?> map) {
        this.a = map;
    }

    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(String str) {
        String str2 = str;
        return this.a.containsKey(str2) ? In.a(this, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str2)) : In.a(this);
    }
}

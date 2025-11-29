package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class Fn implements Kn<String> {
    private final String a;

    public Fn(String str) {
        this.a = str;
    }

    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return In.a(this);
        }
        return In.a(this, this.a + " is empty.");
    }
}

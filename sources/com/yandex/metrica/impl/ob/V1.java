package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes3.dex */
public abstract class V1<T> {
    protected final Context a;
    private final String b;
    private final String c;

    public V1(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public T a() {
        int identifier = this.a.getResources().getIdentifier(this.b, this.c, this.a.getPackageName());
        if (identifier == 0) {
            return null;
        }
        try {
            return a(identifier);
        } catch (Throwable unused) {
            return null;
        }
    }

    protected abstract T a(int i);
}

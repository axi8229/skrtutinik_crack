package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;

/* loaded from: classes3.dex */
public final class Z<T> {
    private final W<T> a;
    private final X<T> b;
    private final E0 c;
    private final String d;

    public Z(W<T> w, X<T> x, E0 e0, String str) {
        this.a = w;
        this.b = x;
        this.c = e0;
        this.d = str;
    }

    public final void a(Context context, ContentValues contentValues) {
        try {
            T tInvoke = this.a.invoke(contentValues);
            if (tInvoke != null) {
                this.c.a(context);
                if (this.b.invoke(tInvoke).booleanValue()) {
                    C0963h2.a("Successfully saved " + this.d, new Object[0]);
                } else {
                    C0963h2.b("Did not save " + this.d + " because data is already present", new Object[0]);
                }
            }
        } catch (Throwable th) {
            C0963h2.a(th, "Unexpected error occurred", new Object[0]);
        }
    }
}

package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class U {
    private static final Object f = new Object();

    @SuppressLint({"StaticFieldLeak"})
    private static volatile U g;
    public final String a = Build.MANUFACTURER;
    public final String b = Build.MODEL;
    public final String c = Build.VERSION.RELEASE;
    public final int d = Build.VERSION.SDK_INT;
    public final String e = String.valueOf(X1.a());

    class a extends ArrayList<String> {
        a(U u) {
            if (X1.b()) {
                add("Superuser.apk");
            }
            if (X1.c()) {
                add("su.so");
            }
        }
    }

    public U() {
        Collections.unmodifiableList(new a(this));
    }

    public static U a() {
        if (g == null) {
            synchronized (f) {
                try {
                    if (g == null) {
                        g = new U();
                    }
                } finally {
                }
            }
        }
        return g;
    }
}

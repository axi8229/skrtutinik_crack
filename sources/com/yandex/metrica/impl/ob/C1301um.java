package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.yandex.metrica.impl.ob.um, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1301um {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile C1301um c;
    private final Context a;
    private final Map<String, C1253sm> b = new HashMap();

    C1301um(Context context) {
        this.a = context;
    }

    public static C1301um a(Context context) {
        if (c == null) {
            synchronized (C1301um.class) {
                try {
                    if (c == null) {
                        c = new C1301um(context);
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public C1253sm a(String str) {
        if (!this.b.containsKey(str)) {
            synchronized (this) {
                try {
                    if (!this.b.containsKey(str)) {
                        this.b.put(str, new C1253sm(new ReentrantLock(), new C1277tm(this.a, str)));
                    }
                } finally {
                }
            }
        }
        return this.b.get(str);
    }
}

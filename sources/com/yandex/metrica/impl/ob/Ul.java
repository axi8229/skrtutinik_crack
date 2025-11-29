package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class Ul {
    private static Map<String, C0858cm> a = new HashMap();
    private static Map<String, Sl> b = new HashMap();
    private static final Object c = new Object();
    private static final Object d = new Object();
    public static final /* synthetic */ int e = 0;

    public static Sl a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Sl.a();
        }
        Sl sl = b.get(str);
        if (sl == null) {
            synchronized (d) {
                try {
                    sl = b.get(str);
                    if (sl == null) {
                        sl = new Sl(str);
                        b.put(str, sl);
                    }
                } finally {
                }
            }
        }
        return sl;
    }

    public static C0858cm b(String str) {
        if (TextUtils.isEmpty(str)) {
            return C0858cm.a();
        }
        C0858cm c0858cm = a.get(str);
        if (c0858cm == null) {
            synchronized (c) {
                try {
                    c0858cm = a.get(str);
                    if (c0858cm == null) {
                        c0858cm = new C0858cm(str);
                        a.put(str, c0858cm);
                    }
                } finally {
                }
            }
        }
        return c0858cm;
    }

    public static C0858cm a() {
        return C0858cm.a();
    }
}

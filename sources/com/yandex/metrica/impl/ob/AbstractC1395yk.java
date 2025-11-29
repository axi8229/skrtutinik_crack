package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.yandex.metrica.impl.ob.yk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC1395yk<T> {
    private List<Object> a;
    private final C1323vk b;

    AbstractC1395yk(T t, C1323vk c1323vk) {
        this.a = c(t);
        this.b = c1323vk;
    }

    private List<Object> c(T t) {
        Object c1275tk;
        Pattern patternCompile;
        Pattern patternCompile2;
        ArrayList arrayList = new ArrayList();
        if (t == null) {
            return arrayList;
        }
        int iB = b(t);
        List<C1420zl> listA = a(t);
        arrayList.add(new Zk(iB));
        for (C1420zl c1420zl : listA) {
            int iOrdinal = c1420zl.a.ordinal();
            if (iOrdinal == 0) {
                c1275tk = new C1275tk(c1420zl.b);
            } else if (iOrdinal != 1) {
                c1275tk = null;
                if (iOrdinal == 2) {
                    try {
                        patternCompile = Pattern.compile(c1420zl.b);
                    } catch (Throwable unused) {
                        patternCompile = null;
                    }
                    if (patternCompile != null) {
                        c1275tk = new Nk(patternCompile);
                    }
                } else if (iOrdinal == 3) {
                    try {
                        patternCompile2 = Pattern.compile(c1420zl.b);
                    } catch (Throwable unused2) {
                        patternCompile2 = null;
                    }
                    if (patternCompile2 != null) {
                        c1275tk = new C1155ok(patternCompile2);
                    }
                }
            } else {
                c1275tk = new C1030jk(c1420zl.b);
            }
            if (c1275tk != null) {
                arrayList.add(c1275tk);
            }
        }
        return A2.c(arrayList);
    }

    C1323vk a() {
        return this.b;
    }

    abstract List<C1420zl> a(T t);

    abstract int b(T t);

    List<Object> b() {
        return this.a;
    }

    void d(T t) {
        this.b.a();
        this.a = c(t);
    }
}

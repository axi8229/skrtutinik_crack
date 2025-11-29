package com.yandex.metrica.impl.ob;

import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class E6 {
    public final String a;
    public final int b;
    public final long c;
    public final String d;
    public final Integer e;
    public final List<StackTraceElement> f;

    public E6(String str, int i, long j, String str2, Integer num, List<StackTraceElement> list) {
        this.a = str;
        this.b = i;
        this.c = j;
        this.d = str2;
        this.e = num;
        this.f = list == null ? Collections.emptyList() : A2.c(list);
    }
}

package com.yandex.metrica.impl.ob;

import android.util.Pair;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.bi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0829bi {
    public final String a;
    public final String b;
    public final String c;
    public final List<Pair<String, String>> d;
    public final Long e;
    public final List<a> f;

    /* renamed from: com.yandex.metrica.impl.ob.bi$a */
    public enum a {
        WIFI,
        CELL
    }

    public C0829bi(String str, String str2, String str3, List<Pair<String, String>> list, Long l, List<a> list2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = A2.c(list);
        this.e = l;
        this.f = list2;
    }
}

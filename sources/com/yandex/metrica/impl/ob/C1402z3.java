package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.YandexMetrica;

/* renamed from: com.yandex.metrica.impl.ob.z3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1402z3 {
    private final A3 a;
    private final CounterConfiguration b;

    public C1402z3(Bundle bundle) {
        this.a = A3.a(bundle);
        this.b = CounterConfiguration.a(bundle);
    }

    public A3 a() {
        return this.a;
    }

    public CounterConfiguration b() {
        return this.b;
    }

    public String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.a + ", mCounterConfiguration=" + this.b + '}';
    }

    public static boolean a(C1402z3 c1402z3, Context context) {
        return (c1402z3.a != null && context.getPackageName().equals(c1402z3.a.f()) && c1402z3.a.i() == YandexMetrica.getLibraryApiLevel()) ? false : true;
    }

    public C1402z3(A3 a3, CounterConfiguration counterConfiguration) {
        this.a = a3;
        this.b = counterConfiguration;
    }
}

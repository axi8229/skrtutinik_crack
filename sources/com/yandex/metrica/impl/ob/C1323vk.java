package com.yandex.metrica.impl.ob;

import android.util.Pair;
import com.yandex.metrica.impl.ob.C1228rl;

/* renamed from: com.yandex.metrica.impl.ob.vk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1323vk {
    private final C1182pm<C1347wk, Pair<Boolean, C1228rl.b>> a;
    private final int b;

    C1323vk(int i, int i2) {
        this.a = new C1371xk(i);
        this.b = i2;
    }

    void a(int i, String str, boolean z, C1228rl.b bVar) {
        if (str.length() <= this.b) {
            this.a.a(new C1347wk(i, str), new Pair<>(Boolean.valueOf(z), bVar));
        }
    }

    Pair<Boolean, C1228rl.b> a(int i, String str) {
        if (str.length() > this.b) {
            return null;
        }
        return this.a.a((C1182pm<C1347wk, Pair<Boolean, C1228rl.b>>) new C1347wk(i, str));
    }

    void a() {
        this.a.a();
    }
}

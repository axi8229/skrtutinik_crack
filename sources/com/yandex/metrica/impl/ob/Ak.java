package com.yandex.metrica.impl.ob;

import android.util.Pair;
import com.yandex.metrica.impl.ob.C1228rl;

/* loaded from: classes3.dex */
class Ak {
    private final C1005ik a;
    private final C1323vk b;
    private final int c;

    Ak(AbstractC1395yk<?> abstractC1395yk, int i) {
        this(abstractC1395yk, i, new C1005ik(abstractC1395yk.b()));
    }

    C1228rl.b a(String str) {
        if (str == null) {
            return null;
        }
        Pair<Boolean, C1228rl.b> pairA = this.b.a(this.c, str);
        if (pairA != null) {
            return (C1228rl.b) pairA.second;
        }
        C1228rl.b bVarA = this.a.a(str);
        this.b.a(this.c, str, bVarA != null, bVarA);
        return bVarA;
    }

    Ak(AbstractC1395yk<?> abstractC1395yk, int i, C1005ik c1005ik) {
        this.c = i;
        this.a = c1005ik;
        this.b = abstractC1395yk.a();
    }
}

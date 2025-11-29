package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes3.dex */
class N1 implements Runnable {
    private final Context a;
    private final C0836c0 b;
    private final Bundle c;
    private final C1014j4 d;

    N1(Context context, C0836c0 c0836c0, Bundle bundle, C1014j4 c1014j4) {
        this.a = context;
        this.b = c0836c0;
        this.c = bundle;
        this.d = c1014j4;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1402z3 c1402z3 = new C1402z3(this.c);
        if (C1402z3.a(c1402z3, this.a)) {
            return;
        }
        C0990i4 c0990i4A = C0990i4.a(c1402z3);
        D3 d3 = new D3(c1402z3);
        this.d.a(c0990i4A, d3).a(this.b, d3);
    }
}

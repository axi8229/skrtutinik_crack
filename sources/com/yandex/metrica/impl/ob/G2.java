package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
class G2 implements InterfaceC1082lm<Context, Intent, Void> {
    final /* synthetic */ V a;
    final /* synthetic */ CountDownLatch b;
    final /* synthetic */ H2 c;

    G2(H2 h2, V v, CountDownLatch countDownLatch) {
        this.c = h2;
        this.a = v;
        this.b = countDownLatch;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1082lm
    public Void a(Context context, Intent intent) {
        this.a.a(this.c.c());
        this.b.countDown();
        this.c.k.b(this);
        return null;
    }
}

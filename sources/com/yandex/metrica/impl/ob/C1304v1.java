package com.yandex.metrica.impl.ob;

import android.content.Intent;
import com.yandex.metrica.impl.ob.A1;

/* renamed from: com.yandex.metrica.impl.ob.v1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1304v1 implements A1.e {
    final /* synthetic */ C1208r1 a;

    C1304v1(C1208r1 c1208r1) {
        this.a = c1208r1;
    }

    @Override // com.yandex.metrica.impl.ob.A1.e
    public void a(Intent intent) {
        if (this.a.a != null) {
            C1208r1 c1208r1 = this.a;
            C1208r1.b(c1208r1, c1208r1.a);
            C1208r1.d(this.a);
            this.a.e.a(this.a.a);
        }
    }
}

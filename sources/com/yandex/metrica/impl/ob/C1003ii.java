package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import com.yandex.metrica.impl.ob.ResultReceiverC0911f0;

/* renamed from: com.yandex.metrica.impl.ob.ii, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1003ii implements ResultReceiverC0911f0.a {
    final /* synthetic */ Yh a;
    final /* synthetic */ C0979hi b;

    C1003ii(C0979hi c0979hi, Yh yh) {
        this.b = c0979hi;
        this.a = yh;
    }

    @Override // com.yandex.metrica.impl.ob.ResultReceiverC0911f0.a
    public void a(int i, Bundle bundle) {
        this.b.a(bundle, this.a);
    }
}

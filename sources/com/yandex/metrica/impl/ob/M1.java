package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes3.dex */
class M1 {
    private final InterfaceC1161p1 a;
    private final com.yandex.metrica.rtm.wrapper.f b;

    M1(InterfaceC1161p1 interfaceC1161p1, Context context) {
        this(interfaceC1161p1, new Zg().b(context));
    }

    void a(int i, Bundle bundle) {
        if (i == 1) {
            this.a.reportData(bundle);
        } else {
            if (i != 2) {
                return;
            }
            this.b.reportData(bundle);
        }
    }

    M1(InterfaceC1161p1 interfaceC1161p1, com.yandex.metrica.rtm.wrapper.f fVar) {
        this.a = interfaceC1161p1;
        this.b = fVar;
    }
}

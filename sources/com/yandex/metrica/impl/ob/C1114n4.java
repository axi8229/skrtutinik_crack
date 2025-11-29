package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;

/* renamed from: com.yandex.metrica.impl.ob.n4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1114n4 implements K, InterfaceC1039k4 {
    private F3 a;
    private final ResultReceiver b;

    public C1114n4(Context context, F3 f3, D3 d3) {
        this.a = f3;
        this.b = d3.c;
        f3.a(this);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1039k4
    public void a(C0836c0 c0836c0, D3 d3) {
        this.a.a(d3.b);
        this.a.a(c0836c0, this);
    }

    public F3 b() {
        return this.a;
    }

    @Override // com.yandex.metrica.impl.ob.K
    public void a(L l) {
        ResultReceiver resultReceiver = this.b;
        int i = ResultReceiverC0911f0.b;
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            l.c(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1039k4
    public void a() {
        this.a.b(this);
    }
}

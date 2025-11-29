package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* loaded from: classes3.dex */
public class Xj extends AbstractC1203qj {
    private int a;
    private AbstractC1203qj b;

    public Xj(Context context, ICommonExecutor iCommonExecutor) {
        this(context.getApplicationContext(), new C1108mn(), iCommonExecutor);
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public synchronized void a() {
        int i = this.a + 1;
        this.a = i;
        if (i == 1) {
            this.b.a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public synchronized void b() {
        int i = this.a - 1;
        this.a = i;
        if (i == 0) {
            this.b.b();
        }
    }

    Xj(Context context, C1108mn c1108mn, ICommonExecutor iCommonExecutor) {
        if (c1108mn.a(context, "android.hardware.telephony")) {
            this.b = new Ij(context, iCommonExecutor);
        } else {
            this.b = new Kj();
        }
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public synchronized void a(InterfaceC0806ak interfaceC0806ak) {
        this.b.a(interfaceC0806ak);
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public synchronized void a(InterfaceC1322vj interfaceC1322vj) {
        this.b.a(interfaceC1322vj);
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public void a(boolean z) {
        this.b.a(z);
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public void a(C1178pi c1178pi) {
        this.b.a(c1178pi);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1122nc
    public void a(C1097mc c1097mc) {
        this.b.a(c1097mc);
    }
}

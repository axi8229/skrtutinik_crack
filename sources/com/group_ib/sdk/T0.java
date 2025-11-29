package com.group_ib.sdk;

import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public final class T0 implements d1 {
    public final MobileSdkService a;
    public final b1 b = new b1();
    public final P0 c;
    public final K0 d;
    public final LinkedList e;

    public T0(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
        this.c = new P0(mobileSdkService);
        K0 k0 = new K0(mobileSdkService);
        this.d = k0;
        LinkedList linkedList = new LinkedList();
        this.e = linkedList;
        linkedList.add(new K0(mobileSdkService));
        linkedList.add(new X0(mobileSdkService));
        linkedList.add(new M0(mobileSdkService));
        linkedList.add(new G0(mobileSdkService));
        linkedList.add(new D0(mobileSdkService));
        linkedList.add(new V0(mobileSdkService));
        linkedList.add(k0);
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
    }

    @Override // com.group_ib.sdk.d1
    public final void a(int i) {
        if (i == 4 || i == 8 || i == 16 || i == 32 || i == 256) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                B0 b0 = (B0) it.next();
                b1 b1Var = this.b;
                if (b0.a(i)) {
                    b0.a(b1Var);
                    b0.d = System.currentTimeMillis();
                }
            }
            this.a.a(this.b, false);
        }
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
        this.c.a(this.b);
        this.d.a(this.b);
        this.a.a(this.b, true);
    }
}

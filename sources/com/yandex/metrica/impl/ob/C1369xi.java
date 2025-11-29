package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.NetworkServiceLocator;
import com.yandex.metrica.networktasks.api.NetworkTask;

/* renamed from: com.yandex.metrica.impl.ob.xi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1369xi implements InterfaceC1393yi {
    private final C1225ri a;

    public C1369xi(C1225ri c1225ri) {
        this.a = c1225ri;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1393yi
    public void a() {
        NetworkTask networkTaskC = this.a.c();
        if (networkTaskC != null) {
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTaskC);
        }
    }
}

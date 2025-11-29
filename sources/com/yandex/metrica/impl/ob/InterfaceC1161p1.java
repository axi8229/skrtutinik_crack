package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.os.RemoteException;
import com.yandex.metrica.MetricaService;

/* renamed from: com.yandex.metrica.impl.ob.p1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC1161p1 extends B1 {
    void a(int i, Bundle bundle);

    void a(Bundle bundle);

    void a(MetricaService.d dVar);

    @Deprecated
    void a(String str, int i, String str2, Bundle bundle) throws RemoteException;

    void b(Bundle bundle);

    void reportData(Bundle bundle);
}

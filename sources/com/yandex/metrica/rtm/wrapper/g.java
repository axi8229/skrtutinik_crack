package com.yandex.metrica.rtm.wrapper;

import com.yandex.metrica.rtm.client.DataSender;
import com.yandex.metrica.rtm.client.ReporterDescriptor;

/* loaded from: classes3.dex */
public class g implements d {
    private final DataSender a;

    public g(k kVar, String str, boolean z) throws Throwable {
        this(new b(new DataSender(new m(kVar), new ReporterDescriptor(str, z))));
    }

    g(b bVar) throws Throwable {
        this.a = bVar.a();
    }
}

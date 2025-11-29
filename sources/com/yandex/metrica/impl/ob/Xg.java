package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Xg implements A6 {
    private final com.yandex.metrica.rtm.wrapper.e a;

    public Xg(com.yandex.metrica.rtm.wrapper.e eVar) {
        this.a = eVar;
    }

    @Override // com.yandex.metrica.impl.ob.A6
    public void a(Throwable th, C1333w6 c1333w6) {
        this.a.reportException(th == null ? "" : th.getClass().getName(), th);
    }
}

package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.oa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1145oa implements InterfaceC1337wa {
    private final InterfaceC0833bm a;

    public C1145oa(InterfaceC0833bm interfaceC0833bm) {
        this.a = interfaceC0833bm;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1337wa
    public long a(Z8 z8) {
        return z8.a(new Rd("LAST_ACTIVATION_DIAGNOSTICS_SENT_TIME_" + ((Xl) this.a).b(), null).a(), Long.MAX_VALUE);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1337wa
    public void a(Z8 z8, long j) {
    }
}

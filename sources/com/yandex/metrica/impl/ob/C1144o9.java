package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.o9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1144o9 extends AbstractC0970h9 {
    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object defaultValue() {
        return new Ff();
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object toState(byte[] bArr) throws IOException {
        return (Ff) MessageNano.mergeFrom(new Ff(), bArr);
    }
}

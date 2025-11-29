package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public class Zd extends AbstractC0970h9 {
    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object defaultValue() {
        return new Cf();
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object toState(byte[] bArr) throws IOException {
        return (Cf) MessageNano.mergeFrom(new Cf(), bArr);
    }
}

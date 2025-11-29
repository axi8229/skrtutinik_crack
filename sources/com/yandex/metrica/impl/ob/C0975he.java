package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.impl.ob.Cf;
import java.io.IOException;

@Deprecated
/* renamed from: com.yandex.metrica.impl.ob.he, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0975he extends AbstractC0970h9 {
    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object defaultValue() {
        return new Cf.a();
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object toState(byte[] bArr) throws IOException {
        return (Cf.a) MessageNano.mergeFrom(new Cf.a(), bArr);
    }
}

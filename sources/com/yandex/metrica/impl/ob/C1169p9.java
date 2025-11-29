package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.impl.ob.If;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.p9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1169p9 extends AbstractC0970h9 {
    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object defaultValue() {
        If r0 = new If();
        r0.k = new If.i();
        return r0;
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object toState(byte[] bArr) throws IOException {
        return (If) MessageNano.mergeFrom(new If(), bArr);
    }
}

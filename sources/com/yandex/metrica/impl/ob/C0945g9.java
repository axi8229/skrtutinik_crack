package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.g9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0945g9 extends AbstractC0970h9 {
    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object defaultValue() {
        return new C1342wf();
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object toState(byte[] bArr) throws IOException {
        return (C1342wf) MessageNano.mergeFrom(new C1342wf(), bArr);
    }
}

package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.core.api.ProtobufStateSerializer;

/* renamed from: com.yandex.metrica.impl.ob.h9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0970h9 implements ProtobufStateSerializer {
    @Override // com.yandex.metrica.core.api.StateSerializer
    public abstract /* synthetic */ Object defaultValue();

    @Override // com.yandex.metrica.core.api.StateSerializer
    public byte[] toByteArray(Object obj) {
        return MessageNano.toByteArray((MessageNano) obj);
    }

    @Override // com.yandex.metrica.core.api.StateSerializer
    public abstract /* synthetic */ Object toState(byte[] bArr);
}

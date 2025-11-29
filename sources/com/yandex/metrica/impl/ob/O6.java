package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.core.api.ProtobufConverter;

/* loaded from: classes3.dex */
public class O6<T> {
    private final ProtobufConverter a;

    O6(ProtobufConverter protobufConverter) {
        this.a = protobufConverter;
    }

    public byte[] a(T t) {
        return MessageNano.toByteArray((MessageNano) this.a.fromModel(t));
    }
}

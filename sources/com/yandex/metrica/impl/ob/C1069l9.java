package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.core.api.ProtobufStateSerializer;
import com.yandex.metrica.core.api.ProtobufStateStorage;

/* renamed from: com.yandex.metrica.impl.ob.l9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1069l9 implements ProtobufStateStorage {
    private final String a;
    private final R7 b;
    private final ProtobufStateSerializer c;
    private final ProtobufConverter d;

    public C1069l9(String str, R7 r7, ProtobufStateSerializer protobufStateSerializer, ProtobufConverter protobufConverter) {
        this.a = str;
        this.b = r7;
        this.c = protobufStateSerializer;
        this.d = protobufConverter;
    }

    @Override // com.yandex.metrica.core.api.ProtobufStateStorage
    public void delete() {
        this.b.b(this.a);
    }

    @Override // com.yandex.metrica.core.api.ProtobufStateStorage
    public Object read() {
        try {
            byte[] bArrA = this.b.a(this.a);
            return A2.a(bArrA) ? this.d.toModel(this.c.defaultValue()) : this.d.toModel(this.c.toState(bArrA));
        } catch (Throwable unused) {
            return this.d.toModel(this.c.defaultValue());
        }
    }

    @Override // com.yandex.metrica.core.api.ProtobufStateStorage
    public void save(Object obj) {
        this.b.a(this.a, this.c.toByteArray(this.d.fromModel(obj)));
    }
}

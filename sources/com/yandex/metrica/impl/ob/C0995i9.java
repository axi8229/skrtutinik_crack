package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.i9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0995i9 extends AbstractC0970h9 {
    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object defaultValue() {
        return new C1390yf();
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0970h9, com.yandex.metrica.core.api.StateSerializer
    public Object toState(byte[] bArr) {
        C1390yf c1390yf = (C1390yf) MessageNano.mergeFrom(new C1390yf(), bArr);
        Intrinsics.checkNotNullExpressionValue(c1390yf, "ClidsInfoProto.ClidsInfo.parseFrom(data)");
        return c1390yf;
    }
}

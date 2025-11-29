package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;

/* renamed from: com.yandex.metrica.impl.ob.ga, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0946ga<T> implements InterfaceC0921fa<T> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC0921fa
    public ProtobufStateStorage a(Context context) {
        return a(context, c(context));
    }

    protected abstract ProtobufStateStorage a(Context context, R7 r7);

    @Override // com.yandex.metrica.impl.ob.InterfaceC0921fa
    public ProtobufStateStorage b(Context context) {
        return a(context, d(context));
    }

    protected abstract R7 c(Context context);

    protected abstract R7 d(Context context);
}

package ru.yoomoney.sdk.kassa.payments.api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;

/* loaded from: classes5.dex */
public final class g implements ParameterizedType {
    public final Type a;

    public g(Type dataType) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        this.a = dataType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return new Type[]{this.a};
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return Call.class;
    }
}

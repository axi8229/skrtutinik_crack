package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.kassa.payments.api.JacksonBaseObjectMapperKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2268b implements Factory {
    public final C2267a a;

    public C2268b(C2267a c2267a) {
        this.a = c2267a;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (ru.yoomoney.sdk.kassa.payments.api.failures.a) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.api.failures.b(JacksonBaseObjectMapperKt.getJacksonBaseObjectMapper()));
    }
}

package ru.yoomoney.sdk.kassa.payments.config;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.Config;

/* loaded from: classes5.dex */
public final class g implements f {
    public final Config a;

    public g(Config getDefaultConfig) {
        Intrinsics.checkNotNullParameter(getDefaultConfig, "getDefaultConfig");
        this.a = getDefaultConfig;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.config.f
    public final Config a() {
        return this.a;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.config.f
    public final Object a(Continuation continuation) {
        Result.Companion companion = Result.INSTANCE;
        return Result.m2628constructorimpl(this.a);
    }
}

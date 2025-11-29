package ru.yoomoney.sdk.kassa.payments.di.module;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;
import ru.yoomoney.sdk.kassa.payments.model.C2331o;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2274h implements ru.yoomoney.sdk.kassa.payments.payment.b {
    public AbstractC2336u a = new C2331o();

    @Override // ru.yoomoney.sdk.kassa.payments.payment.b
    public final AbstractC2336u a() {
        return this.a;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.b
    public final void a(AbstractC2336u abstractC2336u) {
        Intrinsics.checkNotNullParameter(abstractC2336u, "<set-?>");
        this.a = abstractC2336u;
    }
}

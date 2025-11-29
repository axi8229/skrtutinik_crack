package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.m1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2433m1 extends Lambda implements Function1 {
    public final /* synthetic */ long a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2433m1(long j) {
        super(1);
        this.a = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Long.valueOf(RangesKt.coerceAtLeast(((Number) obj).longValue() - this.a, 0L));
    }
}

package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C2492l extends FunctionReferenceImpl implements Function1 {
    public C2492l(Integer num) {
        super(1, num, Integer.TYPE, "plus", "plus(I)I", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Integer.valueOf(((Number) this.receiver).intValue() + ((Number) obj).intValue());
    }
}

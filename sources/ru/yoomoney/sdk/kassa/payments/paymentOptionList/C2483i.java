package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2483i extends Lambda implements Function0 {
    public final /* synthetic */ C2495m a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2483i(C2495m c2495m) {
        super(0);
        this.a = c2495m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Integer.valueOf(this.a.d.nextInt(10));
    }
}

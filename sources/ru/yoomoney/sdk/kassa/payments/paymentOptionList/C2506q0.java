package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.q0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2506q0 extends AbstractC2499n0 {
    public final List a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2506q0(List options) {
        super(0);
        Intrinsics.checkNotNullParameter(options, "options");
        this.a = options;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentOptionList.AbstractC2499n0
    public final List a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2506q0) && Intrinsics.areEqual(this.a, ((C2506q0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PaymentOptionListSuccessOutputModel(options=" + this.a + ")";
    }
}

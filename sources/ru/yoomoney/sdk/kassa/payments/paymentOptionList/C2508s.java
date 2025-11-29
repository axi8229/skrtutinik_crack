package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2508s extends C {
    public final AbstractC2499n0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2508s(AbstractC2499n0 content) {
        super(0);
        Intrinsics.checkNotNullParameter(content, "content");
        this.a = content;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2508s) && Intrinsics.areEqual(this.a, ((C2508s) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LoadPaymentOptionListSuccess(content=" + this.a + ")";
    }
}

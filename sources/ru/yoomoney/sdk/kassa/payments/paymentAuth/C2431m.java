package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2321e;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2431m {
    public final AbstractC2330n[] a;
    public final EnumC2321e b;

    public C2431m(EnumC2321e defaultAuthType, AbstractC2330n[] authTypeStates) {
        Intrinsics.checkNotNullParameter(authTypeStates, "authTypeStates");
        Intrinsics.checkNotNullParameter(defaultAuthType, "defaultAuthType");
        this.a = authTypeStates;
        this.b = defaultAuthType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(C2431m.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.paymentAuth.CheckoutAuthContextGetResponse");
        C2431m c2431m = (C2431m) obj;
        return Arrays.equals(this.a, c2431m.a) && this.b == c2431m.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (Arrays.hashCode(this.a) * 31);
    }

    public final String toString() {
        return super.toString();
    }
}

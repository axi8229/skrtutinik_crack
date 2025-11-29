package ru.yoomoney.sdk.kassa.payments.navigation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l extends v {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String errorDescription) {
        super(0);
        Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
        this.a = errorDescription;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && Intrinsics.areEqual(this.a, ((l) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SberPaySdkConfirmationFailed(errorDescription=" + this.a + ")";
    }
}

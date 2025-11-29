package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import android.content.ActivityNotFoundException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2342a extends o {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2342a(ActivityNotFoundException throwable) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.a = throwable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2342a) && Intrinsics.areEqual(this.a, ((C2342a) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ActivityNotFound(throwable=" + this.a + ")";
    }
}

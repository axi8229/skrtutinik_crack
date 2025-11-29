package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class S0 extends V0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S0(String title, String subtitle, String screenTitle, String screenText) {
        super(0);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(screenTitle, "screenTitle");
        Intrinsics.checkNotNullParameter(screenText, "screenText");
        this.a = title;
        this.b = subtitle;
        this.c = screenTitle;
        this.d = screenText;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S0)) {
            return false;
        }
        S0 s0 = (S0) obj;
        return Intrinsics.areEqual(this.a, s0.a) && Intrinsics.areEqual(this.b, s0.b) && Intrinsics.areEqual(this.c, s0.c) && Intrinsics.areEqual(this.d, s0.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "MessageSavePaymentMethodOption(title=" + this.a + ", subtitle=" + this.b + ", screenTitle=" + this.c + ", screenText=" + this.d + ")";
    }
}

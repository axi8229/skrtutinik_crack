package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class M2 extends Z2 {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M2(String phone) {
        super(0);
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.a = phone;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof M2) && Intrinsics.areEqual(this.a, ((M2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return Q1.a(new StringBuilder("OneTimePassword(phone="), this.a, ')');
    }
}

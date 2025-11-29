package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class X8 extends AbstractC1687j9 {
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X8(String phone) {
        super(phone, 0);
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.b = phone;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof X8) && Intrinsics.areEqual(this.b, ((X8) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return Q1.a(new StringBuilder("ConfirmSuccess(phone="), this.b, ')');
    }
}

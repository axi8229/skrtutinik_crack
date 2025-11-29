package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.e9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1563e9 extends AbstractC1687j9 {
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1563e9(String phone) {
        super(phone, 0);
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.b = phone;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1563e9) && Intrinsics.areEqual(this.b, ((C1563e9) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return Q1.a(new StringBuilder("CreateOtpSuccess(phone="), this.b, ')');
    }
}

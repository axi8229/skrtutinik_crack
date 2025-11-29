package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.f9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1588f9 extends AbstractC1687j9 {
    public final Bk b;
    public final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1588f9(Bk description, String phone) {
        super(phone, 0);
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.b = description;
        this.c = phone;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1588f9)) {
            return false;
        }
        C1588f9 c1588f9 = (C1588f9) obj;
        return Intrinsics.areEqual(this.b, c1588f9.b) && Intrinsics.areEqual(this.c, c1588f9.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreateOtpSystemOrInternalError(description=");
        sb.append(this.b);
        sb.append(", phone=");
        return Q1.a(sb, this.c, ')');
    }
}

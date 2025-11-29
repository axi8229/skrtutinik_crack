package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.d9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1538d9 extends AbstractC1687j9 {
    public final Bk b;
    public final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1538d9(Bk description, String phone) {
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
        if (!(obj instanceof C1538d9)) {
            return false;
        }
        C1538d9 c1538d9 = (C1538d9) obj;
        return Intrinsics.areEqual(this.b, c1538d9.b) && Intrinsics.areEqual(this.c, c1538d9.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreateOtpOrderNotFoundError(description=");
        sb.append(this.b);
        sb.append(", phone=");
        return Q1.a(sb, this.c, ')');
    }
}

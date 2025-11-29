package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.a9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1463a9 extends AbstractC1687j9 {
    public final Bk b;
    public final String c;

    public C1463a9(Bk description, String phone) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.b = description;
        this.c = phone;
    }

    public final Bk b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1463a9)) {
            return false;
        }
        C1463a9 c1463a9 = (C1463a9) obj;
        return Intrinsics.areEqual(this.b, c1463a9.b) && Intrinsics.areEqual(this.c, c1463a9.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfirmWrongCode(description=");
        sb.append(this.b);
        sb.append(", phone=");
        return Q1.a(sb, this.c, ')');
    }
}

package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class W8 extends AbstractC1687j9 {
    public final Bk b;
    public final String c;

    public W8(Bk description, String phone) {
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
        if (!(obj instanceof W8)) {
            return false;
        }
        W8 w8 = (W8) obj;
        return Intrinsics.areEqual(this.b, w8.b) && Intrinsics.areEqual(this.c, w8.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfirmCodeLifetimeExpired(description=");
        sb.append(this.b);
        sb.append(", phone=");
        return Q1.a(sb, this.c, ')');
    }
}

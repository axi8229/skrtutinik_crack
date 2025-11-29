package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class V8 extends AbstractC1687j9 {
    public final Bk b;
    public final String c;

    public V8(Bk description, String phone) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.b = description;
        this.c = phone;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V8)) {
            return false;
        }
        V8 v8 = (V8) obj;
        return Intrinsics.areEqual(this.b, v8.b) && Intrinsics.areEqual(this.c, v8.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfirmAttemptsExhausted(description=");
        sb.append(this.b);
        sb.append(", phone=");
        return Q1.a(sb, this.c, ')');
    }
}

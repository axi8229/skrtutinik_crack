package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class O4 {
    public final String a;

    public O4(String str) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof O4) && Intrinsics.areEqual(this.a, ((O4) obj).a);
    }

    public final int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return Q1.a(new StringBuilder("ClientData(bankLogo="), this.a, ')');
    }
}

package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S1 extends AbstractC1855q2 {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S1(String description) {
        super(0);
        Intrinsics.checkNotNullParameter(description, "description");
        this.a = description;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof S1) && Intrinsics.areEqual(this.a, ((S1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return Q1.a(new StringBuilder("Exception(description="), this.a, ')');
    }
}

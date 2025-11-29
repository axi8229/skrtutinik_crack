package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Xn extends co {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xn(String localSessionId) {
        super(0);
        Intrinsics.checkNotNullParameter(localSessionId, "localSessionId");
        this.a = localSessionId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Xn) && Intrinsics.areEqual(this.a, ((Xn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return Q1.a(new StringBuilder("SetLocalSessionId(localSessionId="), this.a, ')');
    }
}

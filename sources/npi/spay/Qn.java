package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Qn extends co {
    public final Ka a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qn(Ka result) {
        super(0);
        Intrinsics.checkNotNullParameter(result, "result");
        this.a = result;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Qn) && Intrinsics.areEqual(this.a, ((Qn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleRevokeTokenResult(result=" + this.a + ')';
    }
}

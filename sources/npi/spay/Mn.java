package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Mn extends co {
    public final AbstractC1855q2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mn(AbstractC1855q2 exception) {
        super(0);
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.a = exception;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mn) && Intrinsics.areEqual(this.a, ((Mn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleException(exception=" + this.a + ')';
    }
}

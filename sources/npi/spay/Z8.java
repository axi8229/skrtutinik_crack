package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Z8 extends AbstractC1687j9 {
    public final Bk b;

    public Z8(Bk description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.b = description;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Z8) && Intrinsics.areEqual(this.b, ((Z8) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ConfirmValidationError(description=" + this.b + ')';
    }
}

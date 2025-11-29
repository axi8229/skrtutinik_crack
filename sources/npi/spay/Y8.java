package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Y8 extends AbstractC1687j9 {
    public final Bk b;

    public Y8(Bk description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.b = description;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Y8) && Intrinsics.areEqual(this.b, ((Y8) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ConfirmSystemOrInternalError(description=" + this.b + ')';
    }
}

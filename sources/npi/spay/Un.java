package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Un extends co {
    public final J7 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Un(J7 effect) {
        super(0);
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.a = effect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Un) && Intrinsics.areEqual(this.a, ((Un) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PerformCreateOtpSdkAction(effect=" + this.a + ')';
    }
}

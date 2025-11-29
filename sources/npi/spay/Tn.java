package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Tn extends co {
    public final C1610g6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tn(C1610g6 effect) {
        super(0);
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.a = effect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Tn) && Intrinsics.areEqual(this.a, ((Tn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PerformConfirmOtpCodeAction(effect=" + this.a + ')';
    }
}

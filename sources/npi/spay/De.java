package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class De extends IllegalStateException {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public De(String state) {
        super("Wrong Outcome state: " + state);
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = state;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof De) && Intrinsics.areEqual(this.a, ((De) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return Q1.a(new StringBuilder("WrongOutcomeState(state="), this.a, ')');
    }
}

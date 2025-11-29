package npi.spay;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ia extends Ka {
    public final Function0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ia(Gd effect) {
        super(0);
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.a = effect;
    }

    @Override // npi.spay.Ka
    public final Function0 a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Ia) && Intrinsics.areEqual(this.a, ((Ia) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RevokeFail(effect=" + this.a + ')';
    }
}

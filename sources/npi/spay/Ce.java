package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ce {
    public final String a;
    public final Gd b;

    public Ce(String authorization, Gd effect) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.a = authorization;
        this.b = effect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ce)) {
            return false;
        }
        Ce ce = (Ce) obj;
        return Intrinsics.areEqual(this.a, ce.a) && Intrinsics.areEqual(this.b, ce.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "RevokeRefreshTokenUseCaseParams(authorization=" + this.a + ", effect=" + this.b + ')';
    }
}

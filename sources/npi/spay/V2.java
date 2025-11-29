package npi.spay;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class V2 extends Z2 {
    public final List a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V2(List authenticators) {
        super(0);
        Intrinsics.checkNotNullParameter(authenticators, "authenticators");
        this.a = authenticators;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof V2) && Intrinsics.areEqual(this.a, ((V2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return U0.a(new StringBuilder("ShowFullEmissionAuth(authenticators="), this.a, ')');
    }
}

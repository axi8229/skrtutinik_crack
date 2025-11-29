package npi.spay;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.dm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1551dm {
    public final List a;

    public C1551dm(List links) {
        Intrinsics.checkNotNullParameter(links, "links");
        this.a = links;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1551dm) && Intrinsics.areEqual(this.a, ((C1551dm) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return U0.a(new StringBuilder("GetAgreementLinksTitlesUseCaseRequestParams(links="), this.a, ')');
    }
}

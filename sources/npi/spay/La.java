package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class La extends IllegalStateException {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public La(String option) {
        super("Unknown option: ".concat(option));
        Intrinsics.checkNotNullParameter(option, "option");
        this.a = option;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof La) && Intrinsics.areEqual(this.a, ((La) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return Q1.a(new StringBuilder("UnknownFeatureOption(option="), this.a, ')');
    }
}

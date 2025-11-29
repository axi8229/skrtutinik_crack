package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class bo extends co {
    public final S6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(S6 helperScreenMode) {
        super(0);
        Intrinsics.checkNotNullParameter(helperScreenMode, "helperScreenMode");
        this.a = helperScreenMode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof bo) && Intrinsics.areEqual(this.a, ((bo) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ShowHelperScreen(helperScreenMode=" + this.a + ')';
    }
}

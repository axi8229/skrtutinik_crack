package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class In extends co {
    public final AbstractC1687j9 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public In(AbstractC1687j9 result) {
        super(0);
        Intrinsics.checkNotNullParameter(result, "result");
        this.a = result;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof In) && Intrinsics.areEqual(this.a, ((In) obj).a);
    }

    public final int hashCode() {
        return Long.hashCode(45000L) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "HandleCreateOtpSdkResult(result=" + this.a + ", timerTime=45000)";
    }
}

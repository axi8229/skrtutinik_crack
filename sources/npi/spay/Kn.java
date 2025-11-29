package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Kn extends co {
    public final AbstractC1727l a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kn(AbstractC1727l deviceCheckStatus) {
        super(0);
        Intrinsics.checkNotNullParameter(deviceCheckStatus, "deviceCheckStatus");
        this.a = deviceCheckStatus;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Kn) && Intrinsics.areEqual(this.a, ((Kn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleDeviceCheck(deviceCheckStatus=" + this.a + ')';
    }
}

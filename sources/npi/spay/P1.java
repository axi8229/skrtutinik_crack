package npi.spay;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class P1 extends AbstractC1855q2 {
    public final Map a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P1(Map notPassedDeviceParams) {
        super(0);
        Intrinsics.checkNotNullParameter(notPassedDeviceParams, "notPassedDeviceParams");
        this.a = notPassedDeviceParams;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof P1) && Intrinsics.areEqual(this.a, ((P1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DeviceFailedCheck(notPassedDeviceParams=" + this.a + ')';
    }
}

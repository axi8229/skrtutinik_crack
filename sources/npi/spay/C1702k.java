package npi.spay;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1702k extends AbstractC1727l {
    public final Map a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1702k(LinkedHashMap notPassedDeviceParams) {
        super(0);
        Intrinsics.checkNotNullParameter(notPassedDeviceParams, "notPassedDeviceParams");
        this.a = notPassedDeviceParams;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1702k) && Intrinsics.areEqual(this.a, ((C1702k) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DeviceFailedCheck(notPassedDeviceParams=" + this.a + ')';
    }
}

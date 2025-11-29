package npi.spay;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Vm {
    public final boolean a;
    public final LinkedHashMap b;

    public Vm(boolean z, LinkedHashMap notSuccessParams) {
        Intrinsics.checkNotNullParameter(notSuccessParams, "notSuccessParams");
        this.a = z;
        this.b = notSuccessParams;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vm)) {
            return false;
        }
        Vm vm = (Vm) obj;
        return this.a == vm.a && Intrinsics.areEqual(this.b, vm.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return this.b.hashCode() + (r0 * 31);
    }

    public final String toString() {
        return "DeviceCheckResult(isSecure=" + this.a + ", notSuccessParams=" + this.b + ')';
    }
}

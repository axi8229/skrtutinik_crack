package npi.spay;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class L2 extends Z2 {
    public final Function1 a;

    public L2(Function1 function1) {
        super(0);
        this.a = function1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof L2) && Intrinsics.areEqual(this.a, ((L2) obj).a);
    }

    public final int hashCode() {
        Function1 function1 = this.a;
        if (function1 == null) {
            return 0;
        }
        return function1.hashCode();
    }

    public final String toString() {
        return "NoInternetConnectionError(caller=" + this.a + ')';
    }
}

package npi.spay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Fd {
    public static final String a() {
        Intrinsics.checkNotNullParameter(C1815oc.a, "<this>");
        int i = C1815oc.b;
        if (i == 0) {
            throw null;
        }
        switch (i - 1) {
            case 0:
                return "PROD";
            case 1:
                return "PSI";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return "IFT";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

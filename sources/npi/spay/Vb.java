package npi.spay;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public abstract class Vb {
    public static String a() {
        int i = C1815oc.b;
        if (i == 0) {
            throw null;
        }
        switch (i - 1) {
            case 0:
                return "https://gate1.spaymentsplus.ru/";
            case 1:
                return "https://psi.gate1.spaymentsplus.ru/";
            case 2:
                return "https://ift.gate1.spaymentsplus.ru/";
            case 3:
            case 4:
                return "https://api.mocki.io/v2/071c7c55/";
            case 5:
            case 6:
                return "https://ift.gate2.spaymentsplus.ru/";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

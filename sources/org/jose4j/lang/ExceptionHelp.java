package org.jose4j.lang;

/* loaded from: classes4.dex */
public class ExceptionHelp {
    public static String toStringWithCauses(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th);
        while (th.getCause() != null) {
            th = th.getCause();
            sb.append("; caused by: ");
            sb.append(th);
        }
        return sb.toString();
    }
}

package bz;

import java.math.BigDecimal;
import java.util.Locale;

/* renamed from: bz.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0566x0 {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(double d) {
        return x0$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(String.format(Locale.ROOT, "%.10f", Double.valueOf(d)))).toPlainString();
    }

    public static String a(String str) {
        int length = str.length();
        if (length == 0) {
            return str;
        }
        if (length == 1) {
            return str.toUpperCase(Locale.ROOT);
        }
        return str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1);
    }
}

package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: npi.spay.zi, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2095zi {
    public static int a(Integer num) {
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final long a(Long l) {
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final String a(long j) {
        String strConcat;
        StringBuilder sb;
        int i = 0;
        boolean z = j < 0;
        String strRemovePrefix = StringsKt.removePrefix(String.valueOf(j), "-");
        if (strRemovePrefix.length() == 2 && j != 0) {
            strConcat = "0,".concat(strRemovePrefix);
            Intrinsics.checkNotNullParameter(strConcat, "<this>");
            if (!z) {
                return strConcat;
            }
            sb = new StringBuilder("-");
        } else if (strRemovePrefix.length() > 2 && j != 0) {
            strConcat = StringsKt.replaceRange(strRemovePrefix, strRemovePrefix.length() - 2, strRemovePrefix.length() - 2, ",").toString();
            for (int length = strConcat.length() - 4; -1 < length; length--) {
                i++;
                if (i != 0 && i % 3 == 0 && length != 0) {
                    strConcat = StringsKt.replaceRange(strConcat, length, length, " ").toString();
                }
            }
            if (strConcat.charAt(strConcat.length() - 1) == '0' && strConcat.charAt(strConcat.length() - 2) == '0') {
                strConcat = StringsKt.removeRange(strConcat, strConcat.length() - 3, strConcat.length()).toString();
            }
            Intrinsics.checkNotNullParameter(strConcat, "<this>");
            if (!z) {
                return strConcat;
            }
            sb = new StringBuilder("-");
        } else {
            if (j == 0) {
                return "0";
            }
            strConcat = strRemovePrefix.concat(",0");
            Intrinsics.checkNotNullParameter(strConcat, "<this>");
            if (!z) {
                return strConcat;
            }
            sb = new StringBuilder("-");
        }
        sb.append(strConcat);
        return sb.toString();
    }

    public static final boolean a(Integer num, int i) {
        return num != null && num.intValue() > i;
    }
}

package org.bouncycastle.pqc.crypto.qtesla;

/* loaded from: classes4.dex */
public class QTESLASecurityCategory {
    public static String getName(int i) {
        if (i == 5) {
            return "qTESLA-p-I";
        }
        if (i == 6) {
            return "qTESLA-p-III";
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }

    static int getPrivateSize(int i) {
        if (i == 5) {
            return 5224;
        }
        if (i == 6) {
            return 12392;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }

    static int getPublicSize(int i) {
        if (i == 5) {
            return 14880;
        }
        if (i == 6) {
            return 38432;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }
}

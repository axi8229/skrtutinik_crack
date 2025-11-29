package bz;

import java.util.Locale;

/* loaded from: classes.dex */
public enum U {
    TwiceZygoteInit(AbstractC0569y0.a(new byte[]{1, 15, -124, -11, 82, -119, -15, -5, 4, 60, 10, -80, -73, 36, -125, -112, -70, -50, -44, 99, -126, -75, 46, -40, -86, -30, -85, 45, 62, 42, 86, -13, 118, -103, -55, -95, 50, -99, 109, 100, 18, 30, -42, 97, 55, 35, -93, 12}), AbstractC0569y0.a(new byte[]{-3, 82, 117, -79, -115, 98, 9, 11, -72, -1, 49, -90, -44, -20, 96, -81}), true),
    /* JADX INFO: Fake field, exist only in values array */
    Xposed(AbstractC0569y0.a(new byte[]{-118, 118, -68, 101, -56, 72, 103, -68, -36, 31, 125, 16, 40, -22, 113, 111, 41, 84, -3, 42, -19, -109, -109, -126, -50, 7, 122, -74, -45, 43, 102, -39}), AbstractC0569y0.a(new byte[]{-20, 30, 104, -82, -20, -51, -67, 115, -85, 48, -12, -126, -116, -84, -2, -43}), false),
    /* JADX INFO: Fake field, exist only in values array */
    CydiaSubstrate(AbstractC0569y0.a(new byte[]{-67, 81, -110, -58, -51, 56, 76, -119, 28, 18, 7, 107, -101, -89, -36, -10, -3, 43, -11, 88, 9, 36, -5, 90, -61, 56, 79, -118, 78, -5, 49, 0}), AbstractC0569y0.a(new byte[]{-93, -6, -75, 16, -70, -80, 13, -110, 37, 36, -93, 88, -31, 32, -22, 52}), false);

    public final String a;
    public final String b;
    public final boolean c;

    U(String str, String str2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public static boolean a(U u, String str, String str2) {
        boolean zEquals = u.c ? str.equals(u.a) : str.contains(u.a);
        return (zEquals || str2 == null || u.b.isEmpty()) ? zEquals : str2.toLowerCase(Locale.ROOT).contains(u.b);
    }
}

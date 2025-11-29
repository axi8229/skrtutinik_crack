package bz;

import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class T {
    public static final T c;
    public static final T d;
    public static final /* synthetic */ T[] e;
    public final String a;
    public final String b;

    static {
        String strA = AbstractC0569y0.a(new byte[]{101, -104, -50, -66, -2, ByteSourceJsonBootstrapper.UTF8_BOM_1, -107, 49, 120, -19, 123, -95, 49, 77, -117, ByteSourceJsonBootstrapper.UTF8_BOM_3, -8, 56, 78, -45, -110, 120, -123, -89, -23, -128, -42, -16, -122, -50, -8, -78});
        String str = V.m;
        T t = new T("SearchSuBinary", 0, strA, str);
        c = t;
        T t2 = new T("SearchSuBinaryX", 1, AbstractC0569y0.a(new byte[]{102, -107, -56, -78, 2, 70, -116, 90, 40, -48, -62, -23, -40, -7, -54, -28, 82, -24, -91, -4, 32, 40, 17, -42, -125, -70, -118, -89, -85, -94, 99, -8}), str);
        d = t2;
        e = new T[]{t, t2};
    }

    public T(String str, int i, String str2, String str3) {
        this.a = str2;
        this.b = str3;
    }

    public static T valueOf(String str) {
        return (T) Enum.valueOf(T.class, str);
    }

    public static T[] values() {
        return (T[]) e.clone();
    }
}

package zone.bi.mobile.fingerprint.api;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class b {
    public static final b b;
    public static final /* synthetic */ b[] c;
    public final long a;

    /* JADX INFO: Fake field, exist only in values array */
    b EF0;

    /* JADX INFO: Fake field, exist only in values array */
    b EF1;

    /* JADX INFO: Fake field, exist only in values array */
    b EF2;

    static {
        b bVar = new b("CACHE_DISABLED", 0, 0L);
        b bVar2 = new b("TWENTY_SECONDS", 1, TimeUnit.SECONDS.toMillis(20L));
        TimeUnit timeUnit = TimeUnit.DAYS;
        b bVar3 = new b("ONE_DAY", 2, timeUnit.toMillis(1L));
        b bVar4 = new b("TWO_DAYS", 3, timeUnit.toMillis(2L));
        b = bVar4;
        c = new b[]{bVar, bVar2, bVar3, bVar4, new b("THREE_DAYS", 4, timeUnit.toMillis(3L)), new b("FOUR_DAYS", 5, timeUnit.toMillis(4L))};
    }

    public b(String str, int i, long j) {
        this.a = j;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) c.clone();
    }
}

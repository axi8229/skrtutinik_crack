package bz;

/* renamed from: bz.d1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0507d1 {
    public static C0519h1 a;

    public static synchronized C0519h1 a() {
        try {
            if (a == null) {
                a = new C0519h1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }
}

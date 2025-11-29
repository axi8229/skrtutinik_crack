package bz;

/* renamed from: bz.v0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0560v0 {
    public static void a(Process process) {
        if (process != null) {
            try {
                try {
                    process.exitValue();
                } catch (IllegalThreadStateException unused) {
                    process.destroy();
                }
            } catch (Throwable unused2) {
            }
        }
    }
}

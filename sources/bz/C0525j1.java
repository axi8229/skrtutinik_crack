package bz;

/* renamed from: bz.j1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0525j1 extends RuntimeException {
    public final N a;

    public C0525j1(N n) {
        this.a = n;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "\n\n\tCircular dependency detected:\n" + this.a;
    }
}

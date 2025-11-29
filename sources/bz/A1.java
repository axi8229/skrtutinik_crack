package bz;

/* loaded from: classes.dex */
public final class A1 extends R0 {
    public final /* synthetic */ C1 a;

    public A1(C1 c1) {
        this.a = c1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zB = C1.b(this.a);
        int iBooleanValue = zB;
        if (!zB) {
            iBooleanValue = C1.a(this.a);
        }
        if (iBooleanValue == 0) {
            C1 c1 = this.a;
            iBooleanValue = c1.c(c1.c.getPackageManager()).booleanValue();
        }
        this.a.a(Integer.valueOf(iBooleanValue));
    }
}

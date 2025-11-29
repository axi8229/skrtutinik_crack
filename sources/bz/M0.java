package bz;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class M0 extends R0 {
    public final /* synthetic */ N0 a;

    public M0(N0 n0) {
        this.a = n0;
    }

    public final /* synthetic */ Integer a() {
        return Integer.valueOf(this.a.c.getPackageManager().getInstalledPackages(0).size());
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a(String.valueOf((Integer) this.a.a(new Callable() { // from class: bz.M0$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.a();
                }
            })));
        } catch (Throwable unused) {
        }
    }
}

package bz;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public interface A0 {
    public static final long n = TimeUnit.DAYS.toMillis(999);

    /* JADX WARN: Multi-variable type inference failed */
    default Serializable a(long j) {
        C0572z0 c0572z0A = f().a(((AbstractC0538n1) this).a);
        if (c0572z0A == null || c0572z0A.b + j <= System.currentTimeMillis()) {
            return null;
        }
        return c0572z0A.a;
    }

    Z0 f();

    /* JADX WARN: Multi-variable type inference failed */
    default void a(Serializable serializable) {
        C0572z0 c0572z0;
        Z0 z0F = f();
        zone.bi.mobile.fingerprint.api.f fVar = ((AbstractC0538n1) this).a;
        if (serializable != null) {
            z0F.getClass();
            c0572z0 = new C0572z0(serializable);
        } else {
            c0572z0 = null;
        }
        z0F.a(fVar, c0572z0);
    }
}

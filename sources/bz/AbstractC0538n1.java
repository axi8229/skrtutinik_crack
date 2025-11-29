package bz;

import android.os.Build;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: bz.n1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0538n1 {
    public static final HashSet b = new HashSet();
    public final zone.bi.mobile.fingerprint.api.f a;

    public AbstractC0538n1(zone.bi.mobile.fingerprint.api.f fVar) {
        this.a = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a == ((AbstractC0538n1) obj).a;
    }

    public abstract Serializable h();

    public final int hashCode() {
        return this.a.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Serializable i() throws AbstractC0543p0 {
        try {
            if (this instanceof B0) {
                j();
            }
            if (this instanceof T0) {
                k();
            }
            if (this instanceof Q0) {
                int i = Build.VERSION.SDK_INT;
                if (28 < i) {
                    throw new C0564w1("this SDK version (" + i + ") is not supported parameter '" + this.a.name() + "'");
                }
            }
            return h();
        } catch (AbstractC0543p0 e) {
            throw e;
        } catch (Throwable th) {
            throw new zone.bi.mobile.fingerprint.api.a(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() throws ClassNotFoundException, C0564w1 {
        Iterator it = ((B0) this).c().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            HashSet hashSet = b;
            if (!hashSet.contains(str)) {
                try {
                    Class.forName(str);
                    hashSet.add(str);
                } catch (ClassNotFoundException | VerifyError unused) {
                    throw new C0564w1("External dependency '" + str + "' does not exists in the project");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k() throws H0 {
        T0 t0 = (T0) this;
        Iterator it = t0.e().iterator();
        while (it.hasNext()) {
            R1 r1 = (R1) it.next();
            if (!K0.a(t0.a(), r1.a)) {
                throw new H0(r1);
            }
        }
    }
}

package bz;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public interface P1 {
    default Object a(Callable callable) {
        mo2257b().getClass();
        try {
            return callable.call();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    zone.bi.mobile.fingerprint.api.settings.a mo2257b();
}

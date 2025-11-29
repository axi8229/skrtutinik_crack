package bz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: bz.r1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0549r1 extends Z0 {
    public final Map a = Collections.synchronizedMap(new HashMap());

    @Override // bz.Z0
    public final C0572z0 a(zone.bi.mobile.fingerprint.api.f fVar) {
        return (C0572z0) this.a.get(fVar);
    }

    @Override // bz.Z0
    public final void a(zone.bi.mobile.fingerprint.api.f fVar, C0572z0 c0572z0) {
        if (c0572z0 == null) {
            this.a.remove(fVar);
        } else {
            this.a.put(fVar, c0572z0);
        }
    }
}

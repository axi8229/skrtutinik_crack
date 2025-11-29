package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.yandex.metrica.impl.ob.mk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1105mk implements InterfaceC1372xl {
    private final M0 a;
    private final TimeProvider b;
    private Map<Long, Long> c;

    C1105mk() {
        this(C1152oh.a(), new SystemTimeProvider());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1372xl
    public synchronized void a(Activity activity, long j) {
        this.c.put(Long.valueOf(j), Long.valueOf(this.b.currentTimeMillis()));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1372xl
    public void a(Activity activity, boolean z) {
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public void a(Throwable th, C1348wl c1348wl) {
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public boolean a(C0932fl c0932fl) {
        return false;
    }

    C1105mk(M0 m0, TimeProvider timeProvider) {
        this.c = new HashMap();
        this.a = m0;
        this.b = timeProvider;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1324vl
    public synchronized void a(long j, Activity activity, C0882dl c0882dl, List<C1228rl> list, C0932fl c0932fl, Bk bk) {
        try {
            this.b.currentTimeMillis();
            if (this.c.get(Long.valueOf(j)) != null) {
                this.c.remove(Long.valueOf(j));
            } else {
                this.a.reportError("ui_parsing_diagnostics", new IllegalStateException("Unexpected situation: no start time"));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}

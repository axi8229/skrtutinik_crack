package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1326w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.ib, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0997ib {
    private Uh a;
    private C0947gb b;
    private final C1326w c;
    private final C0972hb d;

    /* renamed from: com.yandex.metrica.impl.ob.ib$a */
    static final class a implements C1326w.b {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.C1326w.b
        public final void a(C1326w.a aVar) {
            C0997ib.this.b();
        }
    }

    public C0997ib(C1326w c1326w, C0972hb c0972hb) {
        this.c = c1326w;
        this.d = c0972hb;
    }

    public synchronized void b(C1178pi c1178pi) {
        Uh uh;
        try {
            if (!Intrinsics.areEqual(c1178pi.m(), this.a)) {
                this.a = c1178pi.m();
                C0947gb c0947gb = this.b;
                if (c0947gb != null) {
                    c0947gb.a();
                }
                this.b = null;
                if (a() && this.b == null && (uh = this.a) != null) {
                    this.b = this.d.a(uh);
                }
            }
        } finally {
        }
    }

    public final synchronized void a(C1178pi c1178pi) {
        this.a = c1178pi.m();
        this.c.a(new a());
        b();
    }

    private final boolean a() {
        boolean zD;
        Uh uh = this.a;
        if (uh == null) {
            return false;
        }
        C1326w.a aVarC = this.c.c();
        Intrinsics.checkNotNullExpressionValue(aVarC, "applicationStateProvider.currentState");
        if (uh.c().length() <= 0) {
            return false;
        }
        int iOrdinal = aVarC.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            zD = uh.d();
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            zD = true;
        }
        return zD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void b() {
        Uh uh;
        try {
            boolean z = this.b != null;
            if (a() == z) {
                return;
            }
            if (z) {
                C0947gb c0947gb = this.b;
                if (c0947gb != null) {
                    c0947gb.a();
                }
                this.b = null;
                return;
            }
            if (this.b == null && (uh = this.a) != null) {
                this.b = this.d.a(uh);
            }
        } finally {
        }
    }
}

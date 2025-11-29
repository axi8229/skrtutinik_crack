package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* renamed from: com.yandex.metrica.impl.ob.gb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0947gb {
    private AbstractRunnableC0908em a;
    private volatile boolean b;
    private final ICommonExecutor c;

    /* renamed from: com.yandex.metrica.impl.ob.gb$a */
    public static final class a extends AbstractRunnableC0908em {
        final /* synthetic */ b b;
        final /* synthetic */ C1046kb c;
        final /* synthetic */ long d;

        a(b bVar, C1046kb c1046kb, long j) {
            this.b = bVar;
            this.c = c1046kb;
            this.d = j;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            if (C0947gb.this.b) {
                return;
            }
            this.b.a(true);
            this.c.a();
            C0947gb.this.c.executeDelayed(C0947gb.b(C0947gb.this), this.d, TimeUnit.SECONDS);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.gb$b */
    public static final class b {
        private volatile boolean a;

        public b(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public /* synthetic */ b(boolean z, int i) {
            this((i & 1) != 0 ? false : z);
        }

        public final void a(boolean z) {
            this.a = z;
        }
    }

    public C0947gb(Uh uh, b bVar, Random random, ICommonExecutor iCommonExecutor, C1046kb c1046kb) {
        this.c = iCommonExecutor;
        this.a = new a(bVar, c1046kb, uh.b());
        if (bVar.a()) {
            AbstractRunnableC0908em abstractRunnableC0908em = this.a;
            if (abstractRunnableC0908em == null) {
                Intrinsics.throwUninitializedPropertyAccessException("periodicRunnable");
            }
            abstractRunnableC0908em.run();
            return;
        }
        long jNextInt = random.nextInt(uh.a() + 1);
        AbstractRunnableC0908em abstractRunnableC0908em2 = this.a;
        if (abstractRunnableC0908em2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("periodicRunnable");
        }
        iCommonExecutor.executeDelayed(abstractRunnableC0908em2, jNextInt, TimeUnit.SECONDS);
    }

    public static final /* synthetic */ AbstractRunnableC0908em b(C0947gb c0947gb) {
        AbstractRunnableC0908em abstractRunnableC0908em = c0947gb.a;
        if (abstractRunnableC0908em == null) {
            Intrinsics.throwUninitializedPropertyAccessException("periodicRunnable");
        }
        return abstractRunnableC0908em;
    }

    public final void a() {
        this.b = true;
        ICommonExecutor iCommonExecutor = this.c;
        AbstractRunnableC0908em abstractRunnableC0908em = this.a;
        if (abstractRunnableC0908em == null) {
            Intrinsics.throwUninitializedPropertyAccessException("periodicRunnable");
        }
        iCommonExecutor.remove(abstractRunnableC0908em);
    }
}

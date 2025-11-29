package npi.spay;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.i1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1655i1 {
    public final T3 a;
    public final InterfaceC1548dj b;
    public final ArrayList c;
    public final Object d;
    public C1605g1 e;

    public C1655i1(T3 settings, InterfaceC1548dj timer) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(timer, "timer");
        this.a = settings;
        this.b = timer;
        this.c = new ArrayList();
        this.d = new Object();
        b();
    }

    public static final void a(C1655i1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    public final void b() {
        InterfaceC1548dj interfaceC1548dj = this.b;
        long j = this.a.e;
        Runnable runnable = new Runnable() { // from class: npi.spay.i1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C1655i1.a(this.f$0);
            }
        };
        L3 l3 = (L3) interfaceC1548dj;
        l3.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        l3.removeMessages(1);
        l3.a.put(1, runnable);
        l3.sendEmptyMessageDelayed(1, j);
    }

    public final void a() {
        C1605g1 c1605g1;
        synchronized (this.d) {
            try {
                if (!this.c.isEmpty() && (c1605g1 = this.e) != null) {
                    List events = CollectionsKt.toList(this.c);
                    this.c.clear();
                    Intrinsics.checkNotNullParameter(events, "events");
                    c1605g1.a.mo2240trySendJP2dKIU(events);
                }
                b();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes4.dex */
public final class D7 {
    public final C1655i1 a;
    public final S8 b;
    public final C1752m c;
    public final CoroutineScope d;

    public D7(C1655i1 eventsStorage, S8 networkDelegate, C1752m eventsPackageBuilder) {
        Intrinsics.checkNotNullParameter(eventsStorage, "eventsStorage");
        Intrinsics.checkNotNullParameter(networkDelegate, "networkDelegate");
        Intrinsics.checkNotNullParameter(eventsPackageBuilder, "eventsPackageBuilder");
        this.a = eventsStorage;
        this.b = networkDelegate;
        this.c = eventsPackageBuilder;
        this.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        a();
    }

    public final void a() {
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new C1785n7(this, null), 3, null);
    }
}

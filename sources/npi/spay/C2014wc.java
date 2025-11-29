package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* renamed from: npi.spay.wc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2014wc extends AbstractC1489ba {
    public final InterfaceC2073yl a;
    public final InterfaceC1495bg b;

    public C2014wc(InterfaceC2073yl sPayRepository, InterfaceC1495bg sPaySdkReducer) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.a = sPayRepository;
        this.b = sPaySdkReducer;
    }

    @Override // npi.spay.AbstractC1489ba
    public final Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default(null, 1, null)), new Fb(this, (Xd) obj, coroutineDispatcher, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}

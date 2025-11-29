package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes4.dex */
public final class E7 extends AbstractC1489ba {
    public final InterfaceC2073yl a;
    public final InterfaceC1495bg b;
    public final C1612g8 c;

    public E7(InterfaceC2073yl sPayRepository, InterfaceC1495bg sPaySdkReducer, C1612g8 fraudMonResultHandler) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(fraudMonResultHandler, "fraudMonResultHandler");
        this.a = sPayRepository;
        this.b = sPaySdkReducer;
        this.c = fraudMonResultHandler;
    }

    @Override // npi.spay.AbstractC1489ba
    public final Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default(null, 1, null)), new N6(this, (C1686j8) obj, coroutineDispatcher, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}

package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* renamed from: npi.spay.wd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2015wd extends AbstractC1489ba {
    public final InterfaceC2073yl a;
    public final InterfaceC1495bg b;

    public C2015wd(InterfaceC2073yl sPayRepository, Ei sPayStorage, InterfaceC1495bg sPaySdkReducer, Ih sPayDataContract) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        this.a = sPayRepository;
        this.b = sPaySdkReducer;
    }

    @Override // npi.spay.AbstractC1489ba
    public final Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default(null, 1, null)), new C1690jc(this, (Ce) obj, coroutineDispatcher, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}

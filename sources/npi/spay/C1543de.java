package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* renamed from: npi.spay.de, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1543de extends AbstractC1489ba {
    public final InterfaceC2073yl a;
    public final InterfaceC1713ka b;
    public final InterfaceC1495bg c;
    public final Ih d;
    public final C1993vg e;
    public final InterfaceC1728l0 f;

    public C1543de(InterfaceC2073yl sPayRepository, InterfaceC1713ka commonRepository, InterfaceC1495bg sPaySdkReducer, Ih sPayDataContract, C1993vg featuresHandler, InterfaceC1728l0 sPaySdkConfigRepository) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        this.a = sPayRepository;
        this.b = commonRepository;
        this.c = sPaySdkReducer;
        this.d = sPayDataContract;
        this.e = featuresHandler;
        this.f = sPaySdkConfigRepository;
    }

    @Override // npi.spay.AbstractC1489ba
    public final Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default(null, 1, null)), new Gc(this, (Ye) obj, coroutineDispatcher, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}

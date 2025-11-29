package npi.spay;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes4.dex */
public final class Z3 extends AbstractC1489ba {
    public final InterfaceC2073yl a;
    public final InterfaceC1495bg b;

    public Z3(InterfaceC2073yl sPayRepository, InterfaceC1495bg sPaySdkReducer) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.a = sPayRepository;
        this.b = sPaySdkReducer;
    }

    @Override // npi.spay.AbstractC1489ba
    public final Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        ((Jh) this.b).a(new C1900rn(new C1485b6(new C2097zk(R$string.spay_empty_string, CollectionsKt.emptyList()))));
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher, new C1681j3(this, (Y4) obj, coroutineDispatcher, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}

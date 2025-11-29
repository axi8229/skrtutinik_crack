package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* renamed from: npi.spay.k4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1707k4 implements Flow {
    public final /* synthetic */ StateFlow a;

    public C1707k4(StateFlow stateFlow) {
        this.a = stateFlow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.a.collect(new C1682j4(flowCollector), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}

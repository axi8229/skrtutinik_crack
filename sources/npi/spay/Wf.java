package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes4.dex */
public final class Wf implements Flow {
    public final /* synthetic */ StateFlow a;
    public final /* synthetic */ Xf b;
    public final /* synthetic */ Ih c;
    public final /* synthetic */ InterfaceC1728l0 d;

    public Wf(StateFlow stateFlow, Xf xf, Ih ih, InterfaceC1728l0 interfaceC1728l0) {
        this.a = stateFlow;
        this.b = xf;
        this.c = ih;
        this.d = interfaceC1728l0;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.a.collect(new Vf(flowCollector, this.b, this.c, this.d), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}

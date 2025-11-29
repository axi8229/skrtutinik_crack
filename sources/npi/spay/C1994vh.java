package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.vh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1994vh implements Flow {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ InterfaceC1728l0 b;

    public C1994vh(Flow flow, InterfaceC1728l0 interfaceC1728l0) {
        this.a = flow;
        this.b = interfaceC1728l0;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.a.collect(new C1969uh(flowCollector, this.b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}

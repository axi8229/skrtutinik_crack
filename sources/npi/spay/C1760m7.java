package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.m7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1760m7 implements Flow {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ D7 b;

    public C1760m7(Flow flow, D7 d7) {
        this.a = flow;
        this.b = d7;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.a.collect(new C1735l7(flowCollector, this.b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}

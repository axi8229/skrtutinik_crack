package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.yh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2069yh implements Flow {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ C2094zh b;

    public C2069yh(Flow flow, C2094zh c2094zh) {
        this.a = flow;
        this.b = c2094zh;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.a.collect(new C2044xh(flowCollector, this.b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}

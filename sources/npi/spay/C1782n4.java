package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.n4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1782n4 implements Flow {
    public final /* synthetic */ C1707k4 a;

    public C1782n4(C1707k4 c1707k4) {
        this.a = c1707k4;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.a.collect(new C1757m4(flowCollector), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}

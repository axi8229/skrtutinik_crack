package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* renamed from: npi.spay.n7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1785n7 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ D7 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1785n7(D7 d7, Continuation continuation) {
        super(2, continuation);
        this.b = d7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1785n7(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C1785n7(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C1655i1 c1655i1 = this.b.a;
            c1655i1.getClass();
            Flow flowOnEach = FlowKt.onEach(FlowKt.flowOn(new C1760m7(FlowKt.callbackFlow(new C1630h1(c1655i1, null)), this.b), Dispatchers.getDefault()), new C1685j7(this.b, null));
            this.a = 1;
            if (FlowKt.collect(flowOnEach, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* renamed from: npi.spay.wb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2013wb extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Flow b;
    public final /* synthetic */ Ab c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2013wb(Flow flow, Continuation continuation, Ab ab) {
        super(2, continuation);
        this.b = flow;
        this.c = ab;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C2013wb(this.b, continuation, this.c);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C2013wb(this.b, (Continuation) obj2, this.c).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = this.b;
            C1988vb c1988vb = new C1988vb(this.c);
            this.a = 1;
            if (flow.collect(c1988vb, this) == coroutine_suspended) {
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

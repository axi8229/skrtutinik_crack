package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes4.dex */
public final class Ob extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ Dc b;
    public final /* synthetic */ C1493be c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ob(Dc dc, C1493be c1493be, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(1, continuation);
        this.b = dc;
        this.c = c1493be;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new Ob(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((Ob) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Dc dc = this.b;
            C1493be c1493be = this.c;
            CoroutineDispatcher coroutineDispatcher = this.d;
            this.a = 1;
            dc.getClass();
            if (FlowKt.flow(new Pb(dc, c1493be, coroutineDispatcher, null)) == coroutine_suspended) {
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

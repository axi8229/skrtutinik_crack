package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class Mj extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ Hk b;
    public final /* synthetic */ C1674il c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mj(Hk hk, C1674il c1674il, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(1, continuation);
        this.b = hk;
        this.c = c1674il;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new Mj(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((Mj) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Hk hk = this.b;
            C1674il c1674il = this.c;
            CoroutineDispatcher coroutineDispatcher = this.d;
            this.a = 1;
            if (hk.b(c1674il, coroutineDispatcher, this) == coroutine_suspended) {
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

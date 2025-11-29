package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class O8 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ C1987va b;
    public final /* synthetic */ Rb c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O8(C1987va c1987va, Rb rb, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(1, continuation);
        this.b = c1987va;
        this.c = rb;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new O8(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((O8) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C1987va c1987va = this.b;
            Rb rb = this.c;
            CoroutineDispatcher coroutineDispatcher = this.d;
            this.a = 1;
            if (c1987va.b(rb, coroutineDispatcher, this) == coroutine_suspended) {
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

package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class Fg extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ C1795nh b;
    public final /* synthetic */ CoroutineDispatcher c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fg(C1795nh c1795nh, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(1, continuation);
        this.b = c1795nh;
        this.c = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new Fg(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((Fg) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C1795nh c1795nh = this.b;
            CoroutineDispatcher coroutineDispatcher = this.c;
            this.a = 1;
            if (c1795nh.b(null, coroutineDispatcher, this) == coroutine_suspended) {
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

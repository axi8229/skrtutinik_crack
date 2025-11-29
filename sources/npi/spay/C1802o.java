package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: npi.spay.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1802o extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ B0 b;
    public final /* synthetic */ C1779n1 c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1802o(B0 b0, C1779n1 c1779n1, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(1, continuation);
        this.b = b0;
        this.c = c1779n1;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C1802o(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C1802o) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            B0 b0 = this.b;
            C1779n1 c1779n1 = this.c;
            CoroutineDispatcher coroutineDispatcher = this.d;
            this.a = 1;
            if (b0.b(c1779n1, coroutineDispatcher, this) == coroutine_suspended) {
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

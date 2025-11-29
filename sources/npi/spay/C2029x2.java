package npi.spay;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.StateFlow;

/* renamed from: npi.spay.x2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2029x2 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ A2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2029x2(A2 a2, Continuation continuation) {
        super(2, continuation);
        this.b = a2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C2029x2(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C2029x2(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            A2 a2 = this.b;
            StateFlow stateFlow = ((C1822oj) a2.e).b;
            C2004w2 c2004w2 = new C2004w2(a2);
            this.a = 1;
            if (stateFlow.collect(c2004w2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}

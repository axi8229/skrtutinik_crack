package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* renamed from: npi.spay.e5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1559e5 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ C1585f6 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1559e5(C1585f6 c1585f6, Continuation continuation) {
        super(2, continuation);
        this.b = c1585f6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1559e5(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C1559e5(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C1661i7 c1661i7 = this.b.e;
            if (c1661i7 != null) {
                this.a = 1;
                Function1 function1 = c1661i7.a;
                if (function1 != null) {
                    obj = function1.invoke(this);
                    if (obj != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        obj = Unit.INSTANCE;
                    }
                } else {
                    obj = null;
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}

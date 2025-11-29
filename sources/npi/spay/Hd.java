package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes4.dex */
public final class Hd extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ C1889rc b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hd(C1889rc c1889rc, Continuation continuation) {
        super(2, continuation);
        this.b = c1889rc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Hd(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Hd(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C1889rc c1889rc = this.b;
            C2015wd c2015wd = c1889rc.d;
            Ce ce = new Ce(((Di) c1889rc.b).p(), new Gd(this.b));
            this.a = 1;
            if (c2015wd.a(ce, Dispatchers.getIO(), this) == coroutine_suspended) {
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

package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: classes4.dex */
public final class Tb extends SuspendLambda implements Function2 {
    public MutableStateFlow a;
    public int b;
    public final /* synthetic */ Ub c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tb(Ub ub, Continuation continuation) {
        super(2, continuation);
        this.c = ub;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Tb(this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Tb(this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ub ub = this.c;
            MutableStateFlow mutableStateFlow2 = ub.e;
            I9 i9 = ub.d;
            this.a = mutableStateFlow2;
            this.b = 1;
            i9.getClass();
            obj = BuildersKt.withContext(Dispatchers.getIO(), new R8(i9, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow = mutableStateFlow2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableStateFlow = this.a;
            ResultKt.throwOnFailure(obj);
        }
        mutableStateFlow.setValue(obj);
        return Unit.INSTANCE;
    }
}

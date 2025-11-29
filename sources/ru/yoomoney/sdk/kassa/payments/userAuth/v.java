package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class v extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ K b;
    public final /* synthetic */ AbstractC2546i c;
    public final /* synthetic */ Out.Builder d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(K k, AbstractC2546i abstractC2546i, Out.Builder builder, Continuation continuation) {
        super(1, continuation);
        this.b = k;
        this.c = abstractC2546i;
        this.d = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new v(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((v) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            K k = this.b;
            C2543f c2543f = (C2543f) this.c;
            this.a = 1;
            if (K.a(k, c2543f, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Function2 function2 = this.b.a;
        Object state = this.d.getState();
        this.a = 2;
        obj = function2.invoke(state, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}

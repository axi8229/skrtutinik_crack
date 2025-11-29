package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.v;

/* loaded from: classes5.dex */
public final class n extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ r b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(r rVar, Continuation continuation) {
        super(1, continuation);
        this.b = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new n(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new n(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            r rVar = this.b;
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.s sVar = rVar.a;
            String str = rVar.b;
            this.a = 1;
            obj = ((v) sVar).a(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}

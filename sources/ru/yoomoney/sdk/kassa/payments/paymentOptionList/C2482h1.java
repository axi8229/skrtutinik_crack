package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.h1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2482h1 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ E1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2482h1(E1 e1, Continuation continuation) {
        super(1, continuation);
        this.b = e1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2482h1(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2482h1(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ru.yoomoney.sdk.kassa.payments.logout.c cVar = this.b.g;
            this.a = 1;
            if (((ru.yoomoney.sdk.kassa.payments.logout.d) cVar).a() == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return C2512u.a;
    }
}

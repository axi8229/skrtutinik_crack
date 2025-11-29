package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.q0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2441q0 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ H0 b;
    public final /* synthetic */ E c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2441q0(H0 h0, E e, Continuation continuation) {
        super(1, continuation);
        this.b = h0;
        this.c = e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2441q0(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2441q0(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            E1 e1 = this.b.e;
            boolean z = ((C2449v) this.c).a;
            this.a = 1;
            obj = ((G1) e1).a(null, z, this);
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

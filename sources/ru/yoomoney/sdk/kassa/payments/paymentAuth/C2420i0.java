package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.i0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2420i0 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ H0 b;
    public final /* synthetic */ E c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2420i0(H0 h0, E e, Continuation continuation) {
        super(1, continuation);
        this.b = h0;
        this.c = e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2420i0(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2420i0(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            H1 h1 = this.b.d;
            B b = (B) this.c;
            boolean z = b.a;
            Amount amount = b.b;
            this.a = 1;
            obj = ((J1) h1).a(this, amount, z);
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

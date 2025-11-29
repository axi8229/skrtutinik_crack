package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class U0 extends SuspendLambda implements Function2 {
    public final /* synthetic */ RuntimeViewModel a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Amount c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U0(RuntimeViewModel runtimeViewModel, boolean z, Amount amount, Continuation continuation) {
        super(2, continuation);
        this.a = runtimeViewModel;
        this.b = z;
        this.c = amount;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new U0(this.a, this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((U0) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.a.handleAction(new B(this.c, this.b));
        return Unit.INSTANCE;
    }
}

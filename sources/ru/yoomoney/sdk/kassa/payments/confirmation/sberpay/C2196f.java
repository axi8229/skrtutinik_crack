package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2196f extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ C2200j b;
    public final /* synthetic */ AbstractC2205o c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2196f(C2200j c2200j, AbstractC2205o abstractC2205o, Continuation continuation) {
        super(1, continuation);
        this.b = c2200j;
        this.c = abstractC2205o;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2196f(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2196f(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.b;
            C2204n c2204n = (C2204n) this.c;
            C2207q c2207q = new C2207q(c2204n.a, c2204n.b, c2204n.c, c2204n.d);
            this.a = 1;
            if (function2.invoke(c2207q, this) == coroutine_suspended) {
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

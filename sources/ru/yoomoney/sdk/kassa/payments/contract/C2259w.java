package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2259w extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ P b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2259w(P p, Continuation continuation) {
        super(1, continuation);
        this.b = p;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2259w(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2259w(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            P p = this.b;
            X0 x0 = p.e;
            int i2 = p.m;
            String str = p.n;
            this.a = 1;
            obj = ((Z0) x0).a(i2, str, this);
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

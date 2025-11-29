package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2263y extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ P b;
    public final /* synthetic */ Out.Builder c;
    public final /* synthetic */ AbstractC2236k d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2263y(P p, Out.Builder builder, AbstractC2236k abstractC2236k, Continuation continuation) {
        super(1, continuation);
        this.b = p;
        this.c = builder;
        this.d = abstractC2236k;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2263y(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C2263y) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.b;
            C2246p c2246p = (C2246p) this.c.getState();
            ru.yoomoney.sdk.kassa.payments.model.U u = ((C2230h) this.d).a;
            int id = c2246p.g.a().getId();
            boolean z = c2246p.d;
            boolean z2 = c2246p.e;
            AbstractC2335t abstractC2335t = c2246p.h;
            H0 h0 = c2246p.g;
            F0 f0 = h0 instanceof F0 ? (F0) h0 : null;
            C2242n c2242n = new C2242n(new ru.yoomoney.sdk.kassa.payments.payment.tokenize.n(id, z, z2, abstractC2335t, u, f0 != null ? f0.e : false, null, u instanceof ru.yoomoney.sdk.kassa.payments.model.G ? ((ru.yoomoney.sdk.kassa.payments.model.G) u).a : null));
            this.a = 1;
            if (function2.invoke(c2242n, this) == coroutine_suspended) {
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

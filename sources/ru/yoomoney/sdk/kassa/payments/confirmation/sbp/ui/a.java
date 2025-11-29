package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
public final class a extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ Function0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Function2 function2, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.b = function2;
        this.c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        a aVar = new a(this.b, this.c, continuation);
        aVar.a = obj;
        return aVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((a) create((ru.yoomoney.sdk.kassa.payments.confirmation.sbp.i) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ru.yoomoney.sdk.kassa.payments.confirmation.sbp.i iVar = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.i) this.a;
        if (iVar instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.g) {
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.g gVar = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.g) iVar;
            this.b.invoke(gVar.a, gVar.b);
        } else if (iVar instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.h) {
            this.c.invoke();
        }
        return Unit.INSTANCE;
    }
}

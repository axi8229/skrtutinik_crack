package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class b extends SuspendLambda implements Function2 {
    public final /* synthetic */ RuntimeViewModel a;
    public final /* synthetic */ LinkedCard b;
    public final /* synthetic */ Q c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(RuntimeViewModel runtimeViewModel, LinkedCard linkedCard, Q q, Continuation continuation) {
        super(2, continuation);
        this.a = runtimeViewModel;
        this.b = linkedCard;
        this.c = q;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new b(this.a, this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.a.handleAction(new ru.yoomoney.sdk.kassa.payments.unbind.b(this.b, this.c));
        return Unit.INSTANCE;
    }
}

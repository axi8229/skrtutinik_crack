package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsViewModelFactory$create$1$1$1", f = "AcceptTermsViewModelFactory.kt", l = {21}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class g extends SuspendLambda implements Function1<Continuation<? super AcceptTerms.Action>, Object> {
    public int a;
    public final /* synthetic */ RuntimeViewModelDependencies<AcceptTerms.State, AcceptTerms.Action, AcceptTerms.Effect> b;
    public final /* synthetic */ Out.Builder<AcceptTerms.State.Content, AcceptTerms.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(RuntimeViewModelDependencies<AcceptTerms.State, AcceptTerms.Action, AcceptTerms.Effect> runtimeViewModelDependencies, Out.Builder<AcceptTerms.State.Content, AcceptTerms.Action> builder, Continuation<? super g> continuation) {
        super(1, continuation);
        this.b = runtimeViewModelDependencies;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new g(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AcceptTerms.Action> continuation) {
        return new g(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<AcceptTerms.State, Continuation<? super AcceptTerms.Action>, Object> showState = this.b.getShowState();
            AcceptTerms.State.Content state = this.c.getState();
            this.a = 1;
            obj = showState.invoke(state, this);
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

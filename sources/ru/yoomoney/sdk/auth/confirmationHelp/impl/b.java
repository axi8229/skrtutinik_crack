package ru.yoomoney.sdk.auth.confirmationHelp.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelp;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.confirmationHelp.impl.ConfirmationHelpViewModelFactory$create$1$1$1", f = "ConfirmationHelpViewModelFactory.kt", l = {18}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class b extends SuspendLambda implements Function1<Continuation<? super ConfirmationHelp.Action>, Object> {
    public int a;
    public final /* synthetic */ RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> b;
    public final /* synthetic */ Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> runtimeViewModelDependencies, Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action> builder, Continuation<? super b> continuation) {
        super(1, continuation);
        this.b = runtimeViewModelDependencies;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ConfirmationHelp.Action> continuation) {
        return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<ConfirmationHelp.State, Continuation<? super ConfirmationHelp.Action>, Object> showState = this.b.getShowState();
            ConfirmationHelp.State.Content state = this.c.getState();
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

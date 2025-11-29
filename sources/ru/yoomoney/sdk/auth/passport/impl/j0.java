package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.passport.PassportProfile;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileViewModelFactory$create$1$1$1", f = "PassportProfileViewModelFactory.kt", l = {23}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class j0 extends SuspendLambda implements Function1<Continuation<? super PassportProfile.Action>, Object> {
    public int a;
    public final /* synthetic */ RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> b;
    public final /* synthetic */ Out.Builder<PassportProfile.State.Init, PassportProfile.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> runtimeViewModelDependencies, Out.Builder<PassportProfile.State.Init, PassportProfile.Action> builder, Continuation<? super j0> continuation) {
        super(1, continuation);
        this.b = runtimeViewModelDependencies;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new j0(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PassportProfile.Action> continuation) {
        return new j0(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<PassportProfile.State, Continuation<? super PassportProfile.Action>, Object> showState = this.b.getShowState();
            PassportProfile.State.Init state = this.c.getState();
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

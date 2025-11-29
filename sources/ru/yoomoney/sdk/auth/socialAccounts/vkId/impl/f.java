package ru.yoomoney.sdk.auth.socialAccounts.vkId.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkId;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.socialAccounts.vkId.impl.VkIdViewModelFactoryImpl$create$1$1$1", f = "VkIdViewModelFactoryImpl.kt", l = {31}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class f extends SuspendLambda implements Function1<Continuation<? super VkId.Action>, Object> {
    public int a;
    public final /* synthetic */ RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> b;
    public final /* synthetic */ Out.Builder<VkId.State.Progress, VkId.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> runtimeViewModelDependencies, Out.Builder<VkId.State.Progress, VkId.Action> builder, Continuation<? super f> continuation) {
        super(1, continuation);
        this.b = runtimeViewModelDependencies;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new f(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super VkId.Action> continuation) {
        return new f(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<VkId.State, Continuation<? super VkId.Action>, Object> showState = this.b.getShowState();
            VkId.State.Progress state = this.c.getState();
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

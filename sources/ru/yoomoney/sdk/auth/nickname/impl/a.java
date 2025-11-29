package ru.yoomoney.sdk.auth.nickname.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.nickname.Nickname;
import ru.yoomoney.sdk.march.Out;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.nickname.impl.NicknameBusinessLogic$handleContentState$1$1", f = "NicknameBusinessLogic.kt", l = {35}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class a extends SuspendLambda implements Function1<Continuation<? super Nickname.Action>, Object> {
    public int a;
    public final /* synthetic */ NicknameBusinessLogic b;
    public final /* synthetic */ Out.Builder<Nickname.State.Content, Nickname.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(NicknameBusinessLogic nicknameBusinessLogic, Out.Builder<Nickname.State.Content, Nickname.Action> builder, Continuation<? super a> continuation) {
        super(1, continuation);
        this.b = nicknameBusinessLogic;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new a(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Nickname.Action> continuation) {
        return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showState;
            Nickname.State.Content state = this.c.getState();
            this.a = 1;
            obj = function2.invoke(state, this);
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

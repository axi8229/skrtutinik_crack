package ru.yoomoney.sdk.auth.nickname.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.nickname.Nickname;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.nickname.impl.NicknameBusinessLogic$handleContentState$2$2", f = "NicknameBusinessLogic.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class c extends SuspendLambda implements Function1<Continuation<? super Nickname.Action>, Object> {
    public int a;
    public final /* synthetic */ NicknameBusinessLogic b;
    public final /* synthetic */ Nickname.Action c;
    public final /* synthetic */ Nickname.State.Content d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NicknameBusinessLogic nicknameBusinessLogic, Nickname.Action action, Nickname.State.Content content, Continuation<? super c> continuation) {
        super(1, continuation);
        this.b = nicknameBusinessLogic;
        this.c = action;
        this.d = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new c(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Nickname.Action> continuation) {
        return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NicknameInteractor nicknameInteractor = this.b.interactor;
            String accessToken = ((Nickname.Action.Submit) this.c).getAccessToken();
            String newNickname = this.d.getNewNickname();
            this.a = 1;
            obj = nicknameInteractor.displayName(accessToken, newNickname, this);
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

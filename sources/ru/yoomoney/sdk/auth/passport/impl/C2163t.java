package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.passport.PassportProfile;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleContentState$14$2", f = "PassportProfileBusinessLogic.kt", l = {163}, m = "invokeSuspend")
/* renamed from: ru.yoomoney.sdk.auth.passport.impl.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2163t extends SuspendLambda implements Function1<Continuation<? super PassportProfile.Action>, Object> {
    public int a;
    public final /* synthetic */ PassportProfileBusinessLogic b;
    public final /* synthetic */ PassportProfile.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2163t(PassportProfileBusinessLogic passportProfileBusinessLogic, PassportProfile.Action action, Continuation<? super C2163t> continuation) {
        super(1, continuation);
        this.b = passportProfileBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C2163t(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PassportProfile.Action> continuation) {
        return new C2163t(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PassportProfileInteractor passportProfileInteractor = this.b.interactor;
            OauthServiceProvider serviceProvider = ((PassportProfile.Action.UnbindSocialAccount) this.c).getServiceProvider();
            this.a = 1;
            obj = passportProfileInteractor.unbindSocialAccount(serviceProvider, this);
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

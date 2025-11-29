package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.passport.PassportProfile;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleContentState$6$1", f = "PassportProfileBusinessLogic.kt", l = {122}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class B extends SuspendLambda implements Function1<Continuation<? super PassportProfile.Action>, Object> {
    public int a;
    public final /* synthetic */ PassportProfileBusinessLogic b;
    public final /* synthetic */ PassportProfile.State.Content c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(PassportProfileBusinessLogic passportProfileBusinessLogic, PassportProfile.State.Content content, Continuation<? super B> continuation) {
        super(1, continuation);
        this.b = passportProfileBusinessLogic;
        this.c = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new B(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PassportProfile.Action> continuation) {
        return new B(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PassportProfileInteractor passportProfileInteractor = this.b.interactor;
            String title = this.c.getAccount().getPhone().getTitle();
            this.a = 1;
            obj = passportProfileInteractor.checkPhone(title, this);
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

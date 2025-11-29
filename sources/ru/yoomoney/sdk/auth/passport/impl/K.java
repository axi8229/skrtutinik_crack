package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.passport.PassportProfile;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleInitState$2$1", f = "PassportProfileBusinessLogic.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class K extends SuspendLambda implements Function1<Continuation<? super PassportProfile.Action>, Object> {
    public final /* synthetic */ PassportProfileBusinessLogic a;
    public final /* synthetic */ PassportProfile.Action b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(PassportProfileBusinessLogic passportProfileBusinessLogic, PassportProfile.Action action, Continuation<? super K> continuation) {
        super(1, continuation);
        this.a = passportProfileBusinessLogic;
        this.b = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new K(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PassportProfile.Action> continuation) {
        return new K(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return this.a.interactor.handleEmailChange((PassportProfile.Action.AccountSuccess) this.b);
    }
}

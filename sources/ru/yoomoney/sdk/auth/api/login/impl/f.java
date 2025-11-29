package ru.yoomoney.sdk.auth.api.login.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.api.login.LoginEnter;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.impl.LoginEnterBusinessLogic$handleContentState$5$1", f = "LoginEnterBusinessLogic.kt", l = {49}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class f extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ LoginEnterBusinessLogic b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(LoginEnterBusinessLogic loginEnterBusinessLogic, Continuation<? super f> continuation) {
        super(1, continuation);
        this.b = loginEnterBusinessLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new f(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new f(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            LoginEnter.Effect.OpenMigrationDescriptionScreen openMigrationDescriptionScreen = LoginEnter.Effect.OpenMigrationDescriptionScreen.INSTANCE;
            this.a = 1;
            if (function2.invoke(openMigrationDescriptionScreen, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

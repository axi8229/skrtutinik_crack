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

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleLoadingState$2$1", f = "PassportProfileBusinessLogic.kt", l = {190}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class X extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ PassportProfileBusinessLogic b;
    public final /* synthetic */ PassportProfile.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(PassportProfileBusinessLogic passportProfileBusinessLogic, PassportProfile.Action action, Continuation<? super X> continuation) {
        super(1, continuation);
        this.b = passportProfileBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new X(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new X(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            PassportProfile.Effect.ShowFailure showFailure = new PassportProfile.Effect.ShowFailure(((PassportProfile.Action.StartChangeFailed) this.c).getFailure());
            this.a = 1;
            if (function2.invoke(showFailure, this) == coroutine_suspended) {
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

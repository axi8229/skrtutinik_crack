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

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleBindingProcessState$7$1", f = "PassportProfileBusinessLogic.kt", l = {286}, m = "invokeSuspend")
/* renamed from: ru.yoomoney.sdk.auth.passport.impl.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2153i extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ PassportProfileBusinessLogic b;
    public final /* synthetic */ PassportProfile.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2153i(PassportProfileBusinessLogic passportProfileBusinessLogic, PassportProfile.Action action, Continuation<? super C2153i> continuation) {
        super(1, continuation);
        this.b = passportProfileBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C2153i(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new C2153i(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            PassportProfile.Effect.ShowBindErrorDialog showBindErrorDialog = new PassportProfile.Effect.ShowBindErrorDialog(((PassportProfile.Action.BindSocialAccountError) this.c).getFailure());
            this.a = 1;
            if (function2.invoke(showBindErrorDialog, this) == coroutine_suspended) {
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

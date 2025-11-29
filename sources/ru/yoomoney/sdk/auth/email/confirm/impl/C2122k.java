package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.EmailConfirmBusinessLogic$handleInvalidState$9$1", f = "EmailConfirmBusinessLogic.kt", l = {89}, m = "invokeSuspend")
/* renamed from: ru.yoomoney.sdk.auth.email.confirm.impl.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2122k extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ EmailConfirmBusinessLogic b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2122k(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Continuation<? super C2122k> continuation) {
        super(1, continuation);
        this.b = emailConfirmBusinessLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C2122k(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new C2122k(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            EmailConfirm.Effect.ToEmailEntered toEmailEntered = EmailConfirm.Effect.ToEmailEntered.INSTANCE;
            this.a = 1;
            if (function2.invoke(toEmailEntered, this) == coroutine_suspended) {
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

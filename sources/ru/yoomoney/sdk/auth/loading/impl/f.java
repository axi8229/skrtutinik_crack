package ru.yoomoney.sdk.auth.loading.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.loading.AuthLoading;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingBusinessLogic$handleProgressState$10$2", f = "AuthLoadingBusinessLogic.kt", l = {77}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class f extends SuspendLambda implements Function1<Continuation<? super AuthLoading.Action>, Object> {
    public int a;
    public final /* synthetic */ AuthLoadingBusinessLogic b;
    public final /* synthetic */ AuthLoading.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(AuthLoadingBusinessLogic authLoadingBusinessLogic, AuthLoading.Action action, Continuation<? super f> continuation) {
        super(1, continuation);
        this.b = authLoadingBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new f(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AuthLoading.Action> continuation) {
        return new f(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthLoadingInteractor authLoadingInteractor = this.b.interactor;
            String phone = ((AuthLoading.Action.ExecuteEnterIdentifier) this.c).getPhoneIdentifier().getPhone();
            String id = ((AuthLoading.Action.ExecuteEnterIdentifier) this.c).getProcess().getId();
            this.a = 1;
            obj = authLoadingInteractor.enterIdentifier(phone, id, this);
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

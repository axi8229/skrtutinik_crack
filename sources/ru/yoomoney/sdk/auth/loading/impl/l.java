package ru.yoomoney.sdk.auth.loading.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.VkOauthCodeParameters;
import ru.yoomoney.sdk.auth.loading.AuthLoading;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingBusinessLogic$handleProgressState$16$1", f = "AuthLoadingBusinessLogic.kt", l = {107}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class l extends SuspendLambda implements Function1<Continuation<? super AuthLoading.Action>, Object> {
    public int a;
    public final /* synthetic */ AuthLoadingBusinessLogic b;
    public final /* synthetic */ AuthLoading.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(AuthLoadingBusinessLogic authLoadingBusinessLogic, AuthLoading.Action action, Continuation<? super l> continuation) {
        super(1, continuation);
        this.b = authLoadingBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new l(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AuthLoading.Action> continuation) {
        return new l(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthLoadingInteractor authLoadingInteractor = this.b.interactor;
            String id = ((AuthLoading.Action.HandleVkIdResponse) this.c).getProcess().getId();
            String token = ((AuthLoading.Action.HandleVkIdResponse) this.c).getToken();
            OauthCodeParameters oauthCodeParameters = ((AuthLoading.Action.HandleVkIdResponse) this.c).getProcess().getOauthCodeParameters();
            Intrinsics.checkNotNull(oauthCodeParameters, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.account.socialAccount.model.VkOauthCodeParameters");
            String state = ((VkOauthCodeParameters) oauthCodeParameters).getState();
            String redirectUrl = ((AuthLoading.Action.HandleVkIdResponse) this.c).getRedirectUrl();
            String uuid = ((AuthLoading.Action.HandleVkIdResponse) this.c).getUuid();
            this.a = 1;
            obj = authLoadingInteractor.enterOauthCodeVkId(id, token, state, redirectUrl, uuid, this);
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

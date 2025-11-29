package ru.yoomoney.sdk.auth.auxToken.impl;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueBusinessLogic$handleAuxAuthorizationInfoState$1$2", f = "AuxTokenIssueBusinessLogic.kt", l = {62}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class d extends SuspendLambda implements Function1<Continuation<? super AuxTokenIssue.Action>, Object> {
    public int a;
    public final /* synthetic */ AuxTokenIssueBusinessLogic b;
    public final /* synthetic */ AuxTokenIssue.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AuxTokenIssueBusinessLogic auxTokenIssueBusinessLogic, AuxTokenIssue.Action action, Continuation<? super d> continuation) {
        super(1, continuation);
        this.b = auxTokenIssueBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new d(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AuxTokenIssue.Action> continuation) {
        return new d(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuxTokenIssueInteractor auxTokenIssueInteractor = this.b.interactor;
            String token = ((AuxTokenIssue.Action.IssueAuxToken) this.c).getToken();
            List<AuxTokenScope> scopes = ((AuxTokenIssue.Action.IssueAuxToken) this.c).getScopes();
            String authCenterClientId = ((AuxTokenIssue.Action.IssueAuxToken) this.c).getAuthCenterClientId();
            this.a = 1;
            obj = auxTokenIssueInteractor.auxAuthorization(token, scopes, authCenterClientId, this);
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

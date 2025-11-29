package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.passport.PassportProfile;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleBindingProcessState$4$1", f = "PassportProfileBusinessLogic.kt", l = {258}, m = "invokeSuspend")
/* renamed from: ru.yoomoney.sdk.auth.passport.impl.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2149e extends SuspendLambda implements Function1<Continuation<? super PassportProfile.Action>, Object> {
    public int a;
    public final /* synthetic */ PassportProfileBusinessLogic b;
    public final /* synthetic */ PassportProfile.State.BindingProcess c;
    public final /* synthetic */ PassportProfile.Action d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2149e(Continuation continuation, PassportProfile.Action action, PassportProfile.State.BindingProcess bindingProcess, PassportProfileBusinessLogic passportProfileBusinessLogic) {
        super(1, continuation);
        this.b = passportProfileBusinessLogic;
        this.c = bindingProcess;
        this.d = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        PassportProfileBusinessLogic passportProfileBusinessLogic = this.b;
        return new C2149e(continuation, this.d, this.c, passportProfileBusinessLogic);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PassportProfile.Action> continuation) {
        return ((C2149e) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PassportProfileInteractor passportProfileInteractor = this.b.interactor;
            String id = this.c.getProcess().getId();
            String token = ((PassportProfile.Action.HandleBindVkIdResponse) this.d).getToken();
            String state = PassportProfileBusinessLogicKt.getState(this.c.getProcess().getOauthCodeParameters());
            String redirectUrl = ((PassportProfile.Action.HandleBindVkIdResponse) this.d).getRedirectUrl();
            String uuid = ((PassportProfile.Action.HandleBindVkIdResponse) this.d).getUuid();
            this.a = 1;
            obj = passportProfileInteractor.enterOauthCodeVkId(id, token, state, redirectUrl, uuid, this);
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

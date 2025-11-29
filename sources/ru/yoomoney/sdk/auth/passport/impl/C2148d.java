package ru.yoomoney.sdk.auth.passport.impl;

import android.net.Uri;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.passport.PassportProfile;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleBindingProcessState$3$1", f = "PassportProfileBusinessLogic.kt", l = {248}, m = "invokeSuspend")
/* renamed from: ru.yoomoney.sdk.auth.passport.impl.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2148d extends SuspendLambda implements Function1<Continuation<? super PassportProfile.Action>, Object> {
    public int a;
    public final /* synthetic */ PassportProfileBusinessLogic b;
    public final /* synthetic */ PassportProfile.Action c;
    public final /* synthetic */ PassportProfile.State.BindingProcess d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2148d(Continuation continuation, PassportProfile.Action action, PassportProfile.State.BindingProcess bindingProcess, PassportProfileBusinessLogic passportProfileBusinessLogic) {
        super(1, continuation);
        this.b = passportProfileBusinessLogic;
        this.c = action;
        this.d = bindingProcess;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C2148d(continuation, this.c, this.d, this.b);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PassportProfile.Action> continuation) {
        return ((C2148d) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PassportProfileInteractor passportProfileInteractor = this.b.interactor;
            Uri uri = ((PassportProfile.Action.HandleBindSberIdResponse) this.c).getUri();
            String id = this.d.getProcess().getId();
            String returnUrl = ((PassportProfile.Action.HandleBindSberIdResponse) this.c).getReturnUrl();
            this.a = 1;
            obj = passportProfileInteractor.enterOauthCodeSberId(uri, id, returnUrl, this);
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

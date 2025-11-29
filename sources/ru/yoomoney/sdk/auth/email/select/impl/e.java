package ru.yoomoney.sdk.auth.email.select.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.email.select.EmailSelect;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.email.select.impl.EmailSelectBusinessLogic$handleContent$5$1", f = "EmailSelectBusinessLogic.kt", l = {114}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class e extends SuspendLambda implements Function1<Continuation<? super EmailSelect.Action>, Object> {
    public int a;
    public final /* synthetic */ EmailSelectBusinessLogic b;
    public final /* synthetic */ EmailSelect.Action c;
    public final /* synthetic */ EmailSelect.State.Content d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(EmailSelectBusinessLogic emailSelectBusinessLogic, EmailSelect.Action action, EmailSelect.State.Content content, Continuation<? super e> continuation) {
        super(1, continuation);
        this.b = emailSelectBusinessLogic;
        this.c = action;
        this.d = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new e(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super EmailSelect.Action> continuation) {
        return ((e) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            EmailSelectInteractor emailSelectInteractor = this.b.interactor;
            String processId = ((EmailSelect.Action.SendEmail) this.c).getProcessId();
            String id = this.d.getSelectedSuggestion().getId();
            this.a = 1;
            obj = emailSelectInteractor.setEmail(processId, id, this);
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

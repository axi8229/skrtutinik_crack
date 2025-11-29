package ru.yoomoney.sdk.auth.phone.enter.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.PhoneEnterBusinessLogic$handleContentState$4$2", f = "PhoneEnterBusinessLogic.kt", l = {74}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class f extends SuspendLambda implements Function1<Continuation<? super PhoneEnter.Action>, Object> {
    public int a;
    public final /* synthetic */ PhoneEnterBusinessLogic b;
    public final /* synthetic */ PhoneEnter.Action c;
    public final /* synthetic */ PhoneEnter.State.Content d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PhoneEnterBusinessLogic phoneEnterBusinessLogic, PhoneEnter.Action action, PhoneEnter.State.Content content, Continuation<? super f> continuation) {
        super(1, continuation);
        this.b = phoneEnterBusinessLogic;
        this.c = action;
        this.d = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new f(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PhoneEnter.Action> continuation) {
        return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasePhoneEnterInteractor basePhoneEnterInteractor = this.b.interactor;
            PhoneEnter.Action.SetPhone setPhone = (PhoneEnter.Action.SetPhone) this.c;
            CountryCallingCode selectedCountry = this.d.getSelectedCountry();
            this.a = 1;
            obj = basePhoneEnterInteractor.setPhone(setPhone, selectedCountry, this);
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

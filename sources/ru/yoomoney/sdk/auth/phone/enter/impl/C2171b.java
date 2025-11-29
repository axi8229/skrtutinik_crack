package ru.yoomoney.sdk.auth.phone.enter.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.PhoneEnterBusinessLogic$handleContentState$2$1", f = "PhoneEnterBusinessLogic.kt", l = {60}, m = "invokeSuspend")
/* renamed from: ru.yoomoney.sdk.auth.phone.enter.impl.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2171b extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ PhoneEnterBusinessLogic b;
    public final /* synthetic */ PhoneEnter.State.Content c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2171b(PhoneEnterBusinessLogic phoneEnterBusinessLogic, PhoneEnter.State.Content content, Continuation<? super C2171b> continuation) {
        super(1, continuation);
        this.b = phoneEnterBusinessLogic;
        this.c = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C2171b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new C2171b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            PhoneEnter.Effect.ShowCountries showCountries = new PhoneEnter.Effect.ShowCountries(this.c.getSelectedCountry());
            this.a = 1;
            if (function2.invoke(showCountries, this) == coroutine_suspended) {
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

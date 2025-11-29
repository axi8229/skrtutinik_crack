package ru.yoomoney.sdk.auth.socialAccounts.vkId.impl;

import android.app.Application;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkId;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.socialAccounts.vkId.impl.VkIdViewModelFactoryImpl$create$1$1$2", f = "VkIdViewModelFactoryImpl.kt", l = {32}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class g extends SuspendLambda implements Function1<Continuation<? super VkId.Action>, Object> {
    public int a;
    public final /* synthetic */ VkIdInteractor b;
    public final /* synthetic */ VkIdViewModelFactoryImpl c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(VkIdInteractor vkIdInteractor, VkIdViewModelFactoryImpl vkIdViewModelFactoryImpl, Continuation<? super g> continuation) {
        super(1, continuation);
        this.b = vkIdInteractor;
        this.c = vkIdViewModelFactoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new g(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super VkId.Action> continuation) {
        return new g(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            VkIdInteractor vkIdInteractor = this.b;
            Application application = this.c.application;
            this.a = 1;
            obj = vkIdInteractor.initVkSdk(application, this);
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

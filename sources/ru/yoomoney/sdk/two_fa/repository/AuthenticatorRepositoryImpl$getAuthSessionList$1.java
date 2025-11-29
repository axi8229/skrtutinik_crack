package ru.yoomoney.sdk.two_fa.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AuthenticatorRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl", f = "AuthenticatorRepository.kt", l = {89}, m = "getAuthSessionList-gIAlu-s")
/* loaded from: classes5.dex */
final class AuthenticatorRepositoryImpl$getAuthSessionList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthenticatorRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthenticatorRepositoryImpl$getAuthSessionList$1(AuthenticatorRepositoryImpl authenticatorRepositoryImpl, Continuation<? super AuthenticatorRepositoryImpl$getAuthSessionList$1> continuation) {
        super(continuation);
        this.this$0 = authenticatorRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo3513getAuthSessionListgIAlus = this.this$0.mo3513getAuthSessionListgIAlus(null, this);
        return objMo3513getAuthSessionListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3513getAuthSessionListgIAlus : Result.m2627boximpl(objMo3513getAuthSessionListgIAlus);
    }
}

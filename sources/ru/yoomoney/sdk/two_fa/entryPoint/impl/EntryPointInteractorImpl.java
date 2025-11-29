package ru.yoomoney.sdk.two_fa.entryPoint.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;

/* compiled from: EntryPointInteractor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractorImpl;", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "repository", "Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;", "(Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;)V", "getContent", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPointInteractorImpl implements EntryPointInteractor {
    public static final int $stable = 8;
    private final AuthenticatorRepository repository;

    /* compiled from: EntryPointInteractor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl", f = "EntryPointInteractor.kt", l = {18}, m = "getContent")
    /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl$getContent$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EntryPointInteractorImpl.this.getContent(null, this);
        }
    }

    public EntryPointInteractorImpl(AuthenticatorRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getContent(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl$getContent$1 r0 = (ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl$getContent$1 r0 = new ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl$getContent$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository r6 = r4.repository
            r0.label = r3
            java.lang.Object r5 = r6.mo3512getAuthContextgIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L53
            ru.yoomoney.sdk.two_fa.domain.AuthContext r5 = (ru.yoomoney.sdk.two_fa.domain.AuthContext) r5
            ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint$Action$LoadingContextSuccess r6 = new ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint$Action$LoadingContextSuccess
            r6.<init>(r5)
            goto L60
        L53:
            ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint$Action$LoadingContextFailed r5 = new ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint$Action$LoadingContextFailed
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.exception.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.two_fa.exception.Failure r6 = (ru.yoomoney.sdk.two_fa.exception.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl.getContent(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
